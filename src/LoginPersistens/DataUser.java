/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.IUser;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Rol's studie PC
 */
public class DataUser implements IUser, Serializable {
    
    private final String userName;
    private String password;
    private int level;
    private final Date createdTime;
    private Date lastLoginTime;

    public DataUser(String userName, String password, int level, Date createdTime, Date lastLoginTime) {
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
    public void setPassword(String pw) {
        this.password = password;
    }

    
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    void updateUser(String password, int level, Date lastLoginTime){
        this.password = password;
        this.level = level;
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Date getCreatedTime() {
        return createdTime;
    }

    @Override
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    
}
