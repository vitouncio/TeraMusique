package com.vcompany.teramusique.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author 14892160652
 */
@Entity
@Data
@Table(name = "Musicoterapeuta")
public class Musicoterapeuta extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String qualificacoes;
    private String especializacao;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Musicoterapeuta_Sessao",
            joinColumns  = {@JoinColumn(name = "musicoterapeuta_id")},
            inverseJoinColumns = {@JoinColumn (name = "sessao_id")}
    )
    private List<Sessao> lstSessoes;

    public Musicoterapeuta() {
        super();
        this.id = 0;
        this.qualificacoes = "";
        this.especializacao = "";
    }

    public Musicoterapeuta(Integer id, String nome, String sexo, Integer idade, String telefone, String qualificacoes, String especializacao) {
        super(nome, sexo, idade, telefone);
        this.id = id;
        this.qualificacoes = qualificacoes;
        this.especializacao = especializacao;

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the qualificacoes
     */
    public String getQualificacoes() {
        return qualificacoes;
    }

    /**
     * @param qualificacoes the qualificacoes to set
     */
    public void setQualificacoes(String qualificacoes) {
        this.qualificacoes = qualificacoes;
    }

    /**
     * @return the especializacao
     */
    public String getEspecializacao() {
        return especializacao;
    }

    /**
     * @param especializacao the especializacao to set
     */
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
