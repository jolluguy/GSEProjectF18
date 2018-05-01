/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;
import java.util.Date;

/**
 *
 * @author Rasmus
 */
public class Admin extends Job {

    private BusinessFacade facade = BusinessFacade.getInstance();

    boolean createUser(String userName, String password1, String password2, int level) {
        if (password1.equals(password2)) {
            return facade.addUser( new User(userName, password1, 0, new Date(), new Date()) {});
        } else {
            return false;
        }
    }
    
    boolean changeJob(String userName, String password, int level){
        IUser user = facade.getUser(userName);
        user.setLevel(level);
        return facade.updateUser(user);
    }
}
