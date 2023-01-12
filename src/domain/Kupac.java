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
public class Kupac {
    private int id;
    private String imePrezime;
    private String brojTelefona;
    private Broj broj;
    private Ulica ulica;
    private Grad grad;
    private Region region;

    public Kupac(){}
    
    public Kupac(int id, String imePrezime, String brojTelefona, Broj broj, Ulica ulica, Grad grad, Region region) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.brojTelefona = brojTelefona;
        this.broj = broj;
        this.ulica = ulica;
        this.grad = grad;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.imePrezime);
        hash = 83 * hash + Objects.hashCode(this.brojTelefona);
        hash = 83 * hash + Objects.hashCode(this.broj);
        hash = 83 * hash + Objects.hashCode(this.ulica);
        hash = 83 * hash + Objects.hashCode(this.grad);
        hash = 83 * hash + Objects.hashCode(this.region);
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
        final Kupac other = (Kupac) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
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
        return Objects.equals(this.region, other.region);
    }

    @Override
    public String toString() {
        return imePrezime;
    }
    
    
}
