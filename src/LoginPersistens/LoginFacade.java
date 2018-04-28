/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.ILoginPersistens;
import Acquaintance.IUser;
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
    public IUser getUser(String userName, String pw) {
        return operations.getUser(userName, pw);
    }
    
    @Override
    public Collection<IUser> getAllUsers(){
        return operations.userMap.values();
    }

    @Override
    public void saveUser(IUser user) {
        operations.saveUser(user);
    }

    @Override
    public void addUser(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
