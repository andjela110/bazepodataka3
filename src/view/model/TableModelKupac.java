/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Kupac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelKupac extends AbstractTableModel{
    
    List<Kupac> lista;
    private final String[] naziviKolona = new String[]{"Ime i prezime", "Broj telefona", "Region", "Grad", "Poštanski broj", "Ulica", "Broj zgrade"};

    public TableModelKupac() {}

    public TableModelKupac(List<Kupac> lista) {
        this.lista = lista;
    }

    public List<Kupac> getLista() {
        return lista;
    }

    public void setLista(List<Kupac> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Kupac vratiIzabranogKupca(int red) {
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
        Kupac k = lista.get(rowIndex);
        switch (columnIndex) {
             case 0:
                return k.getImePrezime();
            case 1:
                return k.getBrojTelefona();
            case 2:
                return k.getRegion().getNaziv();
            case 3:
                return k.getGrad().getNaziv();
            case 4:
                return k.getGrad().getPostanskiBroj();
            case 5:
                return k.getUlica().getNaziv();
            case 6:
                return k.getBroj().getBrVrednost();
                
            default:
                return "Greška";
        }
    }
    
}
