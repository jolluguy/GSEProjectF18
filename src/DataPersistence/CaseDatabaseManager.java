/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICase;
import Acquaintance.IInformationGathering;
import Acquaintance.IInquiry;
import Acquaintance.IMeeting;
import Acquaintance.IOffer;
import Acquaintance.IService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alexa
 */
public class CaseDatabaseManager {

    Connection conn;
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/mcheibvh";
    String dbUsername = "mcheibvh";
    String dbPassword = "keLgH7ysBAb9ly98JEFysr6EwwRGbVY_";

    public boolean saveInquiry(IInquiry inq) {

        String address = inq.getCitizen().getRoadName() + " " + inq.getCitizen().getHouseNumber() + ", " + inq.getCitizen().getPostalCode() + " " + inq.getCitizen().getCity();
        String personID = "error"; //incase of no change while creating a new citizen in database
        int inquiryID = -1;

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            // Statement 1 - create person
            PreparedStatement st = conn.prepareStatement("INSERT INTO person(cpr, fornavn, efternavn, adresse, telefonnummer) "
                    + "VALUES(" + inq.getCitizen().getCpr() + ", " + inq.getCitizen().getFirstName() + ", " + inq.getCitizen().getLastName() + ", " + address + ", " + inq.getCitizen().getPhoneNumber() + ");");

            st.executeUpdate();

            //Statement 2 - create inquiry
            PreparedStatement st2 = conn.prepareStatement("INSERT INTO henvendelse (sagsbehandler_domaene_id, henvendelse.indforstået, henvendelse.problembeskrivelse, henvendelse.henvender, henvendelse.henvendelses_dato)"
                    + "VALUES ('" + inq.getResponsibleCaseWorkerDomainID() + ", " + inq.getCitizenAgreement() + "', '" + inq.getProblemDescription() + "', '" + inq.getInquirer() + "', '" + inq.getTime() + "');");

            st2.executeUpdate();

            // Statement 3 - Get personID from person for later use
            Statement st3 = conn.createStatement();

            String sql = "SELECT person.person_id FROM person WHERE person.cpr = '" + inq.getCitizen().getCpr() + "';";

            ResultSet result = st3.executeQuery(sql);

            while (result.next()) {
                personID = result.getString("person_id");
            }

            //Statement 4 - Get inquiryID from henveldelse for later use
            Statement st4 = conn.createStatement();

            String sql2 = "SELECT henvendelse.henvendelses_id FROM henvendelse WHERE tidspunkt = '" + inq.getTime() + "' AND sagsbehandler_domaene_id = '" + inq.getResponsibleCaseWorkerDomainID() + "';";

            ResultSet result2 = st4.executeQuery(sql2);

            while (result2.next()) {
                inquiryID = result2.getInt("henvendelses_id");
            }

            //Statement 5 - Create a "borger" with a personID
            PreparedStatement st5 = conn.prepareStatement("INSERT INTO borger(person_id) VALUES('" + personID + "';");

            st5.executeUpdate();

            //Statement 6 - create relation between borger and henvendelse
            PreparedStatement st6 = conn.prepareStatement("INSERT INTO omhandler(person_id, henvendelses_id) "
                    + "VALUES('" + personID + "', " + inquiryID + "');");

            st6.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean saveCase(ICase case1) {
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            int tempCaseID = -1;
            int tempPersonID = -1;
            int meetingID = -1;
            int caseID = -1;

            //Statement 1 - create inquiry for the new case
            for (IInquiry inquiry : case1.getInquiryList()) {
                saveInquiry(inquiry);
            }

            //Statement 2 - Create case in database
            Statement st2 = conn.createStatement();

            String sql2 = "INSERT INTO sag(sagsbehandler_domaene_id, samtykke_indsamling, informeret_registrering, informeret_bistand, saerlige_forhold, anden_betalingskommune, "
                    + "anden_handlekommune) "
                    + "VALUES('" + case1.getResponsibleCaseworker() + "', '" + case1.getConsent() + "', " + case1.isInformedRightsBystander() + ", '"
                    + case1.getSpecialCircumstances() + "', '" + case1.getOtherPayingMunicipality() + "', '" + case1.getOtherActingMunicipality() + "');";

            st2.executeUpdate(sql2);

            //Statement 3 - Get caseID from case
            PreparedStatement st3 = conn.prepareStatement("SELECT MAX(sags_id) FROM sag;");

            ResultSet result3 = st3.executeQuery();

            while (result3.next()) {
                tempCaseID = result3.getInt("max");
            }

            //Statement 4 - Get personID from person
            for (IInquiry inquiry : case1.getInquiryList()) {
                PreparedStatement st4 = conn.prepareStatement("SELECT person.person_id FROM person "
                        + "WHERE person.cpr = '" + inquiry.getCitizen().getCprNumber() + "';");

                ResultSet result4 = st4.executeQuery();

                while (result4.next()) {
                    tempPersonID = result4.getInt("person_id");
                }

            }

            //Statement 5 - create relation  "drejer_sig_om"
            Statement st5 = conn.createStatement();

            String sql5 = "INSERT INTO drejer_sig_om(person_id, sags_id) "
                    + "VALUES('" + tempPersonID + "', " + tempCaseID + ");";

            st5.executeUpdate(sql5);

            //Statement 6 - create meeting
            for (IMeeting meeting : case1.getMeetingList()) {
                Statement st6 = conn.createStatement();

                String sql6 = "INSERT INTO aftale(dato, lokation, beskrivelse) "
                        + "VALUES(" + meeting.getMeetingTime() + ", '" + meeting.getMeetingLocation() + "', '" + meeting.getMeetingDescription() + "';)";

                st6.executeUpdate(sql6);

            }

            //Statement 7 - Get "aftale_id"
            PreparedStatement st7 = conn.prepareStatement("SELECT MAX(aftale_id) FROM aftale");

            ResultSet result7 = st7.executeQuery();

            while (result7.next()) {
                meetingID = result3.getInt("max");
            }

            //Statement 8 - Create relation in "relaterer_til"
            Statement st8 = conn.createStatement();

            String sql8 = "INSERT INTO relaterer_til(sags_id, aftale_id) "
                    + "VALUES(" + caseID + ", " + meetingID + ");";

            st8.executeUpdate(sql8);

            //Statement 9 - Create relation in "giver"
            for (IService service : case1.getServiceList()) {
                Statement st9 = conn.createStatement();

                String sql9 = "INSERT INTO giver(tilbuds_id, sags_id) "
                        + "VALUES(" + service.getServiceID() + ", " + caseID + ");";

                st9.executeQuery(sql9);
            }
            
            //Statement 10 - Create relation in "bevilger!
            for(IOffer offer : case1.getOfferList()){
                Statement st10 = conn.createStatement();
                
                String sql10 = "INSER INTO bevilger(ydelses_id, sags_id) "
                        + "VALUES(" + offer.getOfferID() + ", " + caseID + ");";
                
                st10.executeQuery(sql10);
            }
            
            //Statement 11 - Create relation in "gives_i"
            for(IInformationGathering infoGathering : case1.getConsentToInformationGatheringList()){
                Statement st11 = conn.createStatement();
                
                String sql11 = "INSERT INTO gives_i(samtykke_id, sags_id) "
                        + "VALUES(" + infoGathering.getInfoGatheringID() + ", " + caseID + ");";
                
                st11.executeQuery(sql11);
            }
            
            

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
