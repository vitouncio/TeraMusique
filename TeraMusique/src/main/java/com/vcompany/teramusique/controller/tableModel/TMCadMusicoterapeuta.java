/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller.tableModel;

import com.vcompany.teramusique.model.Musicoterapeuta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMCadMusicoterapeuta extends AbstractTableModel {

    private List lista;
    
    private final int COL_NOME = 0;   
    private final int COL_ESPECIALIZACAO = 1;    
    private final int COL_ID = 2;    

    public TMCadMusicoterapeuta(List lstMusicoterapeutas) {        
        lista = lstMusicoterapeutas;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Musicoterapeuta aux = new Musicoterapeuta();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Musicoterapeuta) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_NOME:
                    return aux.getNome();
                case COL_ESPECIALIZACAO:
                    return aux.getEspecializacao();
                 case COL_ID:
                    return aux.getId();
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
            case COL_NOME:
                return "Nome";
            case COL_ESPECIALIZACAO:
                return "Especializacao";
            case COL_ID:
                return "Id";
            
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


