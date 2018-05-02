/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IGUI;
import Business.BusinessFacade;
import DataPersistens.DataFacade;
import semesterlogin.GUIFacade;
import Acquaintance.IDataPersistens;
import Acquaintance.ILoginPersistens;
import LoginPersistens.LoginFacade;

/**
 *
 * @author Alexa
 */
public class Starter {
    
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        IGUI gui = GUIFacade.getInstance();
        IBusiness business = BusinessFacade.getInstance();
        business.startUp();
        IDataPersistens dataPersistens = new DataFacade();
        ILoginPersistens loginPersistens = new LoginFacade();
        business.injectLoginPersistens(loginPersistens);
        business.injectionDataPersistens(dataPersistens);
        gui.injectBusiness(business);
        
        System.out.println("Ready to start system");
        gui.startApplication(args);
    }
    
}
