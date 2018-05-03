/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public interface ILoginPersistens {
    
    void getMap();
    
    IUser getUser(String userName);

    boolean addUser(IUser user);
    
    boolean updateUser(IUser user);
    
    Collection<IUser> getAllUsers();
    
    boolean userExist(String userName);
}
