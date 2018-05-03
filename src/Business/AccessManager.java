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

    public AccessManager() {
    }

    public int login(String userName, String pw) {
        int level = -1;
        IUser daUs = facade.getUser(userName); //Parsing User due to IUser return
        User checkUser = new User(daUs.getUserName(), daUs.getPassword(), daUs.getLevel(), daUs.getCreatedTime(), daUs.getLastLoginTime());

        if (checkUser.checkPassword(pw)) {
            userOne = checkUser;
            userOne.setLastLoginTime();
            if (facade.updateUser(userOne)) {
                level = userOne.getLevel();
            }
        }
        return level;
    }

    public void logOut() {
        userOne = null;
        System.out.println(userOne.toString());
    }

    public boolean checkCredentials(String userName, String password) {
        if (facade.getUserInfo(userName)) {
            IUser user = facade.getUser(userName);
            if (user.getPassword().equals(password)) {

                return true;
            }

        }

        return false;
    }
}
