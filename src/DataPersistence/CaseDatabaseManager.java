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
import java.sql.Timestamp;
import java.util.Collection;

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
    
    public boolean saveCase(ICase case1){
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
        Class.forName("org.postgresql.Driver");
        
        Collection<String> consentToInformationGathering = case1.getConsentToInformationGathering();
        boolean informedRightsBistander = case1.isInformedRightsBystander();
        boolean informedRightsElectronicRegistration = case1.isInformedRightsElectronicRegistration();
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
    
}
