package com.ApiRest.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_medicamento")
    private Medicamento medicamento;

    private String fecha;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    private Long cantidad;

    @Column(name = "valor_total")
    private Double valorTotal;

}
