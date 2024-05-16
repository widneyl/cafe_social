package com.widneydev.cafe_social.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioPutDTO {
    @NotNull(message = "Para atualizar usuário, o ID não pode ser vazio ou nulo.")
    private Long id;
    private String nome;
    private String username;
    @Email(message = "Email inválido")
    private String email;
    private String senha;
    private int idade;

}
