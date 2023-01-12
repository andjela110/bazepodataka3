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
public class Kupio {
    private Date datumKupovineGP;
    private GotovProizvod gotovProizvod;
    private Kupac kupac;
    private boolean garancija;
    private String imePrezimeKupca;

    public Kupio(){}
    
    public Kupio(Date datumKupovineGP, GotovProizvod gotovProizvod, Kupac kupac, boolean garancija, String imePrezimeKupca) {
        this.datumKupovineGP = datumKupovineGP;
        this.gotovProizvod = gotovProizvod;
        this.kupac = kupac;
        this.garancija = garancija;
        this.imePrezimeKupca = imePrezimeKupca;
    }

    public Date getDatumKupovineGP() {
        return datumKupovineGP;
    }

    public void setDatumKupovineGP(Date datumKupovineGP) {
        this.datumKupovineGP = datumKupovineGP;
    }

    public GotovProizvod getGotovProizvod() {
        return gotovProizvod;
    }

    public void setGotovProizvod(GotovProizvod gotovProizvod) {
        this.gotovProizvod = gotovProizvod;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public boolean isGarancija() {
        return garancija;
    }

    public void setGarancija(boolean garancija) {
        this.garancija = garancija;
    }

    public String getImePrezimeKupca() {
        return imePrezimeKupca;
    }

    public void setImePrezimeKupca(String imePrezimeKupca) {
        this.imePrezimeKupca = imePrezimeKupca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.datumKupovineGP);
        hash = 61 * hash + Objects.hashCode(this.gotovProizvod);
        hash = 61 * hash + Objects.hashCode(this.kupac);
        hash = 61 * hash + (this.garancija ? 1 : 0);
        hash = 61 * hash + Objects.hashCode(this.imePrezimeKupca);
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
        final Kupio other = (Kupio) obj;
        if (this.garancija != other.garancija) {
            return false;
        }
        if (!Objects.equals(this.imePrezimeKupca, other.imePrezimeKupca)) {
            return false;
        }
        if (!Objects.equals(this.datumKupovineGP, other.datumKupovineGP)) {
            return false;
        }
        if (!Objects.equals(this.gotovProizvod, other.gotovProizvod)) {
            return false;
        }
        return Objects.equals(this.kupac, other.kupac);
    }

    @Override
    public String toString() {
        return datumKupovineGP + ", " + gotovProizvod + ", " + kupac;
    }
    
    
}
