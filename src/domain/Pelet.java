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
public class Pelet {
    private int id;
    private PeletPodaci peletPodaci;

    public Pelet() {}

    public Pelet(int id, PeletPodaci peletPodaci) {
        this.id = id;
        this.peletPodaci = peletPodaci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PeletPodaci getPeletPodaci() {
        return peletPodaci;
    }

    public void setPeletPodaci(PeletPodaci peletPodaci) {
        this.peletPodaci = peletPodaci;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.peletPodaci);
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
        final Pelet other = (Pelet) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.peletPodaci, other.peletPodaci);
    }

    @Override
    public String toString() {
        return peletPodaci.getNazivPeleta();
    }
    
    
}
