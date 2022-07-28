package com.jpa.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jpa.demo.service.UserService;

@EnableWebSecurity
public class SecurityConfig {

   private static UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
   

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userService)
            .passwordEncoder(passwordEncoder());
    }


    protected void configure( HttpSecurity http ) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/customer/**")
                    .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/product/**")
                    .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/order/**")
                    .hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/api/customer/**")
                    .permitAll()
                .anyRequest().authenticated()
            .and()
                .httpBasic()
                
           
        ;
    }

  
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui/index.html",
                "/webjars/**");
    }
}
