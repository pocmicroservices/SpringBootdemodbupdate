package com.demo.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Value("${demo.global.username}")
	String userName;
	@Value("${demo.global.password}")
	String password;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.anyRequest().authenticated()
				.and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);
		System.out.println("Authentication Configuration Invoked");
		//Added for H2 console issue
				http.headers().frameOptions().disable();
				http.headers().frameOptions().sameOrigin();
	}
/*
	//Added for H2 Console Issue
		@Override
	    public void configure(WebSecurity web) throws Exception {
	        //super.configure(web);
	        web.ignoring().antMatchers("**"); 
	    }
	*/
	
	@Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//String password = "Password";
		String encryptedPassword = this.passwordEncoder().encode(password);
		System.out.println("Encoded password=" + encryptedPassword);
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> mngConfig = auth.inMemoryAuthentication();
        mngConfig.withUser(userName).password(encryptedPassword).roles("USER");
	}
}