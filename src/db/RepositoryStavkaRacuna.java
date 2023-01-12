/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Materijal;
import domain.Racun;
import domain.StavkaRacuna;
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
public class RepositoryStavkaRacuna extends DbRepository{
    private Connection connection;

    public RepositoryStavkaRacuna() {}

 
    public List<StavkaRacuna> getAll() throws Exception {
       try {
            List<StavkaRacuna> stavkeRacuna=new ArrayList<>();
            String upit="SELECT sr.RbrStavkeRacuna as rbr, sr.RacunID as racunID, r.datumIzdavanjaRacuna as datumIzdavanja, r.UkupnaCenaRacuna as ukupnaCena,"
                    + " sr.KolicinaStavkeRacuna as kolicina, sr.PdvStavkeRacuna as pdv, sr.RabatStavkeRacuna as rabat, sr.MaterijalID as "
                    + "materijalID, m.NazivMaterijala as naziv_materijala FROM StavkaRacuna sr INNER JOIN Racun r ON (r.RacunID=sr.RacunID)"
                    + "INNER JOIN Materijal m ON (m.MaterijalID=sr.MaterijalID) ORDER BY sr.RacunID ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                StavkaRacuna sr=new StavkaRacuna();
                sr.setRbr(rs.getInt("rbr"));
                Racun rac=new Racun();
                rac.setId(rs.getInt("racunID"));
                rac.setDatumIzdavanja(rs.getDate("datumIzdavanja"));
                rac.setUkupnaCena(rs.getDouble("ukupnaCena"));
                sr.setRacun(rac);
                sr.setKolicina(rs.getInt("kolicina"));
                sr.setPdv(rs.getInt("pdv"));
                sr.setRabat(rs.getInt("rabat"));
                Materijal m=new Materijal();
                m.setId(rs.getInt("materijalID"));
                m.setNaziv(rs.getString("naziv_materijala"));
                sr.setMaterijal(m);
               
                stavkeRacuna.add(sr);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista stavki računa!");
            return stavkeRacuna;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste stavki računa!\n"+ex);
            throw ex;
        }
    }
   
    public void add(StavkaRacuna sr) throws Exception {
        try {
            String upit="INSERT INTO StavkaRacuna (RacunID, KolicinaStavkeRacuna, PdvStavkeRacuna, RabatStavkeRacuna, "
                    + "MaterijalID) VALUES (?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setInt(1,sr.getRacun().getId());
            statement.setInt(2,sr.getKolicina());
            statement.setInt(3,sr.getPdv());
            statement.setInt(4,sr.getRabat());
            statement.setInt(5,sr.getMaterijal().getId());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje stavke računa!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje stavke računa!");
            rollback();
            throw ex;
        }
    }
  
    public void edit(StavkaRacuna sr) throws Exception {
         try {
            String sql = "UPDATE StavkaRacuna SET KolicinaStavkeRacuna = ?, PdvStavkeRacuna=?, RabatStavkeRacuna=?, MaterijalID=? "
                    + "WHERE RbrStavkeRacuna = ? AND RacunID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setInt(1, sr.getKolicina());
            ps.setInt(2, sr.getPdv());
            ps.setInt(3, sr.getRabat());
            ps.setInt(4, sr.getMaterijal().getId());
            ps.setInt(5, sr.getRbr());
            ps.setInt(6, sr.getRacun().getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjena stavka računa!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjena stavka računa!");
            rollback();
            throw ex;
        }
        
    }
   
    public void delete(StavkaRacuna sr) throws Exception {
        try {
            String sql = "DELETE FROM StavkaRacuna WHERE RbrStavkeRacuna = " + sr.getRbr()+" AND RacunID="+sr.getRacun().getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje stavke računa!\n"+ex);
            throw ex;
        }
    }
    
    
}
