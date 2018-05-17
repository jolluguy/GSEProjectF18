/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author Alexa
 */
public interface IBusiness {

    void injectDataPersistence(IDataPersistence dataPersistence);

    void injectLoginPersistence(ILoginPersistence loginPersistence);

    int login(String name, String pw);
    
    int getAccess(String userName);

    void logOut();
    
    boolean changePassword(String oldPassword, String newPassword1, String newPassword2);
    
    IUser getUserOne();
    
    boolean checkCredentials(String userName, String password);
    
    boolean createUser(int userID, String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime);

    boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName);
    
    Collection<IUser> getUserList();
   
   public boolean sendToDB(IInquiry inquiry);
   
   public void startUp();
   
   boolean newInquiry(long cprNumber, String problemDescription, String firstName, String lastName, String roadName, String houseNumber,
                       String floor, int postalCode, String city, String phoneNumber);

   void pingDatabase() throws SQLException;

}
