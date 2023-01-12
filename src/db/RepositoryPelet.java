/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Pelet;
import domain.PeletPodaci;
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
public class RepositoryPelet extends DbRepository{
    
    private Connection connection;

    public RepositoryPelet() {}

    
    public List<Pelet> getAll() throws Exception {
       try {
            List<Pelet> peleti=new ArrayList<>();
            String upit="SELECT * FROM Pelet";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            while(rs.next()){
                Pelet p = new Pelet();
                p.setId(rs.getInt("PeletID"));
                PeletPodaci pp = (PeletPodaci) rs.getObject("Podaci");
                p.setPeletPodaci(pp);
                peleti.add(p);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista peleta!");
            return peleti;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste peleta!\n"+ex);
            throw ex;
        }
    }
    
    public void add(Pelet p) throws Exception {
        try {
            
            String upit="INSERT INTO Pelet ( Podaci) VALUES (?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setObject(1,p.getPeletPodaci());
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje peleta!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje peleta!");
            rollback();
            throw ex;
        }
    }

    public void edit(Pelet p) throws Exception {
         try {
            String sql = "UPDATE Pelet SET Podaci = ? WHERE PeletID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setObject(1, p.getPeletPodaci());
            ps.setInt(2,p.getId());
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjen pelet!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjen pelet!");
            rollback();
            throw ex;
        }
    }
    
    public void delete(Pelet p) throws Exception {
        try {
            String sql = "DELETE FROM Pelet WHERE PeletID = " + p.getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje peleta!\n"+ex);
            throw ex;
        }
    }
    
    

}
