/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.PacienteException;
import com.vcompany.teramusique.model.Paciente;
import com.vcompany.teramusique.model.dao.PacienteDao;
import com.vcompany.teramusique.valid.ValidatePaciente;

/**
 *
 * @author vitor
 */
public class PacienteController {

    private PacienteDao repositorio;

    public PacienteController() {
        repositorio = new PacienteDao();
    }

    public void cadastrarPaciente(Paciente cadPaciente) {
        ValidatePaciente check = new ValidatePaciente();
        Paciente novoPaciente = check.validaCamposEntrada(cadPaciente);

        try {
            repositorio.save(novoPaciente);
        } catch (PacienteException e) {
            throw new PacienteException("Error - já existe um paciente com este 'id'. ");
        }
  
    }

    public void atualizarPaciente(Paciente editPaciente) {

        ValidatePaciente check = new ValidatePaciente();
        Paciente novoPaciente = check.validaCamposEntrada(editPaciente);

        try {
            repositorio.save(novoPaciente);
        } catch (PacienteException e) {
            throw new PacienteException("Error - já existe um paciente com este 'id'. ");
        }
    }

    public Paciente buscarPaciente(Integer id) {
        
        return (Paciente) this.repositorio.find(id);
    }

    public void excluirPaciente (Paciente paciente){
        if (paciente.getId() != null){
            repositorio.delete(paciente);
        }else{
            throw new PacienteException("Erro! Este paciente não existe.");
        }
    }
}
