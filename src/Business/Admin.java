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
    
    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }
    
    boolean createUser(String firstName, String lastName, String userName, String password1, String password2, int level) {
        if (password1.equals(password2)) {
            return facade.addUser( new User(firstName, lastName, userName, password1, level));
        } else {
            return false;
        }
    }
    
    boolean changeJob(String userName, String password, int level){
        IUser user = facade.getUser(userName);
        user.setLevel(level);
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
