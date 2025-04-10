package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Nota;
import com.lucasgois.schoolflow.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public List<Nota> listarTodas() {
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Nota> buscarPorId(@PathVariable Long id) {
        return notaRepository.findById(id);
    }

    @PostMapping
    public Nota criar(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        notaRepository.deleteById(id);
    }
}
