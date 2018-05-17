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
    
    IJob getJob();
    
    void setJob(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName);
    
    String getFirstName();
    
    String getLastName();

    String getUserName();
    
    String getPhoneNumber();
    
    String getMail();

    int getLevel();

    void setLevel(int level);

    void changePassword(String password);
    
    String getPassword();
    
    Timestamp getCreatedTime();
    
    Timestamp getLastLoginTime();

    public void setLastLoginTime();

}
