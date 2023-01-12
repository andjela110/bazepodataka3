/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.Broj;
import domain.Grad;
import domain.Magacin;
import domain.OrganizacionaJedinica;
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
public class RepositoryMagacin  extends DbRepository{
    private Connection connection;

    public RepositoryMagacin() {}


    public List<Magacin> getAll() throws Exception {
       try {
            List<Magacin> magacini=new ArrayList<>();
            String upit="SELECT * FROM Magacin ORDER BY NazivMagacina ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Magacin m=new Magacin();
                m.setId(rs.getInt("MagacinID"));
                m.setNaziv(rs.getString("NazivMagacina"));
                m.setVelicinaZaliha(rs.getString("VelicinaZalihaMagacina"));
                m.setVelicina(rs.getString("VelicinaMagacina"));
                Broj br=new Broj();
                br.setId(rs.getInt("BrojID"));
                Ulica u = new Ulica();
                u.setId(rs.getInt("UlicaID"));
                Grad g=new Grad();
                g.setPostanskiBroj(rs.getInt("PostanskiBroj"));
                Region r = new Region();
                r.setId(rs.getInt("RegionID"));
                m.setRegion(r);
                g.setRegion(r);
                m.setRegion(r);
                u.setRegion(r);
                u.setGrad(g);
                m.setUlica(u);
                br.setRegion(r);
                br.setGrad(g);
                br.setUlica(u);
                m.setBroj(br);
                OrganizacionaJedinica oj=new OrganizacionaJedinica();
                oj.setId(rs.getInt("OrganizacionaJedinicaID"));
                m.setOrganizacionaJedinica(oj);
                
                magacini.add(m);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista magacina!");
            return magacini;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste magacina!\n"+ex);
            throw ex;
        }
    }
}
