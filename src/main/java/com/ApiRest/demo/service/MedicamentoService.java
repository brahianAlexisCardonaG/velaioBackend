package com.ApiRest.demo.service;

import com.ApiRest.demo.entity.Medicamento;
import com.ApiRest.demo.repository.IMedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    private IMedicamentoRepository medicamentoRepository;

    @Autowired
    public MedicamentoService(IMedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public void createdMedicamento(Medicamento medicamento){
        medicamentoRepository.save(medicamento);
    }

    public void updateMedicamento(Medicamento medicamento){
        medicamentoRepository.save(medicamento);
    }

    public void deleteMedicamento(Long id){
        medicamentoRepository.deleteById(id);
    }

    public List<Medicamento> getAllMedicamentos(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return medicamentoRepository.findAll(sort);
    }

    public Optional<Medicamento> getMedicamentoById(Long id){
        return medicamentoRepository.findById(id);
    }

    public List<Medicamento> getMedicamentoByNombre(String nombre){
        return medicamentoRepository.findByNombre(nombre);
    }

    public List<Medicamento> getMedicamentoByLaboratorio(String laboratorioFabrica){
        return medicamentoRepository.findByLaboratorioFabrica(laboratorioFabrica);
    }

    @Transactional
    public void restarStock(Long id, Long discountStock) {
        Optional<Medicamento> idMedicamento = medicamentoRepository.findById(id);
        if(idMedicamento.isPresent()) {
            Medicamento medicamento = idMedicamento.get();
            Long newStock = medicamento.getCantidadStock() - discountStock;

            if(newStock <= 0){
                throw new RuntimeException("Por favor verifique la cantidad ya que no debe superar el stock actual.");
            }

            medicamento.setCantidadStock(newStock);
            medicamentoRepository.save(medicamento);
        }
    }

}
