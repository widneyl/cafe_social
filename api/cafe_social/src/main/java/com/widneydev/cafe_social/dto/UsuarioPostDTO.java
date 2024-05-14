package com.widneydev.cafe_social.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioPostDTO {
    private String nome;
    private String username;
    private String email;
    private String senha;
    private int idade;

}
