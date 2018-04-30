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
     private long cprNumber;
     
    public DataCPR(long cprNumber) {
        this.cprNumber = cprNumber;
    }
    
    @Override
    public long getCprNumber() {
        return cprNumber;
    }

    @Override
    public void setCprNumber(long cprNumber) {
        this.cprNumber = cprNumber;
    }

    @Override
    public boolean validateCPR() {
        long elevenDigitMin, tenDigitMin;
        elevenDigitMin = (long)Math.pow(10, 10);
        tenDigitMin = 1000000000;
        
        return (this.cprNumber < elevenDigitMin && this.cprNumber >= tenDigitMin);
    }
    
}
