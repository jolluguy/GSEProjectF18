/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IService;

/**
 *
 * @author Rasmus
 */
public class Service implements IService {
    
    int seviceID;
    String serviceDescription;

    public Service(int serviceID) {
        this.seviceID = serviceID;
        this.serviceDescription = getServiceDescription(serviceID);
    }

    private String getServiceDescription(int serviceID) {
        throw new UnsupportedOperationException("Not supported yet."); // incert code here that take the service id and returns the service id from wherever it is stored.... maby a hashmap???? make catalouge class again?
    }

    public int getSeviceID() {
        return seviceID;
    }
    public String getServiceDescription() {
        return serviceDescription;
    }
    
     
}
