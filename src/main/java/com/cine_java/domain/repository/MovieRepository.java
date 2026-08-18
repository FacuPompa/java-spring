package com.cine_java.domain.repository;

import com.cine_java.domain.dto.MovieDto;
import com.cine_java.domain.dto.UpdateMovieDto;
import org.hibernate.sql.Update;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
}
