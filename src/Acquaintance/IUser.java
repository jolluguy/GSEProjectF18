/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Date;

/**
 *
 * @author Alexa
 */
public interface IUser {

    String getUserName();

    int getLevel();

    void setLevel(int level);

    void setPassword(String pw);

    void setLastLoginTime(Date lastLoginTime);
    
}
