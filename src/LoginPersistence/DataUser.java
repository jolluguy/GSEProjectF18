/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IAdmin;
import Acquaintance.IJob;
import Acquaintance.IUser;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Rol's studie PC
 */
public class DataUser implements IUser, Serializable {
    
    private int userID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String userName;
    private String password;
    private boolean active;
    private Timestamp createdTime;
    private Timestamp lastLoginTime;
    private IJob job;

    /**
     * for creating a new user in the system
     * @param userID
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param active
     * @param jobTitle
     * @param jobID
     * @param accessLevel
     * @param departmentID
     * @param departmentName
     * @param createdTime
     * @param lastLoginTime 
     */
    public DataUser(int userID, String firstName, String lastName, String userName, String password, boolean active, String jobTitle, int jobID, int accessLevel, int departmentID, String departmentName, Timestamp createdTime, Timestamp lastLoginTime) {
        this.userID = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = "88888888"; //NB!! - TelefonNummer skal oprettes automatisk;
        this.mail = userName + "@sensum.dk";
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());


            this.job = new DataJob(jobTitle, jobID, accessLevel, departmentID, departmentName);

    }

    /**
     * for getting a user from the database
     * @param userID
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param mail
     * @param userName
     * @param password
     * @param active
     * @param createdTime
     * @param lastLoginTime
     * @param jobTitle
     * @param jobID
     * @param accessLevel
     * @param departmentID
     * @param departmentName 
     */
    public DataUser(int userID, String firstName, String lastName, String phoneNumber, String mail, String userName, String password, boolean active, Timestamp createdTime, Timestamp lastLoginTime, String jobTitle, int jobID, int accessLevel, int departmentID, String departmentName) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
        this.job =  this.job = new DataJob(jobTitle, jobID, accessLevel, departmentID, departmentName);
    }
    
       
    
    @Override
    public String getFirstName(){
        return firstName;
    }
    
    @Override
    public String getLastName(){
        return lastName; 
    }
    
    @Override
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    @Override
    public String getMail(){
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

    @Override
    public void changePassword(String pw) {
        this.password = pw;
    }

    
    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    void updateUser(String password, boolean active, Timestamp lastLoginTime){
        this.password = password;
        this.active = active;
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String getPassword() {
        return password;
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
    public void setLastLoginTime() {
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public IJob getJob() {
        return job;
    }

    @Override
    public void setJob(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        
            this.job = new DataJob(jobTitle, ID, accessLevel, departmentID, departmentName);
    }

    @Override
    public int getUserID() {
       return this.userID;
    }
}
