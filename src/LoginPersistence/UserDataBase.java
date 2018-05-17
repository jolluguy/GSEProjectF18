/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import java.sql.*;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexa
 */
public class UserDataBase {

    String url = "jdbc:postgresql://horton.elephantsql.com:5432/ksevsemh";
    String username = "ksevsemh";
    String password = "S_ACh-Y8moY8kuw4BtFMiGDWoqLrzc_o";
    
    //NB! - Status er sat til true under test af query. Denne SKAL rettes tilabge før push!!!
    public void createUserInDB(String username, String password, boolean b, java.util.Date createdTime, java.util.Date lastLoginTime){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            
            String sql = "INSERT INTO login(brugernavn, kodeord, status, created_time, last_login_time) "
                    + "VALUES(" + username + ", " + password + ", " + true + ", "
                    + createdTime + ", " + lastLoginTime + ");";
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
    
}
