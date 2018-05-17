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