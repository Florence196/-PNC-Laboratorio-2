package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Reserva;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iReservaRepository extends iGenericRepository<Reserva, UUID> {
    public Reserva findReservaByEstadoVigente(Boolean estadoVigente);

    @Query("SELECT r FROM Reserva r WHERE r.cliente.nombre = :clienteNombre")
    public Reserva findByCliente(@Param("clienteNombre") String clienteNombre);

    @Query(nativeQuery = true, value = "SELECT * FROM reserva WHERE fecha_entrada = :fechaEntrada")
    public Reserva findReservaByFechaEntrada(@Param("fechaEntrada") String fechaEntrada);
}
