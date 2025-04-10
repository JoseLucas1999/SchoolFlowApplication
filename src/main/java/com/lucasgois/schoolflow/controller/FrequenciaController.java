package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Frequencia;
import com.lucasgois.schoolflow.repository.FrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/frequencias")
public class FrequenciaController {

    @Autowired
    private FrequenciaRepository frequenciaRepository;

    @GetMapping
    public List<Frequencia> listarTodas() {
        return frequenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Frequencia> buscarPorId(@PathVariable Long id) {
        return frequenciaRepository.findById(id);
    }

    @PostMapping
    public Frequencia criar(@RequestBody Frequencia frequencia) {
        return frequenciaRepository.save(frequencia);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        frequenciaRepository.deleteById(id);
    }
}
