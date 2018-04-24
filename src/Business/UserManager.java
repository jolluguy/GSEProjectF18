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

    public boolean addUser(String name, String pw, int level) {
        // Hvis der allerede er en user med brugernavnet 'name' returneres 'false'
        // Ellers oprettes ny bruger som gemmes og der returneres 'true'
        if (!UserOperations.getInstance().userExists(name)) {
            UserOperations.getInstance().addUserToMap(new User(name, pw, level));
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
            return "Password er forkert!";
        }
        if (!newPw1.equals(newPw2)) {
            return "Password matcher ikke!";
        }
        currentUser.changePassWord(newPw2);
        UserOperations.getInstance().saveUser(currentUser);
        return "Password opdateret";
    }

    public String changeLevel(String name, String pw, int level) {
        User user = UserOperations.getInstance().getUser(name, pw);

        if (!UserOperations.getInstance().userExists(name)) {
            return "Bruger eksisterer ikke!";
        }

        if (user == currentUser) {
            return "Ændring ikke tilladt!";
        }

        if (level == user.getLevel()) {
            return ("Bruger " + user.getUser() + " har allerede level " + level);
        }

        user.setLevel(level);
        UserOperations.getInstance().saveUser(user);

        return (user.getUser() + " har nu level " + user.getLevel());
    }
}
