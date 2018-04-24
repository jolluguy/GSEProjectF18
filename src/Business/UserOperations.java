/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

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
public class UserOperations {
    
    private static UserOperations instance = null;
    private Map<String, User> userMap;
    private File file = new File("UserSetFile.obj");

    private UserOperations() {
        if (!file.exists()) {
            userMap = new HashMap<>();
            addUserToMap(new User("Admin", "Super", 2));// Default SuperUser
            saveMap();
        }
        else{
            readMap();
        }
    }

    public static UserOperations getInstance() {
        if (instance == null) {
            instance = new UserOperations();
        }
        return instance;
    }

    // private methods to read and write a whole Map.

    private void saveMap() {  // Called every time a user is created/updated/deleted
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

    private void readMap() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Object obj = ois.readObject();
            userMap = (Map<String, User>) obj;

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

    // public I/O operations:
    public boolean userExists(String userName){
        return userMap.containsKey(userName);
    }
    
    public User getUser(String userName, String pw) {
        User user = userMap.get(userName);
        if(user != null && user.checkPassWord(pw)){
            return user;
        }
        return null;
    }

    public void addUserToMap(User user) {
        userMap.put(user.getUserName(), user);
        saveMap();
    }
    
    public Collection<User> getAllUsers(){
        return userMap.values();
    }

    public void saveUser(User user) {
        userMap.put(user.getUserName(), user);
        saveMap();
    }
    
}
