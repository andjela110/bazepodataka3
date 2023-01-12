/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.OrganizacionaJedinica;
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
public class RepositoryOrganizacionaJedinica extends DbRepository{
    private Connection connection;

    public RepositoryOrganizacionaJedinica() {}


    public List<OrganizacionaJedinica> getAll() throws Exception {
       try {
            List<OrganizacionaJedinica> jedinice=new ArrayList<>();
            String upit="SELECT * FROM OrganizacionaJedinica ORDER BY NazivOrganizacioneJedinice ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                OrganizacionaJedinica oj=new OrganizacionaJedinica();
                oj.setId(rs.getInt("OrganizacionaJedinicaID"));
                oj.setNaziv(rs.getString("NazivOrganizacioneJedinice"));
                
                jedinice.add(oj);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista organizacionih jednica!");
            return jedinice;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste organizacionih jednica!\n"+ex);
            throw ex;
        }
    }
}
