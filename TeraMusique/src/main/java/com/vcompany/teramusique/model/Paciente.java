
package com.vcompany.teramusique.model;


/**
 *
 * @author 14892160652
 */

public class Paciente extends Pessoa{
   
    private Integer id;
    private String infoDeSaude;
    private Boolean tomaMedicacao;
    
    public Paciente (){
        super();
        this.id = 0;
        this.infoDeSaude = "";
        this.tomaMedicacao = false;
    }
    
    public Paciente (Integer id, String nome, String sexo, Integer idade, String telefone, String infoDeSaude, Boolean tomaMedicacao){
        super(nome,sexo,idade,telefone);
        this.id = id;
        this.infoDeSaude = infoDeSaude;
        this.tomaMedicacao = tomaMedicacao;
        
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
     * @return the infoDeSaude
     */
    public String getInfoDeSaude() {
        return infoDeSaude;
    }

    /**
     * @param infoDeSaude the infoDeSaude to set
     */
    public void setInfoDeSaude(String infoDeSaude) {
        this.infoDeSaude = infoDeSaude;
    }

    /**
     * @return the tomaMedicacao
     */
    public Boolean getTomaMedicacao() {
        return tomaMedicacao;
    }

    /**
     * @param tomaMedicacao the tomaMedicacao to set
     */
    public void setTomaMedicacao(Boolean tomaMedicacao) {
        this.tomaMedicacao = tomaMedicacao;
    }
}
