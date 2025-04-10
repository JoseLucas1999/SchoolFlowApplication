package com.lucasgois.schoolflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasgois.schoolflow.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}

/*JpaRepository<Usuario, Long> — já traz CRUD pronto!
findByEmail — para login
existsByEmail — para evitar duplicidade de cadastro*/