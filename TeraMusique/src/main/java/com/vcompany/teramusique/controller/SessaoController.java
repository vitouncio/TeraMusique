/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller;

import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Sessao;
import com.vcompany.teramusique.model.dao.SessaoDao;
import com.vcompany.teramusique.valid.ValidateSessao;

/**
 *
 * @author vitor
 */
public class SessaoController {
    private SessaoDao repositorio;
    
    public SessaoController(){
        this.repositorio = new SessaoDao();
}
    public void cadastrarSessao(Sessao cadSessao){
        
        ValidateSessao check = new ValidateSessao();
        Sessao novaSessao = check.validaCamposEntrada(cadSessao);
        
        try{
            repositorio.save(novaSessao);
        }catch(SessaoException e){
            throw new SessaoException("Erro ao salvar sessão.");
        }
    }
    
}