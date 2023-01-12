/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import domain.Broj;
import domain.Grad;
import domain.Kupac;
import domain.Region;
import domain.Ulica;
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
public class RepositoryKupac extends DbRepository {
    private Connection connection;

    public RepositoryKupac() {}

    public List<Kupac> getAll() throws Exception {
       try {
            List<Kupac> kupci=new ArrayList<>();
            String upit="SELECT k.KupacID as kupacID, k.ImePrezimeKupca as ime_prezime, k.BrojTelefonaKupca as broj_telefona, b.BrojID as brojID,"
                    + " b.BrojVrednost as broj_kuce, u.UlicaID as ulicaID, u.NazivUlice as naziv_ulice, g.PostanskiBroj as postanski_broj, "
                    + "g.NazivGrada as naziv_grada, r.RegionID as regionId, r.NazivRegiona as naziv_regiona FROM Kupac k INNER JOIN Broj b "
                    + "ON (b.BrojID = k.BrojID AND b.UlicaID=k.UlicaID AND b.PostanskiBroj=k.PostanskiBroj AND b.RegionID=k.RegionID) INNER JOIN"
                    + " Ulica u ON (u.UlicaID=k.UlicaID AND u.PostanskiBroj=k.PostanskiBroj AND u.RegionID=k.RegionID) INNER JOIN Grad g ON "
                    + "(g.PostanskiBroj=k.PostanskiBroj AND g.RegionID=k.RegionID) INNER JOIN Region r ON (r.RegionID=k.RegionID) "
                    + "order by ImePrezimeKupca asc";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Kupac k=new Kupac();
                k.setId(rs.getInt("kupacID"));
                k.setImePrezime(rs.getString("ime_prezime"));
                k.setBrojTelefona(rs.getString("broj_telefona"));
                
                Region r = new Region();
                r.setId(rs.getInt("regionID"));
                r.setNaziv(rs.getString("naziv_regiona"));
                
                Grad g=new Grad();
                g.setPostanskiBroj(rs.getInt("postanski_broj"));
                g.setNaziv(rs.getString("naziv_grada"));
                g.setRegion(r);
                
                Ulica u = new Ulica();
                u.setId(rs.getInt("ulicaID"));
                u.setNaziv(rs.getString("naziv_ulice"));
                u.setRegion(r);
                u.setGrad(g);
                
                Broj br = new Broj();
                br.setId(rs.getInt("brojID"));
                br.setBrVrednost(rs.getString("broj_kuce"));
                br.setRegion(r);
                br.setGrad(g);
                br.setUlica(u);
                
                k.setRegion(r);
                k.setGrad(g);
                k.setUlica(u);
                k.setBroj(br);
                
                kupci.add(k);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista kupaca!");
            return kupci;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste kupaca!\n"+ex);
            throw ex;
        }
    }

    public void add(Kupac k) throws Exception {
        try {
            
            String upit="INSERT INTO Kupac (ImePrezimeKupca, BrojTelefonaKupca, BrojID, UlicaID, PostanskiBroj, RegionID) VALUES (?,?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setString(1, k.getImePrezime());
            statement.setString(2, k.getBrojTelefona());
            statement.setInt(3, k.getBroj().getId());
            statement.setInt(4, k.getBroj().getId());
            statement.setInt(5, k.getUlica().getId());
            statement.setInt(6, k.getGrad().getPostanskiBroj());
            statement.setInt(7, k.getRegion().getId());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje kupca!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje kupca!");
            rollback();
            throw ex;
        }
    }

    
    public void edit(Kupac k) throws Exception {
       try {
            String sql = "UPDATE Kupac SET ImePrezimeKupca = ?, BrojTelefonaKupca=?, BrojID=?, UlicaID=?, PostanskiBroj=?, RegionID=? "
                    + "WHERE KupacID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, k.getImePrezime());
            ps.setString(2, k.getBrojTelefona());
            ps.setInt(3, k.getBroj().getId());
            ps.setInt(4, k.getUlica().getId());
            ps.setInt(5, k.getGrad().getPostanskiBroj());
            ps.setInt(6, k.getRegion().getId());
            ps.setInt(7, k.getId());
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjen kupac!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjen kupac!");
            rollback();
            throw ex;
        }
    }

    
    public void delete(Kupac k) throws Exception {
         try {
            String sql = "DELETE FROM Kupac WHERE KupacID = " + k.getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje kupca!\n"+ex);
            throw ex;
        }
    }
    
}
