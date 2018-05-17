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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String inquierer = inq.getInquirer();
        boolean agreement = inq.getCitizenAgreement();
        Timestamp date = inq.getTime();
        
        
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO henvendelse (indforstået, problembeskrivelse, henvender, henvendelses_dato)"
                    + "VALUES ('" + agreement + "', '" + problemDesc + "', '" + inquierer + "', '" + date + "');");
            st.executeUpdate();
            
//            Thread.sleep(1000);
//            String inqID = null;      
//            Statement st2 = conn.createStatement();
//            String sql = "SELECT henvendelses_id FROM henvendelse WHERE ";
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean doesInquiryExist(String inqID){
        int matches = -1;
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            Statement st = conn.createStatement();
            String sql = "SELECT COUNT('henvendelses_id') FROM henvendelse WHERE henvendelses_id = '" + inqID + "';";
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                matches = result.getInt("count");
            }
            
            if (matches == 1) {
                return true;
            }
            
        }   catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        return false;
    }   
    
    public IInquiry getInquiry(String inqID){
        DataInquiry inquiry = null;
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            if (doesInquiryExist(inqID)) {
                Statement st = conn.createStatement();
                String sql = "SELECT henvendelse.indforstået, henvendelse.problembeskrivelse, henvendelse.henvender, henvendelse.henvendelses_dato FROM henvendelse WHERE henvendelses_id = '" + inqID + "';";
                ResultSet result = st.executeQuery(sql);
                
                while(result.next()){
                    boolean tempAgreement = result.getBoolean("indforstået");
                    String tempProblemDesc = result.getString("problembeskrivelse");
                    String tempInquirer = result.getString("henvender");
                    Timestamp tempTimeStamp = result.getTimestamp("henvendelses_dato");
                    
                    inquiry = new DataInquiry(tempProblemDesc, tempInquirer, tempAgreement);
                    
                }
            }
            
        }   catch (Exception ex) {
            ex.printStackTrace();
            }
        return null; //CHANGE!!!!!!!!!!!!!!
    }   
}
