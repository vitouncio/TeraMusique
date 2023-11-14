/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Sessao;
import com.vcompany.teramusique.view.popups.DlgPopUpCampoVazio;
import java.awt.Frame;

/**
 *
 * @author vitor
 */
public class ValidateSessao {

    public Sessao validaCamposEntrada(Sessao validaSessao) {
        Sessao s = new Sessao();

        if (validaSessao.getData().isEmpty()) {
            new DlgPopUpCampoVazio(new Frame(), true, "Error - Campo vazio: 'Data'.");
        }
        s.setData(validaSessao.getData());

        if (validaSessao.getHorario().isEmpty()) {
            new DlgPopUpCampoVazio(new Frame(), true, "Error - Campo vazio: 'Horario'.");
        }
        s.setHorario(validaSessao.getHorario());

        if (validaSessao.getInfoPreSessao().isEmpty()) {
            new DlgPopUpCampoVazio(new Frame(), true, "Error - Campo vazio: 'Info Pre-Sessao'.");
        }
        s.setInfoPreSessao(validaSessao.getInfoPreSessao());

        s.setInfoPosSessao(validaSessao.getInfoPosSessao());

        if (validaSessao.getMusicoterapeutaResp() == null) {
            new DlgPopUpCampoVazio(new Frame(), true, "Selecione um musicoterapeuta que será responsável pela sesão'.");
        }

        s.setMusicoterapeutaResp(validaSessao.getMusicoterapeutaResp());

        if (validaSessao.getLstMusicas().size() < 1) {
            new DlgPopUpCampoVazio(new Frame(), true, "Selecione pelo menos uma múscia");
        }

        s.setLstMusicas(validaSessao.getLstMusicas());

        if (validaSessao.getLstPacientes().size() < 1) {
            new DlgPopUpCampoVazio(new Frame(), true, "Selecione pelo menos um paciente");
                }

        s.setLstPacientes(validaSessao.getLstPacientes());

        return s;
    }
}
