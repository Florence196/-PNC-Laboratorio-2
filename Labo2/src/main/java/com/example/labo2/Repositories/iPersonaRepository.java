package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Persona;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iPersonaRepository extends iGenericRepository<Persona, UUID> {
    public Persona findByNombre(String nombre);

    @Query("SELECT p FROM Persona p WHERE p.rol.nombre = :rolName")
    public Persona findByRolName(@Param("rolName") String rolName);

    @Query(nativeQuery = true, value = "SELECT * FROM persona WHERE apellido = :apellido")
    public Persona findByApellido(@Param("apellido") String apellido);
}
