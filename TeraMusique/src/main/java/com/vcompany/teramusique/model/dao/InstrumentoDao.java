/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.model.dao.contracts.Dao;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.InstrumentoException;
import com.vcompany.teramusique.model.Instrumento;
import java.util.List;

/**
 *
 * @author vitor
 */
public class InstrumentoDao extends Dao<Instrumento> {

    @Override
    public Instrumento find(int id) {


        try {
        super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            Instrumento i = entityManager.find(Instrumento.class, id);

            return i;

        } catch (InstrumentoException msg) {
            throw new InstrumentoException("Erro em retornar 'Instrumento'.");
        } finally {
            super.entityManager.close();
        }
    }

    @Override
    public List<Instrumento> findAll() {

        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();


            jpql = " SELECT i "
                    + " FROM Instrumento i ";

            qry = super.entityManager.createQuery(jpql, Instrumento.class);

            List lstIntrumentos = qry.getResultList();
            return lstIntrumentos;

        } catch (InstrumentoException msg) {

            throw new InstrumentoException("Erro em retornar lista de 'Instrumentos'.");

        } finally {

            super.entityManager.close();

        }

    }
}
