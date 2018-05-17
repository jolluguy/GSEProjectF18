/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IJob;
import Acquaintance.IUser;
import Presentation.AdminController;
import java.io.Serializable;
import java.text.DateFormat;
import java.sql.Timestamp;

/**
 *
 * @author erso
 */
public class User implements IUser, Serializable {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private int userID;
    private String userName;
    private String password;
    private boolean active;
    private Timestamp createdTime;
    private Timestamp lastLoginTime;
    private IJob job;

    public User(String firstName, String lastName, String userName, String password, boolean active, String jobtitle, int ID, int accessLevel, int departmentID, String departmentName, Timestamp createdTime, Timestamp lastLoginTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = "88888888"; //NB!! - TelefonNummer skal oprettes automatisk;
        this.mail = userName + "@sensum.dk";
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());

        if (jobtitle.equalsIgnoreCase("admin")) {
            this.job = new Admin(ID, accessLevel, departmentID, departmentName);

        } else if (jobtitle.equalsIgnoreCase("sagsbehandler")) {
            this.job = new CaseWorker(ID, accessLevel, departmentID, departmentName);
        }

    }

    public User(String userName, String password, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
    }
    
    @Override
    public IJob getJob() {
        return job;
    }

    @Override
    public void setJob(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        if (jobTitle.equalsIgnoreCase("admin")) {
            this.job = new Admin(ID, accessLevel, departmentID, departmentName);
        }
        else if (jobTitle.equalsIgnoreCase("caseworker")) {
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
    public int getUserID() {
        return userID;
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
