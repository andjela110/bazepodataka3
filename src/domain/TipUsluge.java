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
public class TipUsluge {
    private int id;
    private NazivVrednost naziv;
    private double cena;
    
    public TipUsluge(){}

    public TipUsluge(int id, NazivVrednost naziv, double cena) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NazivVrednost getNaziv() {
        return naziv;
    }

    public void setNaziv(NazivVrednost naziv) {
        this.naziv = naziv;
    }
    
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.naziv);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
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
        final TipUsluge other = (TipUsluge) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String toString() {
        return naziv.getNaziv();
    }

    

    
}
