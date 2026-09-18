package com.rachell.laboratorio_VI.controller;

import com.rachell.laboratorio_VI.dto.CursoDTO;
import com.rachell.laboratorio_VI.service.CursoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService = new CursoService();

    @PostMapping
    public ResponseEntity<CursoDTO> crear(@RequestBody CursoDTO cursoDTO) {
        CursoDTO cursoCreado = cursoService.crear(cursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<CursoDTO> buscarPorCodigo(@PathVariable String codigo) {
        Optional<CursoDTO> curso = cursoService.buscarPorCodigo(codigo);

        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizar(
            @PathVariable Long id,
            @RequestBody CursoDTO cursoDTO) {

        Optional<CursoDTO> cursoActualizado =
                cursoService.actualizar(id, cursoDTO);

        if (cursoActualizado.isPresent()) {
            return ResponseEntity.ok(cursoActualizado.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (cursoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
