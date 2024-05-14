package com.widneydev.cafe_social.servico;

import java.util.List;

import com.widneydev.cafe_social.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.widneydev.cafe_social.modelo.Usuario;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
    private final UsuarioRepositorio usuarioRepositorio;

    // listando os usuarios do banco de dados (lista por enquanto)
    public List<Usuario> listAll(){
        return usuarioRepositorio.findAll();
    }

    // procurando usuario por id e exibindo se existir
    public Usuario findById(long id){
        return usuarioRepositorio.findById(id).orElseThrow();
    }

}
