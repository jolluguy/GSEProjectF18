/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.ILoginPersistens;
import Acquaintance.IUser;
import java.io.Serializable;



/**
 *
 * @author Rol's studie PC
 */
public class LoginFacade implements ILoginPersistens, Serializable {
    
    Operations operations;

//    public LoginFacade() {
//        operations = new Operations();
//    }
    
    private static LoginFacade instance = null;
    public static LoginFacade getInstance(){
        if(instance == null) {
            instance = new LoginFacade();
        }
        return instance;
    }

    
    @Override
    public void getMap() {
        operations.getMap();
    }
    
    @Override
    public IUser getUser(String userName) {
        System.out.println("Login loginfacade entered");
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
