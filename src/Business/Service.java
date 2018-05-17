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
    
    int serviceID;
    String serviceDescription;

    public Service(int serviceID, String serviceString) {
        this.serviceID = serviceID;
        this.serviceDescription = serviceString;
    }


    @Override
    public String getServiceDescription() {
        return this.serviceDescription;
    }

    @Override
    public int getServiceID() {
        return this.serviceID;
    }
}
