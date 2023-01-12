/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Delatnost;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelDelatnost extends AbstractTableModel{
    
    List<Delatnost> lista;
    private final String[] naziviKolona = new String[]{"Naziv delatnosti"};

    public TableModelDelatnost() {}

    public TableModelDelatnost(List<Delatnost> lista) {
        this.lista = lista;
    }

    public List<Delatnost> getLista() {
        return lista;
    }

    public void setLista(List<Delatnost> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Delatnost vratiIzabranuDelatnost(int red) {
         return lista.get(red);
    }

    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        } else {
            return lista.size();
        }
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Delatnost d = lista.get(rowIndex);
        switch (columnIndex) {
             case 0:
                return d.getNaziv();
            
            default:
                return "Greška";
        }
    }
    
}
