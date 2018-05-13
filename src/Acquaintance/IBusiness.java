/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Alexa
 */
public interface IBusiness {

    void injectDataPersistence(IDataPersistence dataPersistence);

    void injectLoginPersistence(ILoginPersistence loginPersistence);

    int login(String name, String pw);

    void logOut();
    
    boolean changePassword(String oldPassword, String newPassword1, String newPassword2);
    
    IUser getUserOne();
    
    boolean checkCredentials(String userName, String password);
    
    boolean createUser(String firstName, String lastName, String userName, String password1, String password2, int level);

    boolean changeJob(String userName, String password, int level);
    
    Collection<IUser> getUserList();
   
   public boolean sendToDB(IInquiry inquiry);
   
   public void startUp();
   
   boolean newInquiry(long cprNumber, String problemDescription, String firstName, String lastName, String roadName, String houseNumber,
                       String floor, int postalCode, String city, String phoneNumber);
}
