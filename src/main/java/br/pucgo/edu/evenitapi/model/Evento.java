package br.pucgo.edu.evenitapi.model;


import br.pucgo.edu.evenitapi.model.dto.EventoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "eventos")
public class Evento {

    public Evento() {
    }

    public Evento(EventoDto eventoDto) {
        this.id = eventoDto.getId();
        this.titulo = eventoDto.getTitulo();
        this.descricao = eventoDto.getDescricao();
        this.dataInicial = eventoDto.getDataInicial();
        this.dataFinal = eventoDto.getDataFinal();
        this.estado = eventoDto.getEstado();
        this.cidade = eventoDto.getCidade();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(length = 120)
    @Getter @Setter
    private String titulo;

    @Column
    @Getter @Setter
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_evento")
    @Getter @Setter
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_evento")
    @Getter @Setter
    private Usuario usuario;

    @Column(name = "data_inicial")
    @Getter @Setter
    private LocalDate dataInicial;

    @Column(name = "data_final")
    @Getter @Setter
    private LocalDate dataFinal;

    @Column(length = 20)
    @Getter @Setter
    private String estado;

    @Column(length = 50)
    @Getter @Setter
    private String cidade;

}
