/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.GotovProizvod;
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
public class RepositoryGotovProizvod extends DbRepository{
    private Connection connection;

    public RepositoryGotovProizvod() {}

    public List<GotovProizvod> getAll() throws Exception {
       try {
            List<GotovProizvod> gotoviProizvodi=new ArrayList<>();
            String upit="SELECT * FROM GotovProizvod order by DatumPoslednjegKvaraGotovogProizvoda asc";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                GotovProizvod gp=new GotovProizvod();
                gp.setId(rs.getInt("GotovProizvodID"));
                gp.setNaziv(rs.getString("NazivGotovogProizvoda"));
                gp.setModel(rs.getString("ModelGotovogProizvoda"));
                gp.setSerijskiBroj(rs.getInt("SerijskiBrojGotovogProizvoda"));
                gp.setSnaga(rs.getDouble("SnagaGotovogProizvoda"));
                gp.setDatumProizvodnje(rs.getDate("DatumProizvodnjeGotovogProizvoda"));
                gp.setDatumPoslednjegKvara(rs.getDate("DatumPoslednjegKvaraGotovogProizvoda"));
                
                gotoviProizvodi.add(gp);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista gotovih proizvoda!");
            return gotoviProizvodi;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste gotovih proizvoda!\n"+ex);
            throw ex;
        }
    }

    public void add(GotovProizvod gp) throws Exception {
        try {
            
            String upit="INSERT INTO GotovProizvod (NazivGotovogProizvoda, ModelGotovogProizvoda, SerijskiBrojGotovogProizvoda, SnagaGotovogProizvoda, DatumProizvodnjeGotovogProizvoda, DatumPoslednjegKvaraGotovogProizvoda) VALUES (?,?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setString(1, gp.getNaziv());
            statement.setString(2, gp.getModel());
            statement.setInt(3, gp.getSerijskiBroj());
            statement.setDouble(4, gp.getSnaga());
            statement.setDate(5, gp.getDatumProizvodnje());
            statement.setDate(6, gp.getDatumPoslednjegKvara());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje gotovog proizvoda!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje gotovog proizvoda!" + ex.getMessage());
            rollback();
            throw ex;
        }
    }
  
    public void edit(GotovProizvod gp) throws Exception {
       try {
            String sql = "UPDATE GotovProizvod SET NazivGotovogProizvoda = ?, ModelGotovogProizvoda=?, SerijskiBrojGotovogProizvoda=?, SnagaGotovogProizvoda=?, DatumProizvodnjeGotovogProizvoda=?, DatumPoslednjegKvaraGotovogProizvoda=? WHERE GotovProizvodID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, gp.getNaziv());
            ps.setString(2, gp.getModel());
            ps.setInt(3, gp.getSerijskiBroj());
            ps.setDouble(4, gp.getSnaga());
            ps.setDate(5, gp.getDatumProizvodnje());
            ps.setDate(6, gp.getDatumPoslednjegKvara());
            ps.setInt(7, gp.getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspesno izmenjen gotov proizvod!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno izmenjen gotov proizvod!" + ex.getMessage());
            rollback();
            throw ex;
        }
    }
    
    public void delete(GotovProizvod gp) throws Exception {
         try {
            String sql = "DELETE FROM GotovProizvod WHERE GotovProizvodID = " +gp.getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje gotovog proizvoda!\n"+ex);
            throw ex;
        }
    }
    
    
}
