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
    
    BusinessFacade business;
    
    private static UserOperations instance = null;

    public static UserOperations getInstance() {
        if (instance == null) {
            instance = new UserOperations();
        }
        return instance;
    }

    // private methods to read and write a whole Map.

    protected String createUser(String userName, String password1, String password2) {
        if (password1.equals(password2)) {
            
            boolean succes = !userExists(userName);
            
            if (succes) {
                business.addUser(userName, password1);
                return "Bruger " + userName + " tilføjet.";
            } else {
                return "Fejl: " + userName + " eksisterer allerede!";
            }
        } else return "Passwords matcher ikke!";
        
    } 

    

    // public I/O operations:
    public boolean userExists(String userName){
        return userMap.containsKey(userName);
    }
    
}
