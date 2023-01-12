/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.NazivVrednost;
import domain.TipUsluge;
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
public class RepositoryTipUsluge extends DbRepository{
    private Connection connection;

    public RepositoryTipUsluge() {}


    public List<TipUsluge> getAll() throws Exception {
       try {
            List<TipUsluge> tipoviUsluge=new ArrayList<>();
            String upit="SELECT * FROM TipUsluge order by CenaTipaUsluge asc";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                TipUsluge t = new TipUsluge();
                t.setId(rs.getInt("TipUslugeID"));
                NazivVrednost naz = (NazivVrednost) rs.getObject("NazivTipaUsluge");
                t.setNaziv(naz);
                t.setCena(rs.getDouble("CenaTipaUsluge"));
               
                tipoviUsluge.add(t);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista tipova usluga!");
            return tipoviUsluge;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste tipova usluga!\n"+ex);
            throw ex;
        }
    }
    
    public void add(TipUsluge t) throws Exception {
        try {
            String upit="INSERT INTO TipUsluge (NazivTipaUsluge, CenaTipaUsluge) VALUES (?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setObject(1,t.getNaziv());
            statement.setDouble(2,t.getCena());
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje tipa usluge!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje tipa usluge!");
            rollback();
            throw ex;
        }
    }

    public void edit(TipUsluge t) throws Exception {
         try {
            String sql = "UPDATE TipUsluge SET NazivTipaUsluge = ?, CenaTipaUsluge=? WHERE TipUslugeID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setObject(1, t.getNaziv());
            ps.setDouble(2, t.getCena());
            ps.setInt(3, t.getId());
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjen tip usluge!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjen tip usluge!");
            rollback();
            throw ex;
        }
        
    }
    
    public void delete(TipUsluge t) throws Exception {
        try {
            String sql = "DELETE FROM TipUsluge WHERE TipUslugeID = " + t.getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje tipa usluge!\n"+ex);
            throw ex;
        }
    }
    
    

}
