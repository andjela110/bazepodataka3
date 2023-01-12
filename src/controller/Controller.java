/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.RepositoryDelatnost;
import db.RepositoryGotovProizvod;
import db.RepositoryKupac;
import db.RepositoryKupio;
import db.RepositoryKvar;
import db.RepositoryPartner;
import db.RepositoryPelet;
import db.RepositoryPrijemnica;
import db.RepositoryRacun;
import db.RepositoryStavkaRacuna;
import db.RepositoryTipUsluge;
import db.RepositoryTrebovanje;
import db.RepositoryRegion;
import db.RepositoryGrad;
import db.RepositoryUlica;
import db.RepositoryBroj;
import db.RepositoryBanka;
import db.RepositoryIzvestajServisera;
import db.RepositoryMagacin;
import db.RepositoryNacinPlacanja;
import db.RepositoryOrganizacionaJedinica;
import db.RepositoryTipPrijemnice;
import db.RepositoryTipKvara;
import db.RepositoryTipUzrokaKvara;
import db.RepositoryMaterijal;
import db.RepositoryValuta;
import db.RepositoryTipTrebovanja;
import domain.Banka;
import domain.Broj;
import domain.Delatnost;
import domain.GotovProizvod;
import domain.Grad;
import domain.IzvestajServisera;
import domain.Kupac;
import domain.Kupio;
import domain.Kvar;
import domain.Magacin;
import domain.Materijal;
import domain.NacinPlacanja;
import domain.OrganizacionaJedinica;
import domain.Partner;
import domain.Pelet;
import domain.Prijemnica;
import domain.Racun;
import domain.Region;
import domain.StavkaRacuna;
import domain.TipKvara;
import domain.TipPrijemnice;
import domain.TipTrebovanja;
import domain.TipUsluge;
import domain.TipUzrokaKvara;
import domain.Trebovanje;
import domain.Ulica;
import domain.Valuta;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public class Controller {
    private static Controller instance;
    private final RepositoryDelatnost storageDelatnost;
    private final RepositoryGotovProizvod storageGotovProizvod;
    private final RepositoryKupac storageKupac;
    private final RepositoryKupio storageKupio;
    private final RepositoryKvar storageKvar;
    private final RepositoryPartner storagePartner;
    private final RepositoryPelet storagePelet;
    private final RepositoryPrijemnica storagePrijemnica;
    private final RepositoryRacun storageRacun;
    private final RepositoryStavkaRacuna storageStavkaRacuna;
    private final RepositoryTipUsluge storageTipUsluge;
    private final RepositoryTrebovanje storageTrebovanje;
    private final RepositoryRegion storageRegion;
    private final RepositoryGrad storageGrad;
    private final RepositoryUlica storageUlica;
    private final RepositoryBroj storageBroj;
    private final RepositoryBanka storageBanka;
    private final RepositoryIzvestajServisera storageIzvestajServisera;
    private final RepositoryNacinPlacanja storageNacinPlacanja;
    private final RepositoryOrganizacionaJedinica storageOrganizacionaJedinica;
    private final RepositoryTipPrijemnice storageTipPrijemnice;
    private final RepositoryMagacin storageMagacin;
    private final RepositoryTipKvara storageTipKvara;
    private final RepositoryTipUzrokaKvara storageTipUzrokaKvara;
    private final RepositoryMaterijal storageMaterijal;
    private final RepositoryValuta storageValuta;
    private final RepositoryTipTrebovanja storageTipTrebovanja;

    public Controller() {
        this.storageDelatnost = new RepositoryDelatnost();
        this.storageGotovProizvod = new RepositoryGotovProizvod();
        this.storageKupac = new RepositoryKupac();
        this.storageKupio = new RepositoryKupio();
        this.storageKvar = new RepositoryKvar();
        this.storagePartner = new RepositoryPartner();
        this.storagePelet = new RepositoryPelet();
        this.storagePrijemnica = new RepositoryPrijemnica();
        this.storageRacun = new RepositoryRacun();
        this.storageStavkaRacuna = new RepositoryStavkaRacuna();
        this.storageTipUsluge = new RepositoryTipUsluge();
        this.storageTrebovanje = new RepositoryTrebovanje();
        this.storageRegion = new RepositoryRegion();
        this.storageGrad = new RepositoryGrad();
        this.storageUlica = new RepositoryUlica();
        this.storageBroj = new RepositoryBroj();
        this.storageBanka = new RepositoryBanka();
        this.storageIzvestajServisera = new RepositoryIzvestajServisera();
        this.storageNacinPlacanja = new RepositoryNacinPlacanja();
        this.storageOrganizacionaJedinica = new RepositoryOrganizacionaJedinica();
        this.storageTipPrijemnice = new RepositoryTipPrijemnice();
        this.storageMagacin = new RepositoryMagacin();
        this.storageTipKvara = new RepositoryTipKvara();
        this.storageTipUzrokaKvara = new RepositoryTipUzrokaKvara();
        this.storageMaterijal = new RepositoryMaterijal();
        this.storageValuta = new RepositoryValuta();
        this.storageTipTrebovanja = new RepositoryTipTrebovanja();
    }
    
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    //DELATNOST
    
    public List<Delatnost> getAllDelatnost() throws Exception {
        return storageDelatnost.getAll();
    }

    public void addDelatnost(Delatnost delatnost) throws Exception {
        storageDelatnost.add(delatnost);
    }

    public void editDelatnost(Delatnost delatnost) throws Exception {
        storageDelatnost.edit(delatnost);
    }
    
    public void deleteDelatnost(Delatnost delatnost) throws Exception {
        storageDelatnost.delete(delatnost);
    }
    
    //GOTOV PROIZVOD
    
    public List<GotovProizvod> getAllGotovProizvod() throws Exception {
       return storageGotovProizvod.getAll();
    }

    public void addGotovProizvod(GotovProizvod gotovProizvod) throws Exception {
        storageGotovProizvod.add(gotovProizvod);
    }

    public void editGotovProizvod(GotovProizvod gotovProizvod) throws Exception {
        storageGotovProizvod.edit(gotovProizvod);
    }
    
    public void deleteGotovProizvod(GotovProizvod gotovProizvod) throws Exception {
         storageGotovProizvod.delete(gotovProizvod);
    }
    
    //KUPAC
    
    public List<Kupac> getAllKupac() throws Exception{
         return storageKupac.getAll();
    }

    public void addKupac(Kupac kupac) throws Exception {
        storageKupac.add(kupac);
    }

    public void editKupac(Kupac kupac) throws Exception {
        storageKupac.edit(kupac);
    }
    
    public void deleteKupac(Kupac kupac) throws Exception{
        storageKupac.delete(kupac);
    }

    //KUPIO
    
    public List<Kupio> getAllKupio()throws Exception {
        return storageKupio.getAll();
    }

    public void addKupio(Kupio kupio) throws Exception {
        storageKupio.add(kupio);
    }

    public void editKupio(Kupio kupio) throws Exception {
        storageKupio.edit(kupio);
    }
    
    public void deleteKupio(Kupio kupio)throws Exception {
        storageKupio.delete(kupio);
    }
    
    //KVAR
    
    public List<Kvar> getAllKvar()throws Exception {
        return storageKvar.getAll();
    }

    public void addKvar(Kvar kvar) throws Exception {
        storageKvar.add(kvar);
    }

    public void editKvar(Kvar kvar) throws Exception {
        storageKvar.edit(kvar);
    }
    
    public void deleteKvar(Kvar kvar)throws Exception {
        storageKvar.delete(kvar);
    }
    
    //PARTNER
    
    public List<Partner> getAllPartner()throws Exception {
        return storagePartner.getAll();
    }

    public void addPartner(Partner partner) throws Exception {
        storagePartner.add(partner);
    }

    public void editPartner(Partner partner) throws Exception {
        storagePartner.edit(partner);
    }
    
    public void deletePartner(Partner partner)throws Exception {
        storagePartner.delete(partner);
    }
    
    //PELET
    
    public List<Pelet> getAllPelet()throws Exception {
        return storagePelet.getAll();
    }

    public void addPelet(Pelet pelet) throws Exception {
        storagePelet.add(pelet);
    }

    public void editPelet(Pelet pelet) throws Exception {
        storagePelet.edit(pelet);
    }
    
    public void deletePelet(Pelet pelet)throws Exception {
        storagePelet.delete(pelet);
    }
    
    //PRIJEMNICA 
    
    public List<Prijemnica> getAllPrijemnica()throws Exception {
        return storagePrijemnica.getAll();
    }

    public void addPrijemnica(Prijemnica prijemnica) throws Exception {
        storagePrijemnica.add(prijemnica);
    }

    public void editPrijemnica(Prijemnica prijemnica) throws Exception {
        storagePrijemnica.edit(prijemnica);
    }
    
    public void deletePrijemnica(Prijemnica prijemnica)throws Exception {
        storagePrijemnica.delete(prijemnica);
    }
    
    //RACUN 
    
    public List<Racun> getAllRacun()throws Exception {
        return storageRacun.getAll();
    }

    public void addRacun(Racun racun) throws Exception {
        storageRacun.add(racun);
    }

    public void editRacun(Racun racun) throws Exception {
        storageRacun.edit(racun);
    }
    
    public void deleteRacun(Racun racun)throws Exception {
        storageRacun.delete(racun);
    }
    
    //STAVKA RACUNA  
    
    public List<StavkaRacuna> getAllStavkaRacuna()throws Exception {
        return storageStavkaRacuna.getAll();
    }

    public void addStavkaRacuna(StavkaRacuna stavkaRacuna) throws Exception {
        storageStavkaRacuna.add(stavkaRacuna);
    }

    public void editStavkaRacuna(StavkaRacuna stavkaRacuna) throws Exception {
        storageStavkaRacuna.edit(stavkaRacuna);
    }
    
    public void deleteStavkaRacuna(StavkaRacuna stavkaRacuna)throws Exception {
        storageStavkaRacuna.delete(stavkaRacuna);
    }
    
    //TIP USLUGE   
    
    public List<TipUsluge> getAllTipUsluge()throws Exception {
        return storageTipUsluge.getAll();
    }

    public void addTipUsluge(TipUsluge tipUsluge) throws Exception {
        storageTipUsluge.add(tipUsluge);
    }

    public void editTipUsluge(TipUsluge tipUsluge) throws Exception {
        storageTipUsluge.edit(tipUsluge);
    }
    
    public void deleteTipUsluge(TipUsluge tipUsluge)throws Exception {
        storageTipUsluge.delete(tipUsluge);
    }
    
    //TREBOVANJE   
    
    public List<Trebovanje> getAllTrebovanje()throws Exception {
        return storageTrebovanje.getAll();
    }

    public void addTrebovanje(Trebovanje trebovanje) throws Exception {
        storageTrebovanje.add(trebovanje);
    }

    public void editTrebovanje(Trebovanje trebovanje) throws Exception {
        storageTrebovanje.edit(trebovanje);
    }
    
    public void deleteTrebovanje(Trebovanje trebovanje)throws Exception {
        storageTrebovanje.delete(trebovanje);
    }
    
    //REGION
    
    public List<Region> getAllRegion()throws Exception {
        return storageRegion.getAll();
    }
    
    //GRAD
    
    public List<Grad> getAllGrad()throws Exception {
        return storageGrad.getAll();
    }
    
    //ULICA
    
    public List<Ulica> getAllUlica()throws Exception {
        return storageUlica.getAll();
    }
    
    //BROJ
    
    public List<Broj> getAllBroj()throws Exception {
        return storageBroj.getAll();
    }
    
    //BANKA
    
    public List<Banka> getAllBanka()throws Exception {
        return storageBanka.getAll();
    }
    
    //IZVESTAJ SERVISERA
    
    public List<IzvestajServisera> getAllIzvestajServisera()throws Exception {
        return storageIzvestajServisera.getAll();
    }
    
    //NACIN PLACANJA
    
    public List<NacinPlacanja> getAllNacinPlacanja()throws Exception {
        return storageNacinPlacanja.getAll();
    }
    
    //ORGANIZACIONA JEDINICA
    
    public List<OrganizacionaJedinica> getAllOrganizacionaJedinica()throws Exception {
        return storageOrganizacionaJedinica.getAll();
    }
    
    //TIP PRIJEMNICE
    
    public List<TipPrijemnice> getAllTipPrijemnice()throws Exception {
        return storageTipPrijemnice.getAll();
    }
    
    //MAGACIN
    
    public List<Magacin> getAllMagacin()throws Exception {
        return storageMagacin.getAll();
    }
    
    //TIP KVARA
    
    public List<TipKvara> getAllTipKvara()throws Exception {
        return storageTipKvara.getAll();
    }
    
    //TIP UZROKA KVARA
    
    public List<TipUzrokaKvara> getAllTipUzrokaKvara()throws Exception {
        return storageTipUzrokaKvara.getAll();
    }
    
    //MATERIJAL
    
    public List<Materijal> getAllMaterijal()throws Exception {
        return storageMaterijal.getAll();
    }
    
    //VALUTA
    
    public List<Valuta> getAllValuta()throws Exception {
        return storageValuta.getAll();
    }
    
    //TIP TREBOVANJA
    
    public List<TipTrebovanja> getAllTipTrebovanja()throws Exception {
        return storageTipTrebovanja.getAll();
    }
    
}
