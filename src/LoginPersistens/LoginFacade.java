/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.ILoginPersistens;
import Business.User;
import java.util.Collection;



/**
 *
 * @author Rol's studie PC
 */
public class LoginFacade implements ILoginPersistens {
    
    Operations operations;
    
    @Override
    public void readMap() {
        operations.readMap();
    }
    
    @Override
    public void saveMap() {  // Called every time a user is created/updated/deleted
        operations.saveMap();
    }
    
    @Override
    public User getUser(String userName, String pw) {
        return operations.getUser(userName, pw);
    }
    
    @Override
    public Collection<User> getAllUsers(){
        return operations.userMap.values();
    }
    
    @Override
    public void addUser(User user) {
        operations.addUser(user);
    }

    @Override
    public void saveUser(User user) {
        operations.saveUser(user);
    }
    
}
