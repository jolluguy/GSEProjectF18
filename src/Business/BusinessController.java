/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author goope
 */
public class BusinessController {
    
    
    public boolean createInquiry(int cprNumber, String problemDescription, String firstname, String surname, String roadName, String houseNumber, String floor, int postNumber, String city, String tlfNumber){
        Inquiry inquiry = new Inquiry(cprNumber, problemDescription, firstname, surname, roadName, houseNumber, floor, postNumber, city, tlfNumber);
        
        if (true) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean sendToDB(Inquiry inquiry){
        
        
        
        if  (returnMessage == false) { //Pseudo code
            DBConnectionError();
        }
    }    
    public void DBConnectionError(){
        
    }
}
