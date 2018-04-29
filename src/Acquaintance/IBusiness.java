/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Business.User;
import Business.UserOperations;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Alexa
 */
public interface IBusiness {

    void injectionDataPersistens(IDataPersistens dataPersistens);

    void injectLoginPersistens(ILoginPersistens loginPersistens);

    int login(String name, String pw);

    void logOut();

    List<String> getUserList();

    String changePassword(String old, String new1, String new2);

    String changeLevel(String name, String pw, int level);

    String getUserName();

    boolean checkPassword(String pw);
    
    String createUser(String userName, String password1, String password2);
    
    void addUser(String userName, String password);
    
    Collection<IUser> getAllUsers();

}
