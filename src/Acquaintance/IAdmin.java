/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public interface IAdmin {
    
   boolean createUser(String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime);
    
    boolean changeJob(String userName, String password, boolean active);

    Collection<IUser> getUserList(); 
    
}
