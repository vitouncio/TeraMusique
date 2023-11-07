

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Sessao;

/**
 *
 * @author vitor
 */
public class ValidateSessao {
    
    public Sessao validaCamposEntrada(Sessao validaSessao) {
        Sessao s = new Sessao();
                
        if(validaSessao.getInfoPreSessao().isEmpty()) {
            throw new SessaoException("Error - Campo vazio: 'Info Pre-Sessao'. ");
        }
        s.setInfoPreSessao(validaSessao.getInfoPreSessao());
        
        if(validaSessao.getInfoPosSessao().isEmpty()) {
            throw new SessaoException("Error - Campo vazio: 'Info Pos-Sessao'. ");
        }
        
                s.setInfoPreSessao(validaSessao.getInfoPosSessao());

        
        if(validaSessao.getMusicoterapeutaResp() == null) {
            throw new SessaoException("Error - Campo vazio: 'Musicoterapeuta responsavel'. ");
        }
        
                s.setMusicoterapeutaResp(validaSessao.getMusicoterapeutaResp());
                
        if(validaSessao.getLstMusicas().isEmpty()) {
            throw new SessaoException("Error - Campo vazio: 'Lista de Musicas'. ");
        }
        
        s.setLstMusicas(validaSessao.getLstMusicas());
        
        if(validaSessao.getLstPacientes().isEmpty()) {
            throw new SessaoException("Error - Campo vazio: 'Lista de Pacientes'. ");
        }
        
        s.setLstPacientes(validaSessao.getLstPacientes());
                
        return s;
    }
}
