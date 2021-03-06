/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IDepartment;
import Acquaintance.IJob;
import Acquaintance.IUser;
import java.io.Serializable;
import java.util.Collection;
import Acquaintance.ILoginPersistence;
import java.sql.SQLException;

/**
 *
 * @author Rol's studie PC
 */
public class LoginFacade implements ILoginPersistence, Serializable {

    private LoginDatabaseManager database = new LoginDatabaseManager();

    private static LoginFacade instance = null;

    private LoginFacade() {

    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void pingDatabase() throws SQLException {

        database.pingDatabase();
    }

    public static LoginFacade getInstance() {
        if (instance == null) {
            instance = new LoginFacade();
        }
        return instance;
    }

    @Override
    public IUser getUser(String userName) {

        return database.getUser(userName);
    }

    @Override
    public boolean addUser(IUser user) {

        return database.createUserInDB(user);
    }

    @Override
    public boolean updateLastLoginTime(IUser user) {

        return database.updateLastLogin(user);
    }

    @Override
    public boolean updateJob(IUser user) {

        return database.updateJob(user);
    }

    @Override
    public Collection<IUser> getAllUsers() {

        return database.getAllUsers();
    }

    @Override
    public Collection<IJob> getJobList() {
        return database.getJobList();
    }

    @Override
    public Collection<IDepartment> getDepartmentList() {
        return database.getDepartmentList();
    }

    @Override
    public boolean doesUserExist(String userName) {
        return database.doesUserExist(userName);
    }

    @Override
    public IUser getUser(int userID) {
        return database.getUser(userID);
    }

    @Override
    public void updatePassword(IUser user) {
        database.updatePassword(user);
    }

}
