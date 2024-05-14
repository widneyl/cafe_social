package com.widneydev.cafe_social.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome; // nome formal do usuario
    
    private String username; // necessário lógica para evitar usernames duplicados
    
    private String email; // necessário lógica para validação de email do usuario
    
    private String senha; // lógica para proteção de senhas no banco de dados

    private int idade; // a idade vai vir como a data de nascimento no front, na api será feita a conversão para a idade

}
