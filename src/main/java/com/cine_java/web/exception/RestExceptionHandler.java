package com.cine_java.web.exception;

import com.cine_java.domain.exception.MovieAlreadyExistsException;
import dev.langchain4j.agent.tool.P;
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
}
