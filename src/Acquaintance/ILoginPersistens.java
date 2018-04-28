/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Business.User;
import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public interface ILoginPersistens {
    
    void readMap();
    
    void saveMap();
    
    User getUser(String userName, String pw);
    
    Collection<User> getAllUsers();

    void addUser(String userName, String password);
    
    void saveUser(User user);
}
