package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.OrdenTrabajo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iOrdenTrabajoRepository extends iGenericRepository<OrdenTrabajo, UUID> {
    public OrdenTrabajo findByFecha(String fecha);

    @Query("SELECT o FROM OrdenTrabajo o WHERE o.aposento.nombre = :aposentoNombre")
    public OrdenTrabajo findByAposentoNombre(@Param("aposentoNombre") String aposentoNombre);

    @Query(nativeQuery = true, value = "SELECT * FROM orden_trabajo WHERE fecha = :fecha")
    public OrdenTrabajo findByFechaNative(@Param("fecha") String fecha);
}
