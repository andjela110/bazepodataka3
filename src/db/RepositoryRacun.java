/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Grad;
import domain.Partner;
import domain.Prijemnica;
import domain.Racun;
import domain.Region;
import domain.TipPrijemnice;
import domain.TipTrebovanja;
import domain.Trebovanje;
import domain.Valuta;
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
public class RepositoryRacun extends DbRepository{
    private Connection connection;

    public RepositoryRacun() {}


    public List<Racun> getAll() throws Exception {
       try {
            List<Racun> racuni=new ArrayList<>();
            String upit="SELECT r.RacunID as racunID, r.DatumPrometaRacuna as datum_prometa, r.DatumIzdavanjaRacuna as datum_izdavanja, "
                    + "r.TrebovanjeID as trebovanjeID, t.DatumTrebovanja as datumTrebovanja, t.TipTrebovanjaID as tipTrebovanja, "
                    + "tt.NazivTipaTrebovanja as nazivTT, r.ValutaID as valutaID, v.NazivValute as naziv_valute, r.PartnerID as partnerID,"
                    + " p.NazivPartnera as naziv_partnera, r.GradIzdavanja as grad_izdavanjaID, gi.NazivGrada as naziv_grada_izdavanja, "
                    + "r.RegionIzdavanja as region_izdavanjaID, ri.NazivRegiona as naziv_regiona_izdavanja, r.GradPrometa as grad_prometaID, "
                    + "gp.NazivGrada as naziv_grada_prometa, r.RegionPrometa as region_prometaID, rp.NazivRegiona as naziv_regiona_prometa,"
                    + " r.PrijemnicaID as prijemnicaID, pri.DatumOdPrijemnice as datumOdPrijemnice, pri.TipPrijemniceID as tipPrijemniceID, "
                    + "tp.NazivTipaPrijemnice as nazivTipaPrijemnice, r.UkupnaCenaRacuna as ukupna_cena_racuna FROM Racun r INNER JOIN Trebovanje t ON "
                    + "(t.TrebovanjeID=r.TrebovanjeID) INNER JOIN TipTrebovanja tt ON (tt.TipTrebovanjaID=t.TipTrebovanjaID) INNER JOIN Valuta v "
                    + "ON (r.ValutaID=v.ValutaID) INNER JOIN Partner_view p ON (p.PartnerID=r.PartnerID) INNER JOIN Grad gi ON "
                    + "(gi.PostanskiBroj=r.GradIzdavanja and r.RegionIzdavanja=gi.RegionID) INNER JOIN Region ri ON "
                    + "(ri.RegionID=r.RegionIzdavanja) INNER JOIN Grad gp ON (gp.PostanskiBroj=r.GradPrometa and "
                    + "r.RegionPrometa=gp.RegionID) INNER JOIN Region rp ON (rp.RegionID=r.RegionPrometa) INNER JOIN Prijemnica pri ON "
                    + "(pri.PrijemnicaID=r.PrijemnicaID) INNER JOIN TipPrijemnice tp ON (tp.TipPrijemniceID=pri.TipPrijemniceID) ORDER BY "
                    + "r.UkupnaCenaRacuna ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Racun r=new Racun();
                r.setId(rs.getInt("racunID"));
                r.setDatumPrometa(rs.getDate("datum_prometa"));
                r.setDatumIzdavanja(rs.getDate("datum_izdavanja"));
                Trebovanje t=new Trebovanje();
                t.setId(rs.getInt("trebovanjeID"));
                t.setDatumTrebovanja(rs.getDate("datumTrebovanja"));
                TipTrebovanja tt=new TipTrebovanja();
                tt.setId(rs.getInt("tipTrebovanja"));
                tt.setNaziv(rs.getString("nazivTT"));
                t.setTipTrebovanja(tt);
                r.setTrebovanje(t);
                Valuta v=new Valuta();
                v.setId(rs.getInt("valutaID"));
                v.setNaziv(rs.getString("naziv_valute"));
                r.setValuta(v);
                Partner p=new Partner();
                p.setId(rs.getInt("partnerID"));
                p.setNaziv(rs.getString("naziv_partnera"));
                r.setPartner(p);
                Grad gi=new Grad();
                gi.setPostanskiBroj(rs.getInt("grad_izdavanjaID"));
                gi.setNaziv(rs.getString("naziv_grada_izdavanja"));
                Region ri=new Region();
                ri.setId(rs.getInt("region_izdavanjaID"));
                ri.setNaziv(rs.getString("naziv_regiona_izdavanja"));
                gi.setRegion(ri);
                r.setRegionIzdavanja(ri);
                r.setGradIzdavanja(gi);
                Grad gp=new Grad();
                gp.setPostanskiBroj(rs.getInt("grad_prometaID"));
                gp.setNaziv(rs.getString("naziv_grada_prometa"));
                Region rp=new Region();
                rp.setId(rs.getInt("region_prometaID"));
                rp.setNaziv(rs.getString("naziv_regiona_prometa"));
                gp.setRegion(rp);
                r.setRegionPrometa(rp);
                r.setGradPrometa(gp);
                Prijemnica pr=new Prijemnica();
                pr.setId(rs.getInt("prijemnicaID"));
                pr.setDatumOd(rs.getDate("datumOdPrijemnice"));
                TipPrijemnice tp=new TipPrijemnice();
                tp.setId(rs.getInt("tipPrijemniceID"));
                tp.setNaziv(rs.getString("nazivTipaPrijemnice"));
                pr.setTipPrijemnice(tp);
                r.setPrijemnica(pr);
                r.setUkupnaCena(rs.getDouble("ukupna_cena_racuna"));
                
                racuni.add(r);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista računa!");
            return racuni;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste računa!\n"+ex);
            throw ex;
        }
    }
    
    public void add(Racun r) throws Exception {
        try {
            String upit="INSERT INTO Racun ( DatumPrometaRacuna, DatumIzdavanjaRacuna, TrebovanjeID, ValutaID, PartnerID, GradIzdavanja,"
                    + " RegionIzdavanja, GradPrometa, RegionPrometa, PrijemnicaID, UkupnaCenaRacuna) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setDate(1,r.getDatumPrometa());
            statement.setDate(2,r.getDatumIzdavanja());
            statement.setInt(3,r.getTrebovanje().getId());
            statement.setInt(4,r.getValuta().getId());
            statement.setInt(5,r.getPartner().getId());
            statement.setInt(6,r.getGradIzdavanja().getPostanskiBroj());
            statement.setInt(7,r.getRegionIzdavanja().getId());
            statement.setInt(8,r.getGradPrometa().getPostanskiBroj());
            statement.setInt(9,r.getRegionPrometa().getId());
            statement.setInt(10,r.getPrijemnica().getId());
            statement.setDouble(11,r.getUkupnaCena());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje računa!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje računa!" + ex.getMessage());
            rollback();
            throw ex;
        }
    }

    public void edit(Racun r) throws Exception {
         try {
            String sql = "UPDATE Racun SET DatumPrometaRacuna = ?, DatumIzdavanjaRacuna=?, TrebovanjeID=?, ValutaID=?, PartnerID=?, "
                    + "GradIzdavanja=?, RegionIzdavanja=?, GradPrometa=?, RegionPrometa=?, PrijemnicaID=?, UkupnaCenaRacuna=? WHERE RacunID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setDate(1, r.getDatumPrometa());
            ps.setDate(2, r.getDatumIzdavanja());
            ps.setInt(3, r.getTrebovanje().getId());
            ps.setInt(4, r.getValuta().getId());
            ps.setInt(5, r.getPartner().getId());
            ps.setInt(6, r.getGradIzdavanja().getPostanskiBroj());
            ps.setInt(7, r.getRegionIzdavanja().getId());
            ps.setInt(8, r.getGradPrometa().getPostanskiBroj());
            ps.setInt(9, r.getRegionPrometa().getId());
            ps.setInt(10, r.getPrijemnica().getId());
            ps.setDouble(11, r.getUkupnaCena());
            ps.setInt(12, r.getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjen račun!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjen račun!" + ex.getMessage());
            rollback();
            throw ex;
        }
        
    }
    
    public void delete(Racun r) throws Exception {
        try {
            String sql = "DELETE FROM Racun WHERE RacunID = " + r.getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje računa!\n"+ex);
            throw ex;
        }
    }
    
    
}
