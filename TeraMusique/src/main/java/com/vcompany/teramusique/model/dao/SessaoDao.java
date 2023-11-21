/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.model.dao.contracts.Dao;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.SessaoException;
import com.vcompany.teramusique.model.Musicoterapeuta;
import com.vcompany.teramusique.model.Sessao;
import java.util.List;
import javax.persistence.TypedQuery;

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

    public Sessao filterByData(String data) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT s "
                + " FROM Sessao s "
                + " WHERE s.data LIKE :data ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Sessao.class);
        qry.setParameter("data", data);

        List<Sessao> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }
    }

    public Sessao filterByMusicoterapeutaResp(Musicoterapeuta musicoterapeutaResp) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT m "
                + " FROM Sessao m "
                + " WHERE m.musicoterapeutaResp LIKE :musicoterapeutaResp";
        TypedQuery qry = this.entityManager.createQuery(jpql, Sessao.class);
        qry.setParameter("musicoterapeutaResp", musicoterapeutaResp);

        List<Sessao> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }

    }

//   public List<Sessao> buscarLstSessoesPorMusicoterapeuta(Musicoterapeuta musicoterapeuta) {
//        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
//
//        String jpql = " SELECT s "
//                + " FROM Sessao s "
//                + " WHERE s.musicoterapeuta LIKE :musicoterapeuta";
//        
//        TypedQuery qry = this.entityManager.createQuery(jpql, Sessao.class);
//        qry.setParameter("musicoterapeuta", musicoterapeuta);
//
//        List<Sessao> lst = qry.getResultList();
//        this.entityManager.close();
//
//        if (lst.isEmpty()) {
//            return null;
//        } else {
//            return (List<Sessao>) lst.get(0);
//        }
//
//    }

}
