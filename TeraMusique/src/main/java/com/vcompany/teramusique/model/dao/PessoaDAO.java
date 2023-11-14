/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.model.dao;


import com.vcompany.teramusique.model.Pessoa;
import com.vcompany.teramusique.model.dao.contracts.IDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author clevs
 */
public class PessoaDAO implements IDao{
      private Query qry;
    private String jpql;

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory("TeraMusique_BD");
            entityManager = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityManager;
    }

    public Pessoa findByEmail(String email) {
        EntityManager entityManager = getEntityManager();

        String jpql = "SELECT p "
                + "FROM Pessoa p "
                + "WHERE p.email LIKE :email";
        Query qry = entityManager.createQuery(jpql);
        qry.setParameter("email", email);

        List<Pessoa> pessoas = qry.getResultList();

        entityManager.close();

        if (pessoas.isEmpty()) {
            return null;
        } else {
            return pessoas.get(0);
        }
    }

    @Override
    public void save(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
