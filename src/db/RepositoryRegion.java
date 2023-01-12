/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Region;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 *
 * @author Korisnik
 */
public class RepositoryRegion extends DbRepository{
    private Connection connection;

    public RepositoryRegion() {}


    public List<Region> getAll() throws Exception {
       try {
            List<Region> regioni=new ArrayList<>();
            String upit="SELECT * FROM Region ORDER BY NazivRegiona ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Region r=new Region();
                r.setId(rs.getInt("RegionID"));
                r.setNaziv(rs.getString("NazivRegiona"));
                
                regioni.add(r);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista regiona!");
            return regioni;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste regiona!\n"+ex);
            throw ex;
        }
    }
}
