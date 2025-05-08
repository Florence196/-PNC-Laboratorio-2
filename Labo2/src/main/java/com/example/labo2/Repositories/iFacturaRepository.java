package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Factura;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iFacturaRepository extends iGenericRepository<Factura, UUID> {
    public Factura findFacturaByFechaEmision(String fechaEmision);

    @Query("SELECT f FROM Factura f WHERE f.reserva.estadoVigente = :estadoVigente")
    public Factura findFacturaByEstadoVigente(@Param("estadoVigente") Boolean estadoVigente);

    @Query(nativeQuery = true, value = "SELECT * FROM factura WHERE fecha_emision = :fechaEmision")
    public Factura findFacturaByFechaEmisionNative(@Param("fechaEmision") String fechaEmision);
}
