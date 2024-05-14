package com.widneydev.cafe_social.controle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.widneydev.cafe_social.modelo.Usuario;
import com.widneydev.cafe_social.servico.UsuarioServico;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;

//Aqui estara os metodos de comuniccação com o banco de dados
@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioControle {

    private final UsuarioServico usuarioService;

    // primeiro endpoint que irá listar os usuarios
    @GetMapping(path = "/listar")
    public ResponseEntity<List<Usuario>> list() {
        return ResponseEntity.ok(usuarioService.listAll());
    }

    // procurando pelo id do usuario
    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

//    http://localhost:8080/usuarios/procurarPorNome?nome=sofia
    @GetMapping(path = "/procurarPorNome")
    public ResponseEntity<List<Usuario>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(usuarioService.findByNome(nome));
    }

    //    http://localhost:8080/usuarios/procurarPorIdade?idade=15
    @GetMapping(path = "/procurarPorIdade")
    public ResponseEntity<List<Usuario>> findByIdade(@RequestParam int idade){
        return ResponseEntity.ok(usuarioService.findByIdade(idade));
    }


    @PostMapping(path = "/cadastrar")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/atualizar")
    public ResponseEntity<Void> update(@RequestBody Usuario usuario){
        usuarioService.update(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}