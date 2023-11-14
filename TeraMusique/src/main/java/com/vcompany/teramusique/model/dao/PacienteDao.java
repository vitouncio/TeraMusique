/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.model.dao.contracts.Dao;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.PacienteException;
import com.vcompany.teramusique.model.Paciente;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author vitor
 */
public class PacienteDao extends Dao<Paciente> {
    
    @Override
    public Paciente find(int id) {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();
        try {
            
            Paciente p = super.entityManager.find(Paciente.class, id);
            
            return p;
        } catch (PacienteException e) {
            throw new PacienteException("Paciente não encontrado.");
        } finally {
            
            super.entityManager.close();
        }
        
    }
    
    @Override
    public List<Paciente> findAll() {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();
        try {
            
            jpql = " SELECT p "
                    + " FROM Paciente p ";
            
            qry = super.entityManager.createQuery(jpql, Paciente.class);
            
            List lst = qry.getResultList();
            return lst;
        } catch (PacienteException e) {
            throw new PacienteException("Tristeza, deu ruim. Não achei a lista de pacientes");
        } finally {
            super.entityManager.close();
            
        }
    }
    
    public List<Paciente> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a "
                + "FROM Paciente a "
                + "WHERE a.nome like :nome";
        TypedQuery qry = this.entityManager.createQuery(jpql, Paciente.class);
        qry.setParameter("nome", nome + "%");

        List<Paciente> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
}
