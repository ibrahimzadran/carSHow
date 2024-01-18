package com.binary.carShow.security;

import com.binary.carShow.entity.Car;
import com.binary.carShow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserServiceImpl userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // everyone should be able to access Get the data
        // only admin should be able to add and edit
        //hasRole for specific user to get or post
        // hasAnyRole to let everyone within the parameter to post or get
        return http
                .cors(Customizer.withDefaults())
                .csrf(c-> c.disable())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers(HttpMethod.GET, "/api/v1/car/*").hasAnyRole("USER","ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/car/*").hasRole("ADMIN")
                                .anyRequest()
                                .authenticated()

                )
                .build();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((userService))
                .passwordEncoder(new BCryptPasswordEncoder());
    }



    //csrf Cross site request forgery attack
    // cors ->

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }





    // Header -> Authentication: Basic Auth means Username : Password
    // Body -> {
    // id:1,
    // make: "Toyota"
    // }
}
