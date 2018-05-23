/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;
import java.util.Collection;

/**
 *
 * @author Rasmus
 */
class Admin extends Job{

    private LoginManager loginManeger = LoginManager.getInstance();

    Admin(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        super(jobTitle, ID, accessLevel, departmentID, departmentName);
    }
    
    
    
    @Override
    boolean createUser(String firstName, String lastName, String userName, String password1, String password2, String jobtitle, int jobID, int accessLevel, int departmentID, String departmentName) {
        if (password1.equals(password2)) {
                    IUser user = new User(firstName, lastName, userName, password1, jobtitle, jobID, accessLevel, departmentID, departmentName);
            return loginManeger.addUser(user);
        } else {
            return false;
        }
    }
    
    @Override
    boolean changeJob(String userName,boolean active, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        IUser iuser = loginManeger.getUser(userName);
        Job job;
         if(jobTitle.equalsIgnoreCase("admin")){
            job = new Admin(jobTitle, ID, accessLevel, departmentID, departmentName);
            
        } else{
            job = new CaseWorker(jobTitle, ID, accessLevel, departmentID, departmentName);
        }
        User user = new User(iuser.getUserID(), iuser.getUserName(), iuser.getPassword(), iuser.getCreatedTime(), iuser.getLastLoginTime(), iuser.getActive(), iuser.getFirstName(), iuser.getLastName(), iuser.getPhoneNumber(), iuser.getMail(), job);
        user.setActive(active);

        return loginManeger.updateJob(user);
    }
    


    @Override
    Collection<IUser> getUserList() {
        return loginManeger.getAllUsers();
        
    }

    
    
}
