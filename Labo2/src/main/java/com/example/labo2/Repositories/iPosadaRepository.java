package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Posada;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iPosadaRepository extends iGenericRepository<Posada, UUID> {
    public Posada findByNombre(String nombre);

    @Query("SELECT p FROM Posada p WHERE p.ubicacion = :ubicacion")
    public Posada findByUbicacion(@Param("ubicacion") String ubicacion);

    @Query(nativeQuery = true, value = "SELECT * FROM posada WHERE nombre = :nombre")
    public Posada findPosadaByNombreNative(@Param("nombre") String nombre);
}
