package com.widneydev.cafe_social.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioPostDTO {
    @NotEmpty(message = "Nome não pode ser vazio")
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;
    @NotEmpty(message = "Username não pode ser vazio")
    @NotNull(message = "Username não pode ser nulo")
    private String username;
    @Email(message = "E-mail inválido, tente inserir novamente")
    private String email;
    @NotEmpty(message = "Senha não pode ser vazia")
    @NotNull(message = "Senha não pode ser nula")
    private String senha;
    // @NotEmpty(message = "Idade não pode ser vazio")
    @NotNull(message = "Idade não pode ser nula")
    private int idade;

}
