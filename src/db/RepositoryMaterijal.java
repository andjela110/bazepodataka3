/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.JedinicaMere;
import domain.Materijal;
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
public class RepositoryMaterijal  extends DbRepository{
    private Connection connection;

    public RepositoryMaterijal() {}


    public List<Materijal> getAll() throws Exception {
       try {
            List<Materijal> materijali=new ArrayList<>();
            String upit="SELECT * FROM Materijal ORDER BY NazivMaterijala ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Materijal m=new Materijal();
                m.setId(rs.getInt("MaterijalID"));
                m.setNaziv(rs.getString("NazivMaterijala"));
                m.setCena(rs.getDouble("CenaMaterijala"));
                m.setBarkod(rs.getInt("BarkodMaterijala"));
                JedinicaMere jm=new JedinicaMere();
                jm.setId(rs.getInt("JedinicaMereID"));
                m.setJedinicaMere(jm);
                
                materijali.add(m);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista materijala!");
            return materijali;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste materijala!\n"+ex);
            throw ex;
        }
    }
}
