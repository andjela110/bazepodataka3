/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Racun;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelRacun extends AbstractTableModel{
    
    List<Racun> lista;
    private final String[] naziviKolona = new String[]{"Datum prometa", "Datum izdavanja", "Trebovanje", "Naziv valute",
        "Naziv partnera", "Region izdavanja", "Grad izdavanja", "Poštanski broj GI", "Region prometa", "Grad prometa", "Poštanski broj GP",
        "Prijemnica", "Ukupna cena računa"};

    public TableModelRacun() {}

    public TableModelRacun(List<Racun> lista) {
        this.lista = lista;
    }

    public List<Racun> getLista() {
        return lista;
    }

    public void setLista(List<Racun> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Racun vratiIzabranRacun(int red) {
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
        Racun r = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getDatumPrometa();
            case 1:
                return r.getDatumIzdavanja();
            case 2:
                return r.getTrebovanje();
            case 3:
                return r.getValuta().getNaziv();
            case 4:
                return r.getPartner().getNaziv();
            case 5:
                return r.getRegionIzdavanja().getNaziv();
            case 6:
                return r.getGradIzdavanja().getNaziv();
            case 7:
                return r.getGradIzdavanja().getPostanskiBroj();
            case 8:
                return r.getRegionPrometa().getNaziv();
            case 9:
                return r.getGradPrometa().getNaziv();
            case 10:
                return r.getGradPrometa().getPostanskiBroj();
            case 11:
                return r.getPrijemnica();
            case 12:
                return r.getUkupnaCena();
            
            default:
                return "Greška";
        }
    }
    
}
