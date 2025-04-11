package com.lucasgois.schoolflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasgois.schoolflow.model.Professor;
import com.lucasgois.schoolflow.repository.ProfessorRepository;
@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}
