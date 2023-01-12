/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.StavkaRacuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelStavkaRacuna extends AbstractTableModel{
    
    List<StavkaRacuna> lista;
    private final String[] naziviKolona = new String[]{"Račun", "Količina", "PDV", "Rabat", "Naziv materijala"};

    public TableModelStavkaRacuna() {}

    public TableModelStavkaRacuna(List<StavkaRacuna> lista) {
        this.lista = lista;
    }

    public List<StavkaRacuna> getLista() {
        return lista;
    }

    public void setLista(List<StavkaRacuna> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public StavkaRacuna vratiIzabranuStavkuRacuna(int red) {
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
        StavkaRacuna sr = lista.get(rowIndex);
        switch (columnIndex) {
             case 0:
                return sr.getRacun();
            case 1:
                return sr.getKolicina();
            case 2:
                return sr.getPdv();
            case 3:
                return sr.getRabat(); 
            case 4:
                return sr.getMaterijal().getNaziv();
            
            default:
                return "Greška";
        }
    }
    
}
