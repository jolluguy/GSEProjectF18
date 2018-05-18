/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IAdmin;
import Acquaintance.IJob;
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
    private IJob job;

    /**
     * For creating a new user for the system.
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param jobtitle
     * @param jobID
     * @param accessLevel
     * @param departmentID
     * @param departmentName 
     */
    public User(String firstName, String lastName, String userName, String password, String jobtitle, int jobID, int accessLevel, int departmentID, String departmentName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = "88888888"; //NB!! - TelefonNummer skal oprettes automatisk;
        this.mail = userName + "@sensum.dk";
        this.userName = userName;
        this.password = password;
        this.active = active = true;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());

        if (jobtitle.equalsIgnoreCase("admin")) {
            this.job = new Admin(jobID, accessLevel, departmentID, departmentName);

        } else if (jobtitle.equalsIgnoreCase("sagsbehandler")) {
            this.job = new CaseWorker(jobID, accessLevel, departmentID, departmentName);
        }

    }

    /**
     * this i dont know what the fuck do
     * @param userName
     * @param password
     * @param active
     * @param createdTime
     * @param lastLoginTime 
     */
    public User(String userName, String password, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
    }

    User(String firstName, String lastName, String userName, String password2, boolean active, String lastName0, int ID, int accessLevel, int ID0, String lastName1, Timestamp createdTime, Timestamp lastLoginTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IJob getJob() {
        return this.job;
    }

//    @Override
    Admin getAdmin() {
        
        if (this.getClass().getSimpleName().equalsIgnoreCase("admin")) {
            return (Admin) this.job;
    }
        else {
            return null;
        }
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

    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    @Override
    public String toString() {
        String str = String.format("%1$-16s\t%2$d\t%3$s\t%4$s", userName, active, df.format(createdTime), df.format(lastLoginTime));
        return str;
    }

}
