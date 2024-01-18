package com.binary.carShow.security;

import com.binary.carShow.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // everyone should be able to access Get the data
        // only admin sould be able to add and edit
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
    //csrf Cross site request forgery attacl
    // cors ->
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(bCryptPasswordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();

        var user = User.builder()
                .username("user")
                .password(bCryptPasswordEncoder().encode("userPass"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
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
