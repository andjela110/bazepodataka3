/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Trebovanje {
    private int id;
    private Date datumTrebovanja;
    private String status;
    private Prijemnica prijemnica;
    private TipTrebovanja tipTrebovanja;
    private GotovProizvod gotovProizvod;
    private Magacin magacin;
    private Magacin mestoTroska;

    public Trebovanje(){}
    
    public Trebovanje(int id, Date datumTrebovanja, String status, Prijemnica prijemnica, TipTrebovanja tipTrebovanja, GotovProizvod gotovProizvod, Magacin magacin, Magacin mestoTroska) {
        this.id = id;
        this.datumTrebovanja = datumTrebovanja;
        this.status = status;
        this.prijemnica = prijemnica;
        this.tipTrebovanja = tipTrebovanja;
        this.gotovProizvod = gotovProizvod;
        this.magacin = magacin;
        this.mestoTroska = mestoTroska;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumTrebovanja() {
        return datumTrebovanja;
    }

    public void setDatumTrebovanja(Date datumTrebovanja) {
        this.datumTrebovanja = datumTrebovanja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
    }

    public TipTrebovanja getTipTrebovanja() {
        return tipTrebovanja;
    }

    public void setTipTrebovanja(TipTrebovanja tipTrebovanja) {
        this.tipTrebovanja = tipTrebovanja;
    }

    public GotovProizvod getGotovProizvod() {
        return gotovProizvod;
    }

    public void setGotovProizvod(GotovProizvod gotovProizvod) {
        this.gotovProizvod = gotovProizvod;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }

    public Magacin getMestoTroska() {
        return mestoTroska;
    }

    public void setMestoTroska(Magacin mestoTroska) {
        this.mestoTroska = mestoTroska;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.datumTrebovanja);
        hash = 23 * hash + Objects.hashCode(this.status);
        hash = 23 * hash + Objects.hashCode(this.prijemnica);
        hash = 23 * hash + Objects.hashCode(this.tipTrebovanja);
        hash = 23 * hash + Objects.hashCode(this.gotovProizvod);
        hash = 23 * hash + Objects.hashCode(this.magacin);
        hash = 23 * hash + Objects.hashCode(this.mestoTroska);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trebovanje other = (Trebovanje) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.datumTrebovanja, other.datumTrebovanja)) {
            return false;
        }
        if (!Objects.equals(this.prijemnica, other.prijemnica)) {
            return false;
        }
        if (!Objects.equals(this.tipTrebovanja, other.tipTrebovanja)) {
            return false;
        }
        if (!Objects.equals(this.gotovProizvod, other.gotovProizvod)) {
            return false;
        }
        if (!Objects.equals(this.magacin, other.magacin)) {
            return false;
        }
        return Objects.equals(this.mestoTroska, other.mestoTroska);
    }

    @Override
    public String toString() {
        return datumTrebovanja + ", " + tipTrebovanja;
    }
    
    
}
