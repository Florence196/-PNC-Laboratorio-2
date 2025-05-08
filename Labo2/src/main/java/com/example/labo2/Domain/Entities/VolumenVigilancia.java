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
public class VolumenVigilancia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idVolumenVigilancia;

    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private Boolean estadoVigente;

    @ManyToOne
    @JoinColumn(name = "id_piso", nullable = false, foreignKey = @ForeignKey(name = "FK_piso"))
    private Piso piso;

    @ManyToOne
    @JoinColumn(name = "id_guardian", nullable = false, foreignKey = @ForeignKey(name = "FK_guardian"))
    private Guardian guardian;
}
