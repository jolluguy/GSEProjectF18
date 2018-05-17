/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;
import java.io.Serializable;
import java.text.DateFormat;
import java.sql.Timestamp;

/**
 *
 * @author erso
 */
public class User implements IUser, Serializable{
   
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String userName;
    private String password;
    private int level;
    private Timestamp createdTime;
    private Timestamp lastLoginTime;
/**
 * for youse when adding a new user to the system, it aoutomaticaly sets createddate and lastlogontime.
 * @param userName
 * @param password
 * @param level 
 */
    public User(String firstName, String lastName, String userName, String password, int level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = "88888888"; //NB!! - Telefonnummer skal oprettes automatisk;
        this.mail = userName + "@sensum.dk";
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());

        if (jobtitle.equalsIgnoreCase("admin")) {
            this.job = new Admin(ID, accessLevel, departmentID, departmentName);

        } else if (jobtitle.equalsIgnoreCase("caseworker")) {
            this.job = new CaseWorker(ID, accessLevel, departmentID, departmentName);
        }

    }
    public User(String userName, String password, int level, Timestamp createdTime, Timestamp lastLoginTime) {
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
    }
    
    @Override
    public Job getJob() {
        return job;
    }

    @Override
    public void setJob(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        if(jobTitle.equalsIgnoreCase("admin")){
            this.job = new Admin(ID, accessLevel, departmentID, departmentName);
            
        } else if(jobTitle.equalsIgnoreCase("caseworker")) {
            this.job = new CaseWorker(ID, accessLevel, departmentID, departmentName);
            
        }
        
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getMail() {
        return mail;
    }
    
    @Override
    public String getUserName() {
        return userName;
    }
    
    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public void changePassword(String password) {
        this.password = password;
    }
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setLastLoginTime() {
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    @Override
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }
    
    
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    @Override
    public String toString() {
   String str = String.format("%1$-16s\t%2$d\t%3$s\t%4$s", userName, level, df.format(createdTime), df.format(lastLoginTime));
       return str; 
    }

}
