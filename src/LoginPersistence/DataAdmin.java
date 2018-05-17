/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPersistence;

import Acquaintance.IAdmin;
import Acquaintance.IDepartment;
import Acquaintance.IUser;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author Rol's studie PC
 */
public class DataAdmin extends DataJob implements IAdmin {
    
    private LoginDatabaseManager loginDatabase;

    public DataAdmin(int ID, int accessLevel, int departmentID, String departmentName) {
        super(ID, accessLevel, departmentID, departmentName);
    }
    
    @Override
    public boolean createUser(String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
//        if (password1.equals(password2)) {
//            return loginDatabase.createUserInDB(new DataUser(firstName, lastName, userName, password2, active, , super.getID(), super.getAccessLevel(), super.getDepartment().getDepartmentID(), super.getDepartment().getDepartmentName(), createdTime, lastLoginTime));
//        } else {
            return false;
//        }
    }
    
    @Override
    public boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName){
        IUser user = loginDatabase.getUser(userName);
        user.setJob(jobTitle, ID, accessLevel, departmentID, departmentName);
        return loginDatabase.updateJob(user);
    }

    @Override
    public Collection<IUser> getUserList() {
        return loginDatabase.getAllUsers();
    }

    @Override
    public IDepartment getDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
