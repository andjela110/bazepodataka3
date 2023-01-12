/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public class DbRepository {
    public void connect() throws SQLException, Exception{
        DbConnectionFactory.getInstance().getConnection();
    }
    
    public void disconnect() throws SQLException, Exception{
        DbConnectionFactory.getInstance().getConnection().close();
    }
    
    public void commit() throws SQLException, Exception{
        DbConnectionFactory.getInstance().getConnection().commit();
    }
    
    public void rollback() throws SQLException, Exception{
        DbConnectionFactory.getInstance().getConnection().rollback();
    }
}
