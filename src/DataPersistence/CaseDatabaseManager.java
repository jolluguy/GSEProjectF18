/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICase;
import Acquaintance.IInquiry;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexa
 */
public class CaseDatabaseManager {
    
    Connection conn;
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/mcheibvh";
    String dbUsername = "mcheibvh";
    String dbPassword = "keLgH7ysBAb9ly98JEFysr6EwwRGbVY_";
       
    public boolean saveInquiry(IInquiry inq){
        
        String problemDesc = inq.getProblemDescription();
        String inquierer = inq.getInquirer();
        boolean agreement = inq.getCitizenAgreement();
        Timestamp date = inq.getTime();
        
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO henvendelse (henvendelse.indforstået, henvendelse.problembeskrivelse, henvendelse.henvender, henvendelse.henvendelses_dato)"
                    + "VALUES ('" + agreement + "', '" + problemDesc + "', '" + inquierer + "', '" + date + "');");
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
//    public boolean doesInquiryExist(String inqID){
//        int matches = -1;
//        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
//            Class.forName("org.postgresql.Driver");
//            
//            Statement st = conn.createStatement();
//            String sql = "SELECT COUNT('henvendelses_id') FROM henvendelse WHERE henvendelses_id = '" + inqID + "';";
//            ResultSet result = st.executeQuery(sql);
//            
//            while(result.next()){
//                matches = result.getInt("count");
//            }
//            
//            if (matches == 1) {
//                return true;
//            }
//            
//        }   catch (Exception ex) {
//                ex.printStackTrace();
//                return false;
//            }
//        return false;
//    }   
    
    //cprNumber check does possibly not work!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //Uses the CPR number of a citizen to find their respective inquiries.
    public IInquiry getInquiry(String cprNumber){
        DataInquiry inquiry = null;
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            Statement IDSt = conn.createStatement();
            String IDSql = "SELECT henvendelses_id FROM henvendelse WHERE ";
            
            
//            if (doesInquiryExist(inqID)) {
                Statement st = conn.createStatement();
                String sql = "SELECT henvendelse.indforstået, henvendelse.problembeskrivelse, henvendelse.henvender, "
                        + "henvendelse.henvendelses_dato, person.fornavn, person.efternavn, person.cpr, person.adresse, "
                        + "person.telefonnummer FROM henvendelse "
                        + "INNER JOIN omhandler on henvendelse.henvendelses_id = omhandler.henvendelses_id "
                        + "INNER JOIN person on borger.person_id = person.person_id "
                        + "WHERE person.cpr = '" + cprNumber + "';";
                ResultSet result = st.executeQuery(sql);
                
                while(result.next()){
                    boolean tempAgreement = result.getBoolean("indforstået");
                    String tempProblemDesc = result.getString("problembeskrivelse");
                    String tempInquirer = result.getString("henvender");
                    Timestamp tempTimeStamp = result.getTimestamp("henvendelses_dato");
                    String tempFirstName = result.getString("fornavn");
                    String tempLastName = result.getString("efternavn");
                    String tempCPRNumber = result.getString("cpr");
                    String tempAdress = result.getString("adresse");
                    String tempPhoneNumber = result.getString("telefonnummer");
                    
                    inquiry = new DataInquiry(tempProblemDesc, tempInquirer, tempAgreement, tempCPRNumber, 
                            tempFirstName, tempLastName, tempAdress, tempPhoneNumber, tempTimeStamp);
                }
//            }
//            else{
//                System.out.println("Inquiry does not excist!");
//                return null;
//            }
            
        }   catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Inquiry does not exist!");
            return null;
            }
        return inquiry;
    } 
    
    public Collection getAllInquiries(){
        Collection<IInquiry> inquiryList = new ArrayList<>();
      
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");        
            
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM henvendelse";
            
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                boolean tempAgreement = result.getBoolean("indforstået");
                String tempProblemDesc = result.getString("problembeskrivelse");
                String tempInquirer = result.getString("henvender");
                Timestamp tempTimeStamp = result.getTimestamp("henvendelses_dato");
                String tempFirstName = result.getString("fornavn");
                String tempLastName = result.getString("efternavn");
                String tempCPRNumber = result.getString("cpr");
                String tempAdress = result.getString("adresse");
                String tempPhoneNumber = result.getString("telefonnummer");
                    
                inquiryList.add(new DataInquiry(tempProblemDesc, tempInquirer, tempAgreement, tempCPRNumber, 
                    tempFirstName, tempLastName, tempAdress, tempPhoneNumber, tempTimeStamp));                
            }
            
        }   catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        return inquiryList;
    }
    //cprNumber check does possibly not work!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public Collection getAllCitizenSpecificInquiries(String cprNumber){
        Collection<IInquiry> inquiryList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");           
            
//            if (doesInquiryExist(inqID)) {
                Statement st = conn.createStatement();
                String sql = "SELECT henvendelse.indforstået, henvendelse.problembeskrivelse, henvendelse.henvender, "
                        + "henvendelse.henvendelses_dato, person.fornavn, person.efternavn, person.cpr, person.adresse, "
                        + "person.telefonnummer FROM henvendelse "
                        + "INNER JOIN omhandler on henvendelse.henvendelses_id = omhandler.henvendelses_id "
                        + "INNER JOIN person on borger.person_id = person.person_id "
                        + "WHERE person.cpr = '" + cprNumber + "';";
                ResultSet result = st.executeQuery(sql);
                
                while(result.next()){
                    boolean tempAgreement = result.getBoolean("indforstået");
                    String tempProblemDesc = result.getString("problembeskrivelse");
                    String tempInquirer = result.getString("henvender");
                    Timestamp tempTimeStamp = result.getTimestamp("henvendelses_dato");
                    String tempFirstName = result.getString("fornavn");
                    String tempLastName = result.getString("efternavn");
                    String tempCPRNumber = result.getString("cpr");
                    String tempAdress = result.getString("adresse");
                    String tempPhoneNumber = result.getString("telefonnummer");
                    
                    inquiryList.add(new DataInquiry(tempProblemDesc, tempInquirer, tempAgreement, tempCPRNumber, 
                            tempFirstName, tempLastName, tempAdress, tempPhoneNumber, tempTimeStamp));
                }
//            }
//            else{
//                System.out.println("No inquiries exist!");
//                return null;
//            }
            
        }   catch (Exception ex) {
            ex.printStackTrace();
            }
        return inquiryList;
    }
    
    //Here begins the methods that handle Cases
    
    public boolean saveCase(ICase case1){
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
        Class.forName("org.postgresql.Driver");
        
        Collection<String> consentToInformationGathering = case1.getConsentToInformationGathering();
        boolean informedRightsBistander = case1.getInformedRightsBistander();
        boolean informedRightsElectronicRegistration = case1.getInformedRightsElectronicRegistration();
        String consent = case1.getConsent();
        String specialCircumstances = case1.getSpecialCircumstances();
        String otherActingMunicipality = case1.getOtherActingMunicipality();
        String otherPayingMunicipality = case1.getOtherPayingMunicipality();
        
        PreparedStatement ps = conn.prepareStatement("INSERT INTO sag (samtykke_indsamling, samtykke, "
                + "informeret_registrering, informeret-bistand, særlige_forhold, "
                + "anden_betalingskommune, anden_handlingskommune) VALUES ('" + consentToInformationGathering
        + "', '" + consent + "', '" + informedRightsElectronicRegistration + "', '" + informedRightsBistander +
                "', '" + specialCircumstances + "', '" + otherPayingMunicipality + "', '"
        + otherActingMunicipality + "');");
        
        ps.executeUpdate();
        
    }   catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    //cprNumber check does possibly not work!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public ICase getCase(String cprNumber){
//        Array IDArray = null;
        DataCase case1 = null;
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");
            
//            Statement st = conn.createStatement();
//            String sql = "SELECT * FROM sag.sags_id";
//            ResultSet result1 = st.executeQuery(sql);
//            
//            while(result1.next()){
//                IDArray = result1.getArray("sags_id");
//            }
            
            Statement st2 = conn.createStatement();
            String sql2 = "SELECT samtykke_indsamling, samtykke, informeret_registrering, "
                    + "informeret_bistand, særlige_forhold, anden_betalingskommune, anden_handlingskommune FROM sag "
                    + "INNER JOIN drejer_sig_om on sag.sags_id = drejer_sig_om.sags_id "
                    + "INNER JOIN person on borger.person_id = person.person_id "
                    + "WHERE person.cpr = '" + cprNumber + "';";
            
            ResultSet result2 = st2.executeQuery(sql2);
            while(result2.next()){
                String responsibleCw = result2.getString("bruger_id");
                String consent = result2.getString("samtykke");
                boolean informedRightsBystander = result2.getBoolean("informeret_bistand");
                boolean informedRightsElectronicRegistration = result2.getBoolean("informeret_registrering");
                String specialCircumstances = result2.getString("særlige_forhold");
                String otherActingMunicipality = result2.getString("anden_handlingskommune");
                String otherPayingMunicipality = result2.getString("anden_betalingskommune");
                case1 = new DataCase(responsibleCw, informedRightsBystander, informedRightsElectronicRegistration, consent, specialCircumstances, otherActingMunicipality, otherPayingMunicipality);
            }
            
        }   catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        return case1;
    }
        
    public Collection getAllCases(){
        Collection caseList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");        
            
            Statement st = conn.createStatement();
            String sql = "SELECT *, sagsbehandler.bruger_id FROM sag "
                    + "INNER JOIN står_for on sag.sags_id = står_for.sags_id "
                    + "INNER JOIN sagsbehandler on står_for.bruger_id = sagsbehandler.bruger_id";
            
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                String responsibleCw = result.getString("bruger_id");
                String consent = result.getString("samtykke");
                boolean informedRightsBystander = result.getBoolean("informeret_bistand");
                boolean informedRightsElectronicRegistration = result.getBoolean("informeret_registrering");
                String specialCircumstances = result.getString("særlige_forhold");
                String otherActingMunicipality = result.getString("anden_handlingskommune");
                String otherPayingMunicipality = result.getString("anden_betalingskommune");
                caseList.add(new DataCase(responsibleCw, informedRightsBystander, informedRightsElectronicRegistration, consent, specialCircumstances, otherActingMunicipality, otherPayingMunicipality));
            }
            
            
        }   catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        return caseList;
    }
    
    public Collection getAllCitizenSpecificCases(String cprNumber){
        Collection caseList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");        
            
            Statement st = conn.createStatement();
            String sql = "SELECT *, sagsbehandler.bruger_id FROM sag "
                    + "INNER JOIN står_for on sag.sags_id = står_for.sags_id "
                    + "INNER JOIN sagsbehandler on står_for.bruger_id = sagsbehandler.bruger_id "
                    + "INNER JOIN person on borger.person_id = person.person_id "
                    + "WHERE person.person_id = '" + cprNumber + "';";
            
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                String responsibleCw = result.getString("bruger_id");
                String consent = result.getString("samtykke");
                boolean informedRightsBystander = result.getBoolean("informeret_bistand");
                boolean informedRightsElectronicRegistration = result.getBoolean("informeret_registrering");
                String specialCircumstances = result.getString("særlige_forhold");
                String otherActingMunicipality = result.getString("anden_handlingskommune");
                String otherPayingMunicipality = result.getString("anden_betalingskommune");
                
                caseList.add(new DataCase(responsibleCw, informedRightsBystander, informedRightsElectronicRegistration, consent, specialCircumstances, otherActingMunicipality, otherPayingMunicipality));
            }
        }   catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        return caseList;
    }
}
