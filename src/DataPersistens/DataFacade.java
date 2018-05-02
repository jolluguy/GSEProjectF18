/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistens;

import Acquaintance.IDataPersistens;
import Acquaintance.IInquiry;

/**
 *
 * @author Alexa
 */
public class DataFacade implements IDataPersistens {
    
    private static DataFacade instance = null;
    public static DataFacade getInstance(){
        return instance;
    }
    
    @Override
    public boolean saveInq(IInquiry inq) {
        SaveInquiryCSV save = new SaveInquiryCSV(inq);
        return save.saveInq();
    }
    
}
