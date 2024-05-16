package com.widneydev.cafe_social.dto;

import com.widneydev.cafe_social.modelo.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T21:36:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2-ea (Private Build)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioPostDTO usuarioPostDTO) {
        if ( usuarioPostDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.nome( usuarioPostDTO.getNome() );
        usuario.username( usuarioPostDTO.getUsername() );
        usuario.email( usuarioPostDTO.getEmail() );
        usuario.senha( usuarioPostDTO.getSenha() );
        usuario.idade( usuarioPostDTO.getIdade() );

        return usuario.build();
    }
}
