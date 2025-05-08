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
public class Piso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idPiso;

    @Column(unique = true, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_posada", nullable = false, foreignKey = @ForeignKey(name = "FK_posada"))
    private Posada posada;
}
