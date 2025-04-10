package com.lucasgois.schoolflow.repository;

import com.lucasgois.schoolflow.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // pode adicionar métodos customizados se quiser (ex: buscar por nome)
}
