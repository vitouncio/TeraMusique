
package com.vcompany.teramusique.model;

import lombok.Data;

/**
 *
 * @author 14892160652
 */
@Data
public class Pessoa {
    private String nome;
    private String sexo;
    private Integer idade;
    private String telefone;
    
    public Pessoa (){
        this.nome = "";
        this.sexo = "";
        this.idade = 0;
        this.telefone = "";
    }
    
    public Pessoa(String nome, String sexo,Integer idade, String telefone){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.telefone = telefone;
    }
}
