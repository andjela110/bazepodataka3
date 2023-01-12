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
public class Materijal{
    private int id;
    private String naziv;
    private double cena;
    private int barkod;
    private JedinicaMere jedinicaMere;
    
    public Materijal(){}
    
    public Materijal (int id, String naziv, double cena, int barkod, JedinicaMere jedinicaMere){
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.barkod = barkod;
        this.jedinicaMere = jedinicaMere;
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

    
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
    public int getBarkod() {
        return barkod;
    }

    public void setBarkod(int barkod) {
        this.barkod = barkod;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.naziv);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
        hash = 23 * hash + this.barkod;
        hash = 23 * hash + Objects.hashCode(this.jedinicaMere);
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
        final Materijal other = (Materijal) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (this.barkod != other.barkod) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return Objects.equals(this.jedinicaMere, other.jedinicaMere);
    }

    @Override
    public String toString() {
        return naziv;
    }
   
}
