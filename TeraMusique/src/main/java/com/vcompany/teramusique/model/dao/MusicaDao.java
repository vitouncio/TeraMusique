/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.MusicaException;
import com.vcompany.teramusique.model.Musica;
import java.util.List;
import org.hibernate.boot.model.relational.Database;

/**
 *
 * @author vitor
 */
public class MusicaDao extends Dao<Musica> {

    @Override
    public Musica find(int id) {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            Musica m = super.entityManager.find(Musica.class, id);

            return m;
        } catch (MusicaException msg) {
            throw new MusicaException("Erro em retornar musica");
        } finally {
            super.entityManager.close();
        }

    }

    @Override
    public List<Musica> findAll() {
        try {
            super.entityManager = DatabaseJPA.getInstance().getEntityManager();

            jpql = " SELECT m "
                    + " FROM Musica m ";

            qry = super.entityManager.createQuery(jpql, Musica.class);

            List lstMusicas = qry.getResultList();
            return lstMusicas;
        } catch (MusicaException msg) {
            throw new MusicaException("Erro em retornar Musica.");
        } finally {
            super.entityManager.close();
        }

    }
}
