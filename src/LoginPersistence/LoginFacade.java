/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IUser;
import java.io.Serializable;
import java.util.Collection;
import Acquaintance.ILoginPersistence;

/**
 *
 * @author Rol's studie PC
 */
public class LoginFacade implements ILoginPersistence, Serializable {

    Operations operations;

    private static LoginFacade instance = null;
    
    private LoginFacade() {
        
    }
    
    public static LoginFacade getInstance() {
        if(instance == null) {
            instance = new LoginFacade();
        }
        return instance;
    }

    @Override
    public IUser getUser(String userName) {
        operations = new Operations();
        return operations.getUser(userName);
    }

    @Override
    public boolean addUser(IUser user) {
        operations = new Operations();
        return operations.addUser(user);
    }

    @Override
    public boolean updateUser(IUser user) {
        operations = new Operations();
        return operations.updateUser(user);
    }
    
    @Override
    public Collection<IUser> getAllUsers(){
        operations = new Operations();
        return operations.getAllUsers();
    }
    
    @Override
    public boolean getUserInfo(String userName) {
        operations = new Operations();
        return operations.isUserInMap(userName);
    }
    


}
