package com.example.labo2.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idOrdenTrabajo;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private String hora;

    @Column(nullable = false)
    private String relatoReparacion;

    @ManyToOne
    @JoinColumn(name = "id_guardian", nullable = false, foreignKey = @ForeignKey(name = "FK_guardian"))
    private Guardian guardian;

    @ManyToOne
    @JoinColumn(name = "id_aposento", nullable = false, foreignKey = @ForeignKey(name = "FK_aposento"))
    private Aposento aposento;
}
