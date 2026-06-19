package com.furkan.trendyoliki.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Clean Code için final eklendi
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    // DÜZELTME 1: @Bean eklendi ve standart Set etme kuralı uygulandı
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider(userDetailsServiceImpl);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    
    http.authenticationProvider(authenticationProvider());
    
    http.authorizeHttpRequests(configurer ->
        configurer
            .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/categories/**").permitAll()
            .requestMatchers("/api/cartItems/**").hasRole("Customer")
            .requestMatchers("/api/orders/**").hasRole("Customer")
            .requestMatchers(HttpMethod.POST, "/api/products").hasRole("Seller")
            .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("Seller")
            .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("Seller")
            .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("Seller")
            .requestMatchers("/api/users/**").hasRole("Admin")
            .requestMatchers("/api/categories/**").hasRole("Admin")
            .anyRequest().authenticated()
    )
    // ↓ BUNU DEĞİŞTİR!
    .httpBasic(basic -> basic
        .authenticationEntryPoint((request, response, authException) -> {
            response.setStatus(401);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Unauthorized\"}");
        })
    );

    http.csrf(csrf -> csrf.disable());
    return http.build();
}   
}

/*Gün 1 ✅: Entity + Repository + Service
Gün 2:   ✅ Controller'lar
Gün 3:   ✅ Spring Security
Gün 4:    Görsel yükleme + Arama/Filtreleme
Gün 5:    Kupon sistemi + Order işlemleri
Gün 6:    Postman test + Bug fix
Gün 7:    Frontend (HTML/CSS/JS)
Gün 8:    GitHub + Son düzeltmeler */