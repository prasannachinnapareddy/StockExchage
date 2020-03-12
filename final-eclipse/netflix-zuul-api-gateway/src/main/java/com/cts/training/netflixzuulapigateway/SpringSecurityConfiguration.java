package com.cts.training.netflixzuulapigateway;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
//		@Autowired
//		PasswordEncoder passwordEncoder;
		
		@Autowired
		DataSource dataSource;
	
		@Override
	    protected void configure(HttpSecurity http) throws Exception 
	 	{
			http.cors().and().csrf().disable()
	      	.authorizeRequests()
	        .antMatchers("/**").permitAll()
	        .antMatchers("/user-service/login").permitAll()
	        .antMatchers("/user-service/activate").permitAll()
	        .antMatchers("/user-service/**").access("hasRole('USER')")
	        .antMatchers("/user-service/registerall**").access("hasRole('USER')")
	        .antMatchers("/user-service/admin-landing-page/**").access("hasRole('ADMIN')")		
	      	.and()
	      	.httpBasic();
	 	}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception
		{
			auth.jdbcAuthentication()
			.usersByUsernameQuery("select username,password,active from registers where username=?")
			.authoritiesByUsernameQuery("select username,user_type from registers where username=?")
			.dataSource(dataSource)
			.passwordEncoder(new PasswordEncoder() {

				@Override
				public String encode(CharSequence rawPassword) 
				{
					return rawPassword.toString();
				}

				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) 
				{
					return rawPassword.equals(encodedPassword);
				}
			});
		}
		@Bean
		public CorsFilter corsFilter()
		{
			UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource=new UrlBasedCorsConfigurationSource();
			CorsConfiguration corsConfiguration=new CorsConfiguration();
			corsConfiguration.setAllowCredentials(true);
			corsConfiguration.addAllowedOrigin("*");
			corsConfiguration.addAllowedHeader("*");
			corsConfiguration.addAllowedMethod("OPTIONS");
			corsConfiguration.addAllowedMethod("GET");
			corsConfiguration.addAllowedMethod("POST");
			corsConfiguration.addAllowedMethod("PUT");
			corsConfiguration.addAllowedMethod("DELETE");
			urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
			return new CorsFilter(urlBasedCorsConfigurationSource);
		}
}
