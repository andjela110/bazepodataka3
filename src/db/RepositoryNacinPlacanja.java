/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.NacinPlacanja;
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
public class RepositoryNacinPlacanja extends DbRepository{
    private Connection connection;

    public RepositoryNacinPlacanja() {}


    public List<NacinPlacanja> getAll() throws Exception {
       try {
            List<NacinPlacanja> nacini=new ArrayList<>();
            String upit="SELECT * FROM NacinPlacanja ORDER BY NazivNacinaPlacanja ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                NacinPlacanja np=new NacinPlacanja();
                np.setId(rs.getInt("NacinPlacanjaID"));
                np.setNaziv(rs.getString("NazivNacinaPlacanja"));
                
                nacini.add(np);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista načina plaćanja!");
            return nacini;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste načina plaćanja!\n"+ex);
            throw ex;
        }
    }
}
