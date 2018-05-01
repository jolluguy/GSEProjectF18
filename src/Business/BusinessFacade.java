/*
 * To change this license header, choose License Headers in Project Properties.
 
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IDataPersistens;
import Acquaintance.ILoginPersistens;
import Acquaintance.IUser;

/**
 *
 * @author Alexa
 */
public class BusinessFacade implements IBusiness {

    private IDataPersistens dataPersistens;
    private ILoginPersistens loginPersistens;


  private AccessManager manager; // Delegate all calls conserning users to the manager.
  
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
    }

    

    
    @Override
    public int login(String userName, String pw) {
        System.out.println("login businessfacade entered after gui");
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
        System.out.println("getUser entered businessfacade");
        return loginPersistens.getUser(userName);
    }


    public boolean addUser(IUser user) {
        return loginPersistens.addUser(user);
    }


    public boolean updateUser(IUser user) {
        return loginPersistens.updateUser(user);
    }

    

}
