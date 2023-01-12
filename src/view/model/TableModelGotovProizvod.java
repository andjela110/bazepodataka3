/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.GotovProizvod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelGotovProizvod  extends AbstractTableModel{
    
    List<GotovProizvod> lista;
    private final String[] naziviKolona = new String[]{"Naziv", "Model", "Serijski broj", "Snaga", "Datum proizvodnje", "Datum poslednjeg kvara"};

    public TableModelGotovProizvod() {}

    public TableModelGotovProizvod(List<GotovProizvod> lista) {
        this.lista = lista;
    }

    public List<GotovProizvod> getLista() {
        return lista;
    }

    public void setLista(List<GotovProizvod> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public GotovProizvod vratiIzabranGotovProizvod(int red) {
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
        GotovProizvod gp = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return gp.getNaziv();
            case 1:
                return gp.getModel();
            case 2:
                return gp.getSerijskiBroj();
            case 3:
                return gp.getSnaga();
            case 4:
                return gp.getDatumProizvodnje();
            case 5:
                return gp.getDatumPoslednjegKvara();
                
            default:
                return "Greska";
        }
    }
    
}
