/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.TipTrebovanja;
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
public class RepositoryTipTrebovanja  extends DbRepository{
    private Connection connection;

    public RepositoryTipTrebovanja() {}


    public List<TipTrebovanja> getAll() throws Exception {
       try {
            List<TipTrebovanja> tipovi=new ArrayList<>();
            String upit="SELECT * FROM TipTrebovanja ORDER BY NazivTipaTrebovanja ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                TipTrebovanja t = new TipTrebovanja();
                t.setId(rs.getInt("TipTrebovanjaID"));
                t.setNaziv(rs.getString("NazivTipaTrebovanja"));
                
                tipovi.add(t);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista tipova trebovanja!");
            return tipovi;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste tipova trebovanja!\n"+ex);
            throw ex;
        }
    }
}
