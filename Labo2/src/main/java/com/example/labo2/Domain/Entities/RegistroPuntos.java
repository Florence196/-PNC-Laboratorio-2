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
public class RegistroPuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRegistroPuntos;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private String fechaUltimaSuma;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_cliente"))
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false, foreignKey = @ForeignKey(name = "FK_empleado"))
    private Persona empleado;
}
