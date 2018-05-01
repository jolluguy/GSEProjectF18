/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.IUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexa
 */
public class Operations implements Serializable {

    protected Map<String, DataUser> userMap; //String = IUser.getUserName;
    private final File file = new File("UserSetFile.obj");
    private DataUser user;

    Map getMap() {
        if (!file.exists()) {
            userMap = new HashMap<>();
            addUser(new DataUser("Admin", "Super", 2, new Date(), new Date())); // Default SuperUser
            saveMap();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                userMap = (Map<String, DataUser>) obj;

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return userMap;
    }

    private void saveMap() {  // Called every time a user is created/updated/deleted
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(userMap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addUser(IUser user) {    // kan ikke bruges som den er til at tilfæje ny bruger da den ikke opretter map
        userMap.put(user.getUserName(), (DataUser) user);
        saveMap();
        return true;
    }

    private void saveUser(IUser user) {
        getMap();
        userMap.put(user.getUserName(), (DataUser) user);
        saveMap();
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

}
