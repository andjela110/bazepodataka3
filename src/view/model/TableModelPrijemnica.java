/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.model;

import domain.Prijemnica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelPrijemnica extends AbstractTableModel{
    
    List<Prijemnica> lista;
    private final String[] naziviKolona = new String[]{"Datum od", "Datum dospeca", "Status", "Izvestaj servisera", "Nacin placanja", "Organizaciona jedinica", "Tip prijemnice", "Magacin", "Partner"};

    public TableModelPrijemnica() {}

    public TableModelPrijemnica(List<Prijemnica> lista) {
        this.lista = lista;
    }

    public List<Prijemnica> getLista() {
        return lista;
    }

    public void setLista(List<Prijemnica> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

      public Prijemnica vratiIzabranuPrijemnicu(int red) {
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
        Prijemnica p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getDatumOd();
            case 1:
                return p.getDatumDospeca();
            case 2:
                return p.getStatus();
            case 3:
                return p.getIzvestajServisera();
            case 4:
                return p.getNacinPlacanja().getNaziv();
            case 5:
                return p.getOrganizacionaJedinica().getNaziv();
            case 6:
                return p.getTipPrijemnice().getNaziv();
            case 7:
                return p.getMagacin().getNaziv();
            case 8:
                return p.getPartner().getNaziv();
                
            default:
                return "Greška";
        }
    }
    
}
