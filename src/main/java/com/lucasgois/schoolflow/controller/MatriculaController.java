package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Matricula;
import com.lucasgois.schoolflow.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping
    public List<Matricula> listarTodas() {
        return matriculaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Matricula> buscarPorId(@PathVariable Long id) {
        return matriculaRepository.findById(id);
    }

    @PostMapping
    public Matricula criar(@RequestBody Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        matriculaRepository.deleteById(id);
    }
}
