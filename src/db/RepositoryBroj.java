/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Broj;
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
public class RepositoryBroj extends DbRepository{
    private Connection connection;

    public RepositoryBroj() {}


    public List<Broj> getAll() throws Exception {
       try {
            List<Broj> brojevi=new ArrayList<>();
            String upit="SELECT b.BrojID, b.UlicaID, u.NazivUlice, b.PostanskiBroj, b.RegionID, b.BrojVrednost FROM Broj b INNER JOIN Ulica u ON "
                    + "(b.UlicaID=u.UlicaID) ORDER BY BrojVrednost ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Broj b=new Broj();
                b.setId(rs.getInt("BrojID"));
                Ulica u=new Ulica();
                u.setId(rs.getInt("UlicaID"));
                u.setNaziv(rs.getString("NazivUlice"));
                Grad g=new Grad();
                g.setPostanskiBroj(rs.getInt("PostanskiBroj"));
                Region r=new Region();
                r.setId(rs.getInt("RegionID"));
                g.setRegion(r);
                u.setGrad(g);
                b.setUlica(u);
                b.setBrVrednost(rs.getString("BrojVrednost"));
                
                brojevi.add(b);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista brojeva!");
            return brojevi;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste brojeva!\n"+ex);
            throw ex;
        }
    }
}
