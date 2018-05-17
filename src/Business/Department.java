/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IDepartment;

/**
 *
 * @author Rol's studie PC
 */
public class Department implements IDepartment {
    
    int departmentID;
    String departmentName;

    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    @Override
    public int getDepartmentID() {
        return departmentID;
    }

    @Override
    public String getDepartmentName() {
        return departmentName;
    }
    
    
    
}
