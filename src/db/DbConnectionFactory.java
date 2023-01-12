/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import dbConstants.DbConstants;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Korisnik
 */
public class DbConnectionFactory {
    
    private Connection connection;
    private static DbConnectionFactory instance;
    
    private DbConnectionFactory(){}
    
    public static DbConnectionFactory getInstance(){
        if(instance==null){
            instance=new DbConnectionFactory();
        }
        return instance;
    }
     
     
    public Connection getConnection() throws Exception{
       
        if (connection == null || connection.isClosed()) {
            try {
                //Properties properties = new Properties();
                //ucitavamo-punimo properties iz nekog fajla
                //properties.load(new FileInputStream("config/db.properties"));
                //moram da zamenim sa konstantama literale
                //String url = properties.getProperty(DbConstants.DB_PASSWORD);
                //String user = properties.getProperty(DbConstants.DB_USER);
                //String password = properties.getProperty(DbConstants.DB_PASSWORD);
                //connection = DriverManager.getConnection(url, user, password);
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "student", "student");
                connection.setAutoCommit(false);
                //distinkt i kdt Connectiontip u Oracle
            java.util.Map map = connection.getTypeMap();
            map.put("STUDENT.PELETPODACI", Class.forName("domain.PeletPodaci"));
            map.put("STUDENT.NAZIVVREDNOST", Class.forName("domain.NazivVrednost"));

            connection.setTypeMap(map);
            } catch (SQLException ex) {
                System.out.println("Neuspešno uspostavljanje konekcije!\n" + ex.getMessage());
                throw ex;
            }
        }
        return connection;
    }
    
    
}