package com.cine_java.web.controller;

import com.cine_java.persistance.crud.CrudMovieEntity;
import com.cine_java.persistance.entity.MovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @GetMapping("/movies")
    public List<MovieEntity> getAll() {
        return (List<MovieEntity>) this.crudMovieEntity.findAll();
    }
}
