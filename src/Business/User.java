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
public class User implements IUser, Serializable {

    
    private String userName;
    private String password;
    private Timestamp createdTime;
    private Timestamp lastLoginTime;
    private boolean active;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private int userID = 0;
    private Job job;

    /**
     * For creating a new user for the system.
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param jobTitle
     * @param jobID
     * @param accessLevel
     * @param departmentID
     * @param departmentName 
     */
    User(String firstName, String lastName, String userName, String password, String jobTitle, int jobID, int accessLevel, int departmentID, String departmentName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = "88888888"; //NB!! - TelefonNummer skal oprettes automatisk;
        this.mail = userName + "@sensum.dk";
        this.userName = userName;
        this.password = password;
        this.active = active = true;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());

        if (jobTitle.equalsIgnoreCase("admin")) {
            this.job = new Admin(jobTitle, jobID, accessLevel, departmentID, departmentName);

        } else if (jobTitle.equalsIgnoreCase("sagsbehandler")) {
            this.job = new CaseWorker(jobTitle, jobID, accessLevel, departmentID, departmentName);
        }

    }

    /**
     * Method for creating User with all parameters.
     * @param userName
     * @param password
     * @param createdTime
     * @param lastLoginTime
     * @param active
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param mail
     * @param job 
     */
    User(String userName, String password, Timestamp createdTime, Timestamp lastLoginTime, boolean active, String firstName, String lastName, String phoneNumber, String mail, Job job) {
        this.userName = userName;
        this.password = password;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.job = job;
    }
    
    

  
    @Override
    public Job getJob() {
        return this.job;
    }
    
    
    @Override
    public void setJob(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        if(jobTitle.equalsIgnoreCase("admin")){
            this.job = new Admin(jobTitle, ID, accessLevel, departmentID, departmentName);
            
        } else if(jobTitle.equalsIgnoreCase("caseworker")) {
            this.job = new CaseWorker(jobTitle, ID, accessLevel, departmentID, departmentName);
            
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
    public boolean getActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
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

    @Override
    public int getUserID() {
        return this.userID;
    }

}
