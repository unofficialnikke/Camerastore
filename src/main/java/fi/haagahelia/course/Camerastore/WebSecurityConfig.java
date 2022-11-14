package fi.haagahelia.course.Camerastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.haagahelia.course.Camerastore.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	/*
	 * This method defines the rights to the different roles of users in the 
	 * camerastore application. Only admins have the rights to add, edit
	 * or delete products, users can only view them and make orders.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().loginPage("/login");
		
		http
		.authorizeRequests()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/signup", "/createaccount").permitAll()
		.and()
		.authorizeRequests()
			.anyRequest().authenticated()
		.and()
	.formLogin()
		.loginPage("/login")
		.permitAll()
		.defaultSuccessUrl("/home", true)
		.permitAll()
		.and()
	.logout()
		.permitAll();
	}	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	

}
