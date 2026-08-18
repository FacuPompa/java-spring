package com.cine_java.persistance.crud;

import com.cine_java.persistance.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
    MovieEntity findFirstByTitulo(String titulo);
}
