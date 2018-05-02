
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IDataPersistens;
import Acquaintance.IInquiry;
import Acquaintance.ILoginPersistens;
import Acquaintance.IUser;
import java.util.Collection;

/**
 *
 * @author Alexa
 */
public class BusinessFacade implements IBusiness {

    private IDataPersistens dataPersistens;
    private ILoginPersistens loginPersistens;
      private BusinessController controller;
  private AccessManager manager; // Delegate all calls conserning users to the manager.
  private Admin admin;
  
    //BusinessLayer instance
    private static BusinessFacade instance = null;
    public static BusinessFacade getInstance(){
        if(instance == null){
            instance = new BusinessFacade();
        } 
        return instance;
    }
    
    //Data-layer injection

    @Override
    public void injectionDataPersistens(IDataPersistens dataPersistens) {
        this.dataPersistens = dataPersistens;
    }
    //Data-layer injection
    @Override
    public void injectLoginPersistens(ILoginPersistens loginPersistens) {
        this.loginPersistens = loginPersistens;
    }

    @Override
    public void initiater(){
      manager = new AccessManager();
      admin = new Admin();
    }

   
    
    @Override
    public int login(String userName, String pw) {
        return manager.login(userName, pw);
    }

    @Override
    public void logOut() { //later: Need to return true before scenechange
        manager.logOut();
    }
    

    public void getMap() {
        loginPersistens.getMap();
    }

    public IUser getUser(String userName) {
        return loginPersistens.getUser(userName);
    }
    
    
    
    @Override
    public boolean createUser(String userName, String password1, String password2, int level){
        return admin.createUser(userName, password1, password2, level);
    }
    
    @Override
    public boolean changeJob(String userName, String password, int level){
        return admin.changeJob(userName, password, level);
    }


    public boolean addUser(IUser user) {
        return loginPersistens.addUser(user);
    }


    public boolean updateUser(IUser user) {
        return loginPersistens.updateUser(user);
    }
    
    public Collection<IUser> getUserList(){
        return admin.getUserList();
    }
 
    Collection<IUser> getAllUsers(){
        return loginPersistens.getAllUsers();
    }
    

    
      
    @Override
    public boolean sendToDB(IInquiry inquiry) {
        controller = new BusinessController();
        return controller.sendToDB(inquiry); // kaldt fra GUI
    }
    
    public boolean saveInq(IInquiry inq) {
        return dataPersistens.saveInq(inq); // kaldt fra Controller
    }
    @Override
    public void testSave(){
        controller = new BusinessController();
        controller.testSave();
    }
}