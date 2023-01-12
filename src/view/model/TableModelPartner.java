/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Delatnost;
import domain.Partner;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelPartner extends AbstractTableModel{
    
    List<Partner> lista;
    private final String[] naziviKolona = new String[]{"Naziv partnera", "Broj telefona", "PIB", "Matični broj", 
        "Tekući račun", "Naziv delatnosti", "Region", "Grad", "Poštanski broj", "Ulica", "Broj zgrade", "Naziv banke"};

    public TableModelPartner() {}

    public TableModelPartner(List<Partner> lista) {
        this.lista = lista;
    }

    public List<Partner> getLista() {
        return lista;
    }

    public void setLista(List<Partner> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Partner vratiIzabranogPartnera(int red) {
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
        Partner p = lista.get(rowIndex);
        switch (columnIndex) {
             case 0:
                return p.getNaziv();
            case 1:
                return p.getBrojTelefona();
            case 2:
                return p.getPib();
            case 3:
                return p.getMaticniBroj();
            case 4:
                return p.getTekuciRacun();
            case 5:
                return p.getDelatnost().getNaziv();
            case 6:
                return p.getRegion().getNaziv();
            case 7:
                return p.getGrad().getNaziv();
            case 8:
                return p.getGrad().getPostanskiBroj();
            case 9:
                return p.getUlica().getNaziv();
            case 10:
                return p.getBroj().getBrVrednost();
            case 11:
                return p.getBanka().getNaziv();

            default:
                return "Greška";
        }
    }
    
}
