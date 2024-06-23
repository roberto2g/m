package com.sending.mails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")
                        .allowedOrigins("https://6678720aa79a96c9c7798f70--visionary-dieffenbachia-1c0617.netlify.app")
                        .allowedMethods("POST", "OPTIONS")
                        .allowedHeaders("Content-Type");
            }
        };
    }
}

