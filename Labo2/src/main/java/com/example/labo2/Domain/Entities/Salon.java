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
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false)
    private String ornamentoDistintivo;

    @ManyToOne
    @JoinColumn(name = "id_posada", nullable = false, foreignKey = @ForeignKey(name = "FK_posada"))
    private Posada posada;
}
