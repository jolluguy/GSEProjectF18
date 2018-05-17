/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.ICaseWorker;
import Acquaintance.IUser;
import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public class DataCaseWorker extends DataJob implements ICaseWorker {
    
    public DataCaseWorker(int ID, int accessLevel, int departmentID, String departmentName) {
        super(ID, accessLevel, departmentID, departmentName);
    }

    @Override
    public Collection<IUser> getUserList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
