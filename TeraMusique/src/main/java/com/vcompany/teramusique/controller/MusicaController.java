/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.controller.tableModel.TMCadMusica;
import com.vcompany.teramusique.controller.tableModel.TMCadMusica;
import com.vcompany.teramusique.exceptions.MusicaException;
import com.vcompany.teramusique.model.Musica;
import com.vcompany.teramusique.model.dao.MusicaDao;
import com.vcompany.teramusique.valid.ValidateMusica;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class MusicaController {

    private MusicaDao repositorio;

    public MusicaController() {
        repositorio = new MusicaDao();
    }

    public void cadastrarMusica(Musica cadMusica) {
        ValidateMusica check = new ValidateMusica();
        Musica novoMusica = check.validaCamposEntrada(cadMusica);

        try {
            repositorio.save(novoMusica);
        } catch (MusicaException e) {
            throw new MusicaException("Error - já existe um Musica com este 'id'. ");
        }
  
    }

    public void atualizarMusica(Musica editMusica) {

        ValidateMusica check = new ValidateMusica();
        Musica novaMusica = check.validaCamposEntrada(editMusica);

        try {
            repositorio.save(novaMusica);
        } catch (MusicaException e) {
            throw new MusicaException("Error - já existe um Musica com este 'id'. ");
        }
    }

    public Musica buscarMusica(Integer id) {
        
        return (Musica) this.repositorio.find(id);
    }
    
    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        
        TMCadMusica tableModel = new TMCadMusica(lst);
        grd.setModel(tableModel);        
    }
    
    public void atualizarTabela(JTable grd, String titulo) {
        List lst = repositorio.filterByTitle(titulo);

        TMCadMusica tableModel = new TMCadMusica(lst);
        grd.setModel(tableModel);
    }
    
    public void atualizarTabelaPorArtista(JTable grd, String artista) {
        List lst = repositorio.filterByArtist(artista);

        TMCadMusica tableModel = new TMCadMusica(lst);
        grd.setModel(tableModel);
    }
    public void atualizarTabelaPorGenero(JTable grd, String genero) {
        List lst = repositorio.filterByGenero(genero);

        TMCadMusica tableModel = new TMCadMusica(lst);
        grd.setModel(tableModel);
    }
    public void atualizarTabelaPorFinalidade(JTable grd, String finalidade) {
        List lst = repositorio.filterByFinalidade(finalidade);

        TMCadMusica tableModel = new TMCadMusica(lst);
        grd.setModel(tableModel);
    }

    public void atualizarTabelaMusicaSessao(JTable grd, List<Musica> lst){
        TMCadMusica tableModel = new TMCadMusica(lst);
        grd.setModel(tableModel);
    }
    
    public void excluirMusica (Musica musica){
        if (musica != null){
            repositorio.delete(musica);
        }else{
            throw new MusicaException("Erro! Esta Musica não existe.");
        }
    }
    
    public List<Musica> filtrarPorTitulo(String titulo){
        return (List<Musica>) repositorio.filterByTitle(titulo);
    }
    
    public List<Musica> filtrarPorArtista(String artista){
        return (List<Musica>) repositorio.filterByArtist(artista);
    }
    
    public List<Musica> filtrarPorGenero(String genero){
        return (List<Musica>) repositorio.filterByGenero(genero);
    }
    
    public List<Musica> filtrarPorFinalidade(String finalidade){
        return (List<Musica>) repositorio.filterByFinalidade(finalidade);
    }
    
}
