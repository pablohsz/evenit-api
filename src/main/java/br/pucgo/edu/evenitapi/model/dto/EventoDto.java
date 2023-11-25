package br.pucgo.edu.evenitapi.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class EventoDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private Long categoria;

    @Getter @Setter
    private String usuario;

    @Getter @Setter
    private LocalDate dataInicial;

    @Getter @Setter
    private LocalDate dataFinal;

    @Getter @Setter
    private String estado;

    @Getter @Setter
    private String cidade;

}
