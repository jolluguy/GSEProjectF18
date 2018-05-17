/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IAdmin;
import Acquaintance.IJob;
import Acquaintance.IUser;
import java.util.Collection;
import java.sql.Timestamp;

/**
 *
 * @author Rasmus
 */
public class Admin extends Job implements IAdmin {

    private BusinessFacade facade = BusinessFacade.getInstance();

    private static Admin instance = null;
    
//    private Admin(){
//        
//    }
//    public static Admin getInstance(){
//        if (instance == null) {
//            instance = new Admin();
//        }
//        return instance;
//    }

    public Admin(int ID, int accessLevel, int departmentID, String departmentName) {
        super(ID, accessLevel, departmentID, departmentName);
    }
    
    @Override
    public boolean createUser(String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
        if (password1.equals(password2)) {
            return facade.addUser( new User(firstName, lastName, userName, password2, active, lastName, ID, accessLevel, ID, lastName, createdTime, lastLoginTime));
        } else {
            return false;
        }
    }
    
    @Override
    public boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        IUser user = facade.getUser(userName);
        user.setJob(jobTitle, ID, accessLevel, departmentID, departmentName); //Parsing IJob to job... Might give some problems.
        return facade.updateJob(user);
    }
    


    @Override
    public Collection<IUser> getUserList() {
        
        return facade.getAllUsers();
        
//        ArrayList<IUser> tempList = new ArrayList<>();
//        for(IUser i : facade.getAllUsers()){
//            tempList.add(new User(i.getUserName(), i.getPassword(), i.getActive(), i.getCreatedTime(), i.getLastLoginTime()));
//        }
//            
//        return tempList;
    }
    
    
}
