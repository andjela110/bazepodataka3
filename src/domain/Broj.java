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
public class Broj {

    private int id;
    private Ulica ulica;
    private Grad grad;
    private Region region;
    private String brVrednost;

    public Broj(){}
    
    public Broj(Ulica ulica, Grad grad, Region region){
        this.ulica = ulica;
        this.grad = grad;
        this.region = region;
    }
    
    public Broj(int id, Ulica ulica, Grad grad, Region region, String brVrednost){
        this.id = id;
        this.ulica = ulica;
        this.grad = grad;
        this.region = region;
        this.brVrednost = brVrednost;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String getBrVrednost() {
        return brVrednost;
    }

    public void setBrVrednost(String brVrednost) {
        this.brVrednost = brVrednost;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.ulica);
        hash = 41 * hash + Objects.hashCode(this.grad);
        hash = 41 * hash + Objects.hashCode(this.region);
        hash = 41 * hash + Objects.hashCode(this.brVrednost);
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
        final Broj other = (Broj) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.brVrednost, other.brVrednost)) {
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
        return ulica.getNaziv() + " " + brVrednost;
    }
    
    
}
