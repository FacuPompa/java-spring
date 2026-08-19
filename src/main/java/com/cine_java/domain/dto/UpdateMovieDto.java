package com.cine_java.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public record UpdateMovieDto(

        @Schema(
                description = "New movie title",
                example = "Titanic: Special edition"
        )
        @NotBlank(message = "El titulo es obligatorio")
        String title,


        @Schema(
                description = "New release date",
                example = "1997-12-19"
        )
        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual")
        LocalDate releaseDate,


        @Schema(
                description = "New movie rating",
                example = "8.6",
                minimum = "0",
                maximum = "10"
        )
        @Min(value = 0, message = "La calificacion no puede ser menor a 0")
        @Max(value = 10, message = "La calificacion no puede ser mayor a 10")
        Double rating
) {
}
