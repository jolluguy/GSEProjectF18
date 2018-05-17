/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IGUI;
import Business.BusinessFacade;
import DataPersistence.DataFacade;
import Presentation.GUIFacade;
import LoginPersistence.LoginFacade;
import Acquaintance.IDataPersistence;
import Acquaintance.ILoginPersistence;

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
        IDataPersistence dataPersistens = DataFacade.getInstance();
        ILoginPersistence loginPersistens = LoginFacade.getInstance();
        business.injectLoginPersistence(loginPersistens);
        business.injectDataPersistence(dataPersistens);
        gui.injectBusiness(business);
        
        System.out.println("Ready to start system");
        gui.startApplication(args);
    }
    
}
