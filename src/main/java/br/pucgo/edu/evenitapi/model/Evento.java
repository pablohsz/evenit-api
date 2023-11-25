package br.pucgo.edu.evenitapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "eventos")
public class Evento {

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
    private Date dataInicial;

    @Column(name = "data_final")
    @Getter @Setter
    private Date dataFinal;

    @Column(length = 20)
    @Getter @Setter
    private String estado;

    @Column(length = 50)
    @Getter @Setter
    private String cidade;

}
