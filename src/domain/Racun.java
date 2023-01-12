/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Racun {
    private int id;
    private Date datumPrometa;
    private Date datumIzdavanja;
    private Trebovanje trebovanje;
    private Valuta valuta;
    private Partner partner;
    private Grad gradIzdavanja;
    private Region regionIzdavanja;
    private Grad gradPrometa;
    private Region regionPrometa;
    private Prijemnica prijemnica;
    private double ukupnaCena; //reduntantna kolona
    private List<StavkaRacuna> stavkeRacuna;

    public Racun(){}
    
    public Racun(int id, Date datumPrometa, Date datumIzdavanja, Trebovanje trebovanje, Valuta valuta, Partner partner, Grad gradIzdavanja, Region regionIzdavanja, Grad gradPrometa, Region regionPrometa, Prijemnica prijemnica, double ukupnaCena, List<StavkaRacuna> stavkeRacuna) {
        this.id = id;
        this.datumPrometa = datumPrometa;
        this.datumIzdavanja = datumIzdavanja;
        this.trebovanje = trebovanje;
        this.valuta = valuta;
        this.partner = partner;
        this.gradIzdavanja = gradIzdavanja;
        this.regionIzdavanja = regionIzdavanja;
        this.gradPrometa = gradPrometa;
        this.regionPrometa = regionPrometa;
        this.prijemnica = prijemnica;
        this.ukupnaCena = ukupnaCena;
        this.stavkeRacuna = stavkeRacuna;
    }

    public Racun(int id, Date datumPrometa, Date datumIzdavanja, Trebovanje trebovanje, Valuta valuta, Partner partner, Grad gradIzdavanja, Region regionIzdavanja, Grad gradPrometa, Region regionPrometa, Prijemnica prijemnica, double ukupnaCena) {
        this.id = id;
        this.datumPrometa = datumPrometa;
        this.datumIzdavanja = datumIzdavanja;
        this.trebovanje = trebovanje;
        this.valuta = valuta;
        this.partner = partner;
        this.gradIzdavanja = gradIzdavanja;
        this.regionIzdavanja = regionIzdavanja;
        this.gradPrometa = gradPrometa;
        this.regionPrometa = regionPrometa;
        this.prijemnica = prijemnica;
        this.ukupnaCena = ukupnaCena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumPrometa() {
        return datumPrometa;
    }

    public void setDatumPrometa(Date datumPrometa) {
        this.datumPrometa = datumPrometa;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Trebovanje getTrebovanje() {
        return trebovanje;
    }

    public void setTrebovanje(Trebovanje trebovanje) {
        this.trebovanje = trebovanje;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Grad getGradIzdavanja() {
        return gradIzdavanja;
    }

    public void setGradIzdavanja(Grad gradIzdavanja) {
        this.gradIzdavanja = gradIzdavanja;
    }

    public Region getRegionIzdavanja() {
        return regionIzdavanja;
    }

    public void setRegionIzdavanja(Region regionIzdavanja) {
        this.regionIzdavanja = regionIzdavanja;
    }

    public Grad getGradPrometa() {
        return gradPrometa;
    }

    public void setGradPrometa(Grad gradPrometa) {
        this.gradPrometa = gradPrometa;
    }

    public Region getRegionPrometa() {
        return regionPrometa;
    }

    public void setRegionPrometa(Region regionPrometa) {
        this.regionPrometa = regionPrometa;
    }

    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.datumPrometa);
        hash = 47 * hash + Objects.hashCode(this.datumIzdavanja);
        hash = 47 * hash + Objects.hashCode(this.trebovanje);
        hash = 47 * hash + Objects.hashCode(this.valuta);
        hash = 47 * hash + Objects.hashCode(this.partner);
        hash = 47 * hash + Objects.hashCode(this.gradIzdavanja);
        hash = 47 * hash + Objects.hashCode(this.regionIzdavanja);
        hash = 47 * hash + Objects.hashCode(this.gradPrometa);
        hash = 47 * hash + Objects.hashCode(this.regionPrometa);
        hash = 47 * hash + Objects.hashCode(this.prijemnica);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.ukupnaCena) ^ (Double.doubleToLongBits(this.ukupnaCena) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.stavkeRacuna);
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
        final Racun other = (Racun) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.ukupnaCena) != Double.doubleToLongBits(other.ukupnaCena)) {
            return false;
        }
        if (!Objects.equals(this.datumPrometa, other.datumPrometa)) {
            return false;
        }
        if (!Objects.equals(this.datumIzdavanja, other.datumIzdavanja)) {
            return false;
        }
        if (!Objects.equals(this.trebovanje, other.trebovanje)) {
            return false;
        }
        if (!Objects.equals(this.valuta, other.valuta)) {
            return false;
        }
        if (!Objects.equals(this.partner, other.partner)) {
            return false;
        }
        if (!Objects.equals(this.gradIzdavanja, other.gradIzdavanja)) {
            return false;
        }
        if (!Objects.equals(this.regionIzdavanja, other.regionIzdavanja)) {
            return false;
        }
        if (!Objects.equals(this.gradPrometa, other.gradPrometa)) {
            return false;
        }
        if (!Objects.equals(this.regionPrometa, other.regionPrometa)) {
            return false;
        }
        if (!Objects.equals(this.prijemnica, other.prijemnica)) {
            return false;
        }
        return Objects.equals(this.stavkeRacuna, other.stavkeRacuna);
    }

    @Override
    public String toString() {
        return datumIzdavanja + ", " + ukupnaCena;
    }
    
    
}
