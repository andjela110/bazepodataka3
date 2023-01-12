/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.GotovProizvod;
import domain.Kupac;
import domain.Kupio;
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
public class RepositoryKupio extends DbRepository{
    private Connection connection;

    public RepositoryKupio() {}
    
    public List<Kupio> getAll() throws Exception {
        try {
            List<Kupio> listaKupio =new ArrayList<>();
            String upit="SELECT k.DatumKupovineGotovogProizvoda as datum_kupovine, k.GotovProizvodID as gotovProizvodID, gp.NazivGotovogProizvoda"
                    + " as naziv_GP, k.KupacID as kupacID, k.Garancija as garancija, k.ImePrezimeKupca as ime_prezime_kupca FROM Kupio k "
                    + "INNER JOIN GotovProizvod gp ON (gp.GotovProizvodID=k.GotovProizvodID) order by k.ImePrezimeKupca asc";
           
            System.out.println(upit);
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
                Kupio k=new Kupio();
                k.setDatumKupovineGP(rs.getDate("datum_kupovine"));
                GotovProizvod gp=new GotovProizvod();
                gp.setId(rs.getInt("gotovProizvodID"));
                gp.setNaziv(rs.getString("naziv_GP"));
                k.setGotovProizvod(gp);
                Kupac kupac=new Kupac();
                kupac.setId(rs.getInt("kupacID"));
                kupac.setImePrezime(rs.getString("ime_prezime_kupca"));
                k.setKupac(kupac);
                k.setImePrezimeKupca(rs.getString("ime_prezime_kupca"));
                k.setGarancija(rs.getBoolean("garancija"));
                
                listaKupio.add(k);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista kupljenih gotovih proizvoda od strane kupca!");
            return listaKupio;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste kupljenih gotovih proizvoda od strane kupca!\n"+ex);
            throw ex;
        }
    }
     
    public void add(Kupio k) throws Exception {
        try {
            String upit="INSERT INTO Kupio (DatumKupovineGotovogProizvoda, GotovProizvodID, KupacID, Garancija, ImePrezimeKupca) VALUES (?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
            
            statement.setDate(1, k.getDatumKupovineGP());
            statement.setInt(2, k.getGotovProizvod().getId());
            statement.setInt(3,k.getKupac().getId());
            if(k.isGarancija()){
                statement.setInt(4, 1);
            } else { statement.setInt(4, 0);}
            //statement.setBoolean(4,k.isGarancija());
            statement.setString(5, k.getImePrezimeKupca());
           
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje kupljenih gotovih proizvoda od strane kupca!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje kupljenih gotovih proizvoda od strane kupca!" + ex.getMessage());
            rollback();
            throw ex;
        }
    }
    public void edit(Kupio k) throws Exception {
        try {
            //slozen primarni kljuc
            String sql = "UPDATE Kupio SET Garancija = ?, ImePrezimeKupca =? WHERE DatumKupovineGotovogProizvoda = ? AND GotovProizvodID=? AND KupacID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            if(k.isGarancija()){
                ps.setInt(1, 1);
            } else { ps.setInt(1, 0);}
            //ps.setBoolean(1, k.isGarancija());
            ps.setString(2, k.getImePrezimeKupca());
            ps.setDate(3, k.getDatumKupovineGP());
            ps.setInt(4, k.getGotovProizvod().getId());
            ps.setInt(5, k.getKupac().getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjeni kupljeni gotovi proizvodi od strane kupca!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjeni kupljeni gotovi proizvodi od strane kupca!" + ex.getMessage());
            rollback();
            throw ex;
        }
    }

    public void delete(Kupio k) throws Exception {
        try {
            String sql = "DELETE FROM Kupio WHERE DatumKupovineGotovogProizvoda ="+k.getDatumKupovineGP()+" AND GotovProizvodID="
                    + ""+k.getGotovProizvod().getId()+" AND KupacID="+k.getKupac().getId();
             
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje kupljenih gotovih proizvoda od strane kupca!\n"+ex);
            throw ex;
        }
    }
    
    
}
