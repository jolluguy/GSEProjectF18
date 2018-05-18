/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IAdmin;
import Acquaintance.IDepartment;
import Acquaintance.IJob;
import Acquaintance.IUser;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public class DataJob implements IJob {
    
    private LoginDatabaseManager loginDatabase;
    private String JobTitle;
    private int ID;
    private int accessLevel;
    private IDepartment department;
    

    /**
     * this is used when getting or creating users
     * @param jobTitle
     * @param ID
     * @param accessLevel
     * @param departmentID
     * @param departmentName 
     */
    public DataJob(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        this.JobTitle = jobTitle;
        this.ID = ID;
        this.accessLevel = accessLevel;
        this.department = new DataDepartment(departmentID, departmentName);
    }
    
    /**
     * this is used when sending a joblist to the GUI
     * @param jobTitle
     * @param ID
     * @param accessLevel 
     */
    public DataJob(String jobTitle, int ID, int accessLevel) {
        this.JobTitle = jobTitle;
        this.ID = ID;
        this.accessLevel = accessLevel;
        this.department = null;
    }


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }

//    public boolean createUser(String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
//        if (password1.equals(password2)) {
//            return loginDatabase.createUserInDB(new DataUser(firstName, lastName, userName, password2, active, lastName, ID, accessLevel, ID, lastName, createdTime, lastLoginTime));
//        } else {
//            return false;
//        }
//    }
//    
//    @Override
//    public boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName){
//        IUser user = loginDatabase.getUser(userName);
//        user.setJob(jobTitle, ID, accessLevel, departmentID, departmentName);
//        return loginDatabase.updateJob(user);
//    }
//
//    @Override
//    public Collection<IUser> getUserList() {
//        return loginDatabase.getAllUsers();
//    }

//    @Override
//    public String getJob() {
//        this.jobTitle;
//    }

    @Override
    public String getJobTitle() {
        return this.JobTitle;
    }

    @Override
    public IDepartment getDepartment() {
        return this.department;
    }
    
}
