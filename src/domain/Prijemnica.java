/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Prijemnica {
    private int id;
    private Date datumOd;
    private Date datumDospeca;
    private String status;
    private IzvestajServisera izvestajServisera;
    private NacinPlacanja nacinPlacanja;
    private OrganizacionaJedinica organizacionaJedinica;
    private TipPrijemnice tipPrijemnice;
    private Magacin magacin;
    private Partner partner;

    public Prijemnica(){}
    
    public Prijemnica(int id, Date datumOd, Date datumDospeca, String status, IzvestajServisera izvestajServisera, NacinPlacanja nacinPlacanja, OrganizacionaJedinica organizacionaJedinica, TipPrijemnice tipPrijemnice, Magacin magacin, Partner partner) {
        this.id = id;
        this.datumOd = datumOd;
        this.datumDospeca = datumDospeca;
        this.status = status;
        this.izvestajServisera = izvestajServisera;
        this.nacinPlacanja = nacinPlacanja;
        this.organizacionaJedinica = organizacionaJedinica;
        this.tipPrijemnice = tipPrijemnice;
        this.magacin = magacin;
        this.partner = partner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDospeca() {
        return datumDospeca;
    }

    public void setDatumDospeca(Date datumDospeca) {
        this.datumDospeca = datumDospeca;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IzvestajServisera getIzvestajServisera() {
        return izvestajServisera;
    }

    public void setIzvestajServisera(IzvestajServisera izvestajServisera) {
        this.izvestajServisera = izvestajServisera;
    }

    public NacinPlacanja getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public OrganizacionaJedinica getOrganizacionaJedinica() {
        return organizacionaJedinica;
    }

    public void setOrganizacionaJedinica(OrganizacionaJedinica organizacionaJedinica) {
        this.organizacionaJedinica = organizacionaJedinica;
    }

    public TipPrijemnice getTipPrijemnice() {
        return tipPrijemnice;
    }

    public void setTipPrijemnice(TipPrijemnice tipPrijemnice) {
        this.tipPrijemnice = tipPrijemnice;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.datumOd);
        hash = 73 * hash + Objects.hashCode(this.datumDospeca);
        hash = 73 * hash + Objects.hashCode(this.status);
        hash = 73 * hash + Objects.hashCode(this.izvestajServisera);
        hash = 73 * hash + Objects.hashCode(this.nacinPlacanja);
        hash = 73 * hash + Objects.hashCode(this.organizacionaJedinica);
        hash = 73 * hash + Objects.hashCode(this.tipPrijemnice);
        hash = 73 * hash + Objects.hashCode(this.magacin);
        hash = 73 * hash + Objects.hashCode(this.partner);
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
        final Prijemnica other = (Prijemnica) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.datumOd, other.datumOd)) {
            return false;
        }
        if (!Objects.equals(this.datumDospeca, other.datumDospeca)) {
            return false;
        }
        if (!Objects.equals(this.izvestajServisera, other.izvestajServisera)) {
            return false;
        }
        if (!Objects.equals(this.nacinPlacanja, other.nacinPlacanja)) {
            return false;
        }
        if (!Objects.equals(this.organizacionaJedinica, other.organizacionaJedinica)) {
            return false;
        }
        if (!Objects.equals(this.tipPrijemnice, other.tipPrijemnice)) {
            return false;
        }
        if (!Objects.equals(this.magacin, other.magacin)) {
            return false;
        }
        return Objects.equals(this.partner, other.partner);
    }

    @Override
    public String toString() {
        return datumOd + ", " + tipPrijemnice;
    }
    
    
}
