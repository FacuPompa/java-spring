package com.cine_java.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record SuggestRequestDto(

        @Schema(
                description = "User preferences for receiving recommendations",
                example = "I want a short, exciting sci-fi movie."
        )

        String userPreferences) {


}
