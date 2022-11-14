package fi.haagahelia.course.Camerastore.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	/*
	 * This MVC config made it possible to create a custom login page for the security
	 */
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
     
        registry.addViewController("/login").setViewName("login");
         
    }
 
}