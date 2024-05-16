package com.widneydev.cafe_social.servico;

import java.util.List;
import java.util.Optional;

import com.widneydev.cafe_social.dto.UsuarioMapper;
import com.widneydev.cafe_social.dto.UsuarioPostDTO;
import com.widneydev.cafe_social.dto.UsuarioPutDTO;
import com.widneydev.cafe_social.exceptions.BadRequestException;
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
        return usuarioRepositorio.findById(id).orElseThrow(
                () -> new BadRequestException("Usuário não encontrado ou não existe.")
        );
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

    public void update(UsuarioPutDTO usuarioPutDTO){
        // usuario que vai sofrer as atualizações
        Usuario usuarioBD = findById(usuarioPutDTO.getId());
        Usuario usuarioComAtualizacoes = UsuarioMapper.INSTANCE.toUsuario(usuarioPutDTO);


        // definindo o que vai ou não ser atualizado de acordo com o que foi fornecido no json da requisição put
        Usuario usuarioAtualizado = Usuario.builder()
        .id(usuarioBD.getId())
        .nome(Optional.ofNullable(usuarioComAtualizacoes.getNome()).isPresent()?usuarioComAtualizacoes.getNome():usuarioBD.getNome())
        .username(Optional.ofNullable(usuarioComAtualizacoes.getUsername()).isPresent()?usuarioComAtualizacoes.getUsername():usuarioBD.getUsername())
        .email(Optional.ofNullable(usuarioComAtualizacoes.getEmail()).isPresent()?usuarioComAtualizacoes.getEmail():usuarioBD.getEmail())
        .senha(Optional.ofNullable(usuarioComAtualizacoes.getSenha()).isPresent()?usuarioComAtualizacoes.getSenha():usuarioBD.getSenha())
        .idade(Optional.of(usuarioComAtualizacoes.getIdade()).map(i -> i == 0).orElse(true)?usuarioBD.getIdade():usuarioComAtualizacoes.getIdade())
        .build();

        usuarioRepositorio.save(usuarioAtualizado);
    }

}
