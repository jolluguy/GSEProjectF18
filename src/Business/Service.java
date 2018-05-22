package Business;

import Acquaintance.IService;

/**
 *
 * @author Rasmus
 */
class Service implements IService {
    
    int serviceID;
    String serviceDescription;

    Service(int serviceID, String serviceString) {
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