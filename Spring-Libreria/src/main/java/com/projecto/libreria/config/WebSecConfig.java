package com.projecto.libreria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.projecto.libreria.servicio.UserService;


@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetails;
	
	//registrar en el contendor de Spring PasswordEncoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	/*auth.inMemoryAuthentication().
    			withUser("user").password("user").roles("USER").
    			and().withUser("admin").password("admin").roles("ADMIN");*/
		
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    	
    }
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
    		.authorizeRequests()
    		.antMatchers("/obra/*").authenticated()
    		.antMatchers("/autor/*").authenticated()
    		.antMatchers("/menu/*").authenticated()
    		.and().formLogin()
    		.loginPage("/login")
    		.defaultSuccessUrl("/menu",true);
		
	}
    
}













