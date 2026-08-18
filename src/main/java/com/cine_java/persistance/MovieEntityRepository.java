package com.cine_java.persistance;

import com.cine_java.domain.dto.MovieDto;
import com.cine_java.domain.dto.UpdateMovieDto;
import com.cine_java.domain.exception.MovieAlreadyExistsException;
import com.cine_java.domain.exception.MovieNotFoundException;
import com.cine_java.domain.repository.MovieRepository;
import com.cine_java.persistance.crud.CrudMovieEntity;
import com.cine_java.persistance.entity.MovieEntity;
import com.cine_java.persistance.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElseThrow(MovieNotFoundException::new);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        };

        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setEstado("D");

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElseThrow(MovieNotFoundException::new);

        if(!movieEntity.getTitulo().equals(updateMovieDto.title())) {
            MovieEntity existingMovie = this.crudMovieEntity.findFirstByTitulo(updateMovieDto.title());
        }

        if(movieEntity != null) {
            throw new MovieAlreadyExistsException(updateMovieDto.title());
        }

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public void delete(long id) {

        var movieEntity = crudMovieEntity.findById(id).orElseThrow(MovieNotFoundException::new);
        this.crudMovieEntity.deleteById(id);
    }

}
