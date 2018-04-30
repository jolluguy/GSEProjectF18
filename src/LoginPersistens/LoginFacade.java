/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.ILoginPersistens;
import Acquaintance.IUser;



/**
 *
 * @author Rol's studie PC
 */
public class LoginFacade implements ILoginPersistens {
    
    Operations operations;
    
    @Override
    public void getMap() {
        operations.getMap();
    }
    
    @Override
    public IUser getUser(String userName) {
        return operations.getUser(userName);
    }

    @Override
    public boolean addUser(IUser user) {
        return operations.addUser(user);
    }

    @Override
    public boolean updateUser(IUser user) {
        return operations.updateUser(user);
    }
    
    
    
}
