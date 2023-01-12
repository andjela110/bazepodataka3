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
public class Kvar{

    private int id;
    private GotovProizvod gotovProizvod;
    private int kolicinaKvara;
    private Date datumKvara;
    private TipKvara tipKvara;
    private TipUzrokaKvara tipUzrokaKvara;
    
    
    public Kvar(){}
    
    public Kvar(int id, GotovProizvod gotovProizvod, int kolicinaKvara, Date datumKvara, TipKvara tipKvara, TipUzrokaKvara tipUzrokaKvara){
        this.id=id;
        this.gotovProizvod = gotovProizvod;
        this.kolicinaKvara=kolicinaKvara;
        this.datumKvara=datumKvara;
        this.tipKvara = tipKvara;
        this.tipUzrokaKvara = tipUzrokaKvara;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GotovProizvod getGotovProizvod() {
        return gotovProizvod;
    }

    public void setGotovProizvod(GotovProizvod gotovProizvod) {
        this.gotovProizvod = gotovProizvod;
    }

    public int getKolicinaKvara() {
        return kolicinaKvara;
    }

    public void setKolicinaKvara(int kolicinaKvara) {
        this.kolicinaKvara = kolicinaKvara;
    }

    public Date getDatumKvara() {
        return datumKvara;
    }

    public void setDatumKvara(Date datumKvara) {
        this.datumKvara = datumKvara;
    }

    public TipKvara getTipKvara() {
        return tipKvara;
    }

    public void setTipKvara(TipKvara tipKvara) {
        this.tipKvara = tipKvara;
    }

    public TipUzrokaKvara getTipUzrokaKvara() {
        return tipUzrokaKvara;
    }

    public void setTipUzrokaKvara(TipUzrokaKvara tipUzrokaKvara) {
        this.tipUzrokaKvara = tipUzrokaKvara;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.gotovProizvod);
        hash = 11 * hash + this.kolicinaKvara;
        hash = 11 * hash + Objects.hashCode(this.datumKvara);
        hash = 11 * hash + Objects.hashCode(this.tipKvara);
        hash = 11 * hash + Objects.hashCode(this.tipUzrokaKvara);
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
        final Kvar other = (Kvar) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.kolicinaKvara != other.kolicinaKvara) {
            return false;
        }
        if (!Objects.equals(this.gotovProizvod, other.gotovProizvod)) {
            return false;
        }
        if (!Objects.equals(this.datumKvara, other.datumKvara)) {
            return false;
        }
        if (!Objects.equals(this.tipKvara, other.tipKvara)) {
            return false;
        }
        return Objects.equals(this.tipUzrokaKvara, other.tipUzrokaKvara);
    }

    @Override
    public String toString() {
        return datumKvara + ", " + tipKvara;
    }
    
    
 
}
