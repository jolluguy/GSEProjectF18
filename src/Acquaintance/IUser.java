/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Business.Job;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Alexa
 */
public interface IUser {
    
    IJob getJob();
    
    void setJob(IJob job);
    
    String getFirstName();
    
    String getLastName();
    
    int getUserID();

    String getUserName();
    
    String getPhoneNumber();
    
    String getMail();

    boolean getActive();

    void setActive(boolean active);

    void changePassword(String password);
    
    String getPassword();
    
    Timestamp getCreatedTime();
    
    Timestamp getLastLoginTime();

    public void setLastLoginTime();

}
