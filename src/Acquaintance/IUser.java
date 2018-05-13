/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Alexa
 */
public interface IUser {
    
    String getFirstName();
    
    String getLastName();

    String getUserName();
    
    String getPhoneNumber();
    
    String getMail();

    int getLevel();

    void setLevel(int level);

    void setPassword(String pw);
    
    String getPassword();
    
    Timestamp getCreatedTime();
    
    Timestamp getLastLoginTime();

    public void setLastLoginTime();

}
