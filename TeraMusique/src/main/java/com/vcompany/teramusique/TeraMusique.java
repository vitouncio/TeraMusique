package com.vcompany.teramusique;

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
        //FrHome telaInicial = new FrHome();
       // telaInicial.setVisible(true);
        
       List<Musicoterapeuta> lstMusicoterpeuta = new ArrayList<>();
       List<Musica> lstMusicas = new ArrayList<>();
       List<Instrumento> lstInstrumentos = new ArrayList<>();
       List<Paciente> lstPacientes = new ArrayList<>();
       
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TeraMusique_BD");
        EntityManager entityManager = factory.createEntityManager();
        
        Paciente p = new Paciente(1,"clevs", "Masculino", 22, "92929292929", "dorme mt", false);
        Musicoterapeuta m = new Musicoterapeuta(1, "Vitor", "Masculino", 22, "9292929292", "Toca violao", "Produtor de sons felizes");
        Sessao s = new Sessao(1, "usar violao e flauta", " ", m);
        Musica musica = new Musica(1, "PRESSURE", "Travis Scott", "Dystopia", "Trap", "05:20", "Relaxar");
        Instrumento i = new Instrumento(1, "Fl Studio", "Programa foda", 1);
        
        lstInstrumentos.add(i);
        lstMusicas.add(musica);
        lstMusicoterpeuta.add(m);
        lstPacientes.add(p);
        
        musica.setLstInstrumentos(lstInstrumentos);
        s.setLstMusicas(lstMusicas);
        s.setLstMusicoterapeutas(lstMusicoterpeuta);
        s.setLstPacientes(lstPacientes);
        
        PacienteController pController = new PacienteController();
        SessaoController sController = new SessaoController();
        
        
        pController.cadastrarPaciente(p);
        
        entityManager.close();
        factory.close();
        
        
    }
}
