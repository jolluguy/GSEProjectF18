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
public class CPR implements ICPR{
    private int CPRNumber;
    
    CPR (int CPRNumber) {
        this.CPRNumber = CPRNumber;
    }

    @Override
    public int getCprNumber() {
        return CPRNumber;
    }

    @Override
    public void setCprNumber(int cprNumber) {
        this.CPRNumber = cprNumber;
    }
}
