package com.vcompany.teramusique.model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 14892160652
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "Musicoterapeuta")
public class Musicoterapeuta extends Pessoa {

    private String especializacao;
    private String qualificacoes; //caminho do arquivo

//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    @Column(name = "qualificacoes", columnDefinition = "BLOB")
//    private byte[] qualificacoes;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Musicoterapeuta_Sessao",
            joinColumns = {
                @JoinColumn(name = "musicoterapeuta_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "sessao_id")}
    )
    private List<Sessao> lstSessoes;

    public Musicoterapeuta() {
        super();
        //this.qualificacoes = new byte[300 * 1024 * 1024]; //Tamanho máximo 300mb
        this.qualificacoes = "";
        this.especializacao = "";
    }

//    public Musicoterapeuta(String nome, String sexo, Integer idade, String telefone, byte[] qualificacoes, String especializacao, String email, String senha, Integer nivelAcesso) {
//        super(nome, sexo, idade, telefone, email, senha, nivelAcesso);
//        this.qualificacoes = qualificacoes;
//        this.especializacao = especializacao;
//
//    }
    public Musicoterapeuta(String nome, String sexo, Integer idade, String telefone, String qualificacoes, String especializacao, String email, String senha, Integer nivelAcesso) {
        super(nome, sexo, idade, telefone, email, senha, nivelAcesso);
        this.qualificacoes = qualificacoes;
        this.especializacao = especializacao;

    }

    @Override
    public String toString() {
        String txt = "---- Dados do Musicoterapeuta ------\n"
                + "id: " + this.id + "\n"
                + super.toString()
                + " Especializacao: " + this.especializacao + "\n"
                + " E-mail: " + this.email + "\n"
                + "-------------------------------------\n";

        return txt;
    }

    public String toStringNome() {
        String txt = this.nome
                + " | "
                + this.email;

        return txt;
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
