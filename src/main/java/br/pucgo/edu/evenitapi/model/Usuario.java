package br.pucgo.edu.evenitapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(length = 15)
    @Getter @Setter
    private String username;

    @Column(length = 50)
    @Getter @Setter
    private String nome;

    @Column(length = 50)
    @Getter @Setter
    private String email;

    @Column
    @Getter @Setter
    private String senha;

    @Column
    @Getter @Setter
    private Boolean admin;
}
