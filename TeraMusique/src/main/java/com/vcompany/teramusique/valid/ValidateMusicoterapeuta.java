/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.MusicoterapeutaException;
import com.vcompany.teramusique.exceptions.MusicoterapeutaException;
import com.vcompany.teramusique.model.Musicoterapeuta;
import com.vcompany.teramusique.view.FrCadMusicoterapeuta;
import com.vcompany.teramusique.view.popups.DlgPopUpCampoVazio;

/**
 *
 * @author vitor
 */
public class ValidateMusicoterapeuta {

    FrCadMusicoterapeuta frMusicoterapeutaParent;

    public Musicoterapeuta validaCamposEntrada(Musicoterapeuta validaMusicoterapeuta) {
        Musicoterapeuta m = new Musicoterapeuta();
        
        if (validaMusicoterapeuta.getNome().isEmpty()) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Campo 'Nome' vazio");
        }

        m.setNome(validaMusicoterapeuta.getNome());

        if (validaMusicoterapeuta.getSexo().isEmpty()) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Informe seu sexo.");
        }

        m.setSexo(validaMusicoterapeuta.getSexo());

        if (validaMusicoterapeuta.getIdade() < 0) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Idade não permitida.");
        }
        
        if (String.valueOf(validaMusicoterapeuta.getIdade()).isEmpty()) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Campo 'idade' vazio.");
        }
        
        m.setIdade(validaMusicoterapeuta.getIdade());

        if (validaMusicoterapeuta.getTelefone().isEmpty()) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Campo 'Telefone' vazio.");
        }

        m.setTelefone(validaMusicoterapeuta.getTelefone());

        if (validaMusicoterapeuta.getSexo() == null) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Preencha o campo 'Toma medicação?'.");
        }
        
        

        if (validaMusicoterapeuta.getQualificacoes() == null) {
            DlgPopUpCampoVazio popup = new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Insira suas qualificações.");
        }

        m.setQualificacoes(validaMusicoterapeuta.getQualificacoes());

        if (validaMusicoterapeuta.getEspecializacao().isEmpty()) {
            DlgPopUpCampoVazio popup = new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Insira suas especializacoes.");
        }

        m.setEspecializacao(validaMusicoterapeuta.getEspecializacao());


        m.setLstSessoes(validaMusicoterapeuta.getLstSessoes());

        if (validaMusicoterapeuta.getEmail().isEmpty()) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Campo de email vazio.");
        }
        
        m.setEmail(validaMusicoterapeuta.getEmail());
        
        if (validaMusicoterapeuta.getSenha().isEmpty()) {
            new DlgPopUpCampoVazio(frMusicoterapeutaParent, true, "Erro: Defina uma senha para seu login.");
        }
        
        m.setSenha(validaMusicoterapeuta.getSenha());
        
        if (validaMusicoterapeuta.getNivelAcesso() < 0) {
                throw new MusicoterapeutaException("Musicoterapeuta com nível de acesso negativo.");
        }
        
        m.setNivelAcesso(validaMusicoterapeuta.getNivelAcesso());
        return m;
    }
}
