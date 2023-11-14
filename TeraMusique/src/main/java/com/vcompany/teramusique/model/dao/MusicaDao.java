/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;

import com.vcompany.teramusique.model.dao.contracts.Dao;
import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.exceptions.MusicaException;
import com.vcompany.teramusique.model.Musica;
import java.util.List;
import javax.persistence.TypedQuery;
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
    
    public List<Musica> filterByTitle(String titulo){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT m "
                + " FROM Musica m "
                + " WHERE m.titulo LIKE :titulo ";
        
        TypedQuery qry = this.entityManager.createQuery(jpql, Musica.class);
        qry.setParameter("titulo", titulo);
        
        List<Musica> lst = qry.getResultList();
        this.entityManager.close();
        
        return lst;
    }
    
    public List<Musica> filterByArtist(String artista){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT m "
                + " FROM Musica m "
                + " WHERE m.artista LIKE :artista";
        
        TypedQuery qry = this.entityManager.createQuery(jpql, Musica.class);
        qry.setParameter("artista", artista);
        
        List<Musica> lst = qry.getResultList();
        this.entityManager.close();
        
        return lst;
    }
    
    public List<Musica> filterByGenero(String genero){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT m "
                + " FROM Musica m "
                + " WHERE m.genero LIKE :genero";
        
        TypedQuery qry = this.entityManager.createQuery(jpql, Musica.class);
        qry.setParameter("genero", genero);
        
        List<Musica> lst = qry.getResultList();
        this.entityManager.close();
        
        return lst;
    }
    
    public List<Musica> filterByFinalidade(String finalidade){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT m "
                + " FROM Musica m "
                + " WHERE m.finalidade LIKE :finalidade";
        
        TypedQuery qry = this.entityManager.createQuery(jpql, Musica.class);
        qry.setParameter("finalidade", finalidade);
        
        List<Musica> lst = qry.getResultList();
        this.entityManager.close();
        
        return lst;
    }
    
    
    
}
