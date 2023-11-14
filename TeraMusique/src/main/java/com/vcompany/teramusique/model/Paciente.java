package com.vcompany.teramusique.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 14892160652
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "Paciente")

@DiscriminatorColumn(name = "nome")

public class Paciente extends Pessoa {

    private String infoDeSaude;
    private Boolean tomaMedicacao;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Paciente_Sessao",
            joinColumns  = {@JoinColumn(name = "paciente_id")},
            inverseJoinColumns = {@JoinColumn (name = "sessao_id")}
    )
            private List<Sessao> lstSessoes;

    public Paciente() {
        super();
        this.infoDeSaude = "";
        this.tomaMedicacao = false;
    }

    public Paciente(String nome, String sexo, Integer idade, String telefone, String infoDeSaude, Boolean tomaMedicacao, String email, String senha, Integer nivelAcesso) {
        super(nome, sexo, idade, telefone, email, senha, nivelAcesso);
        this.infoDeSaude = infoDeSaude;
        this.tomaMedicacao = tomaMedicacao;

    }

    @Override
    public String toString() {
        String txt = "---- Dados do Paciente ------\n"
                + "id: " + this.id + "\n"
                + super.toString()
                + " Info de saude: " + this.infoDeSaude + "\n"
                + " O Paciente toma medicacao: " + this.tomaMedicacao + "\n"
                + "-------------------------------------\n";

        return txt;
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
