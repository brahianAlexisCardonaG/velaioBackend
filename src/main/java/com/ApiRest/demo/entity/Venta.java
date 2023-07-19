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

    @Column(name = "id_medicamento")
    private Long idMedicamento;

    @Column(name = "nombre_medicamento")
    private String nombreMedicamento;

    private String fecha;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    private Long cantidad;

    @Column(name = "valor_total")
    private Double valorTotal;

}
