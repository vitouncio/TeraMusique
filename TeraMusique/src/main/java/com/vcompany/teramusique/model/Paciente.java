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
@Data
@Entity
@Table(name = "Paciente")
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String infoDeSaude;
    private Boolean tomaMedicacao;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Paciente_Sessao",
            joinColumns  = {@JoinColumn(name = "paciente_id")},
            inverseJoinColumns = {@JoinColumn (name = "sessao_id")}
    )
            private List<Sessao> lstSessoes;

    public Paciente() {
        super();
        this.id = 0;
        this.infoDeSaude = "";
        this.tomaMedicacao = false;
    }

    public Paciente(Integer id, String nome, String sexo, Integer idade, String telefone, String infoDeSaude, Boolean tomaMedicacao) {
        super(nome, sexo, idade, telefone);
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
