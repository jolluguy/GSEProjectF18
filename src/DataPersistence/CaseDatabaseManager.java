/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICase;
import Acquaintance.ICaseNote;
import Acquaintance.IInformationGathering;
import Acquaintance.IInquiry;
import Acquaintance.IMeeting;
import Acquaintance.IOffer;
import Acquaintance.IRepresentation;
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
            
            System.out.println("citizenCpr = " + inq.getCitizen().getCprNumber());
            System.out.println("citizenName = " + inq.getCitizen().getFirstName());
            System.out.println("citizenLastName = " + inq.getCitizen().getLastName());
            System.out.println("citizen adress = " + address);
            System.out.println("citizen phone = " + inq.getCitizen().getPhoneNumber());
            System.out.println("save inq responsible caseworker = " + inq.getResponsibleCaseWorkerDomainID());
            System.out.println("citizenAgreement = " + inq.getCitizenAgreement());
            System.out.println("description = " + inq.getProblemDescription());
            System.out.println("save inq inquirer = " + inq.getInquirer());
            System.out.println("inq time = " + inq.getTime());
            
            Class.forName("org.postgresql.Driver");

            // Statement 1 - create person
            PreparedStatement st = conn.prepareStatement("INSERT INTO person(cpr, fornavn, efternavn, adresse, telefonnummer) "
                    + "VALUES('" + inq.getCitizen().getCprNumber() + "', '" + inq.getCitizen().getFirstName() + "', '" + inq.getCitizen().getLastName() + "', '" + address + "', '" 
                    + inq.getCitizen().getPhoneNumber() + "');");

            st.executeUpdate();

            //Statement 2 - create inquiry
            PreparedStatement st2 = conn.prepareStatement("INSERT INTO henvendelse(sagsbehandler_domaene_id, indforstaaet, problembeskrivelse, "
                    + "henvender, tidspunkt)"
                    + "VALUES ('" + inq.getResponsibleCaseWorkerDomainID() + "', '" + inq.getCitizenAgreement() + "', '" + inq.getProblemDescription() + "', '" + inq.getInquirer() 
                    + "', '" + inq.getTime() + "');");

            st2.executeUpdate();

            // Statement 3 - Get personID from person for later use
            Statement st3 = conn.createStatement();

            String sql = "SELECT person.person_id FROM person WHERE person.cpr = '" + inq.getCitizen().getCprNumber()+ "';";

            ResultSet result = st3.executeQuery(sql);

            while (result.next()) {
                personID = result.getString("person_id");
            }

            //Statement 4 - Get inquiryID from henveldelse for later use
            Statement st4 = conn.createStatement();

            String sql2 = "SELECT henvendelse.henvendelses_id FROM henvendelse WHERE tidspunkt = '" + inq.getTime() + "' AND sagsbehandler_domaene_id = '" 
                    + inq.getResponsibleCaseWorkerDomainID() + "';";

            ResultSet result2 = st4.executeQuery(sql2);

            while (result2.next()) {
                inquiryID = result2.getInt("henvendelses_id");
            }

            //Statement 5 - Create a "borger" with a personID
            PreparedStatement st5 = conn.prepareStatement("INSERT INTO borger(person_id) VALUES('" + personID + "');");

            st5.executeUpdate();

            //Statement 6 - create relation between borger and henvendelse
            PreparedStatement st6 = conn.prepareStatement("INSERT INTO omhandler(person_id, henvendelses_id) "
                    + "VALUES('" + personID + "', '" + inquiryID + "');");

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
            int tempRepresentationID = -1;
            int tempCaseNoteID = -1;

            //Statement 1 - create inquiry for the new case
            for (IInquiry inquiry : case1.getInquiryList()) {
                saveInquiry(inquiry);
            }

            //Statement 2 - Create case in database
            PreparedStatement st2 = conn.prepareStatement("INSERT INTO sag(sagsbehandler_domaene_id, samtykke_indsamling, informeret_registrering, informeret_bistand, "
                    + "saerlige_forhold, anden_betalingskommune, anden_handlekommune) "
                    + "VALUES('" + case1.getResponsibleCaseworker() + "', '" + case1.getConsent() + "', " + case1.isInformedRightsElectronicRegistration() + ", " + case1.isInformedRightsBystander() + ", '"
                    + case1.getSpecialCircumstances() + "', '" + case1.getOtherPayingMunicipality() + "', '" + case1.getOtherActingMunicipality() + "');");

            st2.executeUpdate();

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
            PreparedStatement st5 = conn.prepareStatement("INSERT INTO drejer_sig_om(person_id, sags_id) "
                    + "VALUES(" + tempPersonID + ", " + tempCaseID + ");");

            st5.executeUpdate();

            //Statement 6 - create meeting
            for (IMeeting meeting : case1.getMeetingList()) {
                PreparedStatement st6 = conn.prepareStatement("INSERT INTO aftale(tidspunkt, lokation, beskrivelse) "
                        + "VALUES('" + meeting.getMeetingTime() + "', '" + meeting.getMeetingLocation() + "', '" + meeting.getMeetingDescription() + "');");

                st6.executeUpdate();

            }

            //Statement 7 - Get "aftale_id"
            PreparedStatement st7 = conn.prepareStatement("SELECT MAX(aftale_id) FROM aftale;");

            ResultSet result7 = st7.executeQuery();

            while (result7.next()) {
                meetingID = result7.getInt("max");
            }

            //Statement 8 - Create relation in "relaterer_til"
            PreparedStatement st8 = conn.prepareStatement("INSERT INTO relaterer_til(sags_id, aftale_id) "
                    + "VALUES(" + caseID + ", " + meetingID + ");");

            st8.executeUpdate();

            //Statement 9 - Create relation in "giver"
            for (IService service : case1.getServiceList()) {
                PreparedStatement st9 = conn.prepareStatement("INSERT INTO giver(tilbuds_id, sags_id) "
                        + "VALUES(" + service.getServiceID() + ", " + caseID + ");");

                st9.executeUpdate();
            }

            //Statement 10 - Create relation in "bevilger!
            for (IOffer offer : case1.getOfferList()) {
                PreparedStatement st10 = conn.prepareStatement("INSERT INTO bevilger(ydelses_id, sags_id) "
                        + "VALUES(" + offer.getOfferID() + ", " + caseID + ");");

                st10.executeUpdate();
            }

            //Statement 11 - Create relation in "gives_i"
            for (IInformationGathering infoGathering : case1.getConsentToInformationGatheringList()) {
                PreparedStatement st11 = conn.prepareStatement("INSERT INTO gives_i(samtykke_id, sags_id) "
                        + "VALUES(" + infoGathering.getInfoGatheringID() + ", " + caseID + ");");

                st11.executeUpdate();
            }

            //Statement 12 - Create person for representative
            for (IRepresentation representation : case1.getRepresentationList()) {
                String address = representation.getPerson().getRoadName() + " " + representation.getPerson().getHouseNumber() + ", " + representation.getPerson().getPostalCode() + " " + representation.getPerson().getCity();

                PreparedStatement st12 = conn.prepareStatement("INSERT INTO person(cpr, fornavn, efternavn, adresse, telefonnummer) "
                        + "VALUES('" + representation.getPerson().getCpr() + "', '" + representation.getPerson().getFirstName() + "', '"
                        + representation.getPerson().getLastName() + "', '" + address + "', '" + representation.getPerson().getPhoneNumber() + "');");

                st12.executeUpdate();
            }

            //Statement 13 - Get RepresentationID            
            Statement st13 = conn.createStatement();

            String sql13 = "SELECT MAX(person_id) FROM person";

            ResultSet result13 = st13.executeQuery(sql13);

            while (result13.next()) {
                tempRepresentationID = result13.getInt("max");
            }

            //Statement 14 - Create "repræsentant"
            for (IRepresentation representation : case1.getRepresentationList()) {
                PreparedStatement st14 = conn.prepareStatement("INSERT INTO repræsentant(person_id, repraesentant_type) "
                        + "VALUES(" + tempRepresentationID + ", '" + representation.getRepresentationType() + "');");

                st14.executeUpdate();
            }

            //Statement 15 - Create relation in "er_knyttet_til"
            PreparedStatement st15 = conn.prepareStatement("INSERT INTO er_tilknyttet_til(person_id, sags_id) "
                    + "VALUES(" + tempRepresentationID + ", " + tempCaseID + ");");

            st15.executeUpdate();

            //Statement 16 - Create caseNote
            for (ICaseNote caseNote : case1.getCaseNoteList()) {
                PreparedStatement st16 = conn.prepareStatement("INSERT INTO sagsnotat(notat_beskrivelse) "
                        + "VALUES('" + caseNote.getNote() + "');");
                
                st16.executeUpdate();
            }
            
            //Statement 17 - Get caseNoteID
            Statement st17 = conn.createStatement();
            
            String sql17 = "SELECT MAX(notat_id) FROM sagsnotat;";
            
            ResultSet result17 = st17.executeQuery(sql17);
            
            while(result17.next()){
                tempCaseNoteID = result17.getInt("max");
            }
            
            //Statement 18 - Create relation in "vedrører"
            PreparedStatement st18 = conn.prepareStatement("INSERT INTO vedrører(notat_id, sags_id) "
                    + "VALUES(" + tempCaseNoteID + ", " + tempCaseID + ");");
            
            st18.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
