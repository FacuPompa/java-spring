package com.cine_java.web.controller;

import com.cine_java.domain.service.CineJavaAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Tag(name = "AI", description = "Operations that use artificial intelligence")
public class HelloController {
    private final String platform;
    private final CineJavaAiService aiService;

    public HelloController(@Value("${spring.application.name}") String platform, CineJavaAiService aiService) {
        this.platform = platform;
        this.aiService = aiService;
    }

    @Operation(
            summary = "Generate greeting",
            description = "Generate a welcome greeting for Cine Java using AI.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Greeting successfully generated"
                    )
            }
    )
    @GetMapping("/hello")
    public String hello() {
        return this.aiService.generateGreeting(platform);
    }
}
