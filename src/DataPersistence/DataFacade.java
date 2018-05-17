/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.IInquiry;
import Acquaintance.IDataPersistence;

/**
 *
 * @author Alexa
 */
public class DataFacade implements IDataPersistence {
    
    private static DataFacade instance = null;
    
    private DataFacade() {
        
    }
    
    public static DataFacade getInstance(){
        if (instance == null) {
            instance = new DataFacade();
        }
        return instance;
    }
    
    @Override
    public boolean saveInquiry(IInquiry inquiry) {
        SaveInquiryCSV save = new SaveInquiryCSV(inquiry);
        return save.saveInquiry();
    }
    
}
