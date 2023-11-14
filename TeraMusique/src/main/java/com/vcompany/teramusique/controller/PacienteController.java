/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller;

import com.mysql.cj.Session;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.controller.tableModel.TMCadPaciente;
import com.vcompany.teramusique.exceptions.PacienteException;
import com.vcompany.teramusique.model.Paciente;
import com.vcompany.teramusique.model.dao.PacienteDao;
import com.vcompany.teramusique.valid.ValidatePaciente;
import java.util.List;
import javax.swing.JTable;
import org.hibernate.Hibernate;

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

    public List<Paciente> buscarTodosPacientes() {
        try {
            return repositorio.findAll();
            
        } catch (PacienteException e) {
            throw new PacienteException("Error - Nao foi possivel buscar todos os pacientes");
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

    public void excluirPaciente(Paciente paciente) {
        if (paciente != null) {
            repositorio.delete(paciente);
        } else {
            throw new PacienteException("Erro! Este paciente não existe.");
        }
    }
    

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        
        TMCadPaciente tableModel = new TMCadPaciente(lst);
        grd.setModel(tableModel);        
    }
    
    public void atualizarTabela(JTable grd, String nome) {
        List lst = repositorio.filterByName(nome);

        TMCadPaciente tableModel = new TMCadPaciente(lst);
        grd.setModel(tableModel);
    }
}
