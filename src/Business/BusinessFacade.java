/*
 * To change this license header, choose License Headers in Project Properties.
 
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import java.util.Collection;
import java.util.List;
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

    //Data layer injection
    @Override
    public void injectionDataPersistens(IDataPersistens dataPersistens) {
        this.dataPersistens = dataPersistens;
    }
    
    @Override
    public void injectLoginPersistens(ILoginPersistens loginPersistens) {
        this.loginPersistens = loginPersistens;
    }

    public BusinessFacade() {
        manager = new UserManager();
    }

    private UserManager manager; // Delegate all calls conserning users to the manager.

    @Override
    public String createUser(String userName, String password1, String password2) {
        userOperations.createUser(userName, password1, password2);
        return "Complete";
    }

    @Override
    public int login(String name, String pw) {
        return manager.login(name, pw);
    }

    @Override
    public void logOut() {
        manager.logOut();
    }

    @Override
    public List<String> getUserList() {
        return manager.getUserList();
    }

    @Override
    public String changePassword(String old, String new1, String new2) {
        return manager.changePw(old, new1, new2);
    }

    @Override
    public String changeLevel(String name, String pw, int level) {
        return manager.changeLevel(name, pw, level);
    }

    private UserOperations operations;

    @Override
    public boolean userExists(String userName) {
        return operations.userExists(userName);
    }

    @Override
    public IUser getUser(String UserName, String pw) {
        return operations.getUser(UserName, pw);
    }
    
    private User user;
    
    @Override
    public String getUserName(){
        return user.getUserName();
    }
    
    @Override
    public boolean checkPassword(String pw){
        return user.checkPassword(pw);
    }

    @Override
    public void addUser(String userName, String password) {
        loginPersistens.addUser(userName, password);
    }

    @Override
    public Collection<User> getAllUsers() {
        return operations.getAllUsers();
    }

}
