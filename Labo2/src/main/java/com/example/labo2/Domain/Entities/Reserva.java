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
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idReserva;

    @Column(nullable = false)
    private String fechaEntrada;

    @Column(nullable = false)
    private String fechaSalida;

    @Column(nullable = false)
    private Boolean estadoVigente;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_cliente"))
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "id_aposento", foreignKey = @ForeignKey(name = "FK_aposento"))
    private Aposento aposento;

    @ManyToOne
    @JoinColumn(name = "id_salon", foreignKey = @ForeignKey(name = "FK_salon"))
    private Salon salon;
}
