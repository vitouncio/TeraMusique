
package com.vcompany.teramusique.model;

import lombok.Data;

/**
 *
 * @author 14892160652
 */

@Data
public class Instrumentos {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer quantDisponivel;
    
    public Instrumentos(){
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.quantDisponivel = 0;
    }
    
    public Instrumentos (Integer id, String nome, String descricao, Integer quantDisponivel){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantDisponivel = quantDisponivel;
    }
}
