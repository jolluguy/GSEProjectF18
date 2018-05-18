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
public abstract class DataJob implements IJob {
    
    private int ID;
    private int accessLevel;
    private IDepartment department;
    

    public DataJob(int ID, int accessLevel, int departmentID, String departmentName) {
        this.ID = ID;
        this.accessLevel = accessLevel;
        this.department = new DataDepartment(departmentID, departmentName);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }
    
}
