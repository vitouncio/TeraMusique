/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.MusicoterapeutaException;
import com.vcompany.teramusique.model.Musicoterapeuta;
import java.util.List;

/**
 *
 * @author vitor
 */
public class MusicoterapeutaDao extends Dao<Musicoterapeuta> {

    @Override
    public Musicoterapeuta find(int id) {
        if (id < 0) {
            throw new MusicoterapeutaException("Este musicoterapeuta não existe.");
        } else {


            try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

                Musicoterapeuta m = entityManager.find(Musicoterapeuta.class, id);

                return m;
            } catch (MusicoterapeutaException e) {
                throw new MusicoterapeutaException("Musicoterapeuta não encontrado");
            } finally {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Musicoterapeuta> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT m "
                    + " FROM Musicoterapeuta m ";

            qry = super.entityManager.createQuery(jpql, Musicoterapeuta.class);

            List lstMusicoterapeutas = qry.getResultList();
            return lstMusicoterapeutas;
        } catch (MusicoterapeutaException msg) {
            throw new MusicoterapeutaException("Erro ao retornar lista de musicoterapeutas.");
        } finally {
            super.entityManager.close();
        }

    }
}
