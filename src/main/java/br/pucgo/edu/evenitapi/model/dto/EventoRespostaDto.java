package br.pucgo.edu.evenitapi.model.dto;

import br.pucgo.edu.evenitapi.model.Evento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class EventoRespostaDto {

    public EventoRespostaDto() {
    }

    public EventoRespostaDto(Evento evento) {
        this.id = evento.getId();
        this.titulo = evento.getTitulo();
        this.descricao = evento.getDescricao();
        this.categoria = new CategoriaDto(evento.getCategoria().getId(), evento.getCategoria().getCategoria());
        this.usuario = evento.getUsuario().getUsername();
        this.dataInicial = evento.getDataInicial();
        this.dataFinal = evento.getDataFinal();
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
    private CategoriaDto categoria;

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private LocalDate dataInicial;

    @Getter
    @Setter
    private LocalDate dataFinal;

    @Getter
    @Setter
    private String modalidade;

}
