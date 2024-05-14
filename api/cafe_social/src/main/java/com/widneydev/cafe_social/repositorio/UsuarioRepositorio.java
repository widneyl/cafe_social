package com.widneydev.cafe_social.repositorio;

//Aqui estarão as Rotas

import com.widneydev.cafe_social.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
