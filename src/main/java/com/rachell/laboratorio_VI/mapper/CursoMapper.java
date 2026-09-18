package com.rachell.laboratorio_VI.mapper;

import com.rachell.laboratorio_VI.dto.CursoDTO;
import com.rachell.laboratorio_VI.entity.Curso;

public class CursoMapper {

    public static Curso toEntity(CursoDTO cursoDTO) {
        Curso curso = new Curso();

        curso.setId(cursoDTO.getId());
        curso.setNombre(cursoDTO.getNombre());
        curso.setCodigo(cursoDTO.getCodigo());
        curso.setCreditos(cursoDTO.getCreditos());
        curso.setEstado(cursoDTO.getEstado());

        return curso;
    }

    public static CursoDTO toDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();

        cursoDTO.setId(curso.getId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setCodigo(curso.getCodigo());
        cursoDTO.setCreditos(curso.getCreditos());
        cursoDTO.setEstado(curso.getEstado());

        return cursoDTO;
    }
}
