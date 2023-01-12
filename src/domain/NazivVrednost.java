/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
/**
 *
 * @author Korisnik
 */
public class NazivVrednost implements SQLData{
    String sqlType="STUDENT.NAZIVVREDNOST";
    private String naziv;
    
    public NazivVrednost() {}
    
    public NazivVrednost (String naziv){
        this.naziv=naziv;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    

    @Override
    public String getSQLTypeName() throws SQLException {
        return sqlType;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sqlType = typeName;
        naziv = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
         stream.writeString(naziv);
    }
    
}
