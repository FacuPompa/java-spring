package com.cine_java.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "La calificacion no puede ser menor a 0")
        @Max(value = 10, message = "La calificacion no puede ser mayor a 10")
        Double rating
) {
}
