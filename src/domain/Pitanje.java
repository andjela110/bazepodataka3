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
public class Pitanje {
    private int id;
    private double instaliranaSnagaURadijatorima;
    private double radniPritisakUInstalaciji;
    private double grejnaPovrsina;
    private boolean izvrsenoStelovanjeParametraPeci;
    private boolean radKotlaPrePustanjaUPogon;
    private boolean ugradjenTKomad;
    private boolean originalneCevi;
    private double precnikDimnjaka;
    private double visinaDimnjaka;
    private boolean povezivanjeDimnihCeviPoUputstvu;
    private boolean ugradjenNepovratniVentil;
    private boolean ugradjenMesackiVentil;
    private boolean ugradjenSobniTermostat;
    private boolean korisnikUpoznatSaKoriscenjemPeci;
    private boolean kotaoPostavljenPremaTehnickomUputstvu;
    private Pelet pelet;

    public Pitanje(){}
    
    public Pitanje(int id, double instaliranaSnagaURadijatorima, double radniPritisakUInstalaciji, double grejnaPovrsina, boolean izvrsenoStelovanjeParametraPeci, boolean radKotlaPrePustanjaUPogon, boolean ugradjenTKomad, boolean originalneCevi, double precnikDimnjaka, double visinaDimnjaka, boolean povezivanjeDimnihCeviPoUputstvu, boolean ugradjenNepovratniVentil, boolean ugradjenMesackiVentil, boolean ugradjenSobniTermostat, boolean korisnikUpoznatSaKoriscenjemPeci, boolean kotaoPostavljenPremaTehnickomUputstvu, Pelet pelet) {
        this.id = id;
        this.instaliranaSnagaURadijatorima = instaliranaSnagaURadijatorima;
        this.radniPritisakUInstalaciji = radniPritisakUInstalaciji;
        this.grejnaPovrsina = grejnaPovrsina;
        this.izvrsenoStelovanjeParametraPeci = izvrsenoStelovanjeParametraPeci;
        this.radKotlaPrePustanjaUPogon = radKotlaPrePustanjaUPogon;
        this.ugradjenTKomad = ugradjenTKomad;
        this.originalneCevi = originalneCevi;
        this.precnikDimnjaka = precnikDimnjaka;
        this.visinaDimnjaka = visinaDimnjaka;
        this.povezivanjeDimnihCeviPoUputstvu = povezivanjeDimnihCeviPoUputstvu;
        this.ugradjenNepovratniVentil = ugradjenNepovratniVentil;
        this.ugradjenMesackiVentil = ugradjenMesackiVentil;
        this.ugradjenSobniTermostat = ugradjenSobniTermostat;
        this.korisnikUpoznatSaKoriscenjemPeci = korisnikUpoznatSaKoriscenjemPeci;
        this.kotaoPostavljenPremaTehnickomUputstvu = kotaoPostavljenPremaTehnickomUputstvu;
        this.pelet = pelet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInstaliranaSnagaURadijatorima() {
        return instaliranaSnagaURadijatorima;
    }

    public void setInstaliranaSnagaURadijatorima(double instaliranaSnagaURadijatorima) {
        this.instaliranaSnagaURadijatorima = instaliranaSnagaURadijatorima;
    }

    public double getRadniPritisakUInstalaciji() {
        return radniPritisakUInstalaciji;
    }

    public void setRadniPritisakUInstalaciji(double radniPritisakUInstalaciji) {
        this.radniPritisakUInstalaciji = radniPritisakUInstalaciji;
    }

    public double getGrejnaPovrsina() {
        return grejnaPovrsina;
    }

    public void setGrejnaPovrsina(double grejnaPovrsina) {
        this.grejnaPovrsina = grejnaPovrsina;
    }

    public boolean isIzvrsenoStelovanjeParametraPeci() {
        return izvrsenoStelovanjeParametraPeci;
    }

    public void setIzvrsenoStelovanjeParametraPeci(boolean izvrsenoStelovanjeParametraPeci) {
        this.izvrsenoStelovanjeParametraPeci = izvrsenoStelovanjeParametraPeci;
    }

    public boolean isRadKotlaPrePustanjaUPogon() {
        return radKotlaPrePustanjaUPogon;
    }

    public void setRadKotlaPrePustanjaUPogon(boolean radKotlaPrePustanjaUPogon) {
        this.radKotlaPrePustanjaUPogon = radKotlaPrePustanjaUPogon;
    }

    public boolean isUgradjenTKomad() {
        return ugradjenTKomad;
    }

    public void setUgradjenTKomad(boolean ugradjenTKomad) {
        this.ugradjenTKomad = ugradjenTKomad;
    }

    public boolean isOriginalneCevi() {
        return originalneCevi;
    }

    public void setOriginalneCevi(boolean originalneCevi) {
        this.originalneCevi = originalneCevi;
    }

    public double getPrecnikDimnjaka() {
        return precnikDimnjaka;
    }

    public void setPrecnikDimnjaka(double precnikDimnjaka) {
        this.precnikDimnjaka = precnikDimnjaka;
    }

    public double getVisinaDimnjaka() {
        return visinaDimnjaka;
    }

    public void setVisinaDimnjaka(double visinaDimnjaka) {
        this.visinaDimnjaka = visinaDimnjaka;
    }

    public boolean isPovezivanjeDimnihCeviPoUputstvu() {
        return povezivanjeDimnihCeviPoUputstvu;
    }

    public void setPovezivanjeDimnihCeviPoUputstvu(boolean povezivanjeDimnihCeviPoUputstvu) {
        this.povezivanjeDimnihCeviPoUputstvu = povezivanjeDimnihCeviPoUputstvu;
    }

    public boolean isUgradjenNepovratniVentil() {
        return ugradjenNepovratniVentil;
    }

    public void setUgradjenNepovratniVentil(boolean ugradjenNepovratniVentil) {
        this.ugradjenNepovratniVentil = ugradjenNepovratniVentil;
    }

    public boolean isUgradjenMesackiVentil() {
        return ugradjenMesackiVentil;
    }

    public void setUgradjenMesackiVentil(boolean ugradjenMesackiVentil) {
        this.ugradjenMesackiVentil = ugradjenMesackiVentil;
    }

    public boolean isUgradjenSobniTermostat() {
        return ugradjenSobniTermostat;
    }

    public void setUgradjenSobniTermostat(boolean ugradjenSobniTermostat) {
        this.ugradjenSobniTermostat = ugradjenSobniTermostat;
    }

    public boolean isKorisnikUpoznatSaKoriscenjemPeci() {
        return korisnikUpoznatSaKoriscenjemPeci;
    }

    public void setKorisnikUpoznatSaKoriscenjemPeci(boolean korisnikUpoznatSaKoriscenjemPeci) {
        this.korisnikUpoznatSaKoriscenjemPeci = korisnikUpoznatSaKoriscenjemPeci;
    }

    public boolean isKotaoPostavljenPremaTehnickomUputstvu() {
        return kotaoPostavljenPremaTehnickomUputstvu;
    }

    public void setKotaoPostavljenPremaTehnickomUputstvu(boolean kotaoPostavljenPremaTehnickomUputstvu) {
        this.kotaoPostavljenPremaTehnickomUputstvu = kotaoPostavljenPremaTehnickomUputstvu;
    }

    public Pelet getPelet() {
        return pelet;
    }

    public void setPelet(Pelet pelet) {
        this.pelet = pelet;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.instaliranaSnagaURadijatorima) ^ (Double.doubleToLongBits(this.instaliranaSnagaURadijatorima) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.radniPritisakUInstalaciji) ^ (Double.doubleToLongBits(this.radniPritisakUInstalaciji) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.grejnaPovrsina) ^ (Double.doubleToLongBits(this.grejnaPovrsina) >>> 32));
        hash = 67 * hash + (this.izvrsenoStelovanjeParametraPeci ? 1 : 0);
        hash = 67 * hash + (this.radKotlaPrePustanjaUPogon ? 1 : 0);
        hash = 67 * hash + (this.ugradjenTKomad ? 1 : 0);
        hash = 67 * hash + (this.originalneCevi ? 1 : 0);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.precnikDimnjaka) ^ (Double.doubleToLongBits(this.precnikDimnjaka) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.visinaDimnjaka) ^ (Double.doubleToLongBits(this.visinaDimnjaka) >>> 32));
        hash = 67 * hash + (this.povezivanjeDimnihCeviPoUputstvu ? 1 : 0);
        hash = 67 * hash + (this.ugradjenNepovratniVentil ? 1 : 0);
        hash = 67 * hash + (this.ugradjenMesackiVentil ? 1 : 0);
        hash = 67 * hash + (this.ugradjenSobniTermostat ? 1 : 0);
        hash = 67 * hash + (this.korisnikUpoznatSaKoriscenjemPeci ? 1 : 0);
        hash = 67 * hash + (this.kotaoPostavljenPremaTehnickomUputstvu ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.pelet);
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
        final Pitanje other = (Pitanje) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.instaliranaSnagaURadijatorima) != Double.doubleToLongBits(other.instaliranaSnagaURadijatorima)) {
            return false;
        }
        if (Double.doubleToLongBits(this.radniPritisakUInstalaciji) != Double.doubleToLongBits(other.radniPritisakUInstalaciji)) {
            return false;
        }
        if (Double.doubleToLongBits(this.grejnaPovrsina) != Double.doubleToLongBits(other.grejnaPovrsina)) {
            return false;
        }
        if (this.izvrsenoStelovanjeParametraPeci != other.izvrsenoStelovanjeParametraPeci) {
            return false;
        }
        if (this.radKotlaPrePustanjaUPogon != other.radKotlaPrePustanjaUPogon) {
            return false;
        }
        if (this.ugradjenTKomad != other.ugradjenTKomad) {
            return false;
        }
        if (this.originalneCevi != other.originalneCevi) {
            return false;
        }
        if (Double.doubleToLongBits(this.precnikDimnjaka) != Double.doubleToLongBits(other.precnikDimnjaka)) {
            return false;
        }
        if (Double.doubleToLongBits(this.visinaDimnjaka) != Double.doubleToLongBits(other.visinaDimnjaka)) {
            return false;
        }
        if (this.povezivanjeDimnihCeviPoUputstvu != other.povezivanjeDimnihCeviPoUputstvu) {
            return false;
        }
        if (this.ugradjenNepovratniVentil != other.ugradjenNepovratniVentil) {
            return false;
        }
        if (this.ugradjenMesackiVentil != other.ugradjenMesackiVentil) {
            return false;
        }
        if (this.ugradjenSobniTermostat != other.ugradjenSobniTermostat) {
            return false;
        }
        if (this.korisnikUpoznatSaKoriscenjemPeci != other.korisnikUpoznatSaKoriscenjemPeci) {
            return false;
        }
        if (this.kotaoPostavljenPremaTehnickomUputstvu != other.kotaoPostavljenPremaTehnickomUputstvu) {
            return false;
        }
        return Objects.equals(this.pelet, other.pelet);
    }

    @Override
    public String toString() {
        return "Pitanje{" + "id=" + id + ", instaliranaSnagaURadijatorima=" + instaliranaSnagaURadijatorima + ", radniPritisakUInstalaciji=" + radniPritisakUInstalaciji + ", grejnaPovrsina=" + grejnaPovrsina + ", izvrsenoStelovanjeParametraPeci=" + izvrsenoStelovanjeParametraPeci + ", radKotlaPrePustanjaUPogon=" + radKotlaPrePustanjaUPogon + ", ugradjenTKomad=" + ugradjenTKomad + ", originalneCevi=" + originalneCevi + ", precnikDimnjaka=" + precnikDimnjaka + ", visinaDimnjaka=" + visinaDimnjaka + ", povezivanjeDimnihCeviPoUputstvu=" + povezivanjeDimnihCeviPoUputstvu + ", ugradjenNepovratniVentil=" + ugradjenNepovratniVentil + ", ugradjenMesackiVentil=" + ugradjenMesackiVentil + ", ugradjenSobniTermostat=" + ugradjenSobniTermostat + ", korisnikUpoznatSaKoriscenjemPeci=" + korisnikUpoznatSaKoriscenjemPeci + ", kotaoPostavljenPremaTehnickomUputstvu=" + kotaoPostavljenPremaTehnickomUputstvu + ", pelet=" + pelet + '}';
    }
    
    
    
    
}
