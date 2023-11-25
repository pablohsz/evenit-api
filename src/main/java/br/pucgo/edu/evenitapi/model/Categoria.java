package br.pucgo.edu.evenitapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(length = 40)
    @Getter @Setter
    private String categoria;

    @Column(length = 120)
    @Getter @Setter
    private String descricao;
}
