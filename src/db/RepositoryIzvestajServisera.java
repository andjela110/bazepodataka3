/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.GotovProizvod;
import domain.IzvestajServisera;
import domain.Kupac;
import domain.NacinPlacanja;
import domain.Partner;
import domain.TerenskiRadniNalog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class RepositoryIzvestajServisera extends DbRepository{
    private Connection connection;

    public RepositoryIzvestajServisera() {}


    public List<IzvestajServisera> getAll() throws Exception {
       try {
            List<IzvestajServisera> izvestaji=new ArrayList<>();
            String upit="SELECT * FROM IzvestajServisera";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                IzvestajServisera is=new IzvestajServisera();
                is.setId(rs.getInt("IzvestajServiseraID"));
                is.setNapomena(rs.getString("NapomenaIzvestaja"));
                is.setOpis(rs.getString("OpisIzvestaja"));
                TerenskiRadniNalog tr=new TerenskiRadniNalog();
                tr.setId(rs.getInt("TerenskiRadniNalogID"));
                is.setTerenskiRadniNalog(tr);
                NacinPlacanja np=new NacinPlacanja();
                np.setId(rs.getInt("NacinPlacanjaID"));
                is.setNacinPlacanja(np);
                Partner p=new Partner();
                p.setId(rs.getInt("PartnerID"));
                is.setPartner(p);
                Kupac k=new Kupac();
                k.setId(rs.getInt("KupacID"));
                is.setKupac(k);
                GotovProizvod gp=new GotovProizvod();
                gp.setId(rs.getInt("GotovProizvodID"));
                is.setGotovProizvod(gp);
                
                izvestaji.add(is);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista izveštaja servisera!");
            return izvestaji;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste izveštaja servisera!\n"+ex);
            throw ex;
        }
    }
}
