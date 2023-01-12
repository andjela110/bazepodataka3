/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.Objects;


/**
 *
 * @author Korisnik
 */
public class Ulica {

    private int id;
    private Grad grad;
    private Region region;
    private String naziv;
    List<Broj> listaBrojeva;
    
    public Ulica(){}
    
    public Ulica(int id, Grad grad, Region region, String naziv){
        this.id=id;
        this.grad = grad;
        this.region= region;
        this.naziv = naziv;
    }

    public Ulica(int id, Grad grad, Region region, String naziv, List<Broj> listaBrojeva) {
        this.id = id;
        this.grad = grad;
        this.region = region;
        this.naziv = naziv;
        this.listaBrojeva = listaBrojeva;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Broj> getListaBrojeva() {
        return listaBrojeva;
    }

    public void setListaBrojeva(List<Broj> listaBrojeva) {
        this.listaBrojeva = listaBrojeva;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.grad);
        hash = 19 * hash + Objects.hashCode(this.region);
        hash = 19 * hash + Objects.hashCode(this.naziv);
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
        final Ulica other = (Ulica) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.grad, other.grad)) {
            return false;
        }
        return Objects.equals(this.region, other.region);
    }


    @Override
    public String toString() {
        return naziv;
    }
    
    
}
