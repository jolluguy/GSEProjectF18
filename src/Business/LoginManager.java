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
 * @author Rol's studie PC
 */
public class LoginManager {
    
    private static BusinessFacade facade = BusinessFacade.getInstance();
    
    private User userOne; //userOne due to future plans of multiple user access at once
    
    private static LoginManager instance;
    
    private LoginManager() {
        
        
    }
    
    public static LoginManager getInstance() {
        if(instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }
    
    
    public int login(String userName, String pw) {
        int access = -1;
        IUser user = facade.getUser(userName); //Parsing User below due to IUser return
        User checkUser = new User(user.getUserName(), user.getPassword(), user.getActive(), user.getCreatedTime(), user.getLastLoginTime());

        if (checkUser.checkPassword(pw)) {
            userOne = checkUser;
            if (facade.updateLastLoginTime(userOne)) {
                access = facade.getAccess(checkUser.getUserName());
            }
        }
        return access;
    }
    
    public void logOut() {
        userOne = null;
    }
    
    public boolean checkCredentials(String userName, String password) {
        IUser user = facade.getUser(userName);
        if (user.getPassword().equals(password)) {
            return true;
        }

        return false;
    }
    
    public User getUserOne() {
        return userOne;
    }
    
    public boolean changePassword(String oldPassword, String newPassword1, String newPassword2) {
        if (oldPassword.equals(userOne.getPassword())) {
            if (newPassword1.equals(newPassword2)) {
                userOne.changePassword(newPassword1);
                return true;
            }
        }
        return false;
    }

    Collection<IUser> getAllUsers() {
        return facade.getAllUsers();
    }

    boolean updateJob(IUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean addUser(String firstName, String lastName, String userName, String password, String jobtitle, int jobID, int accessLevel, int departmentID, String departmentName) {
        IUser user = new User(firstName, lastName, userName, password, jobtitle, jobID, accessLevel, departmentID, departmentName);
        return facade.addUser(user);
    }

    IUser getUser(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
