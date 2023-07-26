package com.example.codegptserver.controller;

import com.example.codegptserver.config.OpenAIProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/config")
public class ConfigController {

    private final OpenAIProperties openAIProperties;

    public ConfigController(OpenAIProperties openAIProperties) {
        this.openAIProperties = openAIProperties;
    }

    @GetMapping
    public OpenAIProperties getOpenAIProperties() {
        return openAIProperties;
    }
}
