package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Regalia;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iRegaliaRepository extends iGenericRepository<Regalia, UUID> {
    public Regalia findByNombre(String nombre);

    @Query("SELECT r FROM Regalia r WHERE r.posada.nombre = :posadaName")
    public Regalia findByPosadaName(@Param("posadaName") String posadaName);

    @Query(nativeQuery = true, value = "SELECT * FROM regalia WHERE costo = :costo")
    public Regalia findByCosto(@Param("costo") Integer costo);
}
