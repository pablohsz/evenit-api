package br.pucgo.edu.evenitapi.model.dto;

import lombok.Getter;
import lombok.Setter;

public class UsuarioDto {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String senha;

}
