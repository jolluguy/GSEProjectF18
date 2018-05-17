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
        this.inq = new DataInquiry(inq.getProblemDescription(), inq.getInquirer(), inq.getCitizenAgreement(), inq.getCitizen().getCprNumber(), inq.getCitizen().getFirstName(), 
            inq.getCitizen().getLastName(), inq.getCitizen().getRoadName(), inq.getCitizen().getHouseNumber(), inq.getCitizen().getFloor(), 
            inq.getCitizen().getPostalCode(), inq.getCitizen().getCity(), inq.getCitizen().getPhoneNumber());
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