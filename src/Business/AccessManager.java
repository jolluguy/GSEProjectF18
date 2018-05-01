/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;

public class AccessManager{

    private static BusinessFacade facade = BusinessFacade.getInstance();
    
    private IUser userOne = null; //userOne due to future plans of multiple user access at once

    public AccessManager() {
    }

    public int login(String userName, String pw) {
        System.out.println("Accessmanager login entered");
        IUser daUs = facade.getUser(userName); //Parsing User due to IUser return
        User checkUser = new User(daUs.getUserName(), daUs.getPassword(), daUs.getLevel(), daUs.getCreatedTime(), daUs.getLastLoginTime());
        if (userOne == null) {
            if(checkUser.checkPassword(pw)){
                userOne = checkUser;
                userOne.setLastLoginTime();
                if(facade.updateUser(userOne)){
                    return userOne.getLevel();
                }
            }
        }
        return 0;
    }

    public void logOut() {
        userOne = null;
    }

//    public boolean addUser(String name, String pw, int level) {
//        // Hvis der allerede er en user med brugernavnet 'name' returneres 'false'
//        // Ellers oprettes ny bruger som gemmes og der returneres 'true'
//        if (!UserOperations.getInstance().userExists(name)) {
//            UserOperations.getInstance().addUserToMap(new User(name, pw, level));
//            return true;
//        } else {
//            return false;
//        }
//
//    }

//      public List<String> getUserList() {
//
//        Collection<User> users = UserOperations.getInstance().getAllUsers();
//        List<String> list = new LinkedList<>();
//        Iterator<User> it = users.iterator();
//        while (it.hasNext()) {
//            list.add(it.next().toString());
//        }
//
//        return list;
//    }

//    public String changePw(String oldPw, String newPw1, String newPw2) {
//
//        if (!userOne.checkPassword(oldPw)) {
//            return "Password er forkert!";
//        }
//        if (!newPw1.equals(newPw2)) {
//            return "Password matcher ikke!";
//        }
//        userOne.changePassword(newPw2);
//        UserOperations.getInstance().saveUser(userOne);
//        return "Password opdateret";
//    }

//    public String changeLevel(String name, String pw, int level) {
//        User user = UserOperations.getInstance().getUser(name, pw);
//
//        if (!UserOperations.getInstance().userExists(name)) {
//            return "Bruger eksisterer ikke!";
//        }
//
//        if (user == userOne) {
//            return "Ændring ikke tilladt!";
//        }
//
//        if (level == user.getLevel()) {
//            return ("Bruger " + user.getUserName() + " har allerede level " + level);
//        }
//
//        user.setLevel(level);
//        UserOperations.getInstance().saveUser(user);
//
//        return (user.getUserName() + " har nu level " + user.getLevel());
//    }
}
