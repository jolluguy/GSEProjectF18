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
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    public int login(String userName, String pw) {
        int access = -1;
        if (facade.doesUserExist(userName)) {
            IUser user = facade.getUser(userName); //Parsing User below due to IUser return
            Job job;
            String jobTitle = user.getJob().getJobTitle().toLowerCase();
            if(user.getActive()){
            switch (jobTitle) {
                case "admin": {
                    job = new Admin(user.getJob().getJobTitle(), user.getJob().getID(), user.getJob().getAccessLevel(), user.getJob().getDepartment().getDepartmentID(), user.getJob().getDepartment().getDepartmentName());
                    break;
                }
                case "sagsbehandler": {
                    job = new CaseWorker(user.getJob().getJobTitle(), user.getJob().getID(), user.getJob().getAccessLevel(), user.getJob().getDepartment().getDepartmentID(), user.getJob().getDepartment().getDepartmentName());
                    break;
                }
                default: {
                    throw new UnsupportedOperationException("jobTitle not recognised."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            User checkUser = new User(user.getUserName(), user.getPassword(), user.getCreatedTime(), user.getLastLoginTime(), user.getActive(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getMail(), job);

            if (checkUser.checkPassword(pw)) {
                userOne = checkUser;
                userOne.setLastLoginTime();
                facade.updateLastLoginTime(userOne);
                access = userOne.getJob().getAccessLevel();
            }
        }
            else{
                access = -2;
            }
        }
        return access;
    }

    public void logOut() {
        userOne = null;
    }

    

    public User getCurentUser() {
        return userOne;
    }

    boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(userOne.getPassword())) {
                userOne.changePassword(newPassword);
                facade.updatePassword(userOne);
                return true;
        }
        return false;
    }

    Collection<IUser> getAllUsers() {
        return facade.getAllUsers();
    }

    boolean updateJob(IUser user) {
        return facade.updateJob(user);
    }

    boolean addUser(IUser user) {
        return facade.addUser(user);
    }

    IUser getUser(String userName) {
        return facade.getUser(userName);
    }

    String getCurrentUserDomainID() {
        DomainID dom = new DomainID();
        return dom.getDomainID(userOne);
    }

    String getdomainID(IUser user) {
        DomainID dom = new DomainID();
        return dom.getDomainID(user);
    }

    IUser getUserFromDomainID(String domainID){
        DomainID dom = new DomainID();
        return facade.getUser(dom.getUserID(domainID));
    }

}
