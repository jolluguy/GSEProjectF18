/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IUser;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Rol's studie PC
 */
public class DataUser implements IUser, Serializable {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private final String userName;
    private String password;
    private int level;
    private final Timestamp createdTime;
    private Timestamp lastLoginTime;

    public DataUser(String userName, String password, int level, Timestamp createdTime, Timestamp lastLoginTime) {
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
    }   

    public DataUser(String firstName, String lastName, String phoneNumber, String mail, String userName, String password, int level, Timestamp createdTime, Timestamp lastLoginTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
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
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setPassword(String pw) {
        this.password = pw;
    }

    
    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    void updateUser(String password, int level, Timestamp lastLoginTime){
        this.password = password;
        this.level = level;
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
    
}
