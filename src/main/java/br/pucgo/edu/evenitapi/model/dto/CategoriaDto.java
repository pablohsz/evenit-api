package br.pucgo.edu.evenitapi.model.dto;

import lombok.Getter;
import lombok.Setter;

public class CategoriaDto {

    public CategoriaDto() {
    }

    public CategoriaDto(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    @Getter
    @Setter
    private Long id;


    @Getter
    @Setter
    private String categoria;
}
