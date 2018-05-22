package Business;

import Acquaintance.ICase;
import Acquaintance.ICaseNote;
import Acquaintance.IInquiry;
import Acquaintance.IMeeting;
import Acquaintance.IOffer;
import Acquaintance.IRepresentation;
import Acquaintance.IService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Rasmus
 */
class Case implements ICase {

    private String responsibleCaseworkerDomainID;
    private boolean informedRightsBystander;
    private boolean informedRightsElectronicRegistration;
    private String consent;
    private Collection<String> consentToInformationGathering;
    private String specialCircumstances;
    private String otherActingMunicipality;
    private String otherPayingMunicipality;

    private Collection<IInquiry> inquiryList;
    private Collection<String> affiliatedCaseworkers;
    private Collection<IMeeting> meetingList;
    private Collection<IRepresentation> representationList;
    private Collection<ICaseNote> caseNoteList;
    private Collection<IService> serviceList;
    private Collection<IOffer> offerList;

    /**
     * Constructor used when creating a new case.
     *
     * @param inquiry
     * @param responsibleCaseworkerDomainID
     * @param informedRightsBystander
     * @param informedRightsElectronicRegistration
     * @param consent
     * @param consentToInformationGathering
     * @param specialCircumstances
     * @param otherActingMunicipality
     * @param otherPayingMunicipality
     * @param meetingTime
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
    Case(IInquiry inquiry,
            String responsibleCaseworkerDomainID,
            boolean informedRightsBystander,
            boolean informedRightsElectronicRegistration,
            String consent,
            Collection<String> consentToInformationGathering,
            String specialCircumstances,
            String otherActingMunicipality,
            String otherPayingMunicipality,
            Timestamp meetingTime, String meetingDescription, String meetingLocation,
            String cprNumber, String firstName, String lastName, String roadName,
            String houseNumber, String floor, int postalCode, String city,
            String phoneNumber, String representationType,
            String note,
            Map<Integer, String> serviceIDMap,
            Map<Integer, String> offerIDMap) {

        // adding a Inquiry to the case
        inquiryList = new ArrayList<>();
        inquiryList.add(inquiry);

        // seting the responsible caseworker
        this.responsibleCaseworkerDomainID = responsibleCaseworkerDomainID;

        this.informedRightsBystander = informedRightsBystander;
        this.informedRightsElectronicRegistration = informedRightsElectronicRegistration;
        this.consent = consent;

        this.consentToInformationGathering = new ArrayList<>();
        if (!consentToInformationGathering.isEmpty()) {
            for (String s : consentToInformationGathering) {
                this.consentToInformationGathering.add(s);
            }
        }

        this.specialCircumstances = specialCircumstances;
        this.otherActingMunicipality = otherActingMunicipality;
        this.otherPayingMunicipality = otherPayingMunicipality;

        // creating a list of caseworkers who has ben affiliated with the case and adding the responsibleCaseworkerDomainID to the list
        this.affiliatedCaseworkers = new ArrayList<>();
        affiliatedCaseworkers.add(this.responsibleCaseworkerDomainID);

        //creates a list to hold meetings and adds the first meeting
        this.meetingList = new ArrayList<>();
        meetingList.add(new Meeting(meetingTime, meetingDescription, meetingLocation));

        // creates a list to hold representants and ads the first representant if one such is added.
        this.representationList = new ArrayList<>();
        if (!cprNumber.isEmpty()) {
            this.representationList.add(new Representation(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber, representationType));
        }

        // creates a list to hold casenotes and ads one if one such exist
        this.caseNoteList = new ArrayList<>();
        if (!note.isEmpty()) {
            this.caseNoteList.add(new CaseNote(note));
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

    private void addAffiliatedCaseworker(Collection<String> caseworkerIDList) {
        for (String s : caseworkerIDList) {
            if (!this.affiliatedCaseworkers.contains(s)) {
                this.affiliatedCaseworkers.add(s);
            }
        }
    }

    @Override
    public void addAffiliatedCaseworker(String caseworkerID) {
        if (!this.affiliatedCaseworkers.contains(caseworkerID)) {
            this.affiliatedCaseworkers.add(caseworkerID);
        }
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
        return responsibleCaseworkerDomainID;
    }

    @Override
    public void setResponsibleCaseworker(String responsibleCaseworkerID) {
        this.responsibleCaseworkerDomainID = responsibleCaseworkerID;
//        addAffiliatedCaseworker(responsibleCaseworkerID);
    }

    @Override
    public Collection<String> getAffiliatedCaseworkers() {
        return affiliatedCaseworkers;
    }

    @Override
    public Collection<IMeeting> getMeetingList() {
        return meetingList;
    }

    @Override
    public void addMeeting(IMeeting meeting) {
        meetingList.add(meeting);
    }

    @Override
    public Collection<IRepresentation> getRepresentationList() {
        return representationList;
    }

    @Override
    public void addRepresentation(IRepresentation representation) {
        representationList.add(representation);
    }

    @Override
    public Collection<ICaseNote> getCaseNoteList() {
        return caseNoteList;
    }

    @Override
    public void addCaseNote(ICaseNote caseNote) {
        caseNoteList.add(caseNote);
    }

    @Override
    public Collection<IService> getServiceList() {
        return serviceList;
    }

    @Override
    public void addService(IService service) {
        serviceList.add(service);
    }

    @Override
    public Collection<IOffer> getOfferList() {
        return offerList;
    }

    @Override
    public void addOffer(IOffer offer) {
        offerList.add(offer);
    }

    @Override
    public boolean isInformedRightsBystander() {
        return informedRightsBystander;
    }

    void setInformedRightsBystander(boolean informedRightsBystander) {
        this.informedRightsBystander = informedRightsBystander;
    }

    void setInformedRightsElectronicRegistration(boolean informedRightsElectronicRegistration) {
        this.informedRightsElectronicRegistration = informedRightsElectronicRegistration;
    }

    void setConsent(String consent) {
        this.consent = consent;
    }

    void setSpecialCircumstances(String specialCircumstances) {
        this.specialCircumstances = specialCircumstances;
    }

    void setOtherActingMunicipality(String otherActingMunicipality) {
        this.otherActingMunicipality = otherActingMunicipality;
    }

    void setOtherPayingMunicipality(String otherPayingMunicipality) {
        this.otherPayingMunicipality = otherPayingMunicipality;
    }

    @Override
    public boolean isInformedRightsElectronicRegistration() {
        return informedRightsElectronicRegistration;
    }

    @Override
    public String getConsent() {
        return consent;
    }

    @Override
    public Collection<String> getConsentToInformationGathering() {
        return consentToInformationGathering;
    }

    @Override
    public String getSpecialCircumstances() {
        return specialCircumstances;
    }

    @Override
    public String getOtherActingMunicipality() {
        return otherActingMunicipality;
    }

    @Override
    public String getOtherPayingMunicipality() {
        return otherPayingMunicipality;
    }

    @Override
    public void addConsentToInformationGathering(String consentToInformationGathering) {
        this.consentToInformationGathering.add(consentToInformationGathering);
    }

}
