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
public class Magacin{
    private int id;
    private String naziv;
    private String velicinaZaliha;
    private String velicina;
    private Broj broj;
    private Ulica ulica;
    private Grad grad;
    private Region region;
    private OrganizacionaJedinica organizacionaJedinica;

    public Magacin(){}
    
    public Magacin(int id, String naziv, String velicinaZaliha, String velicina, Broj broj, Ulica ulica, Grad grad, Region region, OrganizacionaJedinica organizacionaJedinica){
        this.id = id;
        this.naziv = naziv;
        this.velicinaZaliha = velicinaZaliha;
        this.velicina = velicina;
        this.broj = broj;
        this.ulica = ulica;
        this.grad = grad;
        this.region = region;
        this.organizacionaJedinica = organizacionaJedinica;
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
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVelicinaZaliha() {
        return velicinaZaliha;
    }

    public void setVelicinaZaliha(String velicinaZaliha) {
        this.velicinaZaliha = velicinaZaliha;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public Broj getBroj() {
        return broj;
    }

    public void setBroj(Broj broj) {
        this.broj = broj;
    }

    public OrganizacionaJedinica getOrganizacionaJedinica() {
        return organizacionaJedinica;
    }

    public void setOrganizacionaJedinica(OrganizacionaJedinica organizacionaJedinica) {
        this.organizacionaJedinica = organizacionaJedinica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.naziv);
        hash = 13 * hash + Objects.hashCode(this.velicinaZaliha);
        hash = 13 * hash + Objects.hashCode(this.velicina);
        hash = 13 * hash + Objects.hashCode(this.broj);
        hash = 13 * hash + Objects.hashCode(this.ulica);
        hash = 13 * hash + Objects.hashCode(this.grad);
        hash = 13 * hash + Objects.hashCode(this.region);
        hash = 13 * hash + Objects.hashCode(this.organizacionaJedinica);
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
        final Magacin other = (Magacin) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.velicinaZaliha, other.velicinaZaliha)) {
            return false;
        }
        if (!Objects.equals(this.velicina, other.velicina)) {
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
        return Objects.equals(this.organizacionaJedinica, other.organizacionaJedinica);
    }

    @Override
    public String toString() {
        return naziv;
    }

   
}
