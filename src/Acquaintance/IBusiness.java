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
    
    public String addUser(String name, String pw1, String pw2, int level);
    
   public int login(String name, String pw);
   
   public void logOut();
    
   public List<String> getUserList();
   
   public String changePassword(String old, String new1, String new2);
   
   public String changeLevel(String name, String pw, int level);
   
   public boolean userExists(String userName);
   
   public User getUser(String UserName, String pw);
   
   public void addUserToMap(User user);
   
   public Collection<User> getAllUsers();
   
   public String getUserName();
   
   public boolean checkPassword(String pw);
    
}
