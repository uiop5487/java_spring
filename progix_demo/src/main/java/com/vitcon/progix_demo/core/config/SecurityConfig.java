package com.vitcon.progix_demo.core.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.vitcon.progix_demo.core.jwt.JwtAccessDeniedHandler;
import com.vitcon.progix_demo.core.jwt.JwtAuthenticationEntryPoint;
import com.vitcon.progix_demo.core.jwt.JwtSecurityConfig;
import com.vitcon.progix_demo.core.jwt.TokenProvider;

@Configuration
public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(
        TokenProvider tokenProvider,
		CorsFilter corsFilter,
		JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
		JwtAccessDeniedHandler jwtAccessDeniedHandler
    ) {
        this.tokenProvider = tokenProvider;
        this.corsFilter = corsFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http			
		
        .cors().configurationSource(corsConfigurationSource())    // rest api이므로 csrf 보안이 필요없으므로 disable처리.
        .and().csrf().disable()
         .httpBasic().disable();
              

     http.sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // jwt token으로 인증하므로 stateless 하도록 처리.
         // .and()

    http.authorizeRequests()	
        // .antMatchers("/board/create").hasRole("USER")  // 인증권한이 필요한 페이지. 
        // .antMatchers("/api/v1/board/edit").hasRole("USER")  // 인증권한이 필요한 페이지. 
        .antMatchers("/api/v1/get").permitAll()
        .antMatchers("/api/v1/login").permitAll();
        // .antMatchers("/api/v1/board/edit").permitAll();
    
    http
        .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
        // .addFilterBefore(usernamepass, JwtFilter.class)
        .exceptionHandling()
        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .accessDeniedHandler(jwtAccessDeniedHandler);
        // .expressionHanling
        // .antMatchers("/api/").permitAll();
        // .antMatchers("/").permitAll()
        // .anyRequest().authenticated();     // 나머지 모든 요청 불허  ( 생략 가능 )

    http.apply(new JwtSecurityConfig(tokenProvider));

    // http.addFilter(jwtau)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
