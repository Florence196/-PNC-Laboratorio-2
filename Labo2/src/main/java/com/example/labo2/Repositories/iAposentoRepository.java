package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Aposento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iAposentoRepository extends iGenericRepository<Aposento, UUID>{
    public Aposento findByNombre(String nombre);

    @Query("SELECT a FROM Aposento a WHERE a.posada.nombre = :posadaNombre")
    public Aposento findByPosadaNombre(@Param("posadaNombre") String posadaNombre);

    @Query(nativeQuery = true, value = "SELECT * FROM aposento WHERE nombre = :nombre")
    public Aposento findByNombreNative(@Param("nombre") String nombre);
}
