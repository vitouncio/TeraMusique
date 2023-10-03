
package com.vcompany.teramusique.model;

import lombok.Data;

/**
 *
 * @author 14892160652
 */

@Data
public class Sessao {
    private Integer id;
    private String infoPreSessao;
    private String infoPosSessao;
    
    public Sessao(){
        this.id = 0;
        this.infoPreSessao = "";
        this.infoPosSessao = "";
    }
    
    public Sessao (Integer id, String infoPreSessao, String infoPosSessao){
        this.id = id;
        this.infoPreSessao = infoPreSessao;
        this.infoPosSessao = infoPosSessao;
    }
}
