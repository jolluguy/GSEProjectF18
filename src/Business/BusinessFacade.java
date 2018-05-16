
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IInquiry;
import Acquaintance.IUser;
import java.util.Collection;
import Acquaintance.IDataPersistence;
import Acquaintance.IJob;
import Acquaintance.ILoginPersistence;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Alexa
 */
public class BusinessFacade implements IBusiness {

    private IDataPersistence dataPersistence;
    private ILoginPersistence loginPersistence;
    private BusinessManager controller;
    private AccessManager manager; // Delegate all calls conserning users to the manager.
    private Admin admin;

    //BusinessLayer instance
    private static BusinessFacade instance = null;

    private BusinessFacade() {
        
    }
    
    public static BusinessFacade getInstance() {
        if (instance == null) {
            instance = new BusinessFacade();
        }
        return instance;
    }
    
    public void pingDatabase() throws SQLException {
        loginPersistence.pingDatabase();
    }

    //Data-layer injection
    @Override
    public void injectDataPersistence(IDataPersistence dataPersistence) {
        this.dataPersistence = dataPersistence;
    }

    //Data-layer injection
    @Override
    public void injectLoginPersistence(ILoginPersistence loginPersistence) {
        this.loginPersistence = loginPersistence;
    }

    @Override
    public void startUp() {
        this.controller = controller.getInstance();
        this.manager = manager.getInstance();
    }

    @Override
    public int login(String userName, String password) {
        return manager.login(userName, password);
    }
    
    @Override
    public int getAccess(String userName) {
        return loginPersistence.getAccess(userName);
    }

    @Override
    public void logOut() { //later: Need to return true before scenechange
        manager.logOut();
    }
    
    @Override
    public boolean changePassword(String oldPassword, String newPassword1, String newPassword2){
        return manager.changePassword(oldPassword, newPassword1, newPassword2);
    }
    
    public IUser getUserOne() {
        return manager.getUserOne();
    }

    @Override
    public boolean checkCredentials(String userName, String password) {
        return manager.checkCredentials(userName, password);
    }
    
    public boolean getUserInfo(String userName) {
        return loginPersistence.getUserInfo(userName);
    }
    public IUser getUser(String userName) {
        return loginPersistence.getUser(userName);
    }

    @Override
    public boolean createUser(int userID, String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
        return admin.createUser(firstName, lastName, userName, password1, password2, active, createdTime, lastLoginTime);
    }

    @Override
    public boolean changeJob(String userName, String password, IJob job) {
        return admin.changeJob(userName, password, job);
    }

    public boolean addUser(IUser user) {
        return loginPersistence.addUser(user);
    }

//    public boolean updateUser(IUser user) {
//        return loginPersistence.updateUser(user);
//    }
    
    public boolean updateLastLoginTime(IUser user){
        return loginPersistence.updateLastLoginTime(user);
    }
    
    public boolean updateJob(IUser user){
        return loginPersistence.updateJob(user);
    }

    @Override
    public Collection<IUser> getUserList() {
        return admin.getUserList();
    }

    Collection<IUser> getAllUsers() {
        return loginPersistence.getAllUsers();
    }

    @Override
    public boolean newInquiry(long cprNumber, String problemDescription, String firstName, String lastName, String roadName, String houseNumber,
            String floor, int postalCode, String city, String phoneNumber) {
        return controller.createInquiry(cprNumber, problemDescription, firstName, lastName, roadName, houseNumber,
                floor, postalCode, city, phoneNumber);
    }

    @Override
    public boolean sendToDB(IInquiry inquiry) {
        return controller.sendToDB(inquiry); // kaldt fra GUI
    }

    public boolean saveInq(IInquiry inquiry) {
        return dataPersistence.saveInquiry(inquiry); // kaldt fra Controller
    }

}
