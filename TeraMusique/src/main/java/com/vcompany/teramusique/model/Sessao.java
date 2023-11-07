package com.vcompany.teramusique.model;

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
        this.id = 0;
        this.musicoterapeutaResp = new Musicoterapeuta();
        this.infoPreSessao = "";
        this.infoPosSessao = "";
    }

    public Sessao(Integer id, String infoPreSessao, String infoPosSessao, Musicoterapeuta musicoterapeutaResp) {
        this.id = id;
        this.musicoterapeutaResp = musicoterapeutaResp;
        this.infoPreSessao = infoPreSessao;
        this.infoPosSessao = infoPosSessao;
    }
}
