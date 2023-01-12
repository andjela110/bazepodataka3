/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Grad;
import domain.Region;
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
public class RepositoryGrad extends DbRepository{
    private Connection connection;

    public RepositoryGrad() {}


    public List<Grad> getAll() throws Exception {
       try {
            List<Grad> gradovi=new ArrayList<>();
            String upit="SELECT * FROM Grad ORDER BY NazivGrada ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Grad g=new Grad();
                g.setPostanskiBroj(rs.getInt("PostanskiBroj"));
                Region r=new Region();
                r.setId(rs.getInt("RegionID"));
                g.setRegion(r);
                g.setNaziv(rs.getString("NazivGrada"));
                
                gradovi.add(g);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista gradova!");
            return gradovi;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste gradova!\n"+ex);
            throw ex;
        }
    }
}
