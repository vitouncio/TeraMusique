/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller.tableModel;

import com.vcompany.teramusique.model.Paciente;
import com.vcompany.teramusique.model.Sessao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMCadSessao extends AbstractTableModel {

    private List lista;
    
    private final int COL_MUSICOTERAPEUTA_RESP = 0;       
    private final int COL_DATA = 1;    
    private final int COL_HORARIO = 2;
    private final int COL_MUSICOTERAPEUTAS = 3;       
    private final int COL_PACIENTES = 4;       
    private final int COL_MUSICAS = 5;       

    public TMCadSessao(List lstSessao) {        
        this.lista = lstSessao;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Sessao aux = new Sessao();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Sessao) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_DATA:
                    return aux.getData();
                 case COL_HORARIO:
                    return aux.getHorario();
                case COL_MUSICOTERAPEUTA_RESP:
                    return aux.getMusicoterapeutaRespToString();
                case COL_MUSICOTERAPEUTAS:
                    return aux.getLstMusicoterapeutasToString();
                case COL_PACIENTES:
                    return aux.getLstPacientesToString();
                case COL_MUSICAS:
                    return aux.getLstMusicasToString();
                default: 
                    break;
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        
        switch (column) {
            case COL_DATA:
                return "Data";
            case COL_HORARIO:
                return "Horario"; 
            case COL_MUSICOTERAPEUTA_RESP:
                return "Musicoterapeuta responsavel";
            case COL_MUSICOTERAPEUTAS:
                return "Musicoterapeutas presentes";
            case COL_PACIENTES:
                return "Pacientes";
            case COL_MUSICAS:
                return "Musicas reproduzidas";
            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
//        if(columnIndex == COL_MATRICULA)
//            return Boolean.class;
        
        return String.class;
    }

}


