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

    void injectionDataPersistens(IDataPersistens dataPersistens);

    void injectLoginPersistens(ILoginPersistens loginPersistens);

    int login(String name, String pw);

    void logOut();
    
    boolean checkCredentials(String userName);
    
    boolean createUser(String userName, String password1, String password2, int level);

    boolean changeJob(String userName, String password, int level);
    
    Collection<IUser> getUserList();
   
   public boolean sendToDB(IInquiry inquiry);
   
   public void startUp();
   
   boolean newInquery(long cprNumber, String problemDescription, String firstname, String surname, String roadName, String houseNumber,
                       String floor, int postNumber, String city, String tlfNumber);
}
