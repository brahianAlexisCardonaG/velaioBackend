package com.ApiRest.demo.controller;

import com.ApiRest.demo.entity.Medicamento;
import com.ApiRest.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {

    private MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping(value = "crear", headers = "Accept=application/json")
    public void crearMedicamento(@RequestBody Medicamento medicamento){
        medicamentoService.createdMedicamento(medicamento);
    }

    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Medicamento> ListarMedicamentos() {
        return medicamentoService.getAllMedicamentos();
    }

    @GetMapping(value = "listarId/{id}", headers = "Accept=application/json")
    public Optional<Medicamento> listarMedicamentosById(@PathVariable Long id){
        return medicamentoService.getMedicamentoById(id);
    }

    @PutMapping(value = "actualizar", headers = "Accept=application/json")
    public void actualizarMedicamento(@RequestBody Medicamento medicamento){
        medicamentoService.updateMedicamento(medicamento);
    }

    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
    public void eliminarMedicamento(@PathVariable Long id){
        medicamentoService.deleteMedicamento(id);
    }

    @GetMapping(value = "listarNombre/{nombre}", headers = "Accept=application/json")
    public List<Medicamento> listarMedicamentosByNombre(@PathVariable String nombre){
        return medicamentoService.getMedicamentoByNombre(nombre);
    }

    @GetMapping(value = "listarNombre/{laboratorioFabrica}", headers = "Accept=application/json")
    public List<Medicamento> listarMedicamentosByLaboratorio(@PathVariable String laboratorioFabrica){
        return medicamentoService.getMedicamentoByLaboratorio(laboratorioFabrica);
    }

}
