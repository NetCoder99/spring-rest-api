package com.example.demo.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {

	  http.csrf().disable()
      .cors().and()	
      .authorizeRequests()
      .mvcMatchers(HttpMethod.GET, "/**").permitAll()
      .mvcMatchers(HttpMethod.POST, "/login").permitAll() 
      .mvcMatchers(HttpMethod.GET, "/getCustomers").permitAll() 
      .anyRequest()
      .authenticated();
  }
}