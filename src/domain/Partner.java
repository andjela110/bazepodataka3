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
public class Partner {
    private int id;
    private String naziv;
    private String brojTelefona;
    private String pib;
    private String maticniBroj;
    private String tekuciRacun;
    private String nazivDelatnosti;
    private Broj broj;
    private Ulica ulica;
    private Grad grad;
    private Region region;
    private Delatnost delatnost;
    private Banka banka;

    public Partner(){}
    
    public Partner(int id, String naziv, String brojTelefona, String pib, String maticniBroj, String tekuciRacun, String nazivDelatnosti, Broj broj, Ulica ulica, Grad grad, Region region, Delatnost delatnost, Banka banka) {
        this.id = id;
        this.naziv = naziv;
        this.brojTelefona = brojTelefona;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.tekuciRacun = tekuciRacun;
        this.nazivDelatnosti = nazivDelatnosti;
        this.broj = broj;
        this.ulica = ulica;
        this.grad = grad;
        this.region = region;
        this.delatnost = delatnost;
        this.banka = banka;
    }

    public Partner(int id, String naziv, String brojTelefona, String pib, String maticniBroj, String tekuciRacun, Broj broj, Ulica ulica, Grad grad, Region region, Delatnost delatnost, Banka banka) {
        this.id = id;
        this.naziv = naziv;
        this.brojTelefona = brojTelefona;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.tekuciRacun = tekuciRacun;
        this.broj = broj;
        this.ulica = ulica;
        this.grad = grad;
        this.region = region;
        this.delatnost = delatnost;
        this.banka = banka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getTekuciRacun() {
        return tekuciRacun;
    }

    public void setTekuciRacun(String tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }

    public String getNazivDelatnosti() {
        return nazivDelatnosti;
    }

    public void setNazivDelatnosti(String nazivDelatnosti) {
        this.nazivDelatnosti = nazivDelatnosti;
    }

    public Broj getBroj() {
        return broj;
    }

    public void setBroj(Broj broj) {
        this.broj = broj;
    }

    public Ulica getUlica() {
        return ulica;
    }

    public void setUlica(Ulica ulica) {
        this.ulica = ulica;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Delatnost getDelatnost() {
        return delatnost;
    }

    public void setDelatnost(Delatnost delatnost) {
        this.delatnost = delatnost;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.naziv);
        hash = 53 * hash + Objects.hashCode(this.brojTelefona);
        hash = 53 * hash + Objects.hashCode(this.pib);
        hash = 53 * hash + Objects.hashCode(this.maticniBroj);
        hash = 53 * hash + Objects.hashCode(this.tekuciRacun);
        hash = 53 * hash + Objects.hashCode(this.nazivDelatnosti);
        hash = 53 * hash + Objects.hashCode(this.broj);
        hash = 53 * hash + Objects.hashCode(this.ulica);
        hash = 53 * hash + Objects.hashCode(this.grad);
        hash = 53 * hash + Objects.hashCode(this.region);
        hash = 53 * hash + Objects.hashCode(this.delatnost);
        hash = 53 * hash + Objects.hashCode(this.banka);
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
        final Partner other = (Partner) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        if (!Objects.equals(this.pib, other.pib)) {
            return false;
        }
        if (!Objects.equals(this.maticniBroj, other.maticniBroj)) {
            return false;
        }
        if (!Objects.equals(this.tekuciRacun, other.tekuciRacun)) {
            return false;
        }
        if (!Objects.equals(this.nazivDelatnosti, other.nazivDelatnosti)) {
            return false;
        }
        if (!Objects.equals(this.broj, other.broj)) {
            return false;
        }
        if (!Objects.equals(this.ulica, other.ulica)) {
            return false;
        }
        if (!Objects.equals(this.grad, other.grad)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        if (!Objects.equals(this.delatnost, other.delatnost)) {
            return false;
        }
        return Objects.equals(this.banka, other.banka);
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
