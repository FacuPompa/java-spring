package com.cine_java.domain.dto;

import com.cine_java.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean state
) {
}
