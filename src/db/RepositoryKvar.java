/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domain.GotovProizvod;
import domain.Kvar;
import domain.TipKvara;
import domain.TipUzrokaKvara;
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
public class RepositoryKvar extends DbRepository{
    private Connection connection;

    public RepositoryKvar() {}

    public List<Kvar> getAll() throws Exception {
       try {
            List<Kvar> kvarovi=new ArrayList<>();
            String upit="SELECT k.KvarID as kvarID, k.gotovProizvodID as gotovProizvodID, gp.nazivGotovogProizvoda as naziv_gotovog_proizvoda, "
                    + "k.KolicinaKvara as kolicina_kvara, k.DatumKvara as datum_kvara, k.TipKvaraID as tip_kvaraID, tk.NazivTipaKvara as "
                    + "naziv_tipa_kvara, k.TipUzrokaKvaraID as tip_uzroka_kvaraID, tuk.NazivTipaUzrokaKvara as naziv_tipa_uzroka_kvara "
                    + "FROM Kvar k INNER JOIN GotovProizvod gp ON (gp.GotovProizvodID=k.GotovProizvodID) INNER JOIN TipKvara tk ON "
                    + "(k.TipKvaraID=tk.TipKvaraID) INNER JOIN TipUzrokaKvara tuk ON (tuk.TipUzrokaKvaraID=k.TipUzrokaKvaraID)ORDER BY k.DatumKvara ASC";
            connection=DbConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            
            while(rs.next()){
             
                Kvar k=new Kvar();
                k.setId(rs.getInt("kvarID"));
                GotovProizvod gp=new GotovProizvod();
                gp.setId(rs.getInt("gotovProizvodID"));
                gp.setNaziv(rs.getString("naziv_gotovog_proizvoda"));
                k.setGotovProizvod(gp);
                k.setKolicinaKvara(rs.getInt("kolicina_kvara"));
                k.setDatumKvara(rs.getDate("datum_kvara"));
                TipKvara tk=new TipKvara();
                tk.setId(rs.getInt("tip_kvaraID"));
                tk.setNaziv(rs.getString("naziv_tipa_kvara"));
                k.setTipKvara(tk);
                TipUzrokaKvara tuk=new TipUzrokaKvara();
                tuk.setId(rs.getInt("tip_uzroka_kvaraID"));
                tuk.setNaziv(rs.getString("naziv_tipa_uzroka_kvara"));
                k.setTipUzrokaKvara(tuk);
                
                kvarovi.add(k);
            }
            rs.close();
            statement.close();
            System.out.println("Uspešno učitana lista kvarova!");
            return kvarovi;
        } catch (SQLException ex) {
            System.out.println("Neuspešno učitavanje liste kvarova!\n"+ex);
            throw ex;
        }
    }

    public void add(Kvar k) throws Exception {
        try {
            String upit="INSERT INTO Kvar (GotovProizvodID, KolicinaKvara, DatumKvara, TipKvaraID, TipUzrokaKvaraID) VALUES (?,?,?,?,?)";
            connection=DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(upit);
           
            statement.setInt(1,k.getGotovProizvod().getId());
            statement.setInt(2,k.getKolicinaKvara());
            statement.setDate(3,k.getDatumKvara());
            statement.setInt(4,k.getTipKvara().getId());
            statement.setInt(5,k.getTipUzrokaKvara().getId());
            
            statement.executeUpdate();
            statement.close();
            commit();
            System.out.println("Uspešno kreiranje kvara!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno kreiranje kvara!");
            rollback();
            throw ex;
        }
    }
  
    public void edit(Kvar k) throws Exception {
         try {
            String sql = "UPDATE Kvar SET KolicinaKvara = ?, DatumKvara=?, TipKvaraID=?, TipUzrokaKvaraID=? WHERE KvarID = ? AND GotovProizvodID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
        
            ps.setInt(1, k.getKolicinaKvara());
            ps.setDate(2, k.getDatumKvara());
            ps.setInt(3, k.getTipKvara().getId());
            ps.setInt(4, k.getTipUzrokaKvara().getId());
            ps.setInt(5, k.getId());
            ps.setInt(6, k.getGotovProizvod().getId());
            
            ps.executeUpdate();
            ps.close();
            commit();
            System.out.println("Uspešno izmenjen kvar!");
        } catch (SQLException ex) {
            System.out.println("Neuspešno izmenjen kvar!");
            rollback();
            throw ex;
        }
        
    }
    
    public void delete(Kvar k) throws Exception {
        try {
            String sql = "DELETE FROM Kvar WHERE KvarID = " + k.getId()+" AND GotovProizvodID="+k.getGotovProizvod().getId();
            Statement sqlStatement = connection.createStatement();
            int br = sqlStatement.executeUpdate(sql);
            sqlStatement.close();
            commit();
        } catch (SQLException ex) {
            System.out.println("Neuspešno brisanje kvara!\n"+ex);
            throw ex;
        }
    }
    

}
