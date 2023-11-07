/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Sessao;
import java.util.List;

/**
 *
 * @author vitor
 */
public class SessaoDao extends Dao<Sessao> {

    @Override
    public Sessao find(int id) {

        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            Sessao s = super.entityManager.find(Sessao.class, id);
            return s;
        } catch (SessaoException e) {
            throw new SessaoException("Erro: Sessão não encontrada.");
        } finally {
            super.entityManager.close();
        }
    }

    @Override
    public List<Sessao> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT s "
                    + " FROM Sessao s ";
            
            qry = super.entityManager.createQuery(jpql, Sessao.class);
            
            List lst = qry.getResultList();
            return lst;
            
        } catch (SessaoException e) {

            throw new SessaoException("Erro: Lista não encontrada."); 

        } finally {
            super.entityManager.close();
        }
    }

}
