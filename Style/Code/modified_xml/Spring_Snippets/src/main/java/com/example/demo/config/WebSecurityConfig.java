package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security configuration class for Basic Authentication.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;

    /**
     * Constructs a new WebSecurityConfig instance with the specified {@link UserDetailsService}.
     *
     * @param userDetailsService the UserDetailsService for user authentication.
     */
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Bean definition for the password encoder. In this case, BCryptPasswordEncoder is used.
     *
     * @return the password encoder to be used for encoding and decoding passwords.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the {@link HttpSecurity} to set up web-based security for HTTP requests.
     *
     * @param http the {@link HttpSecurity} to configure.
     * @return the SecurityFilterChain that has been configured.
     * @throws Exception if an error occurs during the configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
        return http.build();
    }

    /**
     * Configures the global {@link AuthenticationManagerBuilder} to use the custom {@link UserDetailsService} and password encoder.
     *
     * @param auth the {@link AuthenticationManagerBuilder} to configure.
     * @return the configured AuthenticationManagerBuilder.
     * @throws Exception if an error occurs during the configuration.
     */
    @Bean
    public AuthenticationManagerBuilder authenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
        return auth;
    }
}
