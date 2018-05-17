
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
import Acquaintance.IDepartment;
import Acquaintance.IJob;
import Acquaintance.ILoginPersistence;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

/**
 *
 * @author Alexa
 */
public class BusinessFacade implements IBusiness {

    private IDataPersistence dataPersistence;
    private ILoginPersistence loginPersistence;
    private CaseManager caseManager;
    private LoginManager loginManager;

    //BusinessLayer instance
    private static BusinessFacade instance;

    private BusinessFacade() {
        
    }
    
    public static BusinessFacade getInstance() {
        if (instance == null) {
            instance = new BusinessFacade();
        }
        return instance;
    }
    
    public void pingDatabase() throws SQLException {
        loginPersistence.pingDatabase();
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
        this.caseManager = caseManager.getInstance();
        this.loginManager = loginManager.getInstance();
    }

    @Override
    public int login(String userName, String password) {
        return loginManager.login(userName, password);
    }
    
    @Override
    public int getAccess(String userName) {
        return loginPersistence.getAccess(userName);
    }

    @Override
    public void logOut() { //later: Need to return true before scenechange
        loginManager.logOut();
    }
    
    @Override
    public boolean changePassword(String oldPassword, String newPassword1, String newPassword2){
        return loginManager.changePassword(oldPassword, newPassword1, newPassword2);
    }
    
    public IUser getUserOne() {
        return loginManager.getUserOne();
    }

    @Override
    public boolean checkCredentials(String userName, String password) {
        return loginManager.checkCredentials(userName, password);
    }
    
    public boolean getUserInfo(String userName) {
        return loginPersistence.getUserInfo(userName);
    }
    public IUser getUser(String userName) {
        return loginPersistence.getUser(userName);
    }

    @Override
    public boolean createUser(int userID, String firstName, String lastName, String userName, String password1, String password2, boolean active, Timestamp createdTime, Timestamp lastLoginTime) {
        return loginManager.getUserOne().getAdmin().createUser(firstName, lastName, userName, password1, password2, active, createdTime, lastLoginTime);
    }

    @Override
    public boolean changeJob(String userName, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName) {
        return loginManager.getUserOne().getAdmin().changeJob(userName, jobTitle, ID, accessLevel, departmentID, departmentName);
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
        System.out.println(loginManager.getUserOne().getJob());
        return loginManager.getUserOne().getJob().getUserList();
    }

    Collection<IUser> getAllUsers() {
        return loginPersistence.getAllUsers();
    }

    @Override
    public boolean newInquiry(String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber) {
        return caseManager.createInquiry(problemDescription, inquirer, citizenAgreement, cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }

//    // dette kald er forkert og bliver ivaretaget internt i casemanager
//    @Override
//    public boolean sendToDB(IInquiry inquiry) {
//        return caseManager.sendInqToDB(inquiry); // kaldt fra GUI
//    }

    public boolean saveInq(IInquiry inquiry) {
        return dataPersistence.saveInquiry(inquiry); // kaldt fra Controller
    }
    
    @Override
    public boolean newCase(String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber,
                String responsibleCaseworker, boolean informedRightsBystander, boolean informedRightsElectronicRegistration, String consent, Collection<String> consentToInformationGathering, String specialCircumstances, String otherActingMunicipality, String otherPayingMunicipality,
                Timestamp meetingTime, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation,
                String cprNumberRep, String firstNameRep, String lastNameRep, String roadNameRep, String houseNumberRep, String floorRep, int postalCodeRep, String cityRep, String phoneNumberRep, String representationType,
                String note, String caseWorkerID,
                Map<Integer, String> serviceIDList,
                Map<Integer, String> offerIDList){
        return caseManager.createCase(problemDescription, inquirer, citizenAgreement, cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber, responsibleCaseworker, informedRightsBystander, informedRightsElectronicRegistration, consent, consentToInformationGathering, specialCircumstances, otherActingMunicipality, otherPayingMunicipality, meetingTime, attendingCasworkerIDList, meetingDescription, meetingLocation, cprNumberRep, firstNameRep, lastNameRep, roadNameRep, houseNumberRep, floorRep, postalCodeRep, cityRep, phoneNumberRep, representationType, note, caseWorkerID, serviceIDList, offerIDList);
    }
    
    boolean saveCase(ICase case1) {
        return dataPersistence.saveCase(case1);
    }

    @Override
    public Collection<IJob> getJobList(){
        return loginPersistence.getJobList();
        
    }

    @Override
    public Collection<IDepartment> getdepartmentList() {
        return loginPersistence.getDepartmentList();
    }
}
