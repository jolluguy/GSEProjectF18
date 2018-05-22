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
class CPR implements ICPR {
    private String CPRNumber;
    
    CPR (String CPRNumber) {
        this.CPRNumber = CPRNumber;
    }

    @Override
    public String getCprNumber() {
        return CPRNumber;
    }
}