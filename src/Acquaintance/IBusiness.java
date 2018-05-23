package Acquaintance;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Alexa
 */
public interface IBusiness {

    Collection<IJob> getJobList();

    Collection<IDepartment> getdepartmentList();

    void injectDataPersistence(IDataPersistence dataPersistence);

    void injectLoginPersistence(ILoginPersistence loginPersistence);

    int login(String name, String pw);

    void logOut();

   public boolean changePassword(String oldPassword, String newPassword);

    IUser getCurentUser();
//    
//    boolean checkCredentials(String userName, String password);

    public boolean createUser(String firstName, String lastName, String userName, String password1, String password2, String jobtitle, int jobID, int accessLevel, int departmentID, String departmentName);

    public boolean changeJob(String userName, boolean active, String jobTitle, int ID, int accessLevel, int departmentID, String departmentName);

    Collection<IUser> getUserList();

    public void startUp();

    void pingDatabase() throws SQLException;

    boolean newInquiry(String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber, String casworkerDomainId);

    public boolean newCase(String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber,
                String responsibleCaseworker, boolean informedRightsBystander, boolean informedRightsElectronicRegistration, String consent, Collection<String> consentToInformationGathering, String specialCircumstances, String otherActingMunicipality, String otherPayingMunicipality,
                Timestamp meetingDate, String meetingDescription, String meetingLocation,
                String cprNumberRep, String firstNameRep, String lastNameRep, String roadNameRep, String houseNumberRep, String floorRep, int postalCodeRep, String cityRep, String phoneNumberRep, String representationType,
                String note,
                Map<Integer, String> serviceIDList,
                Map<Integer, String> offerIDList);

    String getCurrentUserDomainID();
    
    String getdomainID(IUser user);
    
    IUser getUserFromDomainID(String domainID);
    
    boolean doesUserExist(String userName);
  
 public boolean validateCPR(String cprNumber);
}
