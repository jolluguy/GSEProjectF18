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
    
    public boolean createUser(String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime);
    
    public boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName);

    public Collection<IUser> getUserList(); 
    
}
