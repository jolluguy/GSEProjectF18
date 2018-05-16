/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IUser;
import java.io.Serializable;
import java.util.Collection;
import Acquaintance.ILoginPersistence;

/**
 *
 * @author Rol's studie PC
 */
public class LoginFacade implements ILoginPersistence, Serializable {

    LoginDatabaseManager database;

    private static LoginFacade instance = null;

    private LoginFacade() {

    }

    public static LoginFacade getInstance() {
        if (instance == null) {
            instance = new LoginFacade();
        }
        return instance;
    }

    @Override
    public IUser getUser(String userName) {
        database = new LoginDatabaseManager();
        return database.getUser(userName);
    }

    @Override
    public boolean addUser(IUser user) {
        database = new LoginDatabaseManager();
        return database.createUserInDB(user);
    }
    
    @Override
    public boolean updateLastLoginTime(IUser user){
        database = new LoginDatabaseManager();
        return database.updateLastLogin(user);
    }
    
    @Override
    public boolean updateJob(IUser user){
        database = new LoginDatabaseManager();
        return database.updateJob(user);
    }

    @Override
    public Collection<IUser> getAllUsers() {
        database = new LoginDatabaseManager();
        return database.getAllUsers();
    }

    @Override
    public boolean getUserInfo(String userName) {
        database = new LoginDatabaseManager();
        return database.doesUserExist(userName);
    }

}
