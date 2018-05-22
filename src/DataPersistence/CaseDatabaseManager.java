/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICase;
import Acquaintance.IInquiry;
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

            
            //Statement 5 - Create a borger with a personID
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
            
            int caseID = -1;
            
            //Statement 1 - Create case in database
            Statement st1 = conn.createStatement();
            
            String sql1 = "INSERT INTO sag(sagsbehandler_domaene_id, samtykke_indsamling, samtykke, informeret_registrering, "
                    + "informeret_bistand, saerlige_forhold, anden_betalingskommune, anden_handlekommune) "
                    + "VALUES('" + case1.getResponsibleCaseworker() + "', " + case1.getConsent() + ", '" + case1.getConsentType() + "' " 
                    + case1.isInformedRightsElectronicRegistration() + ", " + case1.isInformedRightsBystander() + ", '" + case1.getSpecialCircumstances() 
                    + "', '" + case1.getOtherPayingMunicipality() + "', '" + case1.getOtherActingMunicipality() + "');";
            
            st1.executeUpdate(sql1);
            
            //Statement 2 - Get caseID from the new case in database
            PreparedStatement st2 = conn.prepareStatement("SELECT sag.sags_id FROM sag WHERE ");
            
            
            for(IInquiry inquiry : case1.getInquiryList()){
                saveInquiry(inquiry);
            }
            

            

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
