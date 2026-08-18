package com.cine_java.domain.dto;

import com.cine_java.domain.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MovieDto(
        Long id,

        @NotBlank(message = "La pelicula debe tener un titulo que no esté vacío")
        String title,

        @Positive(message = "El valor de la duración debe ser un número positivo")
        Integer duration,


        Genre genre,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior o igual a la actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "El valor minimo de calificacion debe ser cero")
        @Max(value = 5, message = "El valor maximo de la calificacion debe ser cinco")
        Double rating,


        Boolean state
) {
}
