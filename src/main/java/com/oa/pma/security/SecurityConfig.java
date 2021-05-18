package com.oa.pma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource; // automatically associated with datasource defined in application.properties
	
	@Autowired
	BCryptPasswordEncoder cryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//		    .withDefaultSchema()
//		        .withUser("admin").password("pass").roles("MASTER")
//		    .and()
//		        .withUser("user1").password("pass1").roles("SLAVE")
//		    .and()
//				.withUser("user2").password("pass2").roles("SLAVE");

//		customize log-in
		auth.jdbcAuthentication()
		    .usersByUsernameQuery("select username, password, enabled from users where username = ?")
		    .authoritiesByUsernameQuery("select username, role from authorities where username = ?")
		    .dataSource(dataSource)
			.passwordEncoder(cryptPasswordEncoder); // getPasswordEncoder() gets encrypted pass which is not secured
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // it's ordered, so it's sorted, special districtions first
//		    .antMatchers("/employee/new").hasRole("MASTER") // expects ROLE_MASTER
//		    .antMatchers("/employee/save").hasRole("MASTER")
		    //.antMatchers("/project/new").hasAnyAuthority("MASTER") // checks the "MASTER" word
		    //.antMatchers("/project/new").hasAnyAuthority("MASTER")
		    //.antMatchers("/project/save").hasAnyAuthority("MASTER")
		    //.antMatchers("/h2_console/**").permitAll()
			.antMatchers("/", "/**").permitAll()
			.and() //.formLogin().loginPage("/login-page"); // custom login page
			.formLogin();
		
		
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
	}
}
