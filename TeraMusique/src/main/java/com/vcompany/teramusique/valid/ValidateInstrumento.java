/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.InstrumentoException;
import com.vcompany.teramusique.model.Instrumento;


/**
 *
 * @author vitor
 */
public class ValidateInstrumento {
   
     public Instrumento validaCamposEntrada(Instrumento validaInstrumento) {
        Instrumento m = new Instrumento();

        m.setId(validaInstrumento.getId());

        if (validaInstrumento.getNome().isEmpty()) {
            throw new InstrumentoException("Error - Campo vazio: 'Nome'. ");
        }

        m.setNome(validaInstrumento.getNome());

        if (validaInstrumento.getDescricao().isEmpty()) {
            throw new InstrumentoException("Error - Campo vazio: 'Descricao'. ");
        }

        m.setDescricao(validaInstrumento.getDescricao());

        if (validaInstrumento.getQuantDisponivel() < 0) {
            throw new InstrumentoException("Error - Campo vazio: 'Quantidade de instrumentos disponiveis'. ");
        }

        m.setQuantDisponivel(validaInstrumento.getQuantDisponivel());
        
        if( validaInstrumento.getLstMusicas().isEmpty()) {
            throw new InstrumentoException("Error - Campo vazio: 'Lista de Musicas'.");
        }
        
        m.setLstMusicas(validaInstrumento.getLstMusicas());
        
        return m;
    }
    
}
