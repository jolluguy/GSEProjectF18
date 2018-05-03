/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.ILoginPersistens;
import Acquaintance.IUser;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public class LoginFacade implements ILoginPersistens, Serializable {

    Operations operations;

    private static LoginFacade instance = null;

    public static LoginFacade getInstance() {
        if (instance == null) {
            instance = new LoginFacade();
        }
        return instance;
    }

    @Override
    public void getMap() {
        operations = new Operations();
        operations.getMap();
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
    
    public boolean userExist(String userName) {
        return operations.isUserInMap(userName);
    }
    


}
