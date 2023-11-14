/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.PacienteException;
import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Paciente;
import com.vcompany.teramusique.view.FrCadPaciente;
import com.vcompany.teramusique.view.popups.DlgPopUpCampoVazio;
import java.awt.Frame;

/**
 *
 * @author vitor
 */
public class ValidatePaciente {
    
    FrCadPaciente parentCadPaciete;

    public Paciente validaCamposEntrada(Paciente validaPaciente) {
        Paciente paciente = new Paciente();

        if (validaPaciente.getNome().isEmpty()) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Campo 'Nome' vazio");
        }

        paciente.setNome(validaPaciente.getNome());

        if (validaPaciente.getSexo().isEmpty()) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Informe seu sexo.");
        }

        paciente.setSexo(validaPaciente.getSexo());

        if (validaPaciente.getIdade() < 0) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Idade não permitida.");
        }
        
        if (String.valueOf(validaPaciente.getIdade()).isEmpty()) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Campo 'idade' vazio.");
        }
        
        paciente.setIdade(validaPaciente.getIdade());

        if (validaPaciente.getTelefone().isEmpty()) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Campo 'Telefone' vazio.");
        }

        paciente.setTelefone(validaPaciente.getTelefone());

        if (validaPaciente.getSexo() == null) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Preencha o campo 'Toma medicação?'.");
        }
        
        if (validaPaciente.getInfoDeSaude().isEmpty()) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Nos informe o que te motivou a conhecer a musicoterapia.");
        }
        
        paciente.setInfoDeSaude(validaPaciente.getInfoDeSaude());
        
        if (validaPaciente.getEmail().isEmpty()) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Campo de email vazio.");
        }
        
        paciente.setEmail(validaPaciente.getEmail());
        
        if (validaPaciente.getSenha().isEmpty()) {
            new DlgPopUpCampoVazio(parentCadPaciete, true, "Erro: Defina uma senha para seu login.");
        }
        
        paciente.setSenha(validaPaciente.getSenha());
        
        if (validaPaciente.getNivelAcesso() < 0) {
                throw new PacienteException("Paciente com nível de acesso negativo.");
        }
        
        paciente.setNivelAcesso(validaPaciente.getNivelAcesso());
        
        
        //apenas seta a lista de sessoes para o paciente
        paciente.setLstSessoes(validaPaciente.getLstSessoes());

        return paciente;
    }
}
