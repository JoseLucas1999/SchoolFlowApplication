package com.lucasgois.schoolflow.repository;

import com.lucasgois.schoolflow.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
}
