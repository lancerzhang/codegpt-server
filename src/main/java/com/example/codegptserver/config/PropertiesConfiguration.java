package com.example.codegptserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfiguration {

    @Bean
    public OpenAIProperties openAIProperties() {
        return new OpenAIProperties();
    }
}
