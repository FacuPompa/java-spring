package com.cine_java.web.controller;

import com.cine_java.domain.dto.MovieDto;
import com.cine_java.domain.dto.SuggestRequestDto;
import com.cine_java.domain.dto.UpdateMovieDto;
import com.cine_java.domain.service.CineJavaAiService;
import com.cine_java.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.cine_java.web.exception.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Operations about movies of Cine-Java")

public class MovieController {
    private final MovieService movieService;
    private final CineJavaAiService aiService;

    public MovieController(MovieService movieService, CineJavaAiService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping()
    @Operation(
            summary = "Get all movies",
            description = "Returns the full movie catalog from Cine Java.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Listing successfully obtained"
                    )
            }
    )
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by ID",
            description = "Returns the movie that matches the sent ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Movie found"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Movie not found",
                            content = @Content(
                                    schema = @Schema(implementation = Error.class)
                            )
                    )
            }
    )
    public ResponseEntity<MovieDto> getById(
            @Parameter(
                    description = "ID of the movie to search",
                    example = "1"
            )
            @PathVariable long id
    ) {
        MovieDto movieDto = this.movieService.getById(id);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggest")
    @Operation(
            summary = "Generate movie recommendations",
            description = "Receives user preferences and returns an AI-generated movie recommendation.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Recommendation successfully generated"
                    )
            }
    )
    public ResponseEntity<String> generateMovieSuggestion(
            @RequestBody SuggestRequestDto suggestRequestDto
    ) {
        return ResponseEntity.ok(
                this.aiService.generateMoviesSuggestion(
                        suggestRequestDto.userPreferences()
                )
        );
    }


    @PostMapping
    @Operation(
            summary = "Create a movie",
            description = "Saves a new movie in the platform with available status.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Movie successfully created"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid data or duplicated movie",
                            content = @Content(
                                    schema = @Schema(
                                            oneOf = {Error.class, Error[].class}
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<MovieDto> add(
            @RequestBody @Valid MovieDto movieDto
    ) {
        MovieDto movieDtoResponse = this.movieService.add(movieDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieDtoResponse);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Update a movie",
            description = "Updates only the title, release date, and rating of an existing movie.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Movie successfully updated"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid data or duplicated movie",
                            content = @Content(
                                    schema = @Schema(
                                            oneOf = {Error.class, Error[].class}
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Movie not found",
                            content = @Content(
                                    schema = @Schema(implementation = Error.class)
                            )
                    )
            }
    )
    public ResponseEntity<MovieDto> update(
            @Parameter(
                    description = "ID of the movie to update",
                    example = "1"
            )
            @PathVariable long id,

            @RequestBody @Valid UpdateMovieDto updateMovieDto
    ) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a movie",
            description = "Deletes an existing movie from the platform.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Movie successfully deleted"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Movie not found",
                            content = @Content(
                                    schema = @Schema(implementation = Error.class)
                            )
                    )
            }
    )
    public ResponseEntity<Void> delete(
            @Parameter(
                    description = "ID of the movie to delete",
                    example = "1"
            )
            @PathVariable long id
    ) {
        this.movieService.delete(id);

        return ResponseEntity.ok().build();
    }
}
