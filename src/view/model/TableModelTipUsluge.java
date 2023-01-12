/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.TipUsluge;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelTipUsluge  extends AbstractTableModel{
    
    List<TipUsluge> lista;
    private final String[] naziviKolona = new String[]{"Naziv tipa usluge", "Cena tipa usluge"};

    public TableModelTipUsluge() {}

    public TableModelTipUsluge(List<TipUsluge> lista) {
        this.lista = lista;
    }

    public List<TipUsluge> getLista() {
        return lista;
    }

    public void setLista(List<TipUsluge> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public TipUsluge vratiIzabranTipUsluge(int red) {
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
        TipUsluge tu = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tu.getNaziv().getNaziv();
            case 1:
                return tu.getCena();
            
            default:
                return "Greška";
        }
    }
    
}
