/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author Alexa
 */
public interface IBusiness {

    void injectionDataPersistens(IDataPersistens dataPersistens);

    void injectLoginPersistens(ILoginPersistens loginPersistens);

    
    
    int login(String name, String pw);

    void logOut();
    
     public void initiater();

//    public void getMap();
//    
//    public boolean addUser(IUser user);
//
//    public boolean updateUser(IUser user);


}
