package com.rachell.laboratorio_VI.controller;

import com.rachell.laboratorio_VI.dto.LibroDTO;
import com.rachell.laboratorio_VI.service.LibroService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService = new LibroService();

    @PostMapping
    public ResponseEntity<LibroDTO> crear(@RequestBody LibroDTO libroDTO) {
        LibroDTO libroCreado = libroService.crear(libroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroCreado);
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> listar() {
        return ResponseEntity.ok(libroService.listar());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<LibroDTO> buscarPorTitulo(@PathVariable String titulo) {
        Optional<LibroDTO> libro = libroService.buscarPorTitulo(titulo);

        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizar(
            @PathVariable Long id,
            @RequestBody LibroDTO libroDTO) {

        Optional<LibroDTO> libroActualizado =
                libroService.actualizar(id, libroDTO);

        if (libroActualizado.isPresent()) {
            return ResponseEntity.ok(libroActualizado.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (libroService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}