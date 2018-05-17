package DataPersistence;

import Acquaintance.IService;

public class DataService implements IService {
    private int serviceID;
    private String serviceDescription;

    
    DataService(int serviceID, String serviceDescription) {
        this.serviceID = serviceID;
        this.serviceDescription = serviceDescription;
    }
    
    @Override
    public int getServiceID() {
        return this.serviceID;
    }

    @Override
    public String getServiceDescription() {
        return this.serviceDescription;
    }
}