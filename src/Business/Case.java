/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICase;
import Acquaintance.ICaseNote;
import Acquaintance.IInquiry;
import Acquaintance.IMeeting;
import Acquaintance.IOffer;
import Acquaintance.IRepresentation;
import Acquaintance.IService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Rasmus
 */
public class Case implements ICase {

    String responsibleCaseworker;
    boolean informedRightsBistander;
    boolean informedRightsElectronicRegistration;
    String consent;
    Collection<String> consentToInformationGathering;
    String specialCircumstances;
    String otherActingMunicipality;
    String otherPayingMunicipality;

    Collection<IInquiry> inquiryList;
    Collection<String> affiliatedCaseworkers;
    Collection<IMeeting> meetingList;
    Collection<IRepresentation> representationList;
    Collection<ICaseNote> caseNoteList;
    Collection<IService> serviceList;
    Collection<IOffer> offerList;

    /**
     * Constructor used when creating a new case.
     * @param inquiry
     * @param responsibleCaseworker
     * @param informedRightsBistander
     * @param informedRightsElectronicRegistration
     * @param consent
     * @param consentToInformationGathering
     * @param specialCircumstances
     * @param otherActingMunicipality
     * @param otherPayingMunicipality
     * @param meetingDate
     * @param attendingCasworkerIDList
     * @param meetingDescription
     * @param meetingLocation
     * @param cprNumber
     * @param firstName
     * @param lastName
     * @param roadName
     * @param houseNumber
     * @param floor
     * @param postalCode
     * @param city
     * @param phoneNumber
     * @param representationType
     * @param note
     * @param caseWorkerID
     * @param serviceIDMap
     * @param offerIDMap 
     */
    public Case(IInquiry inquiry,
            String responsibleCaseworker,
            boolean informedRightsBistander,
            boolean informedRightsElectronicRegistration,
            String consent,
            Collection<String> consentToInformationGathering,
            String specialCircumstances,
            String otherActingMunicipality,
            String otherPayingMunicipality,
            Date meetingDate, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation,
            String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType,
            String note, String caseWorkerID,
            Map<Integer, String> serviceIDMap,
            Map<Integer, String> offerIDMap) {

        // adding a Inquiry to the case
        inquiryList = new ArrayList<>();
        inquiryList.add(inquiry);
        
        // seting the responsible caseworker
        this.responsibleCaseworker = responsibleCaseworker;
        
        
        this.informedRightsBistander = informedRightsBistander;
        this.informedRightsElectronicRegistration = informedRightsElectronicRegistration;
        this.consent = consent;
        
        this.consentToInformationGathering = new ArrayList<>();
        if (!consentToInformationGathering.isEmpty()){
            for(String s : consentToInformationGathering){
                this.consentToInformationGathering.add(s);
            }
        }
        
        this.specialCircumstances = specialCircumstances;
        this.otherActingMunicipality = otherActingMunicipality;
        this.otherPayingMunicipality = otherPayingMunicipality;
        

        // creating a list of caseworkers who has ben affiliated with the case and adding the responsibleCaseworker to the list
        this.affiliatedCaseworkers = new ArrayList<>();
        affiliatedCaseworkers.add(this.responsibleCaseworker);
        addAffiliatedCaseworker(attendingCasworkerIDList);

        //creates a list to hold meetings and adds the first meeting
        this.meetingList = new ArrayList<>();
        meetingList.add(new Meeting(meetingDate, attendingCasworkerIDList, meetingDescription, meetingLocation));

        // creates a list to hold representants and ads the first representant if one such is added.
        this.representationList = new ArrayList<>();
        if (!cprNumber.isEmpty()) {
            this.representationList.add(new Representation(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber, representationType));
        }

        // creates a list to hold casenotes and ads one if one such exist
        this.caseNoteList = new ArrayList<>();
        if (!note.isEmpty()) {
            this.caseNoteList.add(new CaseNote(note, caseWorkerID));
        }

        this.serviceList = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : serviceIDMap.entrySet()) {
            this.serviceList.add(new Service(entry.getKey(), entry.getValue()));
        }

        this.offerList = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : offerIDMap.entrySet()) {
            this.offerList.add(new Offer(entry.getKey(), entry.getValue()));
        }

    }

        private void addAffiliatedCaseworker(Collection<String> casworkerIDList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addAffiliatedCaseworker(String casworkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
