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
    public User(String userName, String password, int level) {
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());
    }
    public User(String userName, String password, int level, Timestamp createdTime, Timestamp lastLoginTime) {
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
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
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void changePassword(String password) {
        this.password = password;
    }

    @Override
    public void setLastLoginTime() {
        this.lastLoginTime = new Timestamp(System.currentTimeMillis());
    }


    
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    @Override
    public String toString() {
   String str = String.format("%1$-16s\t%2$d\t%3$s\t%4$s", userName, level, df.format(createdTime), df.format(lastLoginTime));
       return str; 
//        return (userName + "\t" + level + "\t" + df.format(createdTime) + "\t" + df.format(lastLoginTime));
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

}
