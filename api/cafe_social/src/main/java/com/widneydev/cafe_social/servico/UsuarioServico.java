package com.widneydev.cafe_social.servico;

import java.util.List;

import com.widneydev.cafe_social.dto.UsuarioMapper;
import com.widneydev.cafe_social.dto.UsuarioPostDTO;
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

    public List<Usuario> listAll(){
        return usuarioRepositorio.findAll();
    }

    // procurando usuario por id e exibindo se existir
    public Usuario findById(long id){
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public List<Usuario> findByNome(String name) {
        return usuarioRepositorio.findByNome(name);
    }

    public List<Usuario> findByIdade(int idade){
        return usuarioRepositorio.findByIdade(idade);
    }

    public Usuario save(UsuarioPostDTO usuarioPostDTO){
        Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioPostDTO);
        return usuarioRepositorio.save(usuario);
    }

    public void delete(Long id){
        usuarioRepositorio.delete(findById(id));
    }

    // metodo update vai precisar de ajustes
    public void update(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

}
