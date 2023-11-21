package com.vcompany.teramusique.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author 14892160652
 */
@Data
@Entity
@Table(name = "Musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private String duracao;
    private String finalidadeNaSessao;

    @ManyToMany(mappedBy = "lstMusicas")
    private List<Sessao> lstSessoes;

    public Musica() {
        this.titulo = "";
        this.artista = "";
        this.album = "";
        this.genero = "";
        this.duracao = "";
        this.finalidadeNaSessao = "";


    }

    public Musica(String titulo, String artista, String album, String genero, String duracao, String finalidadeNaSessao) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracao = duracao;
        this.finalidadeNaSessao = finalidadeNaSessao;

    }
    
    @Override
    public String toString() {
        String txt = "---- Dados do Musica ------\n"
                + "id: " + this.id + "\n"
                + super.toString()
                + " Titulo: " + this.titulo + "\n"
                + " Artista: " + this.artista + "\n"
                + "Album: " + this.album + "\n"
                + "-------------------------------------\n";

        return txt;
    }

}
