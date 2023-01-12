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
public class Grad {

    private int postanskiBroj;
    private Region region;
    private String naziv;
    List<Ulica> listaUlica;
    
    public Grad(){}
    
    public Grad(int postanskiBroj, Region region, String naziv){
        this.postanskiBroj = postanskiBroj;
        this.region= region;
        this.naziv = naziv;
    }

    public Grad(int postanskiBroj, Region region, String naziv, List<Ulica> listaUlica) {
        this.postanskiBroj = postanskiBroj;
        this.region = region;
        this.naziv = naziv;
        this.listaUlica = listaUlica;
    }
    
    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
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

    public List<Ulica> getListaUlica() {
        return listaUlica;
    }

    public void setListaUlica(List<Ulica> listaUlica) {
        this.listaUlica = listaUlica;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.postanskiBroj;
        hash = 67 * hash + Objects.hashCode(this.region);
        hash = 67 * hash + Objects.hashCode(this.naziv);
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
        final Grad other = (Grad) obj;
        if (this.postanskiBroj != other.postanskiBroj) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return Objects.equals(this.region, other.region);
    }

    @Override
    public String toString() {
        return naziv;
    }
  
}
