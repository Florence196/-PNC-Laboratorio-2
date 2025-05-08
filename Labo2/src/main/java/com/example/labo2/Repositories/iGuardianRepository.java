package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Guardian;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iGuardianRepository extends iGenericRepository<Guardian, UUID>{
    public Guardian findByDepartamento(String departamento);

    @Query("SELECT g FROM Guardian g WHERE g.posada.nombre = :nombrePosada")
    public Guardian findByPosada(@Param("nombrePosada") String nombrePosada);

    @Query(nativeQuery = true, value = "SELECT * FROM guardian WHERE departamente = :departamento")
    public Guardian findByDepartamentoNative(@Param("departamento") String departamento);
}
