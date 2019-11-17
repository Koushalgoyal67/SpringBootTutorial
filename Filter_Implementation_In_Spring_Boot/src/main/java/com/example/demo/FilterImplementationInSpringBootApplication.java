package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.filters.Filter2;

@SpringBootApplication
public class FilterImplementationInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterImplementationInSpringBootApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<Filter2> loggingFilter(){
	    FilterRegistrationBean<Filter2> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new Filter2());
	    registrationBean.addUrlPatterns("/get/student/lastname");  // /* for all  pattern must start with /
	         
	    return registrationBean;    
	}
}
