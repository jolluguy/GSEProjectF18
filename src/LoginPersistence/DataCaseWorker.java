/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.ICaseWorker;
import Acquaintance.IDepartment;

/**
 *
 * @author Rol's studie PC
 */
public class DataCaseWorker extends DataJob implements ICaseWorker {
    
    public DataCaseWorker(int ID, int accessLevel, int departmentID, String departmentName) {
        super(ID, accessLevel, departmentID, departmentName);
    }

    @Override
    public IDepartment getDepartment() {
        return super.getDepartment();
    }
    
}
