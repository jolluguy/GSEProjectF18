/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;

public class AccessManager {

    private static BusinessFacade facade = BusinessFacade.getInstance();

    private IUser userOne = null; //userOne due to future plans of multiple user access at once

    private static AccessManager instance = null;

    public static AccessManager getInstance() {
        if (instance == null) {
            instance = new AccessManager();
        }
        return instance;
    }

//    public int login(String userName, String pw) {
//        int access = -1;
//        IUser user = facade.getUser(userName); //Parsing User below due to IUser return
//        User checkUser = new User(user.getUserName(), user.getPassword(), user.getActive(), user.getCreatedTime(), user.getLastLoginTime());
//
//        if (checkUser.checkPassword(pw)) {
//            userOne = checkUser;
//            if (facade.updateLastLoginTime(userOne)) {
//                access = facade.getAccess(checkUser.getUserName());
//            }
//        }
//        return access;
//    }

//    public void logOut() {
//        userOne = null;
//    }

//    public boolean checkCredentials(String userName, String password) {
//        IUser user = facade.getUser(userName);
//        if (user.getPassword().equals(password)) {
//            return true;
//        }
//
//        return false;
//    }

    public boolean changePassword(String oldPassword, String newPassword1, String newPassword2) {
        if (oldPassword.equals(userOne.getPassword())) {
            if (newPassword1.equals(newPassword2)) {
                userOne.changePassword(newPassword1);
                return true;
            }
        }
        return false;
    }

//    public IUser getUserOne() {
//        return userOne;
//    }

}
