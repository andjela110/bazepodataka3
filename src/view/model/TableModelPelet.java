/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Pelet;
import domain.TipUsluge;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelPelet  extends AbstractTableModel{
    
    List<Pelet> lista;
    private final String[] naziviKolona = new String[]{"podaci (naziv, marka, prečnik, dužina)"};

    public TableModelPelet() {}

    public TableModelPelet(List<Pelet> lista) {
        this.lista = lista;
    }

    public List<Pelet> getLista() {
        return lista;
    }

    public void setLista(List<Pelet> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public Pelet vratiIzabranPelet(int red) {
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
        Pelet p = lista.get(rowIndex);
        switch (columnIndex) {
             case 0:
                return p.getPeletPodaci().getNazivPeleta()+", "+p.getPeletPodaci().getMarkaPeleta()+", "
                        + ""+p.getPeletPodaci().getPrecnikPeleta()+", "+p.getPeletPodaci().getDuzinaPeleta();
           
            default:
                return "Greška";
        }
    }
    
}