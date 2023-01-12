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
public class Region {
    private int id;
    private String naziv;
    List<Grad> listaGradova;
    
    public Region(){}
    
    public Region(int id, String naziv){
        this.id = id;
        this.naziv = naziv;
    }

    public Region(int id, String naziv, List<Grad> listaGradova) {
        this.id = id;
        this.naziv = naziv;
        this.listaGradova = listaGradova;
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

    public List<Grad> getListaGradova() {
        return listaGradova;
    }

    public void setListaGradova(List<Grad> listaGradova) {
        this.listaGradova = listaGradova;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.naziv);
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
        final Region other = (Region) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
