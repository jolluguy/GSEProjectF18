/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IDepartment;
import Acquaintance.IJob;

/**
 *
 * @author Rasmus
 */
public abstract class Job implements IJob {    
    private int ID;
    private int accessLevel;
    private Department department;

    public Job(int ID, int accessLevel, int departmentID, String departmentName) {
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
    public IDepartment getDepartment() {
        return this.department;
    }
    
}
