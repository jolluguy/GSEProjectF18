/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IUser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alexa
 */
public class Operations implements Serializable {

    protected Map<String, DataUser> userMap; //String = IUser.getUserName;
    protected List<DataUser> tempUserList; //Only for loading in users from DB;
    private DataUser user;
    DatabaseManager database = new DatabaseManager();

//    private Map getMap() {
//        System.out.println("getMap called");
//        
//        userMap = new HashMap<>();
//
//        for (DataUser user : tempUserList) {
//            userMap.put(user.getUserName(), user);
//        }
//        System.out.println("tempUserList = " + tempUserList.toString());
//        System.out.println("userMap = " + userMap.toString());
//        
//        return userMap;
//    }

//    private void saveMap() {  // Called every time a user is created/updated
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
//            oos.writeObject(userMap);
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

//    public boolean addUser(IUser user) {    // kan ikke bruges som den er til at tilfæje ny bruger da den ikke opretter map
//        getMap();
//
////        saveMap();
////        String firstName = user.getFirstName();
////        String lastName = user.getLastName();
////        String phoneNumber = user.getPhoneNumber();
////        String mail = user.getMail();
////        String username = user.getUserName();
////        String password = user.getPassword();
////        int level = user.getLevel();
////        Timestamp createdTime = user.getCreatedTime();
////        Timestamp lastLoginTime = user.getLastLoginTime();
////        database.createUserInDB(firstName, lastName, phoneNumber, mail, username, password, level, createdTime, lastLoginTime);
//
//        return true;
//    }

//    boolean updateUser(IUser user) {
//        getMap();
//        userMap.remove(user.getUserName());
//        userMap.put(user.getUserName(), new DataUser(user.getUserName(), user.getPassword(), user.getLevel(), user.getCreatedTime(), user.getLastLoginTime()));
////        saveMap();
//        return true;
//    }
    
//    boolean updateLastLoginTime(IUser user){
//        String username = user.getUserName();
//        return database.updateLastLogin(username);
//    }
    
//    boolean updateJob(IUser user){
//        String userName = user.getUserName();
//        int level = user.getLevel();
//        return database.updateJob(userName, level);
//    }

//    IUser getUser(String userName) {
//        getMap();
//        user = userMap.get(userName);
//
//        return user;
//    }

//    boolean isUserInMap(String userName) {
//        getMap();
//        if (userMap.containsKey(userName)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    
}
