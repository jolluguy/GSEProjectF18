/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Alexa
 */
public class BusinessFacade implements IBusiness {

    private IData data;

    //Data layer injection
    @Override
    public void injectionData(IData data) {
        this.data = data;
    }

    private static BusinessFacade instance = null;

    public BusinessFacade() {
        manager = new UserManager();
    }

    public static BusinessFacade getInstance() {
        if (instance == null) {
            instance = new BusinessFacade();
        }
        return instance;
    }

    private UserManager manager; // Delegate all calls conserning users to the manager.

    public String addUser(String name, String pw1, String pw2, int level) {
        if (pw1.equals(pw2)) {
            
            boolean succes = manager.addUser(name, pw1, level);
            
            if (succes) {
                return "User " + name + " added.";
            } else {
                return "Error: " + name + " already registered!";
            }
        } else return "Passwords do not match!";

    }

    public int login(String name, String pw) {
        return manager.login(name, pw);
    }

    public void logOut() {
        manager.logOut();
    }

    public List<String> getUserList() {
        return manager.getUserList();
    }

    public String changePassword(String old, String new1, String new2) {
        return manager.changePw(old, new1, new2);
    }

    public String changeLevel(String name, String pw, int level) {
        return manager.changeLevel(name, pw, level);
    }

    private UserOperations operations;

    public boolean userExists(String userName) {
        return operations.userExists(userName);
    }

    public User getUser(String UserName, String pw) {
        return operations.getUser(UserName, pw);
    }

    public void addUserToMap(User user) {
        operations.addUserToMap(user);
    }

    public Collection<User> getAllUsers() {
        return operations.getAllUsers();
    }

}
