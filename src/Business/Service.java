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

    public Service(int serviceID, String serviceString) {
        this.seviceID = serviceID;
        this.serviceDescription = serviceString;
    }

    public int getSeviceID() {
        return seviceID;
    }
    public String getServiceDescription() {
        return serviceDescription;
    }

    @Override
    public int getServiceID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
}
