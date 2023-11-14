/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller;

import com.vcompany.teramusique.controller.tableModel.TMCadMusicoterapeuta;
import com.vcompany.teramusique.controller.tableModel.TMCadPaciente;
import com.vcompany.teramusique.controller.tableModel.TMCadSessao;
import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Musicoterapeuta;
import com.vcompany.teramusique.model.Paciente;
import com.vcompany.teramusique.model.Sessao;
import com.vcompany.teramusique.model.dao.SessaoDao;
import com.vcompany.teramusique.valid.ValidateSessao;
import com.vcompany.teramusique.view.popups.DlgPopUpCampoVazio;
import java.awt.Frame;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.swing.JTable;

/**
 *
 * @author vitor
 */
public class SessaoController {

    private SessaoDao repositorio;

    public SessaoController() {
        this.repositorio = new SessaoDao();
    }

    public void cadastrarSessao(Sessao cadSessao) {

        ValidateSessao check = new ValidateSessao();
        Sessao novaSessao = check.validaCamposEntrada(cadSessao);

        try {
            repositorio.save(novaSessao);
        } catch (SessaoException e) {
            throw new SessaoException("Erro ao salvar sessão.");
        }
    }

    public void atualizarSessao(Sessao sessao) {
        ValidateSessao valid = new ValidateSessao();
        Sessao novaSessao = valid.validaCamposEntrada(sessao);

        repositorio.update(sessao);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMCadSessao tableModel = new TMCadSessao(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.

    }

    public void atualizarTabelaPacienteSessao(JTable grd, List<Paciente> lst) {
        TMCadPaciente tableModel = new TMCadPaciente(lst);
        grd.setModel(tableModel);
    }

    public void atualizarTabelaMusicoterapeutasSessao(JTable grd, List<Musicoterapeuta> lst) {
        TMCadMusicoterapeuta tableModel = new TMCadMusicoterapeuta(lst);
        grd.setModel(tableModel);
    }

    public void excluirSessao(Sessao sessao) {
        if (sessao != null) {
            repositorio.delete(sessao);
        } else {
            new DlgPopUpCampoVazio(new Frame(), true, "Esta sessão não existe.");
        }
    }

    public List<Sessao> filtrarPorData(String data) {
        return (List<Sessao>) repositorio.filterByData(data);
    }

    public List<Sessao> filtrarPorMusicoterapeutaResp(Musicoterapeuta musicoterapeuta) {
        return (List<Sessao>) repositorio.filterByMusicoterapeutaResp(musicoterapeuta);
    }
}
