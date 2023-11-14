/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.controller.tableModel;

import com.vcompany.teramusique.model.Musica;
import com.vcompany.teramusique.model.Musicoterapeuta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMCadMusica extends AbstractTableModel {

    private List lista;
    
    private final int COL_TITULO = 0;   
    private final int COL_ARTISTA = 1;    
    private final int COL_ALBUM = 2;    
    private final int COL_GENERO = 3;    
    private final int COL_DURACAO = 4;    
    private final int COL_FINALIDADE = 5;    
    private final int COL_ID = 6;    

    public TMCadMusica(List lstMusicas) {        
        lista = lstMusicas;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Musica aux = new Musica();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Musica) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_TITULO:
                    return aux.getTitulo();
                case COL_ARTISTA:
                    return aux.getArtista();
                case COL_ALBUM:
                    return aux.getAlbum();
                case COL_GENERO:
                    return aux.getGenero();
                case COL_DURACAO:
                    return aux.getDuracao();
                case COL_FINALIDADE:
                    return aux.getFinalidadeNaSessao();
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
            case COL_TITULO:
                return "Titulo";
            case COL_ARTISTA:
                return "Artista";
            case COL_ALBUM:
                return "Album";
            case COL_GENERO:
                return "Genero";
            case COL_DURACAO:
                return "Duracao";
            case COL_FINALIDADE:
                return "Finalidade";
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


