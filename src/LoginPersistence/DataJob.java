/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IDepartment;
import Acquaintance.IJob;

/**
 *
 * @author Rol's studie PC
 */
class DataJob implements IJob {
    
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
    DataJob(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
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
    DataJob(String jobTitle, int ID, int accessLevel) {
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

    @Override
    public String getJobTitle() {
        return this.JobTitle;
    }

    @Override
    public IDepartment getDepartment() {
        return this.department;
    }
    
}
