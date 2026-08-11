package com.cine_java.domain.repository;

import com.cine_java.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
}
