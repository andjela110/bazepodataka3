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
public class StavkaRacuna {
    private int rbr;
    private Racun racun;
    private int kolicina;
    private int pdv;
    private int rabat;
    private Materijal materijal;

    public StavkaRacuna() {}

    public StavkaRacuna(int rbr, Racun racun, int kolicina, int pdv, int rabat, Materijal materijal) {
        this.rbr = rbr;
        this.racun = racun;
        this.kolicina = kolicina;
        this.pdv = pdv;
        this.rabat = rabat;
        this.materijal = materijal;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getPdv() {
        return pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    public int getRabat() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    public Materijal getMaterijal() {
        return materijal;
    }

    public void setMaterijal(Materijal materijal) {
        this.materijal = materijal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.rbr;
        hash = 41 * hash + Objects.hashCode(this.racun);
        hash = 41 * hash + this.kolicina;
        hash = 41 * hash + this.pdv;
        hash = 41 * hash + this.rabat;
        hash = 41 * hash + Objects.hashCode(this.materijal);
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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (this.rbr != other.rbr) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        if (this.pdv != other.pdv) {
            return false;
        }
        if (this.rabat != other.rabat) {
            return false;
        }
        if (!Objects.equals(this.racun, other.racun)) {
            return false;
        }
        return Objects.equals(this.materijal, other.materijal);
    }

    @Override
    public String toString() {
        return racun + ", " + materijal;
    }
    
    
    
    
}
