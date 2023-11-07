/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.exceptions.PacienteException;
import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Paciente;

/**
 *
 * @author vitor
 */
public class ValidatePaciente {

    public Paciente validaCamposEntrada(Paciente validaPaciente) {
        Paciente paciente = new Paciente();

        paciente.setId(validaPaciente.getId());

        if (validaPaciente.getNome().isEmpty()) {
            throw new PacienteException("Error - Campo vazio: 'nome'. ");
        }

        paciente.setNome(validaPaciente.getNome());

        if (validaPaciente.getSexo().isEmpty()) {
            throw new PacienteException("Eroor - Campo vazio: 'sexo'. ");
        }

        paciente.setSexo(validaPaciente.getSexo());

        if (validaPaciente.getIdade() < 0) {
            throw new PacienteException("Error - Campo vazio: 'sexo'. ");
        }

        paciente.setIdade(validaPaciente.getIdade());

        if (validaPaciente.getTelefone().isEmpty()) {
            throw new PacienteException("Error - Campo vazio: 'telefone'. ");
        }

        paciente.setTelefone(validaPaciente.getTelefone());

        if (validaPaciente.getSexo() == null) {
            throw new PacienteException("Error - O paciente faz uso de alguma medicacao? ");
        }

        paciente.setLstSessoes(validaPaciente.getLstSessoes());

        return paciente;
    }
}
