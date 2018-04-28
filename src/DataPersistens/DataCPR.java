/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistens;

import Acquaintance.ICPR;

/**
 *
 * @author Rasmus
 */
class DataCPR implements ICPR {
     private int cprNumber;
     
    public DataCPR(int cprNumber) {
        this.cprNumber = cprNumber;
    }
     @Override
    public int getCprNumber() {
        return cprNumber;
    }

     @Override
    public void setCprNumber(int cprNumber) {
        this.cprNumber = cprNumber;
    }


}
