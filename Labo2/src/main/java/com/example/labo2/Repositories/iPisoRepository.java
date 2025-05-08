package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Piso;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iPisoRepository extends iGenericRepository<Piso, UUID>{
    public Piso findByNombre(String nombre);

    @Query("SELECT p FROM Piso p WHERE p.posada.nombre = :posadaName")
    public Piso findByPosadaName(@Param("posadaName") String posadaName);

    @Query(nativeQuery = true, value = "SELECT * FROM piso WHERE nombre = :nombre")
    public Piso findByNombreNative(@Param("nombre") String nombre);
}
