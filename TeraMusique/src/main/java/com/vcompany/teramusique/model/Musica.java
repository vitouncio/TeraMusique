
package com.vcompany.teramusique.model;

import lombok.Data;

/**
 *
 * @author 14892160652
 */

@Data
public class Musica {
    private Integer id;
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private String duracao;
    private String finalidadeNaSessao;
    
    public Musica(){
        this.id = 0;
        this.titulo = "";
        this.artista = "";
        this.album = "";
        this.genero = "";
        this.duracao = "";
        this.finalidadeNaSessao = "";
    }
    
    public Musica(Integer id, String titulo, String artista, String album, String genero, String duracao, String finalidadeNaSessao){
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracao = duracao;
        this.finalidadeNaSessao = finalidadeNaSessao;
        
    }
    
}
