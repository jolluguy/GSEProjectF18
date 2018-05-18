/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IJob;
import Acquaintance.IUser;
import java.util.Collection;

/**
 *
 * @author Rasmus
 */
public abstract class Job implements IJob {

    private int ID;
    private int accessLevel;
    private Department department;
    private String jobTitle;
    

    public Job(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        this.jobTitle = jobTitle;
        this.ID = ID;
        this.accessLevel = accessLevel;
        this.department = new Department(departmentID, departmentName);

    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }
    
    @Override
    public String getJobTitle(){
        return this.jobTitle;
    
}

    @Override
    public  Department getDepartment() {
        return department;
    }

    abstract Collection<IUser> getUserList();

    abstract boolean createUser(String firstName, String lastName, String userName, String password1, String password2, String jobtitle, int jobID, int accessLevel, int departmentID, String departmentName);

    abstract boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName);
}
