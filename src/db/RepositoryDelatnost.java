/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Delatnost;
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
public class RepositoryDelatnost extends DbRepository{
    private Connection connection;

    public RepositoryDelatnost() {}


    public List<Delatnost> getAll() throws Exception {
       try {
            List<Delatnost> delatnosti=new ArrayList<>();
            String upit="SELECT * FROM Delatnost ORDER BY NazivDelatnosti ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Delatnost d=new Delatnost();
                d.setId(rs.getInt("DelatnostID"));
                d.setNaziv(rs.getString("NazivDelatnosti"));
              
                delatnosti.add(d);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista delatnosti!");
            return delatnosti;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste delatnosti!\n"+ex);
            throw ex;
        }
    }
    
    public void add(Delatnost d) throws Exception {
        try {
            
            String upit="INSERT INTO Delatnost (NazivDelatnosti) VALUES (?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setString(1,d.getNaziv());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje delatnosti!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje delatnosti!");
            rollback();
            throw ex;
        }
    }

    public void edit(Delatnost d) throws Exception {
         try {
            String sql = "UPDATE Delatnost SET NazivDelatnosti = ? WHERE DelatnostID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setString(1, d.getNaziv());
            ps.setInt(2, d.getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjena delatnost!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjena delatnost!");
            rollback();
            throw ex;
        }
        
    }
    
    public void delete(Delatnost d) throws Exception {
        try {
            String sql = "DELETE FROM Delatnost WHERE DelatnostID = " + d.getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje delatnosti!\n"+ex);
            throw ex;
        }
    }
    

}
