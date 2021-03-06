/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public interface ILoginPersistence {
    
    IUser getUser(String userName);

    boolean addUser(IUser user);
    
//    boolean updateUser(IUser user);
    
    boolean updateLastLoginTime(IUser user);
    
    boolean updateJob(IUser user);
    
    Collection<IUser> getAllUsers();
    
    void pingDatabase() throws SQLException;

    public Collection<IJob> getJobList();

    public Collection<IDepartment> getDepartmentList();

    public boolean doesUserExist(String userName);

    public IUser getUser(int userID);

    public void updatePassword(IUser user);
}
