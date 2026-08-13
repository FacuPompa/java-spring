package com.cine_java.persistance.mapper;

import com.cine_java.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genero) {
        if (genero == null) return null;

        return switch (genero.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "EPICA" -> Genre.EPIC;
            case "AVENTURA" -> Genre.ADVENTURE;
            case "DRAMA" -> Genre.DRAMA;
            case "CIENCIA_FICCION" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        if (genre == null) return null;

        return switch (genre) {
            case ACTION -> "ACCION";
            case EPIC -> "EPICA";
            case ADVENTURE -> "AVENTURA";
            case DRAMA -> "DRAMA";
            case SCI_FI -> "CIENCIA_FICCION";
            default -> null;
        };
    }
}
