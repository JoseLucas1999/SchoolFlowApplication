package com.lucasgois.schoolflow.controller;

import com.lucasgois.schoolflow.model.Boletim;
import com.lucasgois.schoolflow.repository.BoletimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boletins")
public class BoletimController {

    @Autowired
    private BoletimRepository boletimRepository;

    @GetMapping
    public List<Boletim> listarTodos() {
        return boletimRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Boletim> buscarPorId(@PathVariable Long id) {
        return boletimRepository.findById(id);
    }

    @PostMapping
    public Boletim criar(@RequestBody Boletim boletim) {
        return boletimRepository.save(boletim);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        boletimRepository.deleteById(id);
    }
}
