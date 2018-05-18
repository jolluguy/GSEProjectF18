/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IJob;

/**
 *
 * @author Rasmus
 */
public abstract class Job implements IJob {

    int ID;
    int accessLevel;
    Department department;
    

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
    
    public String getJob(){
        String name = this.getClass().getSimpleName();
        if(name.contains("dmin")){
            return "Admin";
        }
        else if (name.contains("ase")){
        return "Sagsbahandler";
    }
        return null;
    
}
    
}
