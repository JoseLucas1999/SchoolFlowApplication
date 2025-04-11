package com.lucasgois.schoolflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucasgois.schoolflow.model.Aluno;
import com.lucasgois.schoolflow.model.Disciplina;
import com.lucasgois.schoolflow.model.Professor;
import com.lucasgois.schoolflow.model.Turma;
import com.lucasgois.schoolflow.repository.AlunoRepository;
import com.lucasgois.schoolflow.repository.DisciplinaRepository;
import com.lucasgois.schoolflow.repository.ProfessorRepository;
import com.lucasgois.schoolflow.repository.TurmaRepository;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        model.addAttribute("professores", professorRepository.findAll());
        model.addAttribute("turmas", turmaRepository.findAll());
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        return "dashboard/dashboard";
    }
    
}
