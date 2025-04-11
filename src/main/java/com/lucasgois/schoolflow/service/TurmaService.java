package com.lucasgois.schoolflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasgois.schoolflow.model.Turma;
import com.lucasgois.schoolflow.repository.TurmaRepository;
@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }
}
