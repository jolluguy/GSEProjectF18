
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.ICase;
import Acquaintance.IInquiry;
import Acquaintance.IUser;
import java.util.Collection;
import Acquaintance.IDataPersistence;
import Acquaintance.ILoginPersistence;
import java.util.Map;
import java.sql.Timestamp;

/**
 *
 * @author Alexa
 */
public class BusinessFacade implements IBusiness {

    private IDataPersistence dataPersistence;
    private ILoginPersistence loginPersistence;
    private CaseManager caseManeger;
    private AccessManager accessManager; // Delegate all calls conserning users to the manager.
    private Admin admin;

    //BusinessLayer instance
    private static BusinessFacade instance = null;

    private BusinessFacade() {
        
    }
    
    public static BusinessFacade getInstance() {
        if (instance == null) {
            instance = new BusinessFacade();
        }
        return instance;
    }

    //Data-layer injection
    @Override
    public void injectDataPersistence(IDataPersistence dataPersistence) {
        this.dataPersistence = dataPersistence;
    }

    //Data-layer injection
    @Override
    public void injectLoginPersistence(ILoginPersistence loginPersistence) {
        this.loginPersistence = loginPersistence;
    }

    @Override
    public void startUp() {
        this.caseManeger = caseManeger.getInstance();
        this.accessManager = accessManager.getInstance();
        this.admin = admin.getInstance();
    }

    @Override
    public int login(String userName, String pw) {
        return accessManager.login(userName, pw);
    }

    @Override
    public void logOut() { //later: Need to return true before scenechange
        accessManager.logOut();
    }
    
    @Override
    public boolean changePassword(String oldPassword, String newPassword1, String newPassword2){
        return accessManager.changePassword(oldPassword, newPassword1, newPassword2);
    }
    
    public IUser getUserOne() {
        return accessManager.getUserOne();
    }

    @Override
    public boolean checkCredentials(String userName, String password) {
        return accessManager.checkCredentials(userName, password);
    }
    
    public boolean getUserInfo(String userName) {
        return loginPersistence.getUserInfo(userName);
    }
    public IUser getUser(String userName) {
        return loginPersistence.getUser(userName);
    }

    @Override
    public boolean createUser(String firstName, String lastName, String userName, String password1, String password2, int level) {
        return admin.createUser(firstName, lastName, userName, password1, password2, level);
    }

    @Override
    public boolean changeJob(String userName, String password, int level) {
        return admin.changeJob(userName, password, level);
    }

    public boolean addUser(IUser user) {
        return loginPersistence.addUser(user);
    }

//    public boolean updateUser(IUser user) {
//        return loginPersistence.updateUser(user);
//    }
    
    public boolean updateLastLoginTime(IUser user){
        return loginPersistence.updateLastLoginTime(user);
    }
    
    public boolean updateJob(IUser user){
        return loginPersistence.updateJob(user);
    }

    @Override
    public Collection<IUser> getUserList() {
        return admin.getUserList();
    }

    Collection<IUser> getAllUsers() {
        return loginPersistence.getAllUsers();
    }

    @Override
    public boolean newInquiry(String problemDescription, String inquierer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber) {
        return caseManeger.createInquiry(problemDescription, inquierer, citizenAgreement, cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }

//    // dette kald er forkert og bliver ivaretaget internt i casemaneger
//    @Override
//    public boolean sendToDB(IInquiry inquiry) {
//        return caseManeger.sendInqToDB(inquiry); // kaldt fra GUI
//    }

    public boolean saveInq(IInquiry inquiry) {
        return dataPersistence.saveInquiry(inquiry); // kaldt fra Controller
    }

    @Override
    public boolean newCase(String problemDescription, String inquierer, boolean citizenAgreement, String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber,
                String responsibleCaseworker, boolean informedRightsBistander, boolean informedRightsElectronicRegistration, String consent, Collection<String> consentToInformationGathering, String specialCircumstances, String otherActingMunicipality, String otherPayingMunicipality,
                Timestamp meetingDate, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation,
                String cprNumberRep, String firstNameRep, String lastNameRep, String roadNameRep, String houseNumberRep, String floorRep, int postalCodeRep, String cityRep, String phoneNumberRep, String representationType,
                String note, String caseWorkerID,
                Map<Integer, String> serviceIDList,
                Map<Integer, String> offerIDList){
        return caseManeger.createCase(problemDescription, inquierer, citizenAgreement, cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber, responsibleCaseworker, informedRightsBistander, informedRightsElectronicRegistration, consent, consentToInformationGathering, specialCircumstances, otherActingMunicipality, otherPayingMunicipality, meetingDate, attendingCasworkerIDList, meetingDescription, meetingLocation, cprNumberRep, firstNameRep, lastNameRep, roadNameRep, houseNumberRep, floorRep, postalCodeRep, cityRep, phoneNumberRep, representationType, note, caseWorkerID, serviceIDList, offerIDList);
    }
    
    boolean saveCase(ICase case1) {
        return dataPersistence.saveCase(case1);
    }

}
