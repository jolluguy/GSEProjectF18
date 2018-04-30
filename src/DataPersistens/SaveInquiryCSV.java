/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistens;

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

    SaveInquiryCSV(IInquiry inq) {
        this.inq = new DataInquiry(new DataCitizen(inq.getCitizen().getCprNumber(), inq.getCitizen().getFirstname(), inq.getCitizen().getSurname(), inq.getCitizen().getRoadName(), inq.getCitizen().getHouseNumber(), inq.getCitizen().getFloor(), inq.getCitizen().getPostNumber(), inq.getCitizen().getCity(), inq.getCitizen().getCity()), inq.getProblemDescription());
    saveInq();
    
    }

    
    boolean saveInq(){
        final String SEPPERATOR = "<";
        
        try (FileWriter fw = new FileWriter("InquiryDB.txt", true); // true betyder at den appender filen i stedet for at overrite den
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter writer = new PrintWriter(bw)) {
            writer.println(
                    inq.getCitizen().getCprNumber()+
                    SEPPERATOR+
                    inq.getCitizen().getFirstname()+
                    SEPPERATOR+
                    inq.getCitizen().getSurname()+
                    SEPPERATOR+
                    inq.getCitizen().getRoadName()+
                    SEPPERATOR+
                    inq.getCitizen().getHouseNumber()+
                    SEPPERATOR+
                    inq.getCitizen().getFloor()+
                    SEPPERATOR+
                    inq.getCitizen().getPostNumber()+
                    SEPPERATOR+
                    inq.getCitizen().getCity()+
                    SEPPERATOR+
                    inq.getCitizen().getCity()+
                    SEPPERATOR+
                    inq.getProblemDescription());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return true;
    }
}
