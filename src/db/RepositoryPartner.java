/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Banka;
import domain.Broj;
import domain.Delatnost;
import domain.Grad;
import domain.Partner;
import domain.Region;
import domain.Ulica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class RepositoryPartner extends DbRepository {
    
    private Connection connection;

    public RepositoryPartner() {}

    
    public List<Partner> getAll() throws SQLException, Exception {
        try {
            List<Partner> partneri=new ArrayList<>();
            
            String upit = "SELECT p.PartnerID as partnerID, p.NazivPartnera as naziv_partnera, p.BrojTelefonaPartnera as broj_telefona, "
                    + "p.PibPartnera as pib_partnera, p.MaticniBrojPartnera as maticni_broj, p.TekuciRacunPartnera as tekuci_racun, "
                    + "p.DelatnostID as delatnostID, p.nazivDelatnosti as naziv_delatnosti, b.BrojID as brojID, b.BrojVrednost as broj_kuce, "
                    + "u.UlicaID as ulicaID, u.NazivUlice as naziv_ulice, g.PostanskiBroj as postanski_broj, g.NazivGrada as naziv_grada, "
                    + "r.RegionID as regionID, r.NazivRegiona as naziv_regiona, ba.BankaID as bankaID, ba.NazivBanke as naziv_banke from "
                    + "Partner_view p INNER JOIN Delatnost d ON (d.DelatnostID = p.DelatnostID) INNER JOIN Broj b "
                    + "ON (b.BrojID = p.BrojID AND b.UlicaID=p.UlicaID AND b.PostanskiBroj=p.PostanskiBroj AND b.RegionID=p.RegionID) INNER JOIN Ulica u "
                    + "ON (u.UlicaID = p.UlicaID AND u.PostanskiBroj = p.PostanskiBroj AND p.RegionID = u.RegionID) INNER JOIN Grad g "
                    + "ON (g.PostanskiBroj = p.PostanskiBroj AND p.RegionID = g.RegionID) INNER JOIN Region r ON (r.RegionID = p.RegionID) "
                    + "INNER JOIN Banka ba ON (ba.BankaID = p.BankaID) ORDER BY p.NazivPartnera ASC";
            System.out.println(upit);
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Partner p = new Partner();
                p.setId(rs.getInt("partnerID"));
                p.setNaziv(rs.getString("naziv_partnera"));
                p.setBrojTelefona(rs.getString("broj_telefona"));
                p.setPib(rs.getString("pib_partnera"));
                p.setMaticniBroj(rs.getString("maticni_broj"));
                p.setTekuciRacun(rs.getString("tekuci_racun"));
                Delatnost d = new Delatnost();
                d.setId(rs.getInt("delatnostID"));
                d.setNaziv(rs.getString("naziv_delatnosti"));
                
                Region r = new Region();
                r.setId(rs.getInt("regionID"));
                r.setNaziv(rs.getString("naziv_regiona"));
                
                Grad g=new Grad();
                g.setPostanskiBroj(rs.getInt("postanski_broj"));
                g.setNaziv(rs.getString("naziv_grada"));
                g.setRegion(r);
                
                Ulica u = new Ulica();
                u.setId(rs.getInt("ulicaID"));
                u.setNaziv(rs.getString("naziv_ulice"));
                u.setRegion(r);
                u.setGrad(g);
                
                Broj br = new Broj();
                br.setId(rs.getInt("brojID"));
                br.setBrVrednost(rs.getString("broj_kuce"));
                br.setRegion(r);
                br.setGrad(g);
                br.setUlica(u);
                
                p.setRegion(r);
                p.setGrad(g);
                p.setUlica(u);
                p.setBroj(br);
                
                Banka ba=new Banka();
                ba.setId(rs.getInt("bankaID"));
                ba.setNaziv(rs.getString("naziv_banke"));
                p.setNazivDelatnosti(rs.getString("naziv_delatnosti"));
                p.setDelatnost(d);
                p.setBanka(ba);
                
                
                partneri.add(p);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista partnera!");
            return partneri;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste partnera!\n"+ex);
            throw ex;
        }
    }

    public void add(Partner p) throws Exception {
       try {
            String upit="INSERT INTO PARTNER_VIEW (NazivPartnera, BrojTelefonaPartnera, PIBPartnera, MaticniBrojPartnera, TekuciRacunPartnera, "
                    + " BrojID, UlicaID, PostanskiBroj, RegionID, DelatnostID, NazivDelatnosti, BankaID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
            
            statement.setString(1,p.getNaziv());
            statement.setString(2,p.getBrojTelefona());
            statement.setString(3, p.getPib());
            statement.setString(4,p.getMaticniBroj());
            statement.setString(5,p.getTekuciRacun());
            statement.setInt(6,p.getBroj().getId());
            statement.setInt(7, p.getUlica().getId());
            statement.setInt(8, p.getGrad().getPostanskiBroj());
            statement.setInt(9, p.getRegion().getId());
            statement.setInt(10, p.getDelatnost().getId());
            statement.setString(11, p.getNazivDelatnosti());
            statement.setInt(12, p.getBanka().getId());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje partnera!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje partnera!" + ex.getMessage());
            rollback();
            throw ex;
        }
    
    }

    public void edit(Partner p) throws Exception {
        try {
            String sql = "UPDATE Partner_view SET NazivPartnera = ?, BrojTelefonaPartnera = ?, PibPartnera=?, MaticniBrojPartnera=?, "
                    + "TekuciRacunPartnera=?, BrojID=?, UlicaID=?, PostanskiBroj=?, RegionID=?, DelatnostID=?, NazivDelatnosti=?, BankaID=? WHERE PartnerID = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setString(1, p.getNaziv());
            ps.setString(2, p.getBrojTelefona());
            ps.setString(3, p.getPib());
            ps.setString(4, p.getMaticniBroj());
            ps.setString(5, p.getTekuciRacun());
            ps.setInt(6, p.getBroj().getId());
            ps.setInt(7, p.getUlica().getId());
            ps.setInt(8, p.getGrad().getPostanskiBroj());
            ps.setInt(9, p.getRegion().getId());
            ps.setInt(10, p.getDelatnost().getId());
            ps.setString(11, p.getNazivDelatnosti());
            ps.setInt(12, p.getBanka().getId());
            ps.setInt(13, p.getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspesno izmenjen partner!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno izmenjen partner!" + ex.getMessage());
            rollback();
            throw ex;
        }
    }
    
    public void delete(Partner p) throws Exception {
         try {
            String sql = "DELETE FROM Partner_view WHERE PartnerID ="+p.getId();
             
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspesno brisanje partnera!\n"+ex);
            throw ex;
        }
    }
    
    
}
