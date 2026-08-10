package com.cine_java.web.controller;

import com.cine_java.domain.service.CineJavaAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String platform;
    private final CineJavaAiService aiService;

    public HelloController(@Value("${spring.application.name}") String platform, CineJavaAiService aiService) {
        this.platform = platform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.aiService.generateGreeting(platform);
    }
}
