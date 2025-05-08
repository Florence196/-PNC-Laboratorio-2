package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Rol;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

@Transactional
public interface iRolRepository extends iGenericRepository<Rol, UUID>{
    public Rol findRolByIdRol(UUID idRol);

    @Query("SELECT r FROM Rol r WHERE r.nombre = :nombre")
    public Rol findRolByNombre(String nombre);

    @Query(nativeQuery = true, value = "SELECT * FROM rol WHERE nombre = :nombre")
    public Rol findRolByNombreNative(String nombre);
}
