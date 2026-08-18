package com.cine_java.domain.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException() {
        super("Película no encontrada.");
    }
}
