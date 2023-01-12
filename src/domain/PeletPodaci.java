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
public class PeletPodaci implements SQLData{
    private String sqlType = "STUDENT.PELETPODACI";
    private String nazivPeleta;
    private String markaPeleta;
    private double precnikPeleta;
    private double duzinaPeleta;
    

    public PeletPodaci() {}

    public PeletPodaci(String nazivPeleta, String markaPeleta, double precnikPeleta, double duzinaPeleta) {
        this.nazivPeleta = nazivPeleta;
        this.markaPeleta = markaPeleta;
        this.precnikPeleta = precnikPeleta;
        this.duzinaPeleta = duzinaPeleta;
    }
    

    @Override
    public String getSQLTypeName() throws SQLException {
        return sqlType;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sqlType = typeName;
        nazivPeleta  = stream.readString();
        markaPeleta = stream.readString();
        precnikPeleta = stream.readDouble();
        duzinaPeleta = stream.readDouble();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(nazivPeleta);
        stream.writeString(markaPeleta);
        stream.writeDouble(precnikPeleta);
        stream.writeDouble(duzinaPeleta);
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getNazivPeleta() {
        return nazivPeleta;
    }

    public void setNazivPeleta(String nazivPeleta) {
        this.nazivPeleta = nazivPeleta;
    }

    public String getMarkaPeleta() {
        return markaPeleta;
    }

    public void setMarkaPeleta(String markaPeleta) {
        this.markaPeleta = markaPeleta;
    }

    public double getPrecnikPeleta() {
        return precnikPeleta;
    }

    public void setPrecnikPeleta(double precnikPeleta) {
        this.precnikPeleta = precnikPeleta;
    }

    public double getDuzinaPeleta() {
        return duzinaPeleta;
    }

    public void setDuzinaPeleta(double duzinaPeleta) {
        this.duzinaPeleta = duzinaPeleta;
    }

   
}
