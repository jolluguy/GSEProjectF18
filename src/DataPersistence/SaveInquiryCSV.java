/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.IInquiry;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Rasmus
 */
public class SaveInquiryCSV {

    IInquiry inq;

    SaveInquiryCSV(IInquiry inquiry) {
        this.inq = new DataInquiry(new DataCitizen(inquiry.getCitizen().getCprNumber(), inquiry.getCitizen().getFirstName(), 
                inquiry.getCitizen().getLastName(), inquiry.getCitizen().getRoadName(), inquiry.getCitizen().getHouseNumber(), 
                inquiry.getCitizen().getFloor(), inquiry.getCitizen().getPostalCode(), inquiry.getCitizen().getCity(), inquiry.getCitizen().getPhoneNumber()),
                inquiry.getProblemDescription());
    }
    
    boolean saveInquiry(){
        final String SEPPERATOR = "<";
        
        try (FileWriter fw = new FileWriter("InquiryDB.txt", true); // true betyder at den appender filen i stedet for at overrite den
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter writer = new PrintWriter(bw)) {
            writer.println(
                    inq.getCitizen().getCprNumber()+
                    SEPPERATOR+
                    inq.getCitizen().getFirstName()+
                    SEPPERATOR+
                    inq.getCitizen().getLastName()+
                    SEPPERATOR+
                    inq.getCitizen().getRoadName()+
                    SEPPERATOR+
                    inq.getCitizen().getHouseNumber()+
                    SEPPERATOR+
                    inq.getCitizen().getFloor()+
                    SEPPERATOR+
                    inq.getCitizen().getPostalCode()+
                    SEPPERATOR+
                    inq.getCitizen().getCity()+
                    SEPPERATOR+
                    inq.getProblemDescription()+
                    "\n");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        return true;
    }
}
