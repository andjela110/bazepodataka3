/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Date;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author Korisnik
 */
public class GotovProizvod {

    private int id;
    private String naziv;
    private String model;
    private int serijskiBroj;
    private double snaga;
    private Date datumProizvodnje;
    private Date datumPoslednjegKvara;
    private List<Kvar> listaKvarova;
    
    public GotovProizvod(){}
    
    public GotovProizvod(int id, String naziv, String model, int serijskiBroj, double snaga, Date datumProizvodnje, Date datumPoslednjegKvara){
        this.id = id;
        this.naziv = naziv;
        this.model = model;
        this.serijskiBroj = serijskiBroj;
        this.snaga = snaga;
        this.datumProizvodnje = datumProizvodnje;
        this.datumPoslednjegKvara = datumPoslednjegKvara;
    }
    
    public GotovProizvod(int id, String naziv, String model, int serijskiBroj, double snaga, Date datumProizvodnje){
        this.id = id;
        this.naziv = naziv;
        this.model = model;
        this.serijskiBroj = serijskiBroj;
        this.snaga = snaga;
        this.datumProizvodnje = datumProizvodnje;
    }

    public GotovProizvod(int id, String naziv, String model, int serijskiBroj, double snaga, Date datumProizvodnje, Date datumPoslednjegKvara, List<Kvar> listaKvarova) {
        this.id = id;
        this.naziv = naziv;
        this.model = model;
        this.serijskiBroj = serijskiBroj;
        this.snaga = snaga;
        this.datumProizvodnje = datumProizvodnje;
        this.datumPoslednjegKvara = datumPoslednjegKvara;
        this.listaKvarova = listaKvarova;
    }

    public GotovProizvod(int id, String naziv, String model, int serijskiBroj, double snaga, Date datumProizvodnje, List<Kvar> listaKvarova) {
        this.id = id;
        this.naziv = naziv;
        this.model = model;
        this.serijskiBroj = serijskiBroj;
        this.snaga = snaga;
        this.datumProizvodnje = datumProizvodnje;
        this.listaKvarova = listaKvarova;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNaziv(){
        return naziv;
    }
    
    public void setNaziv(String naziv){
        this.naziv=naziv;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setModel(String model){
        this.model=model;
    }
    
    public int getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(int serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }
    
    public double getSnaga() {
        return snaga;
    }

    public void setSnaga(double snaga) {
        this.snaga = snaga;
    }
    
    public Date getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public void setDatumProizvodnje(Date datumProizvodnje) {
        this.datumProizvodnje = datumProizvodnje;
    }
    
    public Date getDatumPoslednjegKvara() {
        return datumPoslednjegKvara;
    }

    public void setDatumPoslednjegKvara(Date datumPoslednjegKvara) {
        this.datumPoslednjegKvara = datumPoslednjegKvara;
    }

    public List<Kvar> getListaKvarova() {
        return listaKvarova;
    }

    public void setListaKvarova(List<Kvar> listaKvarova) {
        this.listaKvarova = listaKvarova;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.naziv);
        hash = 43 * hash + Objects.hashCode(this.model);
        hash = 43 * hash + this.serijskiBroj;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.snaga) ^ (Double.doubleToLongBits(this.snaga) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.datumProizvodnje);
        hash = 43 * hash + Objects.hashCode(this.datumPoslednjegKvara);
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
        final GotovProizvod other = (GotovProizvod) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.serijskiBroj != other.serijskiBroj) {
            return false;
        }
        if (Double.doubleToLongBits(this.snaga) != Double.doubleToLongBits(other.snaga)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.datumProizvodnje, other.datumProizvodnje)) {
            return false;
        }
        return Objects.equals(this.datumPoslednjegKvara, other.datumPoslednjegKvara);
    }

    @Override
    public String toString() {
        return naziv;
    }
   
}
