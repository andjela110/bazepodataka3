/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Kupio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelKupio extends AbstractTableModel{
    
    List<Kupio> lista;
    private final String[] naziviKolona = new String[]{"Datum kupovine","Gotov proizvod", "Ime i prezime kupca", "Garancija"};

    public TableModelKupio() {}

    public TableModelKupio(List<Kupio> lista) {
        this.lista = lista;
    }

    public List<Kupio> getLista() {
        return lista;
    }

    public void setLista(List<Kupio> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Kupio vratiIzabranoKupio(int red) {
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
        Kupio k = lista.get(rowIndex);
        switch (columnIndex) {
             case 0:
                return k.getDatumKupovineGP();
            case 1:
                return k.getGotovProizvod().getNaziv();
            case 2:
                return k.getImePrezimeKupca();
            case 3:
                return k.isGarancija();
            
            default:
                return "Greška";
        }
    }
    
}
