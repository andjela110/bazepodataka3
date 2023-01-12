/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class IzvestajServisera {
    private int id;
    private String napomena;
    private String opis;
    private TerenskiRadniNalog terenskiRadniNalog;
    private NacinPlacanja nacinPlacanja;
    private Partner partner;
    private Kupac kupac;
    private GotovProizvod gotovProizvod;

    public IzvestajServisera(){}
    
    public IzvestajServisera(int id, String napomena, String opis, TerenskiRadniNalog terenskiRadniNalog, NacinPlacanja nacinPlacanja, Partner partner, Kupac kupac, GotovProizvod gotovProizvod) {
        this.id = id;
        this.napomena = napomena;
        this.opis = opis;
        this.terenskiRadniNalog = terenskiRadniNalog;
        this.nacinPlacanja = nacinPlacanja;
        this.partner = partner;
        this.kupac = kupac;
        this.gotovProizvod = gotovProizvod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public TerenskiRadniNalog getTerenskiRadniNalog() {
        return terenskiRadniNalog;
    }

    public void setTerenskiRadniNalog(TerenskiRadniNalog terenskiRadniNalog) {
        this.terenskiRadniNalog = terenskiRadniNalog;
    }

    public NacinPlacanja getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public GotovProizvod getGotovProizvod() {
        return gotovProizvod;
    }

    public void setGotovProizvod(GotovProizvod gotovProizvod) {
        this.gotovProizvod = gotovProizvod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.napomena);
        hash = 53 * hash + Objects.hashCode(this.opis);
        hash = 53 * hash + Objects.hashCode(this.terenskiRadniNalog);
        hash = 53 * hash + Objects.hashCode(this.nacinPlacanja);
        hash = 53 * hash + Objects.hashCode(this.partner);
        hash = 53 * hash + Objects.hashCode(this.kupac);
        hash = 53 * hash + Objects.hashCode(this.gotovProizvod);
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
        final IzvestajServisera other = (IzvestajServisera) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.napomena, other.napomena)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.terenskiRadniNalog, other.terenskiRadniNalog)) {
            return false;
        }
        if (!Objects.equals(this.nacinPlacanja, other.nacinPlacanja)) {
            return false;
        }
        if (!Objects.equals(this.partner, other.partner)) {
            return false;
        }
        if (!Objects.equals(this.kupac, other.kupac)) {
            return false;
        }
        return Objects.equals(this.gotovProizvod, other.gotovProizvod);
    }

    @Override
    public String toString() {
        return opis;
    }
    
    
    
}
