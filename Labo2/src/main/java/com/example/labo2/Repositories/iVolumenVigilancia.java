package com.example.labo2.Repositories;

import com.example.labo2.Domain.Entities.VolumenVigilancia;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Transactional
public interface iVolumenVigilancia extends iGenericRepository<VolumenVigilancia, UUID>{
    public VolumenVigilancia findByHorario(String horario);

    @Query("SELECT v FROM VolumenVigilancia v WHERE v.piso.nombre = :pisoName")
    public VolumenVigilancia findByPisoName(@Param("pisoName") String pisoName);

    @Query(nativeQuery = true, value = "SELECT * FROM volumen_vigilancia WHERE estado_vigente = :estadoVigente")
    public VolumenVigilancia findByEstadoVigente(@Param("estadoVigente") String estadoVigente);
}
