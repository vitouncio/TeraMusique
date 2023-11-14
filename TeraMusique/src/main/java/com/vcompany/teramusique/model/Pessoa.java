package com.vcompany.teramusique.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;

/**
 *
 * @author 14892160652
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;
    protected String sexo;
    protected Integer idade;
    protected String telefone;
    protected String email;
    protected String senha;
    protected Integer nivelAcesso;
    

    public Pessoa() {
        this.id = 0;
        this.nome = "gustavo";
        this.sexo = "";
        this.idade = 0;
        this.telefone = "";
        this.email = "";
        this.senha = "";
        this.nivelAcesso = -1;
    }

    public Pessoa(String nome, String sexo, Integer idade, String telefone, String email, String senha, Integer nivelAcesso) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
}
