/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Collection;

/**
 *
 * @author Alexa
 */
public interface IBusiness {

    void injectionDataPersistens(IDataPersistens dataPersistens);

    void injectLoginPersistens(ILoginPersistens loginPersistens);

    int login(String name, String pw);

    void logOut();

    void initiater();
    
    boolean createUser(String userName, String password1, String password2, int level);

    boolean changeJob(String userName, String password, int level);

   public List<String> getUserList();
   
   public String changePassword(String old, String new1, String new2);
   
   public String changeLevel(String name, String pw, int level);
   
   public boolean userExists(String userName);
   
   public User getUser(String UserName, String pw);
   
   public void addUserToMap(User user);
   
   public Collection<User> getAllUsers();
   
   public String getUserName();
   
   public boolean checkPassword(String pw);
   
   public boolean sendToDB(IInquiry inquiry);
   
   public void testSave();
}
