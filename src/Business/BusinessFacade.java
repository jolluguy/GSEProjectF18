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

    private UserOperations userOperations;

    //BusinessLayer instance
    private static BusinessFacade instance = null;
    static BusinessFacade getInstance(){
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

    public BusinessFacade() {
        manager = new AccessManager();
    }

    private AccessManager manager; // Delegate all calls conserning users to the manager.

    
    @Override
    public int login(String userName, String pw) {
        System.out.println("login businessfacade entered after gui");
        return manager.login(userName, pw);
    }

    @Override
    public void logOut() { //later: Need to return true before scenechange
        manager.logOut();
    }
    
    @Override
    public void getMap() {
        loginPersistens.getMap();
    }

    public IUser getUser(String userName) {
        System.out.println("getUser entered businessfacade");
        return loginPersistens.getUser(userName);
    }

    @Override
    public boolean addUser(IUser user) {
        return loginPersistens.addUser(user);
    }

    @Override
    public boolean updateUser(IUser user) {
        return loginPersistens.updateUser(user);
    }

    

}
