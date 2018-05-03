package Business;

import Acquaintance.ICPR;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goope
 */
public class CPR implements ICPR {
    private long CPRNumber;
    
    CPR (long CPRNumber) {
        this.CPRNumber = CPRNumber;
    }

    @Override
    public long getCprNumber() {
        return CPRNumber;
    }

    @Override
    public void setCprNumber(long cprNumber) {
        this.CPRNumber = cprNumber;
    }
    
    @Override
    public boolean validateCPR() {
        long elevenDigitMin, tenDigitMin;
        elevenDigitMin = (long)Math.pow(10, 10);
        tenDigitMin = 1000000000;
        
        return (this.CPRNumber < elevenDigitMin && this.CPRNumber >= tenDigitMin);
    }
}
