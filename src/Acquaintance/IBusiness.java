/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alexa
 */
public interface IBusiness {

    void injectDataPersistence(IDataPersistence dataPersistence);

    void injectLoginPersistence(ILoginPersistence loginPersistence);

    int login(String name, String pw);

    void logOut();
    
    boolean changePassword(String oldPassword, String newPassword1, String newPassword2);
    
    IUser getUserOne();
    
    boolean checkCredentials(String userName, String password);
    
    boolean createUser(String firstName, String lastName, String userName, String password1, String password2, int level);

    boolean changeJob(String userName, String password, int level);
    
    Collection<IUser> getUserList();
   
//  se se komentar på busnisfasade  
//   public boolean sendToDB(IInquiry inquiry);
   
   public void startUp();
   
   boolean newInquiry(String problemDescription, String inquierer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber);

    public boolean newCase(String problemDescription, String inquierer, boolean citizenAgreement, String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber,
                String responsibleCaseworker, boolean informedRightsBistander, boolean informedRightsElectronicRegistration, String consent, Collection<String> consentToInformationGathering, String specialCircumstances, String otherActingMunicipality, String otherPayingMunicipality,
                Timestamp meetingDate, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation,
                String cprNumberRep, String firstNameRep, String lastNameRep, String roadNameRep, String houseNumberRep, String floorRep, int postalCodeRep, String cityRep, String phoneNumberRep, String representationType,
                String note, String caseWorkerID,
                Map<Integer, String> serviceIDList,
                Map<Integer, String> offerIDList);
}
