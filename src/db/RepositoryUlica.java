/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Grad;
import domain.Region;
import domain.Ulica;
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
public class RepositoryUlica  extends DbRepository{
    private Connection connection;

    public RepositoryUlica() {}


    public List<Ulica> getAll() throws Exception {
       try {
            List<Ulica> ulice=new ArrayList<>();
            String upit="SELECT * FROM Ulica ORDER BY NazivUlice ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Ulica u=new Ulica();
                u.setId(rs.getInt("UlicaID"));
                Grad g=new Grad();
                g.setPostanskiBroj(rs.getInt("PostanskiBroj"));
                Region r=new Region();
                r.setId(rs.getInt("RegionID"));
                g.setRegion(r);
                u.setGrad(g);
                u.setNaziv(rs.getString("NazivUlice"));
                
                ulice.add(u);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista ulica!");
            return ulice;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste ulica!\n"+ex);
            throw ex;
        }
    }
}
