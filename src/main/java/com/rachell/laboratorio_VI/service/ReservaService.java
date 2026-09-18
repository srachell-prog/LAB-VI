package com.rachell.laboratorio_VI.service;

import com.rachell.laboratorio_VI.dto.ReservaDTO;
import com.rachell.laboratorio_VI.entity.Reserva;
import com.rachell.laboratorio_VI.mapper.ReservaMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaService {

    private final List<Reserva> reservas = new ArrayList<>();
    private Long siguienteId = 1L;

    public ReservaDTO crear(ReservaDTO reservaDTO) {
        Reserva reserva = ReservaMapper.toEntity(reservaDTO);
        reserva.setId(siguienteId++);
        reservas.add(reserva);

        return ReservaMapper.toDTO(reserva);
    }

    public List<ReservaDTO> listar() {
        return reservas.stream()
                .map(ReservaMapper::toDTO)
                .toList();
    }

    public Optional<ReservaDTO> buscarPorId(Long id) {
        return reservas.stream()
                .filter(reserva -> reserva.getId().equals(id))
                .findFirst()
                .map(ReservaMapper::toDTO);
    }

    public Optional<ReservaDTO> actualizar(Long id, ReservaDTO reservaDTO) {
        Optional<Reserva> reservaEncontrada = reservas.stream()
                .filter(reserva -> reserva.getId().equals(id))
                .findFirst();

        if (reservaEncontrada.isEmpty()) {
            return Optional.empty();
        }

        Reserva reserva = reservaEncontrada.get();

        reserva.setNombreCliente(reservaDTO.getNombreCliente());
        reserva.setHabitacion(reservaDTO.getHabitacion());
        reserva.setFechaEntrada(reservaDTO.getFechaEntrada());
        reserva.setFechaSalida(reservaDTO.getFechaSalida());
        reserva.setEstado(reservaDTO.getEstado());

        return Optional.of(ReservaMapper.toDTO(reserva));
    }

    public boolean cancelar(Long id) {
        return reservas.removeIf(reserva -> reserva.getId().equals(id));
    }
}