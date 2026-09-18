package com.rachell.laboratorio_VI.service;

import com.rachell.laboratorio_VI.dto.CursoDTO;
import com.rachell.laboratorio_VI.entity.Curso;
import com.rachell.laboratorio_VI.mapper.CursoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoService {

    private final List<Curso> cursos = new ArrayList<>();
    private Long siguienteId = 1L;

    public CursoDTO crear(CursoDTO cursoDTO) {
        Curso curso = CursoMapper.toEntity(cursoDTO);
        curso.setId(siguienteId++);
        cursos.add(curso);

        return CursoMapper.toDTO(curso);
    }

    public List<CursoDTO> listar() {
        return cursos.stream()
                .map(CursoMapper::toDTO)
                .toList();
    }

    public Optional<CursoDTO> buscarPorCodigo(String codigo) {
        return cursos.stream()
                .filter(curso -> curso.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .map(CursoMapper::toDTO);
    }

    public Optional<CursoDTO> actualizar(Long id, CursoDTO cursoDTO) {
        Optional<Curso> cursoEncontrado = cursos.stream()
                .filter(curso -> curso.getId().equals(id))
                .findFirst();

        if (cursoEncontrado.isEmpty()) {
            return Optional.empty();
        }

        Curso curso = cursoEncontrado.get();

        curso.setNombre(cursoDTO.getNombre());
        curso.setCodigo(cursoDTO.getCodigo());
        curso.setCreditos(cursoDTO.getCreditos());
        curso.setEstado(cursoDTO.getEstado());

        return Optional.of(CursoMapper.toDTO(curso));
    }

    public boolean eliminar(Long id) {
        return cursos.removeIf(curso -> curso.getId().equals(id));
    }
}