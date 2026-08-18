package com.cine_java.web.exception;

import com.cine_java.domain.exception.MovieAlreadyExistsException;
import com.cine_java.domain.exception.MovieNotFoundException;
import dev.langchain4j.agent.tool.P;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException e) {
        Error error = new Error("movie-already-exists", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Error> handleException(MovieNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("movie-not-found", e.getMessage()));
    }
}
