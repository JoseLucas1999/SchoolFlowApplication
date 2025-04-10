package com.lucasgois.schoolflow.repository;

import com.lucasgois.schoolflow.model.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletimRepository extends JpaRepository<Boletim, Long> {
}
