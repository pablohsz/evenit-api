package br.pucgo.edu.evenitapi.model.dto;

import br.pucgo.edu.evenitapi.model.Evento;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class EventoRelatorioDto {

    public EventoRelatorioDto() {
    }

    public EventoRelatorioDto(Evento evento) {
        this.id = evento.getId();
        this.titulo = evento.getTitulo();
        this.descricao = evento.getDescricao();
        this.categoria = evento.getCategoria().getCategoria();
        this.usuario = evento.getUsuario().getUsername();
        this.dataInicial = Date.valueOf(evento.getDataInicial());
        this.dataFinal = Date.valueOf(evento.getDataFinal());
        this.modalidade = evento.getModalidade();
    }

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String titulo;

    @Getter
    @Setter
    private String descricao;

    @Getter
    @Setter
    private String categoria;

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private Date dataInicial;

    @Getter
    @Setter
    private Date dataFinal;

    @Getter
    @Setter
    private String modalidade;

}
