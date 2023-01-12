/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.GotovProizvod;
import domain.Magacin;
import domain.Prijemnica;
import domain.TipPrijemnice;
import domain.TipTrebovanja;
import domain.Trebovanje;
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
public class RepositoryTrebovanje extends DbRepository{
    private Connection connection;

    public RepositoryTrebovanje() {}


    public List<Trebovanje> getAll() throws Exception {
       try {
            List<Trebovanje> trebovanja=new ArrayList<>();
            String upit="SELECT t.TrebovanjeID as trebovanjeID, t.DatumTrebovanja as datum_trebovanja, t.StatusTrebovanja as status, "
                    + "t.PrijemnicaID as prijemnicaID, pri.DatumOdPrijemnice as datumOdPrijemnice, pri.TipPrijemniceID as tipPrijemniceID, "
                    + "tp.NazivTipaPrijemnice as nazivTipaPrijemnice, t.TipTrebovanjaID as tip_trebovanja, tt.NazivTipaTrebovanja as "
                    + "naziv_tipa_trebovanja, t.GotovProizvodID as gotovProizvodID, gp.NazivGotovogProizvoda as naziv_gotovog_proizvoda, "
                    + "t.MagacinID as magacinID, m.NazivMagacina as naziv_magacina, t.MestoTroskaID as mesto_troska, mt.NazivMagacina as "
                    + "naziv_mesta_troska FROM Trebovanje t INNER JOIN Prijemnica pri ON (pri.PrijemnicaID=t.PrijemnicaID) INNER JOIN "
                    + "TipPrijemnice tp ON (tp.TipPrijemniceID=pri.TipPrijemniceID) INNER JOIN TipTrebovanja tt ON "
                    + "(tt.TipTrebovanjaID=t.TipTrebovanjaID) INNER JOIN GotovProizvod gp ON (gp.GotovProizvodID=t.GotovProizvodID) INNER JOIN "
                    + "Magacin m ON (t.MagacinID=m.MagacinID) INNER JOIN Magacin mt ON (mt.MagacinID=t.MestoTroskaID) ORDER BY DatumTrebovanja ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Trebovanje t=new Trebovanje();
                t.setId(rs.getInt("trebovanjeID"));
                t.setDatumTrebovanja(rs.getDate("datum_trebovanja"));
                t.setStatus(rs.getString("status"));
                Prijemnica p=new Prijemnica();
                p.setId(rs.getInt("prijemnicaID"));
                p.setDatumOd(rs.getDate("datumOdPrijemnice"));
                TipPrijemnice tp=new TipPrijemnice();
                tp.setId(rs.getInt("tipPrijemniceID"));
                tp.setNaziv(rs.getString("nazivTipaPrijemnice"));
                p.setTipPrijemnice(tp);
                t.setPrijemnica(p);
                TipTrebovanja tt=new TipTrebovanja();
                tt.setId(rs.getInt("tip_trebovanja"));
                tt.setNaziv(rs.getString("naziv_tipa_trebovanja"));
                t.setTipTrebovanja(tt);
                GotovProizvod gp=new GotovProizvod();
                gp.setId(rs.getInt("gotovProizvodID"));
                gp.setNaziv(rs.getString("naziv_gotovog_proizvoda"));
                t.setGotovProizvod(gp);
                Magacin m=new Magacin();
                m.setId(rs.getInt("magacinID"));
                m.setNaziv(rs.getString("naziv_magacina"));
                t.setMagacin(m);
                Magacin mt=new Magacin();
                mt.setId(rs.getInt("mesto_troska"));
                mt.setNaziv(rs.getString("naziv_mesta_troska"));
                t.setMestoTroska(mt);
                
                trebovanja.add(t);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista trebovanja!");
            return trebovanja;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste trebovanja!\n"+ex);
            throw ex;
        }
    }
    
    public void add(Trebovanje t) throws Exception {
        try {
            String upit="INSERT INTO Trebovanje ( DatumTrebovanja, StatusTrebovanja, PrijemnicaID, TipTrebovanjaID, GotovProizvodID,"
                    + "MagacinID, MestoTroskaID) VALUES (?,?,?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
 
            statement.setDate(1,t.getDatumTrebovanja());
            statement.setString(2,t.getStatus());
            statement.setInt(3,t.getPrijemnica().getId());
            statement.setInt(4,t.getTipTrebovanja().getId());
            statement.setInt(5,t.getGotovProizvod().getId());
            statement.setInt(6,t.getMagacin().getId());
            statement.setInt(7,t.getMestoTroska().getId());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje trebovanja!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje trebovanja!");
            rollback();
            throw ex;
        }
    }

    public void edit(Trebovanje t) throws Exception {
         try {
            String sql = "UPDATE Trebovanje SET DatumTrebovanja = ?, StatusTrebovanja=?, PrijemnicaID=?, TipTrebovanjaID=?, GotovProizvodID=?,"
                    + "MagacinID=?, MestoTroskaID=? WHERE TrebovanjeID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setDate(1, t.getDatumTrebovanja());
            ps.setString(2, t.getStatus());
            ps.setInt(3, t.getPrijemnica().getId());
            ps.setInt(4, t.getTipTrebovanja().getId());
            ps.setInt(5, t.getGotovProizvod().getId());
            ps.setInt(6, t.getMagacin().getId());
            ps.setInt(7, t.getMestoTroska().getId());
            ps.setInt(8, t.getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjeno trebovanje!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjeno trebovanje!");
            rollback();
            throw ex;
        }
        
    }
    
    public void delete(Trebovanje t) throws Exception {
        try {
            String sql = "DELETE FROM Trebovanje WHERE TrebovanjeID = " + t.getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje trebovanja!\n"+ex);
            throw ex;
        }
    }

    
}

