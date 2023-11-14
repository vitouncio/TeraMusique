/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.InstrumentoException;
import com.vcompany.teramusique.model.Instrumento;
import com.vcompany.teramusique.model.dao.InstrumentoDao;
import com.vcompany.teramusique.valid.ValidateInstrumento;

/**
 *
 * @author vitor
 */
public class InstrumentoController {

    private InstrumentoDao repositorio;

    public InstrumentoController() {
        repositorio = new InstrumentoDao();
    }

    public void cadastrarInstrumento(Instrumento cadInstrumento) {
        ValidateInstrumento check = new ValidateInstrumento();
        Instrumento novoInstrumento = check.validaCamposEntrada(cadInstrumento);

        try {
            repositorio.save(novoInstrumento);
        } catch (InstrumentoException e) {
            throw new InstrumentoException("Error - já existe um Instrumento com este 'id'. ");
        }
  
    }

    public void atualizarInstrumento(Instrumento editInstrumento) {

        ValidateInstrumento check = new ValidateInstrumento();
        Instrumento novoInstrumento = check.validaCamposEntrada(editInstrumento);

        try {
            repositorio.save(novoInstrumento);
        } catch (InstrumentoException e) {
            throw new InstrumentoException("Error - já existe um Instrumento com este 'id'. ");
        }
    }

    public Instrumento buscarInstrumento(Integer id) {
        
        return (Instrumento) this.repositorio.find(id);
    }

    public void excluirInstrumento (Instrumento instrumento){
        if (instrumento != null){
            repositorio.delete(instrumento);
        }else{
            throw new InstrumentoException("Erro! Este Instrumento não existe.");
        }
    }
}
