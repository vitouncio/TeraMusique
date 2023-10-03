
package com.vcompany.teramusique.model;


/**
 *
 * @author 14892160652
 */

public class Musicoterapeuta extends Pessoa{
    private Integer id;
    private String qualificacoes;
    private String especializacao;
    
    public Musicoterapeuta(){
        super();
        this.id = 0;
        this.qualificacoes = "";
        this.especializacao = "";
    }
    
    public Musicoterapeuta(Integer id, String nome, String sexo, Integer idade, String telefone, String qualificacoes, String especializacao){
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
