package rc.bootsecurity;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSecurityApplication.class, args);
    }
// we can configure CORS for whole project or can use @CrossOrigin with every Controller    
//  @Configuration
//  public class MyConfiguration {
//
//      @Bean
//      public WebMvcConfigurer corsConfigurer() {
//          return new WebMvcConfigurerAdapter() {
//              @Override
//              public void addCorsMappings(CorsRegistry registry) {
//                  registry.addMapping("/**")
//                  .allowedMethods("GET", "POST","PUT","DELETE");
//              }
//          };
//      }
//  } 

    // @Bean
    // public ServletWebServerFactory servletContainer() {
    //     // Enable SSL Trafic
    //     TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
    //         @Override
    //         protected void postProcessContext(Context context) {
    //             SecurityConstraint securityConstraint = new SecurityConstraint();
    //             securityConstraint.setUserConstraint("CONFIDENTIAL");
    //             SecurityCollection collection = new SecurityCollection();
    //             collection.addPattern("/*");
    //             securityConstraint.addCollection(collection);
    //             context.addConstraint(securityConstraint);
    //         }
    //     };

    //     // Add HTTP to HTTPS redirect
    //     tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());

    //     return tomcat;
    // }

    // /*
    // We need to redirect from HTTP to HTTPS. Without SSL, this application used
    // port 8083. With SSL it will use port 8443. So, any request for 8082 needs to be
    // redirected to HTTPS on 8443.
    //  */
    // private Connector httpToHttpsRedirectConnector() {
    //     Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
    //     connector.setScheme("http");
    //     connector.setPort(8083);
    //     connector.setSecure(false);  // if true then page will not redirect from 8083 to 8443
    //     connector.setRedirectPort(8443);
    //     return connector;
    // }

}
