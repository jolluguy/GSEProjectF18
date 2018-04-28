/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistens;

import Acquaintance.IUser;
import Business.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alexa
 */
public class Operations {

    protected Map<String, IUser> userMap;
    private File file = new File("UserSetFile.obj");

    protected void readMap() {
        if (!file.exists()) {
            userMap = new HashMap<>();
            addUser(new User("Admin", "Super", 2));// Default SuperUser
            saveMap();
        } else {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                Object obj = ois.readObject();
                userMap = (Map<String, IUser>) obj;

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    protected void saveMap() {  // Called every time a user is created/updated/deleted
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(userMap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected IUser getUser(String userName, String pw) {
        IUser user = userMap.get(userName);
        if (user != null && user.checkPassword(pw)) {
            return user;
        }
        return null;
    }

    public Collection<IUser> getAllUsers() {
        readMap(); //Updates userMap before sending info
        return userMap.values();
    }
    
    public void addUser(User user) {
        userMap.put(user.getUserName(), user);
        saveMap();
    }


    public void saveUser(IUser user) {
        userMap.put(user.getUserName(), user);
        saveMap();
    }

}
