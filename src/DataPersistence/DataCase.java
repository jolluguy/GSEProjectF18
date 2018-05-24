package DataPersistence;

import Acquaintance.ICase;
import Acquaintance.ICaseNote;
import Acquaintance.IInformationGathering;
import Acquaintance.IInquiry;
import Acquaintance.IMeeting;
import Acquaintance.IOffer;
import Acquaintance.IRepresentation;
import Acquaintance.IService;
import java.util.Collection;

class DataCase implements ICase {
    
    private String responsibleCaseworker;
    private boolean informedRightsBystander;
    private boolean informedRightsElectronicRegistration;
    private String consent;
    private String specialCircumstances;
    private String otherActingMunicipality;
    private String otherPayingMunicipality;
    
    private Collection<IInquiry> inquiryList;
    private Collection<String> affiliatedCaseworkers;
    private Collection<IMeeting> meetingList;
    private Collection<IRepresentation> representationList;
    private Collection<ICaseNote> caseNoteList;
    private Collection<IInformationGathering> informationGatheringList;
    private Collection<IService> serviceList;
    private Collection<IOffer> offerList;

    
    // Alle ting i collections tilføjes via add-metoderne, så vi kan iterere over dem
    DataCase(String responsibleCw, boolean informedRightsBystander, boolean informedRightsElectronicRegistration, String consent, String specialCircumstances,
            String otherActingMunicipality, String otherPayingMunicipality) {
        this.responsibleCaseworker = responsibleCw;
        this.informedRightsBystander = informedRightsBystander;
        this.informedRightsElectronicRegistration = informedRightsElectronicRegistration;
        this.consent = consent;
        this.specialCircumstances = specialCircumstances;
        this.otherActingMunicipality = otherActingMunicipality;
        this.otherPayingMunicipality = otherPayingMunicipality;
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

    @Override
    public boolean isInformedRightsBystander() {
        return this.informedRightsBystander;
    }

    @Override
    public boolean isInformedRightsElectronicRegistration() {
        return this.informedRightsElectronicRegistration;
    }

    @Override
    public String getConsent() {
        return this.consent;
    }

    @Override
    public String getSpecialCircumstances() {
        return this.specialCircumstances;
    }

    @Override
    public String getOtherActingMunicipality() {
        return this.otherActingMunicipality;
    }

    @Override
    public String getOtherPayingMunicipality() {
        return this.otherPayingMunicipality;
    }

    @Override
    public Collection<IInformationGathering> getConsentToInformationGatheringList() {
        return this.informationGatheringList;
    }

    @Override
    public void addConsentToInformationGathering(IInformationGathering informationGathering) {
        this.informationGatheringList.add(informationGathering);
    }
}