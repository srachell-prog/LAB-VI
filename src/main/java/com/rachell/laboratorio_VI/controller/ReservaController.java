package com.rachell.laboratorio_VI.controller;

import com.rachell.laboratorio_VI.dto.ReservaDTO;
import com.rachell.laboratorio_VI.service.ReservaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService = new ReservaService();

    @PostMapping
    public ResponseEntity<ReservaDTO> crear(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO reservaCreada = reservaService.crear(reservaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaCreada);
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> listar() {
        return ResponseEntity.ok(reservaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarPorId(@PathVariable Long id) {
        Optional<ReservaDTO> reserva = reservaService.buscarPorId(id);

        if (reserva.isPresent()) {
            return ResponseEntity.ok(reserva.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ReservaDTO reservaDTO) {

        Optional<ReservaDTO> reservaActualizada =
                reservaService.actualizar(id, reservaDTO);

        if (reservaActualizada.isPresent()) {
            return ResponseEntity.ok(reservaActualizada.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {

        if (reservaService.cancelar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}