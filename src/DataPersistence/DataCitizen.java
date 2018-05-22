package DataPersistence;

import Acquaintance.ICitizen;

class DataCitizen extends DataPerson implements ICitizen {
    
    DataCitizen(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }
    
}