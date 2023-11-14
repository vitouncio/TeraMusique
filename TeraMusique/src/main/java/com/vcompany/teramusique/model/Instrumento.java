package com.vcompany.teramusique.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 *
 * @author 14892160652
 */
@Data
@Entity

public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;
    private Integer quantDisponivel;

    @ManyToMany
    @JoinTable(
            name = "Instrumentos_Musica",
            joinColumns  = {@JoinColumn(name = "instrumento_id")},
            inverseJoinColumns = {@JoinColumn (name = "musica_id")}
    )
    private List<Musica> lstMusicas;

    public Instrumento() {
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.quantDisponivel = 0;
    }

    public Instrumento(Integer id, String nome, String descricao, Integer quantDisponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantDisponivel = quantDisponivel;
    }

    @Override
    public String toString() {
        String txt = "---- Dados do Instrumento ------\n"
                + "id: " + this.id + "\n"
                + super.toString()
                + " Nome: " + this.nome + "\n"
                + " Descricao: " + this.descricao + "\n"
                + "-------------------------------------\n";

        return txt;
    }
    
}
