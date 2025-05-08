package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.RegistroPuntos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iRegistroPuntosRepository extends iGenericRepository<RegistroPuntos, UUID>{
    public RegistroPuntos findByCantidad(Integer cantidad);

    @Query("SELECT rp FROM RegistroPuntos rp WHERE rp.empleado.nombre = :empleadoNombre")
    public RegistroPuntos findByEmpleadoNombre(@Param("empleadoNombre") String empleadoNombre);

    @Query(nativeQuery = true, value = "SELECT * FROM registro_puntos WHERE cantidad = :cantidad")
    public RegistroPuntos findRegistroPuntosByCantidad(@Param("cantidad") Integer cantidad);
}
