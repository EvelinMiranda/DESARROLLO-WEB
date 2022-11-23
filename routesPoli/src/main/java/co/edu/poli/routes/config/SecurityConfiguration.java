package co.edu.poli.routes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
//autenticación
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.inMemoryAuthentication() 
		.withUser("Conductor") 
		.password("{noop}123456")//{noop} plain text comment methods noPasswordEncoder/passwordEncoder
		.roles("ADMIN");
	}
//autorización
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/v1/routes").hasAnyRole("ADMIN", "USER").antMatchers("/api/v1/routss/**").hasRole("ADMIN").anyRequest().authenticated() 
		.and().formLogin().and().httpBasic().and().logout();
		
	}
	
}