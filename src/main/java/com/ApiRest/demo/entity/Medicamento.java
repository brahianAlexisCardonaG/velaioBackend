package com.ApiRest.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "medicamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "laboratorio_fabrica")
    private String laboratorioFabrica;

    @Column(name = "fecha_fabricacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFabricacion;

    @Column(name = "fecha_vencimiento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimiento;

    @Column(name = "cantidad_stock")
    private Long cantidadStock;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

}
