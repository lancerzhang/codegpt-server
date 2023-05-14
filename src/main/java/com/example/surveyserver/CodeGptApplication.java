package com.example.surveyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CodeGptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeGptApplication.class, args);
    }

}
