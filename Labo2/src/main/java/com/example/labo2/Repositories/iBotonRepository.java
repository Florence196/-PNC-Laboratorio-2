package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.Boton;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iBotonRepository extends iGenericRepository<Boton, Integer> {
    public Boton findBotonByColor(String color);

    @Query("SELECT b FROM Boton b WHERE b.piso.nombre = :pisoNombre")
    public Boton findByPisoNombre(@Param("pisoNombre") String pisoNombre);

    @Query(nativeQuery = true, value = "SELECT * FROM boton WHERE color = :color")
    public Boton findByColorNative(@Param("color") String color);
}
