package DataPersistence;

import Acquaintance.ICase;
import Acquaintance.ICaseNote;
import Acquaintance.IInquiry;
import Acquaintance.IMeeting;
import Acquaintance.IOffer;
import Acquaintance.IRepresentation;
import Acquaintance.IService;
import java.util.Collection;

public class DataCase implements ICase {
    Collection<IInquiry> inquiryList;
    String responsibleCaseworker;
    Collection<String> affiliatedCaseworkers;
    Collection<IMeeting> meetingList;
    Collection<IRepresentation> representationList;
    Collection<ICaseNote> caseNoteList;
    Collection<IService> serviceList;
    Collection<IOffer> offerList;

    
    // Alle ting i collections tilføjes via add-metoderne, så vi kan iterere over dem
    DataCase(String responsibleCw) {
        this.responsibleCaseworker = responsibleCw;
    }
    
    @Override
    public Collection<IInquiry> getInquiryList() {
        return this.inquiryList;
    }

    @Override
    public void addInquiryToCase(IInquiry inq) {
        this.inquiryList.add(inq);
    }

    @Override
    public String getResponsibleCaseworker() {
        return this.responsibleCaseworker;
    }

    @Override
    public void setResponsibleCaseworker(String responsibleCaseworkerID) {
        this.responsibleCaseworker = responsibleCaseworkerID;
    }

    @Override
    public Collection<String> getAffiliatedCaseworkers() {
        return this.affiliatedCaseworkers;
    }

    @Override
    public void addAffiliatedCaseworker(String caseworkerID) {
        this.affiliatedCaseworkers.add(caseworkerID);
    }

    @Override
    public Collection<IMeeting> getMeetingList() {
        return this.meetingList;
    }

    @Override
    public void addMeeting(IMeeting meeting) {
        this.meetingList.add(meeting);
    }

    @Override
    public Collection<IRepresentation> getRepresentationList() {
        return this.representationList;
    }

    @Override
    public void addRepresentation(IRepresentation representation) {
        this.representationList.add(representation);
    }

    @Override
    public Collection<ICaseNote> getCaseNoteList() {
        return this.caseNoteList;
    }

    @Override
    public void addCaseNote(ICaseNote caseNote) {
        this.caseNoteList.add(caseNote);
    }

    @Override
    public Collection<IService> getServiceList() {
        return this.serviceList;
    }

    @Override
    public void addService(IService service) {
        this.serviceList.add(service);
    }

    @Override
    public Collection<IOffer> getOfferList() {
        return this.offerList;
    }

    @Override
    public void addOffer(IOffer offer) {
        this.offerList.add(offer);
    }
}