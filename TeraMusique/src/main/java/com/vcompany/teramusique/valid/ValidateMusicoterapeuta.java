/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.MusicoterapeutaException;
import com.vcompany.teramusique.model.Musicoterapeuta;

/**
 *
 * @author vitor
 */
public class ValidateMusicoterapeuta {

    public Musicoterapeuta validaCamposEntrada(Musicoterapeuta validaMusicoterapeuta) {
        Musicoterapeuta m = new Musicoterapeuta();

        m.setId(validaMusicoterapeuta.getId());

        if (validaMusicoterapeuta.getQualificacoes().isEmpty()) {
            throw new MusicoterapeutaException("Error - Campo vazio: 'Qualificacoes'. ");
        }

        m.setQualificacoes(validaMusicoterapeuta.getQualificacoes());

        if (validaMusicoterapeuta.getEspecializacao().isEmpty()) {
            throw new MusicoterapeutaException("Error - Campo vazio: 'Especializacao'. ");
        }

        m.setEspecializacao(validaMusicoterapeuta.getEspecializacao());

        if (validaMusicoterapeuta.getLstSessoes().isEmpty()) {
            throw new MusicoterapeutaException("Error - Campo vazio: 'Lista de sessoes'. ");
        }

        m.setLstSessoes(validaMusicoterapeuta.getLstSessoes());
        
        return m;
    }
}
