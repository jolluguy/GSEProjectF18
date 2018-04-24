/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author erso
 */
public class User implements Serializable {
    
    private String userName;
    private String pw;
    private int level;
    private Date createdTime;
    private Date lastLoginTime;

    public User(String user, String pw, int level) {
        this.userName = user;
        this.pw = pw;
        this.level = level;
        this.createdTime = new Date();
        this.lastLoginTime = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    

    public boolean checkPassWord(String pw) {
        return this.pw.equals(pw);
    }

    public void changePassWord(String pw) {
        this.pw = pw;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    @Override
    public String toString() {
//        String str = String.format("%1$-16s\t%2$d\t%3$s\t%4$s", user, level, df.format(createdTime), df.format(lastLoginTime));
        
        return (userName + "\t" + level + "\t" + df.format(createdTime) + "\t" + df.format(lastLoginTime));
    }

}
