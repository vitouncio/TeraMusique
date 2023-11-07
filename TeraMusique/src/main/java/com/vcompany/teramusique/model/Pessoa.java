package com.vcompany.teramusique.model;

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
    private String nome;
    private String sexo;
    private Integer idade;
    private String telefone;

    public Pessoa() {
        this.nome = "";
        this.sexo = "";
        this.idade = 0;
        this.telefone = "";
    }

    public Pessoa(String nome, String sexo, Integer idade, String telefone) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.telefone = telefone;
    }
}
