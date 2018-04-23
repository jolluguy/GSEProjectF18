/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IGUI;
import Business.BusinessFacade;
import Data.DataFacade;
import semesterlogin.SemesterLogin;

/**
 *
 * @author Alexa
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IGUI gui = new SemesterLogin();
        IBusiness business = new BusinessFacade();
        IData data = new DataFacade();
        business.injectionData(data);
        gui.injectBusiness(business);
        
        System.out.println("Ready to start system");
        System.out.println("Not");
        gui.startApplication(args);
    }
    
}
