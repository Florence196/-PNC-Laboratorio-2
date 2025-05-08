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
public class Boton {
    @Id
    private Integer numeroMagico;

    @Column(unique = true, nullable = false)
    private String color;

    @OneToOne
    @JoinColumn(name = "id_piso", nullable = false, foreignKey = @ForeignKey(name = "FK_piso"))
    private Piso piso;
}
