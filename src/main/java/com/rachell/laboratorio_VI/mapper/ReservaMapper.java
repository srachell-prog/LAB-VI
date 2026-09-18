package com.rachell.laboratorio_VI.mapper;

import com.rachell.laboratorio_VI.dto.ReservaDTO;
import com.rachell.laboratorio_VI.entity.Reserva;

public class ReservaMapper {

    public static Reserva toEntity(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();

        reserva.setId(reservaDTO.getId());
        reserva.setNombreCliente(reservaDTO.getNombreCliente());
        reserva.setHabitacion(reservaDTO.getHabitacion());
        reserva.setFechaEntrada(reservaDTO.getFechaEntrada());
        reserva.setFechaSalida(reservaDTO.getFechaSalida());
        reserva.setEstado(reservaDTO.getEstado());

        return reserva;
    }

    public static ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO();

        reservaDTO.setId(reserva.getId());
        reservaDTO.setNombreCliente(reserva.getNombreCliente());
        reservaDTO.setHabitacion(reserva.getHabitacion());
        reservaDTO.setFechaEntrada(reserva.getFechaEntrada());
        reservaDTO.setFechaSalida(reserva.getFechaSalida());
        reservaDTO.setEstado(reserva.getEstado());

        return reservaDTO;
    }
}