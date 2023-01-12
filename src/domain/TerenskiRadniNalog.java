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
public class TerenskiRadniNalog {
    private int id;
    private Date datumRealizacije;
    private String napomena;
    private String opisPoslova;
    private RadniNalog radniNalog;
    private OrganizacionaJedinica organizacionaJedinica;
    private GotovProizvod gotovProizvod;
    private Kupac kupac;
    private Partner partner;
    private TipTerenskogRadnogNaloga tipTerenskogRadnogNaloga;
    private Pitanje pitanje;

    public TerenskiRadniNalog(){}
    
    public TerenskiRadniNalog(int id, Date datumRealizacije, String napomena, String opisPoslova, RadniNalog radniNalog, OrganizacionaJedinica organizacionaJedinica, GotovProizvod gotovProizvod, Kupac kupac, Partner partner, TipTerenskogRadnogNaloga tipTerenskogRadnogNaloga, Pitanje pitanje) {
        this.id = id;
        this.datumRealizacije = datumRealizacije;
        this.napomena = napomena;
        this.opisPoslova = opisPoslova;
        this.radniNalog = radniNalog;
        this.organizacionaJedinica = organizacionaJedinica;
        this.gotovProizvod = gotovProizvod;
        this.kupac = kupac;
        this.partner = partner;
        this.tipTerenskogRadnogNaloga = tipTerenskogRadnogNaloga;
        this.pitanje = pitanje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOpisPoslova() {
        return opisPoslova;
    }

    public void setOpisPoslova(String opisPoslova) {
        this.opisPoslova = opisPoslova;
    }

    public RadniNalog getRadniNalog() {
        return radniNalog;
    }

    public void setRadniNalog(RadniNalog radniNalog) {
        this.radniNalog = radniNalog;
    }

    public OrganizacionaJedinica getOrganizacionaJedinica() {
        return organizacionaJedinica;
    }

    public void setOrganizacionaJedinica(OrganizacionaJedinica organizacionaJedinica) {
        this.organizacionaJedinica = organizacionaJedinica;
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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public TipTerenskogRadnogNaloga getTipTerenskogRadnogNaloga() {
        return tipTerenskogRadnogNaloga;
    }

    public void setTipTerenskogRadnogNaloga(TipTerenskogRadnogNaloga tipTerenskogRadnogNaloga) {
        this.tipTerenskogRadnogNaloga = tipTerenskogRadnogNaloga;
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.datumRealizacije);
        hash = 37 * hash + Objects.hashCode(this.napomena);
        hash = 37 * hash + Objects.hashCode(this.opisPoslova);
        hash = 37 * hash + Objects.hashCode(this.radniNalog);
        hash = 37 * hash + Objects.hashCode(this.organizacionaJedinica);
        hash = 37 * hash + Objects.hashCode(this.gotovProizvod);
        hash = 37 * hash + Objects.hashCode(this.kupac);
        hash = 37 * hash + Objects.hashCode(this.partner);
        hash = 37 * hash + Objects.hashCode(this.tipTerenskogRadnogNaloga);
        hash = 37 * hash + Objects.hashCode(this.pitanje);
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
        final TerenskiRadniNalog other = (TerenskiRadniNalog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.napomena, other.napomena)) {
            return false;
        }
        if (!Objects.equals(this.opisPoslova, other.opisPoslova)) {
            return false;
        }
        if (!Objects.equals(this.datumRealizacije, other.datumRealizacije)) {
            return false;
        }
        if (!Objects.equals(this.radniNalog, other.radniNalog)) {
            return false;
        }
        if (!Objects.equals(this.organizacionaJedinica, other.organizacionaJedinica)) {
            return false;
        }
        if (!Objects.equals(this.gotovProizvod, other.gotovProizvod)) {
            return false;
        }
        if (!Objects.equals(this.kupac, other.kupac)) {
            return false;
        }
        if (!Objects.equals(this.partner, other.partner)) {
            return false;
        }
        if (!Objects.equals(this.tipTerenskogRadnogNaloga, other.tipTerenskogRadnogNaloga)) {
            return false;
        }
        return Objects.equals(this.pitanje, other.pitanje);
    }

    @Override
    public String toString() {
        return datumRealizacije + ", " + tipTerenskogRadnogNaloga;
    }
    
    
    
}
