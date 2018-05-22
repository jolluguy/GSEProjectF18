/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;
import java.util.Collection;

/**
 *
 * @author Rasmus
 */
class CaseWorker extends Job{

    CaseWorker(String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        super(jobTitle, ID, accessLevel, departmentID, departmentName);
    }

    @Override
    Collection<IUser> getUserList() {
        throw new UnsupportedOperationException("Not supported by this job.");
    }

    @Override
    boolean createUser(String firstName, String lastName, String userName, String password1, String password2, String jobtitle, int jobID, int accessLevel, int departmentID, String departmentName) {
        throw new UnsupportedOperationException("Not supported by this job.");
    }

    @Override
    boolean changeJob(String userName, boolean active, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        throw new UnsupportedOperationException("Not supported by this job.");
    }

}
