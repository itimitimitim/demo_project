package com.myproject.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter{

	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        List<String> origins = new ArrayList<>();
	        origins.add("http://localhost:9999");
	        origins.add("http://localhost:8082");
	        origins.add("http://localhost:8081");
	        origins.add("http://localhost:3000");
	        
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowCredentials(true);
//	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedOrigins(origins);
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
	        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token", "apikey",
	                "token", "jwttoken", "role", "user", "org", "*"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }

}
