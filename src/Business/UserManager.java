/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UserManager {

    private User currentUser = null;

    public UserManager() {
        this.currentUser = currentUser;
    }

    public int login(String name, String pw) {

        User user = UserOperations.getInstance().getUser(name, pw);

        if (user != null) {
            user.setLastLoginTime(new Date());
            currentUser = user;
            UserOperations.getInstance().saveUser(currentUser);
            System.out.println("Current user is " + currentUser.getUser());
            System.out.println(currentUser);
            return user.getLevel();
        }

        return 0;
    }

    public void logOut() {
        currentUser = null;
    }

    public boolean addUser(String name, String pw1, int level) {
        // Hvis der allerede er en user med brugernavnet 'name' returneres 'false'
        // Ellers oprettes ny bruger som gemmes og der returneres 'true'
        if (!UserOperations.getInstance().userExists(name)) {
            UserOperations.getInstance().addUserToMap(new User(name, pw1, level));
            return true;
        } else {
            return false;
        }

    }

    public List<String> getUserList() {

        Collection<User> users = UserOperations.getInstance().getAllUsers();
        List<String> list = new LinkedList<>();
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            list.add(it.next().toString());
        }

        return list;
    }

    public String changePw(String oldPw, String newPw1, String newPw2) {

        if (!currentUser.checkPassWord(oldPw)) {
            return "Password is incorrect!";
        }
        if (!newPw1.equals(newPw2)) {
            return "New password not repeated";
        }
        currentUser.changePassWord(newPw2);
        UserOperations.getInstance().saveUser(currentUser);
        return "Password updated";
    }

    public String changeLevel(String name, String pw, int level) {
        User user = UserOperations.getInstance().getUser(name, pw);

        if (!UserOperations.getInstance().userExists(name)) {
            return "Error: Invalid entry";
        }

        if (user == currentUser) {
            return "Permission Not granted";
        }
        
        if(level == user.getLevel()){
            return ("User already has level " + level);
        }

        user.setLevel(level);
        UserOperations.getInstance().saveUser(user);
        System.out.println("UserLevel has been changed");

        return ("Level has been changed");
    }
}
