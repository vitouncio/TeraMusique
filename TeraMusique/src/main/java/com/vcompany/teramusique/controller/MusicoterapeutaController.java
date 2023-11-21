/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.controller.tableModel.TMCadMusicoterapeuta;
import com.vcompany.teramusique.controller.tableModel.TMCadMusicoterapeuta;
import com.vcompany.teramusique.controller.tableModel.TMCadMusicoterapeuta;
import com.vcompany.teramusique.controller.tableModel.TMCadSessao;
import com.vcompany.teramusique.exceptions.MusicoterapeutaException;
import com.vcompany.teramusique.model.Musicoterapeuta;
import com.vcompany.teramusique.model.Sessao;
import com.vcompany.teramusique.model.dao.MusicoterapeutaDao;
import com.vcompany.teramusique.valid.ValidateMusicoterapeuta;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class MusicoterapeutaController {

    private MusicoterapeutaDao repositorio;

    public MusicoterapeutaController() {
        repositorio = new MusicoterapeutaDao();
    }

    public void cadastrarMusicoterapeuta(Musicoterapeuta cadMusicoterapeuta) {
        ValidateMusicoterapeuta check = new ValidateMusicoterapeuta();
        Musicoterapeuta novoMusicoterapeuta = check.validaCamposEntrada(cadMusicoterapeuta);

        try {
            repositorio.save(novoMusicoterapeuta);
        } catch (MusicoterapeutaException e) {
            throw new MusicoterapeutaException("Error ao salvar Musicoterapeuta. ");
        }
  
    }
    
    public void atualizarMusicoterapeuta(Musicoterapeuta editMusicoterapeuta) {

        ValidateMusicoterapeuta check = new ValidateMusicoterapeuta();
        Musicoterapeuta novoMusicoterapeuta = check.validaCamposEntrada(editMusicoterapeuta);

        try {
            repositorio.save(novoMusicoterapeuta);
        } catch (MusicoterapeutaException e) {
            throw new MusicoterapeutaException("Error - já existe um Musicoterapeuta com este 'id'. ");
        }
    }
    
    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        
        TMCadMusicoterapeuta tableModel = new TMCadMusicoterapeuta(lst);
        grd.setModel(tableModel);        
    }
    
    public void atualizarTabela(JTable grd, String nome) {
        List lst = repositorio.filterByName(nome);

        TMCadMusicoterapeuta tableModel = new TMCadMusicoterapeuta(lst);
        grd.setModel(tableModel);
    }

    public Musicoterapeuta buscarMusicoterapeuta(Integer id) {
        
        return (Musicoterapeuta) this.repositorio.find(id);
    }
    
    public void atualizarTabelaMusicoterapeutasSessao(JTable grd, List<Musicoterapeuta> lst){
        TMCadMusicoterapeuta tableModel = new TMCadMusicoterapeuta(lst);
        grd.setModel(tableModel);
    }
    
    public void atualizarTabelaSessaoMusicoterapeuta(JTable grd, List<Sessao> lst){
        TMCadSessao tableModel = new TMCadSessao(lst);
        grd.setModel(tableModel);
    }

    public List<Musicoterapeuta> buscarTodosMusicoterapeutas(){
        return repositorio.findAll();
    }
    
    public void excluirMusicoterapeuta (Musicoterapeuta musicoterapeuta){
        if (musicoterapeuta != null){
            repositorio.delete(musicoterapeuta);
        }else{
            throw new MusicoterapeutaException("Erro! Este Musicoterapeuta não existe.");
        }
    }
    
    public List<Musicoterapeuta> filtrarPorNome(String nome){
        return (List<Musicoterapeuta>) repositorio.filterByName(nome);
    }
    
    public List<Musicoterapeuta> filtrarPorEspecializacao(String especializacao){
        return (List<Musicoterapeuta>) repositorio.filterByEspecializacao(especializacao);
    }
}
