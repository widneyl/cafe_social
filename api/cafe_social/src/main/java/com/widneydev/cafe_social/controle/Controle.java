package com.widneydev.cafe_social.controle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widneydev.cafe_social.dominio.Usuario;
import com.widneydev.cafe_social.servico.UsuarioServico;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Aqui estara os metodos de comuniccação com o banco de dados
@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class Controle {

    private final UsuarioServico usuarioService;

    // primeiro endpoint que irá listar os usuarios
    @GetMapping(path = "list")
    public ResponseEntity<List<Usuario>> list() {
        return ResponseEntity.ok(usuarioService.listAll());
    }
    
    // procurando pelo id do usuario
    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }
}
