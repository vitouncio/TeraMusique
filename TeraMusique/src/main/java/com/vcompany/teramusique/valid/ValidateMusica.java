/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.MusicaException;
import com.vcompany.teramusique.model.Musica;

/**
 *
 * @author vitor
 */
public class ValidateMusica {
 
     public Musica validaCamposEntrada(Musica validaMusica) {
        Musica m = new Musica();

        m.setId(validaMusica.getId());

        if (validaMusica.getTitulo().isEmpty()) {
            throw new MusicaException("Error - Campo vazio: 'Titulo'. ");
        }

        m.setTitulo(validaMusica.getTitulo());

        if (validaMusica.getArtista().isEmpty()) {
            throw new MusicaException("Error - Campo vazio: 'Artista'. ");
        }

        m.setArtista(validaMusica.getArtista());

        if (validaMusica.getAlbum().isEmpty()) {
            throw new MusicaException("Error - Campo vazio: 'Album'. ");
        }

        m.setAlbum(validaMusica.getAlbum());
        
         if (validaMusica.getGenero().isEmpty()) {
            throw new MusicaException("Error - Campo vazio: 'Genero'. ");
        }

        m.setGenero(validaMusica.getGenero());
        
        
         if (validaMusica.getDuracao().isEmpty()) {
            throw new MusicaException("Error - Campo vazio: 'Duracao'. ");
        }

        m.setDuracao(validaMusica.getDuracao());
        
         if (validaMusica.getFinalidadeNaSessao().isEmpty()) {
            throw new MusicaException("Error - Campo vazio: 'Finalidade na sessao'. ");
        }

        m.setFinalidadeNaSessao(validaMusica.getFinalidadeNaSessao());
        
        return m;
    }
    
}
