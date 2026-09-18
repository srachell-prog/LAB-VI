package com.rachell.laboratorio_VI.service;

import com.rachell.laboratorio_VI.dto.LibroDTO;
import com.rachell.laboratorio_VI.entity.Libro;
import com.rachell.laboratorio_VI.mapper.LibroMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroService {

    private final List<Libro> libros = new ArrayList<>();
    private Long siguienteId = 1L;

    public LibroDTO crear(LibroDTO libroDTO) {
        Libro libro = LibroMapper.toEntity(libroDTO);
        libro.setId(siguienteId++);
        libros.add(libro);

        return LibroMapper.toDTO(libro);
    }

    public List<LibroDTO> listar() {
        return libros.stream()
                .map(LibroMapper::toDTO)
                .toList();
    }

    public Optional<LibroDTO> buscarPorTitulo(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .map(LibroMapper::toDTO);
    }

    public Optional<LibroDTO> actualizar(Long id, LibroDTO libroDTO) {
        Optional<Libro> libroEncontrado = libros.stream()
                .filter(libro -> libro.getId().equals(id))
                .findFirst();

        if (libroEncontrado.isEmpty()) {
            return Optional.empty();
        }

        Libro libro = libroEncontrado.get();

        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setIsbn(libroDTO.getIsbn());
        libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        libro.setEstado(libroDTO.getEstado());

        return Optional.of(LibroMapper.toDTO(libro));
    }

    public boolean eliminar(Long id) {
        return libros.removeIf(libro -> libro.getId().equals(id));
    }
}