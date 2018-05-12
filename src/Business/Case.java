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

/**
 *
 * @author Rasmus
 */
public class Case {
    
    Collection<IInquiry> inquiryList;
    Collection<String> responsibleCaseworkerIDList;    // skal det være en collection eller bare en?
    Collection<IMeeting> meeting;
    Collection<IRepresentation> representationList;
    Collection<ICaseNote> caseNoteList;
    Collection<IService> serviceList;
    Collection<IOffer> offerList;
    
        public Case(Inquiry inquiry, Collection<String> responsibleCaseworkerIDList, Collection<IMeeting> meeting, Collection<IRepresentation> representationList, Collection<ICaseNote> caseNoteList, Collection<IService> serviceList, Collection<IOffer> offerList) {
        inquiryList = new ArrayList<>();
        inquiryList.add(inquiry);
        this.responsibleCaseworkerIDList = new ArrayList<>();
        for(String s: responsibleCaseworkerIDList){
            this.responsibleCaseworkerIDList.add(s);
        }
        this.meeting = new Meeting();
        this.representationList = representationList;
        this.caseNoteList = caseNoteList;
        this.serviceList = serviceList;
        this.offerList = offerList;
    } 
    
}
