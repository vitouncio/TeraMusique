package com.vcompany.teramusique.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @JoinColumn(name = "musicoterapeutaResp_id")
    private Musicoterapeuta musicoterapeutaResp;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Musicoterapeutas_Sessao",
            joinColumns = {
                @JoinColumn(name = "musicoterapeuta_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "sessao_id")}
    )
    private List<Musicoterapeuta> lstMusicoterapeutas;

    @ManyToMany
    @JoinTable(
            name = "Musicas_Sessao",
            joinColumns = {
                @JoinColumn(name = "musicas_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "sessao_id")}
    )
    private List<Musica> lstMusicas;

    @ManyToMany
    @JoinTable(
            name = "Pacientes_Sessao",
            joinColumns = {
                @JoinColumn(name = "paciente_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "sessao_id")}
    )
    private List<Paciente> lstPacientes;

    public Sessao() {
        this.musicoterapeutaResp = new Musicoterapeuta();
        this.data = "";
        this.horario = "";
        this.infoPreSessao = "";
        this.infoPosSessao = "";

        this.lstPacientes = new ArrayList<Paciente>();
        this.lstMusicas = new ArrayList<Musica>();
        this.lstMusicoterapeutas = new ArrayList<Musicoterapeuta>();
    }

    public Sessao(String data, String horario, String infoPreSessao, String infoPosSessao, Musicoterapeuta musicoterapeutaResp, List<Musicoterapeuta> lstMusicoterapeutas, List<Musica> lstMusicas, List<Paciente> lstPacientes) {
        this.data = data;
        this.horario = horario;
        this.infoPreSessao = infoPreSessao;
        this.infoPosSessao = infoPosSessao;
        this.musicoterapeutaResp = musicoterapeutaResp;
        this.lstMusicoterapeutas = lstMusicoterapeutas;
        this.lstMusicas = lstMusicas;
        this.lstPacientes = lstPacientes;
    }

    @Override
    public String toString() {
        String txt = "---- Dados da Sessao ------\n"
                + "id: " + this.id + "\n"
                + " Data: " + this.data + "\n"
                + " Horario: " + this.horario + "\n"
                + "Info pre-sessao:" + this.infoPreSessao + "\n"
                + "-------------------------------------\n";

        return txt;
    }
    
    public String getLstMusicoterapeutasToString() {
        String txt = "";
        for(Musicoterapeuta musicoterapeuta : getLstMusicoterapeutas()){
            txt = musicoterapeuta.getNome() + "\n";
        }
        return txt;
    }
    public String getLstPacientesToString() {
        String txt = "";
        for(Paciente paciente : getLstPacientes()){
            txt = paciente.getNome() + "\n";
        }
        return txt;
    }
    public String getLstMusicasToString() {
        String txt = "";
        for(Musica musica : getLstMusicas()){
            txt = musica.getTitulo() + "\n";
        }
        return txt;
    }
    public String getMusicoterapeutaRespToString() {
        
           String txt = musicoterapeutaResp.getNome() + "\n"
                        + musicoterapeutaResp.getEmail() + "\n";
        
        return txt;
    }

}
