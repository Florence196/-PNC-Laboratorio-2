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
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idGuardian;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private Boolean esCoordinador;

    @ManyToOne
    @JoinColumn(name = "id_posada", nullable = false, foreignKey = @ForeignKey(name = "FK_posada"))
    private Posada posada;

    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "FK_persona"))
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_supervisor", foreignKey = @ForeignKey(name = "FK_supervisor"))
    private Guardian supervisor;
}
