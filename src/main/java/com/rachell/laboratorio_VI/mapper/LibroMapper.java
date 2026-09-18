package com.rachell.laboratorio_VI.mapper;

import com.rachell.laboratorio_VI.dto.LibroDTO;
import com.rachell.laboratorio_VI.entity.Libro;

public class LibroMapper {

    public static LibroDTO toDTO(Libro libro) {
        return new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getAnioPublicacion(),
                libro.getEstado()
        );
    }

    public static Libro toEntity(LibroDTO libroDTO) {
        return new Libro(
                libroDTO.getId(),
                libroDTO.getTitulo(),
                libroDTO.getAutor(),
                libroDTO.getIsbn(),
                libroDTO.getAnioPublicacion(),
                libroDTO.getEstado()
        );
    }
}