/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alexa
 */
public class Operations implements Serializable {

    protected Map<String, DataUser> userMap; //String = IUser.getUserName;
    protected List<DataUser> tempUserList; //Only for loading in users from DB;
    private final File file = new File("UserSetFile.obj");
    private DataUser user;
    DatabaseManager database = new DatabaseManager();

    private Map getMap() {
        System.out.println("getMap called");
        tempUserList = database.getAllUsers();
        
        userMap = new HashMap<>();

        for (DataUser user : tempUserList) {
            userMap.put(user.getUserName(), user);
        }
        System.out.println("tempUserList = " + tempUserList);
        System.out.println("userMap = " + userMap);
        
        return userMap;

//        if (!file.exists()) {
//            userMap = new HashMap<>();
//            userMap.put("admin", new DataUser("admin", "Super", 2, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()))); // Default SuperUser
//            saveMap();
//        } else {
//            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//                Object obj = ois.readObject();
//                userMap = (Map<String, DataUser>) obj;
//
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            } catch (ClassNotFoundException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return userMap;
    }

    private void saveMap() {  // Called every time a user is created/updated
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(userMap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addUser(IUser user) {    // kan ikke bruges som den er til at tilfæje ny bruger da den ikke opretter map
        getMap();

        saveMap();
        String username = user.getUserName();
        String password = user.getPassword();
        int level = user.getLevel();
        Timestamp createdTime = user.getCreatedTime();
        Timestamp lastLoginTime = user.getLastLoginTime();
        database.createUserInDB(username, password, level, createdTime, lastLoginTime);

        return true;
    }

    boolean updateUser(IUser user) {
        getMap();
        userMap.remove(user.getUserName());
        userMap.put(user.getUserName(), new DataUser(user.getUserName(), user.getPassword(), user.getLevel(), user.getCreatedTime(), user.getLastLoginTime()));
        saveMap();
        return true;
    }

    IUser getUser(String userName) {
        getMap();
        user = userMap.get(userName);

        return user;
    }

    boolean isUserInMap(String userName) {
        getMap();
        if (userMap.containsKey(userName)) {
            return true;
        } else {
            return false;
        }
    }

    Collection<IUser> getAllUsers() {
        Collection<IUser> col = new ArrayList<>();
        getMap();
        for (DataUser i : userMap.values()) {
            col.add(i);

        }
        return col;
    }
}
