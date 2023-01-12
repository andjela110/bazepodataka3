/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Kvar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelKvar extends AbstractTableModel{
    
    List<Kvar> lista;
    private final String[] naziviKolona = new String[]{"Gotov proizvod", "Količina", "Datum kvara", "Tip kvara", "Tip uzroka kvara"};

    public TableModelKvar() {}

    public TableModelKvar(List<Kvar> lista) {
        this.lista = lista;
    }

    public List<Kvar> getLista() {
        return lista;
    }

    public void setLista(List<Kvar> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Kvar vratiIzabranKvar(int red) {
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
        Kvar k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getGotovProizvod().getNaziv();
            case 1:
                return k.getKolicinaKvara();
            case 2:
                return k.getDatumKvara();
            case 3:
                return k.getTipKvara().getNaziv();
            case 4:
                return k.getTipUzrokaKvara().getNaziv();
            
            default:
                return "Greška";
        }
    }
    
}
