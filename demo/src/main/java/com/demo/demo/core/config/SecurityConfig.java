package com.demo.demo.core.config;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.demo.demo.service.response.RestWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
	RestWriter restWriter;

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                    org.springframework.security.core.AuthenticationException authException)
                    throws IOException, ServletException {
                        if(request.getRequestURI().indexOf("/apis") < 0) {
                            RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
                            redirectStrategy.sendRedirect(request, response, "/login" + request.getServerPort());
                            return;
                        }
                        restWriter.writeCode(request, response, "error");
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
        .antMatchers("/apis/auth/signup").anonymous()
        .antMatchers("/apis/auth/login").anonymous()
        .antMatchers("/apis/dashboard/*").authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll();
        return http.build();
    }

//     @Bean
// public AuthenticationFailureHandler authenticationFailureHandler() {
//     return new CustomAuthenticationFailureHandler();
// } 

// @Bean
// public AuthenticationSuccessHandler authenticationSuccessHandler() {
//    return new CustomAuthenticationSuccessHandler();
// }

// @Bean
// public AccessDeniedHandler accessDeniedHandler() {
//    return new CustomAccessDeniedHandler();
// }

}
