package com.widneydev.cafe_social.repositorio;

//Aqui estarão as Rotas

import com.widneydev.cafe_social.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNome(String name);
    List<Usuario> findByIdade(int idade);
}
