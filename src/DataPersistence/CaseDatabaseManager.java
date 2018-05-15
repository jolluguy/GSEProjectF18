/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

/**
 *
 * @author Alexa
 */
public class CaseDatabaseManager {
    
    Connection conn;
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/mcheibvh";
    String dbUsername = "mcheibvh";
    String dbPassword = "keLgH7ysBAb9ly98JEFysr6EwwRGbVY_";
    
    public void testDatabase(){
        
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO aftale(dato, lokation, beskrivelse) VALUES ('" +  new Timestamp(System.currentTimeMillis()) + "', place', 'description');");
            
            st.executeUpdate();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
