/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICaseNote;
import Acquaintance.IInquiry;
import Acquaintance.IMeeting;
import Acquaintance.IOffer;
import Acquaintance.IRepresentation;
import Acquaintance.IService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Rasmus
 */
public class Case {
    
    Collection<IInquiry> inquiryList;
    Collection<String> responsibleCaseworkerIDList;    // skal det være en collection eller bare en?
    Collection<IMeeting> meetingList;
    Collection<IRepresentation> representationList;
    Collection<ICaseNote> caseNoteList;
    Collection<IService> serviceList;
    Collection<IOffer> offerList;
    
    /**
     * 
     * @param inquiry , created by 
     * @param responsibleCaseworkerIDList
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
     * @param serviceIDList
     * @param offerIDList 
     */
        public Case(Inquiry inquiry,
                Collection<String> responsibleCaseworkerIDList,
                Date meetingDate, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation,
                String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType,
                String note, String caseWorkerID,
                Collection<Integer> serviceIDList,
                Collection<Integer> offerIDList) {
        
            inquiryList = new ArrayList<>();
        inquiryList.add(inquiry);
        
        this.responsibleCaseworkerIDList = new ArrayList<>();
        for(String s: responsibleCaseworkerIDList){
            this.responsibleCaseworkerIDList.add(s);
        }
        
        this.meetingList = new ArrayList<>();
        meetingList.add(new Meeting(meetingDate, responsibleCaseworkerIDList, meetingDescription, meetingLocation));
        
        
        this.representationList = new ArrayList<>();
        this.representationList.add(new Representation(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber, representationType));
        
        this.caseNoteList = new ArrayList<>();
        this.caseNoteList.add(new CaseNote(note, caseWorkerID));
        
        this.serviceList = new ArrayList<>();
        for(int i : serviceIDList){
            this.serviceList.add(new Service(i));
        }
        
        
        this.offerList = new ArrayList<>();
        for(int i : offerIDList){
            this.offerList.add(new Offer(i));
        }
    } 
    
}
