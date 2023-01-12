/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Banka;
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
public class RepositoryBanka  extends DbRepository{
    private Connection connection;

    public RepositoryBanka() {}


    public List<Banka> getAll() throws Exception {
       try {
            List<Banka> banke=new ArrayList<>();
            String upit="SELECT * FROM Banka ORDER BY NazivBanke ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Banka b=new Banka();
                b.setId(rs.getInt("BankaID"));
                b.setNaziv(rs.getString("NazivBanke"));
                
                banke.add(b);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista banaka!");
            return banke;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste banaka!\n"+ex);
            throw ex;
        }
    }
}
