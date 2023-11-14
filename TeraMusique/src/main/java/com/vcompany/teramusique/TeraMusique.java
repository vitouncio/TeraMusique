package com.vcompany.teramusique;

import com.vcompany.teramusique.connection.DatabaseJPA;
import com.vcompany.teramusique.controller.PacienteController;
import com.vcompany.teramusique.controller.SessaoController;
import com.vcompany.teramusique.model.Instrumento;
import com.vcompany.teramusique.model.Musica;
import com.vcompany.teramusique.model.Musicoterapeuta;
import com.vcompany.teramusique.model.Paciente;
import com.vcompany.teramusique.model.Sessao;
import com.vcompany.teramusique.view.FrHome;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 14892160652
 */
public class TeraMusique {

    public static void main(String[] args) {
        
        FrHome telaInicial = new FrHome();
       telaInicial.setVisible(true);
    }
}
