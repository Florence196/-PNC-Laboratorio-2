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
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idFactura;

    @Column(nullable = false)
    private String fechaEmision;

    @Column(nullable = false)
    private Double totalCobrado;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false, foreignKey = @ForeignKey(name = "FK_reserva"))
    private Reserva reserva;
}
