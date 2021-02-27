package net.javaci.dbsample;

import java.sql.*;

public class JdbcApp1 {

    private static final String DB_DERBY_URL_SERVER = "jdbc:derby://localhost:1527/mydb1;create=true";
    
    private static final String DB_DERBY_URL_MEMORY = "jdbc:derby:memory:mydb1;create=true";
    
    private static final String DB_DERBY_URL_FILE = "jdbc:derby:./.mydb1/;create=true";
    
    private static final String DB_MYSQL_URL_SERVER = "jdbc:mysql://localhost:3306/mydb1";
    
    private static final String CURRENT_DB_URL = DB_DERBY_URL_FILE;
    
    public static void main(String[] args) throws SQLException {
        
        System.out.println("Uygulama aciliyor.");
        
        Connection dbConn = DriverManager.getConnection(CURRENT_DB_URL, "root", "");
        
        System.out.println("Veritabanina baglanildi.");
        
        Statement stmt = dbConn.createStatement();
        
        createTableIfNotExists(stmt);
        
        addRecord(stmt);
        
        System.out.println("Kayit eklendi.");
        
        readRecords(stmt);
        
        dbConn.close();
        
        System.out.println("Veritabani baglantisi kapatildi.");
    }

    private static void createTableIfNotExists(Statement stmt) throws SQLException {
        try {
            stmt.executeUpdate( "CREATE TABLE customer (id int primary key, name varchar(30) )");
        } catch(SQLException e) {
            System.out.println("Tablo zaten var olabilir.");
        }
        System.out.println("Tablo olusturuldu.");
    }
    
    private static void addRecord(Statement stmt) throws SQLException {
        stmt.executeUpdate("INSERT INTO customer VALUES (6, 'tom')");
    }
    
    private static void readRecords(Statement stmt) throws SQLException {
        
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM customer");
        
        while(resultSet.next()) {
            
            String name = resultSet.getString(2);
            int id = resultSet.getInt("id");
            System.out.printf("id: %d , name: %s\n", id, name);
            
        }
        
        System.out.println("Kayit okuma tamamlandi.");
    }

}
