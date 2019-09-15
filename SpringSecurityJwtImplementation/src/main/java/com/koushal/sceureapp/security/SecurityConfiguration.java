package com.koushal.sceureapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.koushal.sceureapp.dao.UserRepository;
import com.koushal.sceureapp.service.UserPrincipalDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserPrincipalDetailsService userPrincipalDetailsService;
	
	@Autowired
	private UserRepository userRepository;

//    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
//        this.userPrincipalDetailsService = userPrincipalDetailsService;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	
        .authorizeRequests()  // requests are intercepted here
        .antMatchers("/index.html").permitAll()
        .antMatchers("/profile/**").authenticated()//only authenticated person can proceed
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
        .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
        .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
        .antMatchers("/api/public/users").hasRole("ADMIN")
        .and()
        //.httpBasic();//this will make to use Basic Auth (automatic pop-up for  login not best for Banking purpose)
        .formLogin() //see more detail about formLogin by pressing ctrl and clicking on it
        .loginProcessingUrl("/signIn") //signIn is mapped to form action in login.html
        .loginPage("/loginPage").permitAll()
        //.failureUrl("/index")  if login failed then this page will be called
        .usernameParameter("txtUsername")
        .passwordParameter("txtPassword")
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/loginPage")
        .and()
        .rememberMe().tokenValiditySeconds(50).key("mySecret!").rememberMeParameter("checkRememberMe").userDetailsService(userPrincipalDetailsService)
        .and()
        // remove csrf and state in session because in jwt we do not need them
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        // add jwt filters (1. authentication, 2. authorization)
        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
        .addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepository))
        .authorizeRequests()
        // configure access rules
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .antMatchers("/api/public/management/*").hasRole("MANAGER")
        .antMatchers("/api/public/admin/*").hasRole("ADMIN")
        .anyRequest().authenticated();
    }

    // tells what types of authentication roles permission is required
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }
    
    //password used to store must be in BCrypt form otherwise application won't work correctly
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
