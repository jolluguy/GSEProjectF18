/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ILoginPersistens;
import Acquaintance.IUser;
/**
 *
 * @author Alexa
 */
public class UserOperations {
    
    private ILoginPersistens loginPersistens;
    
    private static UserOperations instance = null;

    public static UserOperations getInstance() {
        if (instance == null) {
            instance = new UserOperations();
        }
        return instance;
    }

    // private methods to read and write a whole Map.

    private void addUser(IUser user){
        loginPersistens.addUser((User) user);
    } 

    

    // public I/O operations:
    public boolean userExists(String userName){
        return userMap.containsKey(userName);
    }
    
}
