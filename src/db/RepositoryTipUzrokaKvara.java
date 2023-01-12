/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.TipUzrokaKvara;
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
public class RepositoryTipUzrokaKvara extends DbRepository{
    private Connection connection;

    public RepositoryTipUzrokaKvara() {}


    public List<TipUzrokaKvara> getAll() throws Exception {
       try {
            List<TipUzrokaKvara> tipovi=new ArrayList<>();
            String upit="SELECT * FROM TipUzrokaKvara ORDER BY NazivTipaUzrokaKvara ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                TipUzrokaKvara tuk = new TipUzrokaKvara();
                tuk.setId(rs.getInt("TipUzrokaKvaraID"));
                tuk.setNaziv(rs.getString("NazivTipaUzrokaKvara"));
                
                tipovi.add(tuk);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista tipova uzroka kvara!");
            return tipovi;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste tipova uzroka kvara!\n"+ex);
            throw ex;
        }
    }
}
