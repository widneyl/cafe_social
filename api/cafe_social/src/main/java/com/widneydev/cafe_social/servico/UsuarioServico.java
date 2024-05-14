package com.widneydev.cafe_social.servico;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.widneydev.cafe_social.dominio.Usuario;

@Service
public class UsuarioServico {
    
    // lista temporaria para testes enquanto nao consigo conexão com o banco de dados
    private List<Usuario> listaTemporariaDeUsuarios = List.of(
        Usuario.builder().id(1l).nome("Jerico Lima").username("Jerico1234").email("jericoYoutuber2010@gmail.com")
        .senha("cafeMuitoBom").idade(20).build(), 
            
        Usuario.builder().id(2l).nome("Cloroquina").username("cloro").email("cloroquinersShow0@hotmail.com")
        .senha("whiskas").idade(4).build()
    );

    // listando os usuarios do banco de dados (lista por enquanto)
    public List<Usuario> listAll(){
        return listaTemporariaDeUsuarios;
    }

    // procurando usuario por id e exibindo se existir
    public Usuario findById(long id){
        return listaTemporariaDeUsuarios.stream()
            .filter(usuario -> usuario.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario not Found")
        );
    }

}
