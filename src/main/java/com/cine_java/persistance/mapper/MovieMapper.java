package com.cine_java.persistance.mapper;

import com.cine_java.domain.dto.MovieDto;
import com.cine_java.persistance.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);
}
