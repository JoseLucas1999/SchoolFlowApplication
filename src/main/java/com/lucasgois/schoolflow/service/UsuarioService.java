package com.lucasgois.schoolflow.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.lucasgois.schoolflow.dto.UsuarioRequestDTO;
import com.lucasgois.schoolflow.dto.UsuarioResponseDTO;
import com.lucasgois.schoolflow.model.Usuario;
import com.lucasgois.schoolflow.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha()); // ⚠️ ainda não criptografada!
        usuario.setRole(dto.getRole());

        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(salvo);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }
}

/*Essa classe faz parte da camada de serviço (service layer). 
 * Ela é responsável por conter a lógica de negócio da aplicação 
 * — ou seja, é onde ficam as "regras" de como as coisas funcionam por trás das rotas (controllers).*/

/* Por que essa classe é necessária?
Ela serve para centralizar a lógica de negócio da sua aplicação:

Deixa o Controller mais limpo (o controller só cuida da entrada e saída HTTP).

Facilita testes, manutenção e reaproveitamento de código.

Segue o padrão de arquitetura em camadas (Controller → Service → Repository).

*/





















