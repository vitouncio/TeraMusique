/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller.tableModel;

import com.vcompany.teramusique.model.Paciente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMCadPaciente extends AbstractTableModel {

    private List lista;
    
    private final int COL_NOME = 0;   
    private final int COL_SEXO = 1;    
    private final int COL_IDADE = 2;
    private final int COL_TELEFONE = 3;       

    public TMCadPaciente(List lstPacientes) {        
        lista = lstPacientes;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Paciente aux = new Paciente();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Paciente) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_NOME:
                    return aux.getNome();
                case COL_SEXO:
                    return aux.getSexo();
                 case COL_IDADE:
                    return aux.getIdade();
                case COL_TELEFONE:
                    return aux.getTelefone();
               
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
            case COL_SEXO:
                return "Sexo";
            case COL_IDADE:
                return "Idade"; 
            case COL_TELEFONE:
                return "Telefone";
            
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


