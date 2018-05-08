
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
import Acquaintance.ILoginPersistence;

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
        this.admin = admin.getInstance();
    }

    @Override
    public int login(String userName, String pw) {
        return manager.login(userName, pw);
    }

    @Override
    public void logOut() { //later: Need to return true before scenechange
        manager.logOut();
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
    public boolean createUser(String userName, String password1, String password2, int level) {
        return admin.createUser(userName, password1, password2, level);
    }

    @Override
    public boolean changeJob(String userName, String password, int level) {
        return admin.changeJob(userName, password, level);
    }

    public boolean addUser(IUser user) {
        return loginPersistence.addUser(user);
    }

    public boolean updateUser(IUser user) {
        return loginPersistence.updateUser(user);
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
