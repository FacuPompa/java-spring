package com.cine_java.web.controller;

import com.cine_java.domain.dto.MovieDto;
import com.cine_java.domain.dto.SuggestRequestDto;
import com.cine_java.domain.dto.UpdateMovieDto;
import com.cine_java.domain.service.CineJavaAiService;
import com.cine_java.domain.service.MovieService;
import jakarta.validation.Valid;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {
    private final MovieService movieService;
    private final CineJavaAiService aiService;

    public MovieController(MovieService movieService, CineJavaAiService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping()
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.aiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));
    }


    @PostMapping()
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        MovieDto movieDtoResponse = this.movieService.add(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDtoResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
