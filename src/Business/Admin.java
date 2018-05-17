/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Rasmus
 */
public class Admin extends Job {

    private BusinessFacade facade = BusinessFacade.getInstance();

    private static Admin instance = null;

    private Admin() {
        
    }
    
    @Override
    public boolean createUser(String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
        if (password1.equals(password2)) {
            return facade.addUser( new User(firstName, lastName, userName, password2, active, lastName, super.getID(), super.getAccessLevel(), super.getDepartment().getDepartmentID(), lastName, createdTime, lastLoginTime));
        } else {
            return false;
        }
    }
    
    @Override
    public boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        IUser user = facade.getUser(userName);
        user.setJob(jobTitle, ID, accessLevel, departmentID, departmentName); //Parsing IJob to job... Might give some problems.
        return facade.updateJob(user);
    }
    


    Collection<IUser> getUserList() {
        ArrayList<IUser> tempList = new ArrayList<>();
        for(IUser i : facade.getAllUsers()){
            tempList.add(new User(i.getUserName(), i.getPassword(), i.getLevel(), i.getCreatedTime(), i.getLastLoginTime()));
        }
            
        return tempList;
    }
    
    
}
