/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICPR;

/**
 *
 * @author Rasmus
 */
class DataCPR implements ICPR {
     private String cprNumber;
     
    public DataCPR(String cprNumber) {
        this.cprNumber = cprNumber;
    }
    
    @Override
    public String getCprNumber() {
        return cprNumber;
    }    
}
