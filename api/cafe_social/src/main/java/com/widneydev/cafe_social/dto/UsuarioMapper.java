package com.widneydev.cafe_social.dto;

import com.widneydev.cafe_social.modelo.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
    // podera ser chamado em qualquer lugar
    public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // vai converter o usuarioPostDTO em entidade Usuario automaticamente
    public abstract Usuario toUsuario(UsuarioPostDTO usuarioPostDTO);

    // futuramente necessário fazer do usuarioPutDTO .....


}
