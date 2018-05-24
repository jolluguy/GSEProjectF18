package Acquaintance;

import java.util.Collection;

/**
 *
 * @author Rasmus
 */
public interface ICase {
    public boolean isInformedRightsBystander();
    public boolean isInformedRightsElectronicRegistration();
    public String getConsent();
    public String getSpecialCircumstances();
    public String getOtherActingMunicipality();
    public String getOtherPayingMunicipality();
    
    public Collection<IInformationGathering> getConsentToInformationGatheringList();
    public void addConsentToInformationGathering(String consentToInformationGathering);
    
    public Collection<IInquiry> getInquiryList();
    public void addInquiryToCase(IInquiry inq);
    
    public String getResponsibleCaseworker();
    public void setResponsibleCaseworker(String responsibleCaseworkerID);
    
    public Collection<String> getAffiliatedCaseworkers();
    public void addAffiliatedCaseworker(String caseworkerID);
    
    public Collection<IMeeting> getMeetingList();
    public void addMeeting(IMeeting meeting);
    
    public Collection<IRepresentation> getRepresentationList();
    public void addRepresentation(IRepresentation representation);
    
    public Collection<ICaseNote> getCaseNoteList();
    public void addCaseNote(ICaseNote caseNote);
    
    public Collection<IService> getServiceList();
    public void addService(IService service);
    
    public Collection<IOffer> getOfferList();
    public void addOffer(IOffer offer);
}