/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.TipKvara;
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
public class RepositoryTipKvara  extends DbRepository{
    private Connection connection;

    public RepositoryTipKvara() {}


    public List<TipKvara> getAll() throws Exception {
       try {
            List<TipKvara> tipovi=new ArrayList<>();
            String upit="SELECT * FROM TipKvara ORDER BY NazivTipaKvara ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                TipKvara tk=new TipKvara();
                tk.setId(rs.getInt("TipKvaraID"));
                tk.setNaziv(rs.getString("NazivTipaKvara"));
                
                tipovi.add(tk);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista tipova kvara!");
            return tipovi;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste tipova kvara!\n"+ex);
            throw ex;
        }
    }
}
