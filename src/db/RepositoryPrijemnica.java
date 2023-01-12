/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.IzvestajServisera;
import domain.Magacin;
import domain.NacinPlacanja;
import domain.OrganizacionaJedinica;
import domain.Partner;
import domain.Prijemnica;
import domain.TipPrijemnice;
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
public class RepositoryPrijemnica extends DbRepository{
    private Connection connection;

    public RepositoryPrijemnica() {}
    
    public List<Prijemnica> getAll() throws Exception {
        try {
            List<Prijemnica> prijemnice =new ArrayList<>();
            String upit = "SELECT p.PrijemnicaID as prijemnicaID, p.DatumOdPrijemnice as datum_od, p.DatumDospecaPrijemnice as datum_dospeca, "
                    + "p.StatusPrijemnice as status, p.IzvestajServiseraID as izvestajServiseraID, i.OpisIzvestaja as opis, p.NacinPlacanjaID as nacin_placanja, "
                    + "np.NazivNacinaPlacanja as naziv_nacina_placanja, p.OrganizacionaJedinicaID as organizacionaJedinicaID, "
                    + "oj.NazivOrganizacioneJedinice as naziv_OJ, p.TipPrijemniceID as tipPrijemniceID, tp.NazivTipaPrijemnice as "
                    + "naziv_tipa_prijemnice, p.MagacinID as magacinID, m.NazivMagacina as naziv_magacina, p.PartnerID as partnerID, "
                    + "par.NazivPartnera as naziv_partnera FROM Prijemnica p INNER JOIN IzvestajServisera  i ON (i.IzvestajServiseraID=p.IzvestajServiseraID) INNER JOIN NacinPlacanja np ON (p.NacinPlacanjaID=np.NacinPlacanjaID)"
                    + " INNER JOIN OrganizacionaJedinica oj ON (oj.OrganizacionaJedinicaID=p.OrganizacionaJedinicaID) INNER JOIN "
                    + "TipPrijemnice tp ON (tp.TipPrijemniceID=p.TipPrijemniceID) INNER JOIN Magacin m ON (m.MagacinID=p.MagacinID) INNER JOIN"
                    + " Partner_view par ON (par.PartnerID=p.PartnerID) ORDER BY p.DatumOdPrijemnice ASC";
           
            System.out.println(upit);
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Prijemnica p=new Prijemnica();
                p.setId(rs.getInt("prijemnicaID"));
                p.setDatumOd(rs.getDate("datum_od"));
                p.setDatumDospeca(rs.getDate("datum_dospeca"));
                p.setStatus(rs.getString("status"));
                IzvestajServisera is=new IzvestajServisera();
                is.setId(rs.getInt("izvestajserviseraID"));
                is.setOpis(rs.getString("opis"));
                p.setIzvestajServisera(is);
                NacinPlacanja np=new NacinPlacanja();
                np.setId(rs.getInt("nacin_placanja"));
                np.setNaziv(rs.getString("naziv_nacina_placanja"));
                p.setNacinPlacanja(np);
                OrganizacionaJedinica oj = new OrganizacionaJedinica();
                oj.setId(rs.getInt("organizacionaJedinicaID"));
                oj.setNaziv(rs.getString("naziv_OJ"));
                p.setOrganizacionaJedinica(oj);
                TipPrijemnice tp=new TipPrijemnice();
                tp.setId(rs.getInt("tipPrijemniceID"));
                tp.setNaziv(rs.getString("naziv_tipa_prijemnice"));
                p.setTipPrijemnice(tp);
                Magacin m=new Magacin();
                m.setId(rs.getInt("magacinID"));
                m.setNaziv(rs.getString("naziv_magacina"));
                p.setMagacin(m);
                Partner par=new Partner();
                par.setId(rs.getInt("partnerId"));
                par.setNaziv(rs.getString("naziv_partnera"));
                p.setPartner(par);
                
                prijemnice.add(p);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista prijemnica!");
            return prijemnice;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste prijemnica!\n"+ex);
            throw ex;
        }
    }
     
    public void add(Prijemnica p) throws Exception {
        try {
            String upit="INSERT INTO Prijemnica (DatumOdPrijemnice, DatumDospecaPrijemnice, StatusPrijemnice, IzvestajServiseraID,"
                    + " NacinPlacanjaID, OrganizacionaJedinicaID, TipPrijemniceID, MagacinID, PartnerID) VALUES (?,?,?,?,?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
            
            statement.setDate(1, p.getDatumOd());
            statement.setDate(2,p.getDatumDospeca());
            statement.setString(3,p.getStatus());
            statement.setInt(4,p.getIzvestajServisera().getId());
            statement.setInt(5,p.getNacinPlacanja().getId());
            statement.setInt(6,p.getOrganizacionaJedinica().getId());
            statement.setInt(7,p.getTipPrijemnice().getId());
            statement.setInt(8,p.getMagacin().getId());
            statement.setInt(9,p.getPartner().getId());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje prijemnice!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje prijemnice!");
            rollback();
            throw ex;
        }
    }
    public void edit(Prijemnica p) throws Exception {
        try {
            
            String sql = "UPDATE Prijemnica SET DatumOdPrijemnice = ?, DatumDospecaPrijemnice=?, StatusPrijemnice=?, IzvestajServiseraID=?, "
                    + "NacinPlacanjaID=?, OrganizacionaJedinicaID=?, TipPrijemniceID=?, MagacinID=?, PartnerID=? WHERE PrijemnicaID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setDate(1, p.getDatumOd());
            ps.setDate(2, p.getDatumDospeca());
            ps.setString(3, p.getStatus());
            ps.setInt(4, p.getIzvestajServisera().getId());
            ps.setInt(5, p.getNacinPlacanja().getId());
            ps.setInt(6, p.getOrganizacionaJedinica().getId());
            ps.setInt(7, p.getTipPrijemnice().getId());
            ps.setInt(8, p.getMagacin().getId());
            ps.setInt(9, p.getPartner().getId());
            ps.setInt(10, p.getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjena prijemnica!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjena prijemnica!");
            rollback();
            throw ex;
        }
    }

    public void delete(Prijemnica p) throws Exception {
        try {
            String sql = "DELETE FROM Prijemnica WHERE PrijemnicaID ="+p.getId();
             
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje prijemnice!\n"+ex);
            throw ex;
        }
    }
    
    
    
}
