/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.model.dao.contracts.Dao;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.MusicoterapeutaException;
import com.vcompany.teramusique.model.Musicoterapeuta;
import java.util.List;
import javax.persistence.TypedQuery;

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
    
    public List<Musicoterapeuta> filterByName(String nome){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT m "
                + " FROM Musicoterapeuta m "
                + " WHERE m.nome LIKE :nome ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Musicoterapeuta.class);
        qry.setParameter("nome", nome);
        
        List<Musicoterapeuta> lst = qry.getResultList();
        this.entityManager.close();
        
       return lst;
        
    }
    
    public List<Musicoterapeuta> filterByEspecializacao(String especializacao){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT m "
                + " FROM Musicoterapeuta m "
                + " WHERE m.especializacao LIKE :especializacao";
        TypedQuery qry = this.entityManager.createQuery(jpql, Musicoterapeuta.class);
        qry.setParameter("especializacao", especializacao);
        
        List<Musicoterapeuta> lst = qry.getResultList();
        this.entityManager.close();
        
       return lst;
        
    }
    
}
