package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Salon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iSalonRepository extends iGenericRepository<Salon, UUID> {
    public Salon findSalonByCapacidad(Integer capacidad);

    @Query("SELECT s FROM Salon s WHERE s.posada.nombre = :posadaName")
    public Salon findSalonByPosadaName(@Param("posadaName") String posadaName);

    @Query(nativeQuery = true, value = "SELECT * FROM salon WHERE capacidad = :capacidad")
    public Salon findSalonByCapacidadNative(@Param("capacidad") int capacidad);
}
