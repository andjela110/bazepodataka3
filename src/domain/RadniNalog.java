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
public class RadniNalog {
    private int id;
    private String status;
    private Date datumKreiranja;
    private Date datumIzmene;
    private Date planiraniDatum;
    private Date datumRealizacije;
    private String napomena;
    private String prioritet;
    private String opis;
    private boolean eksportovanost;
    private boolean zavrsenost;
    private boolean spornost;
    private boolean internost;
    private TipRadnogNaloga tipRadnogNaloga;
    private Partner partner;
    private GotovProizvod gotovProizvod;
    private Kupac kupac;

    public RadniNalog(){}
    
    public RadniNalog(int id, String status, Date datumKreiranja, Date datumIzmene, Date planiraniDatum, Date datumRealizacije, String napomena, String prioritet, String opis, boolean eksportovanost, boolean zavrsenost, boolean spornost, boolean internost, TipRadnogNaloga tipRadnogNaloga, Partner partner, GotovProizvod gotovProizvod, Kupac kupac) {
        this.id = id;
        this.status = status;
        this.datumKreiranja = datumKreiranja;
        this.datumIzmene = datumIzmene;
        this.planiraniDatum = planiraniDatum;
        this.datumRealizacije = datumRealizacije;
        this.napomena = napomena;
        this.prioritet = prioritet;
        this.opis = opis;
        this.eksportovanost = eksportovanost;
        this.zavrsenost = zavrsenost;
        this.spornost = spornost;
        this.internost = internost;
        this.tipRadnogNaloga = tipRadnogNaloga;
        this.partner = partner;
        this.gotovProizvod = gotovProizvod;
        this.kupac = kupac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Date getDatumIzmene() {
        return datumIzmene;
    }

    public void setDatumIzmene(Date datumIzmene) {
        this.datumIzmene = datumIzmene;
    }

    public Date getPlaniraniDatum() {
        return planiraniDatum;
    }

    public void setPlaniraniDatum(Date planiraniDatum) {
        this.planiraniDatum = planiraniDatum;
    }

    public Date getDatumRealizacije() {
        return datumRealizacije;
    }

    public void setDatumRealizacije(Date datumRealizacije) {
        this.datumRealizacije = datumRealizacije;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getPrioritet() {
        return prioritet;
    }

    public void setPrioritet(String prioritet) {
        this.prioritet = prioritet;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isEksportovanost() {
        return eksportovanost;
    }

    public void setEksportovanost(boolean eksportovanost) {
        this.eksportovanost = eksportovanost;
    }

    public boolean isZavrsenost() {
        return zavrsenost;
    }

    public void setZavrsenost(boolean zavrsenost) {
        this.zavrsenost = zavrsenost;
    }

    public boolean isSpornost() {
        return spornost;
    }

    public void setSpornost(boolean spornost) {
        this.spornost = spornost;
    }

    public boolean isInternost() {
        return internost;
    }

    public void setInternost(boolean internost) {
        this.internost = internost;
    }

    public TipRadnogNaloga getTipRadnogNaloga() {
        return tipRadnogNaloga;
    }

    public void setTipRadnogNaloga(TipRadnogNaloga tipRadnogNaloga) {
        this.tipRadnogNaloga = tipRadnogNaloga;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.status);
        hash = 41 * hash + Objects.hashCode(this.datumKreiranja);
        hash = 41 * hash + Objects.hashCode(this.datumIzmene);
        hash = 41 * hash + Objects.hashCode(this.planiraniDatum);
        hash = 41 * hash + Objects.hashCode(this.datumRealizacije);
        hash = 41 * hash + Objects.hashCode(this.napomena);
        hash = 41 * hash + Objects.hashCode(this.prioritet);
        hash = 41 * hash + Objects.hashCode(this.opis);
        hash = 41 * hash + (this.eksportovanost ? 1 : 0);
        hash = 41 * hash + (this.zavrsenost ? 1 : 0);
        hash = 41 * hash + (this.spornost ? 1 : 0);
        hash = 41 * hash + (this.internost ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.tipRadnogNaloga);
        hash = 41 * hash + Objects.hashCode(this.partner);
        hash = 41 * hash + Objects.hashCode(this.gotovProizvod);
        hash = 41 * hash + Objects.hashCode(this.kupac);
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
        final RadniNalog other = (RadniNalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.eksportovanost != other.eksportovanost) {
            return false;
        }
        if (this.zavrsenost != other.zavrsenost) {
            return false;
        }
        if (this.spornost != other.spornost) {
            return false;
        }
        if (this.internost != other.internost) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.napomena, other.napomena)) {
            return false;
        }
        if (!Objects.equals(this.prioritet, other.prioritet)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.datumKreiranja, other.datumKreiranja)) {
            return false;
        }
        if (!Objects.equals(this.datumIzmene, other.datumIzmene)) {
            return false;
        }
        if (!Objects.equals(this.planiraniDatum, other.planiraniDatum)) {
            return false;
        }
        if (!Objects.equals(this.datumRealizacije, other.datumRealizacije)) {
            return false;
        }
        if (!Objects.equals(this.tipRadnogNaloga, other.tipRadnogNaloga)) {
            return false;
        }
        if (!Objects.equals(this.partner, other.partner)) {
            return false;
        }
        if (!Objects.equals(this.gotovProizvod, other.gotovProizvod)) {
            return false;
        }
        return Objects.equals(this.kupac, other.kupac);
    }

    @Override
    public String toString() {
        return datumKreiranja + ", " + opis;
    }
    
    
    
    
}
