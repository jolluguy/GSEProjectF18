/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.IInquiry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexa
 */
public class CaseDatabaseManager {
    
    Connection conn;
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/mcheibvh";
    String dbUsername = "mcheibvh";
    String dbPassword = "keLgH7ysBAb9ly98JEFysr6EwwRGbVY_";
    
    
    public boolean saveInquiry(IInquiry inq){
        
        String problemDesc = inq.getProblemDescription();
        String inquierer = inq.getInquierer();
        boolean agreement = inq.getCitizenAgreement();
        Timestamp date = inq.getDate();
        
        
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO henvendelse (indforstået, problembeskrivelse, henvender, henvendelses_dato)"
                    + "VALUES ('" + agreement + "', '" + problemDesc + "', '" + inquierer + "', '" + date + "');");
            st.executeUpdate();
            
            String inqID = null;
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
}
