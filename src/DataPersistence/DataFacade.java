/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICase;
import Acquaintance.IInquiry;
import Acquaintance.IDataPersistence;

/**
 *
 * @author Alexa
 */
public class DataFacade implements IDataPersistence {
    
    private static DataFacade instance;
    private CaseDatabaseManager caseDatabase = new CaseDatabaseManager();
    
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
        return caseDatabase.saveInquiry(inquiry);
    }
    
    @Override
    public boolean saveCase(ICase case1) {
        return caseDatabase.saveCase(case1);
    }
    
}
