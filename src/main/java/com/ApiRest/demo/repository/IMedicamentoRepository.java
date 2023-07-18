package com.ApiRest.demo.repository;

import com.ApiRest.demo.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicamentoRepository extends JpaRepository <Medicamento, Long> {

    List<Medicamento> findByNombre(String nombre);
    List<Medicamento> findByLaboratorioFabrica(String laboratorioFabrica);

}
