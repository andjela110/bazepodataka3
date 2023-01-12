/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Trebovanje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelTrebovanje extends AbstractTableModel{
    
    List<Trebovanje> lista;
    private final String[] naziviKolona = new String[]{"Datum trebovanja", "Status trebovanja", "Prijemnica",
        "Tip trebovanja", "Naziv proizvoda", "Magacin", "Mesto troška"};

    public TableModelTrebovanje() {}

    public TableModelTrebovanje(List<Trebovanje> lista) {
        this.lista = lista;
    }

    public List<Trebovanje> getLista() {
        return lista;
    }

    public void setLista(List<Trebovanje> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Trebovanje vratiIzabranoTrebovanje(int red) {
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
        Trebovanje t = lista.get(rowIndex);
        switch (columnIndex) {
             case 0:
                return t.getDatumTrebovanja();
            case 1:
                return t.getStatus();
            case 2:
                return t.getPrijemnica();
            case 3:
                return t.getTipTrebovanja().getNaziv();
            case 4:
                return t.getGotovProizvod().getNaziv();
            case 5:
                return t.getMagacin().getNaziv();
            case 6:
                return t.getMestoTroska().getNaziv();
            
            default:
                return "Greška";
        }
    }
    
}
