
package com.crudangularspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Usuario
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.crudangularspring"} )
public class WebConfig implements WebMvcConfigurer{
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/WEB-INF/").suffix(".jsp");
    }
}
