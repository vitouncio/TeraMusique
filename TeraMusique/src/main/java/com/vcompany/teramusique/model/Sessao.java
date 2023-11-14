package com.vcompany.teramusique.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author 14892160652
 */
@Entity
@Data
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String data;
    private String horario;
    private String infoPreSessao;
    private String infoPosSessao;
    
    @ManyToOne
    @JoinColumn(name = "muscoterapeutaResp_id")
    private Musicoterapeuta musicoterapeutaResp;
    
    @ManyToMany(mappedBy = "lstSessoes")
    private List<Musicoterapeuta> lstMusicoterapeutas;
    
    @ManyToMany(mappedBy = "lstSessoes")
    private List<Musica> lstMusicas;
    
    @ManyToMany(mappedBy = "lstSessoes")
    private List<Paciente> lstPacientes;
    

    public Sessao() {
        this.musicoterapeutaResp = new Musicoterapeuta();
        this.data = "";
        this.horario = "";
        this.infoPreSessao = "";
        this.infoPosSessao = "";
        
        this.lstPacientes = new ArrayList<>();
        this.lstMusicas = new ArrayList<>();
        this.lstMusicoterapeutas = new ArrayList<>();
    }

    public Sessao(String data, String horario, String infoPreSessao, String infoPosSessao, Musicoterapeuta musicoterapeutaResp, List<Musicoterapeuta> lstMusicoterapeutas, List<Musica> lstMusicas, List<Paciente> lstPacientes) {
        this.musicoterapeutaResp = musicoterapeutaResp;
        this.lstMusicoterapeutas = lstMusicoterapeutas;
        this.lstMusicas = lstMusicas;
        this.lstPacientes = lstPacientes;
        this.data = data;
        this.horario = horario;
        this.infoPreSessao = infoPreSessao;
        this.infoPosSessao = infoPosSessao;
    }
    @Override
    public String toString() {
        String txt = "---- Dados da Sessao ------\n"
                + "id: " + this.id + "\n"
                + super.toString()
                + " Data: " + this.data + "\n"
                + " Horario: " + this.horario + "\n"
                + "Info pre-sessao:" + this.infoPreSessao + "\n"
                + "-------------------------------------\n";

        return txt;
    }
}
