package Presentation;

import Acquaintance.IBusiness;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Alexa
 */
public class CaseworkerController implements Initializable {

    private IBusiness business = GUIFacade.getInstance().getBusiness();

    //private TextField cprTextField;
    @FXML
    private TextField phoneNumberPrefixTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField streetNameTextField;
    @FXML
    private TextField streetNumberTextField;
    @FXML
    private TextField floorTextField;
    @FXML
    private TextField postalCodeTextField;
    @FXML
    private Button cprInfoButton;
    @FXML
    private TextField cityTextField;
    @FXML
    private MenuItem logOutButton;

    @FXML
    private CheckBox activity104CheckBox;
    @FXML
    private CheckBox carriageCheckBox;
    @FXML
    private CheckBox carriage105CheckBox;
    @FXML
    private CheckBox carriage25CheckBox;
    @FXML
    private CheckBox carriage5CheckBox;
    @FXML
    private CheckBox carriage10CheckBox;
    @FXML
    private CheckBox carriage170CheckBox;
    @FXML
    private CheckBox carriage172CheckBox;
    @FXML
    private CheckBox individualCarriageCheckBox;
    @FXML
    private CheckBox treatmentCheckBox;
    @FXML
    private CheckBox treatment101CheckBox;
    @FXML
    private CheckBox treatment141CheckBox;
    @FXML
    private CheckBox treatmentTherapyCheckBox;
    @FXML
    private CheckBox treatmentPsykCheckBox;
    @FXML
    private CheckBox protectedEmploymentCheckBox;
    @FXML
    private CheckBox dayReliefCheckBox;
    @FXML
    private CheckBox cashBenefitCheckBox;
    @FXML
    private CheckBox remunerationCheckBox;
    @FXML
    private CheckBox additionalCostCheckBox;
    @FXML
    private CheckBox control126CheckBox;
    @FXML
    private CheckBox control127CheckBox;
    @FXML
    private CheckBox control128CheckBox;
    @FXML
    private CheckBox control125CheckBox;
    @FXML
    private CheckBox institutioningCheckBox;
    @FXML
    private CheckBox _24HourReliefCheckBox;
    @FXML
    private CheckBox longInstitutionalisingCheckBox;
    @FXML
    private CheckBox temporaryInstitutionalising80CheckBox;
    @FXML
    private CheckBox temporaryInstitutionalising107CheckBox;
    @FXML
    private CheckBox temporaryInstitutionalising109CheckBox;
    @FXML
    private CheckBox personalHelp83CheckBox;
    @FXML
    private CheckBox personalHelp95CheckBox;
    @FXML
    private CheckBox practicalHelp83CheckBox;
    @FXML
    private CheckBox practicalhelp95CheckBox;
    @FXML
    private CheckBox socialSupportCheckBox;
    @FXML
    private CheckBox administrationSupportCheckBox;
    @FXML
    private CheckBox temporaryInstitutionalising110CheckBox;
    @FXML
    private CheckBox shoppingSupportCheckBox;
    @FXML
    private CheckBox contactSupportCheckBox;
    @FXML
    private CheckBox medicinalSupportCheckBox;
    @FXML
    private CheckBox personalCareCheckBox;
    @FXML
    private CheckBox practicalSupportCheckBox;
    @FXML
    private CheckBox educationSupportCheckBox;
    @FXML
    private CheckBox parentingSupportCheckBox;
    @FXML
    private CheckBox supportPersonCheckBox;
    @FXML
    private CheckBox temporaryReplacement84CheckBox;
    @FXML
    private CheckBox temporaryReplacement95CheckBox;
    @FXML
    private CheckBox personalAssistanceCheckBox;
    @FXML
    private CheckBox contactForDeafblindCheckBox;
    @FXML
    private CheckBox companionCheckBox;
    @FXML
    private CheckBox kinCare118CheckBox;
    @FXML
    private CheckBox kinCare119CheckBox;
    @FXML
    private CheckBox supportToolCheckBox;
    @FXML
    private CheckBox aidCheckBox;
    @FXML
    private CheckBox carAidCheckBox;
    @FXML
    private CheckBox furnishingAidCheckBox;
    @FXML
    private CheckBox goodsAidCheckBox;
    @FXML
    private CheckBox trainingCheckBox;
    @FXML
    private CheckBox rehabilitation85CheckBox;
    @FXML
    private CheckBox rehabilitation86CheckBox;
    @FXML
    private CheckBox rehabilitation102CheckBox;
    @FXML
    private CheckBox maintainingAbility85CheckBox;
    @FXML
    private CheckBox maintainingAbility86CheckBox;
    @FXML
    private CheckBox maintainingAbility102CheckBox;
    @FXML
    private CheckBox educationCheckBox;
    @FXML
    private CheckBox compensatingSpecialEducationCheckBox;
    @FXML
    private CheckBox youthEducationSpecialNeedsCheckBox;
    @FXML
    private CheckBox nonSearchedServicesCheckBox;
    @FXML
    private CheckBox counselingCheckBox;
    @FXML
    private CheckBox supportOrContactPersonCheckBox;
    @FXML
    private CheckBox adultMedicalTreatmentCheckBox;
    @FXML
    private CheckBox activityAndSocialOfferCheckBox;
    @FXML
    private CheckBox protectedEmploymentOfferCheckBox;
    @FXML
    private CheckBox adultDailyTreatmentCheckBoc;
    @FXML
    private CheckBox educationOfferCheckBox;
    @FXML
    private CheckBox standardCareHomeCheckBox;
    @FXML
    private CheckBox standardElderCareHomeCheckBox;
    @FXML
    private CheckBox communityHomeCheckBox;
    @FXML
    private CheckBox adultDayCareCheckBox;
    @FXML
    private CheckBox hostelryCheckBox;
    @FXML
    private CheckBox crisisCenterCheckBox;
    @FXML
    private CheckBox safeHousingCheckBox;
    @FXML
    private CheckBox longTermSafeHousingCheckBox;
    @FXML
    private CheckBox temporaryHousingCheckBox;
    @FXML
    private CheckBox nursingHomeCheckBox;
    @FXML
    private CheckBox rehabilitationgOfferCheckBox;
    @FXML
    private CheckBox adultOutboundOffersCheckBox;
    @FXML
    private CheckBox governmentApprovedOfferCheckBox;
    @FXML
    private ToggleGroup YesNoGroup;
    @FXML
    private RadioButton inquiryYesRadioButton;
    @FXML
    private RadioButton inquiryNoRadioButton;
    @FXML
    private CheckBox controlCheckBox;
    @FXML
    private TextArea descriptionTextAreaInquiry;
    @FXML
    private TextArea descriptionTextAreaCase;
    @FXML
    private ToggleGroup inquiryOriginGroup;
    @FXML
    private ToggleGroup inquiryYesOrNoGroup;
    @FXML
    private ToggleGroup guardianshipGroup;
    @FXML
    private ToggleGroup rightsYesOrNoGroup;
    @FXML
    private ToggleGroup consentYesOrNoGroup;
    @FXML
    private ToggleGroup consentGroup;
    @FXML
    private RadioButton inquiryOriginCitizenRadioButton;
    @FXML
    private RadioButton inquiryOriginNextOfKinRadioButton;
    @FXML
    private RadioButton inquiryOriginDoctorRadioButton;
    @FXML
    private RadioButton inquiryOriginHospitalRadioButton;
    @FXML
    private RadioButton inquiryOriginOtherInstanceRadioButton;
    @FXML
    private RadioButton inquiryOriginActiveOperationRadioButton;
    @FXML
    private RadioButton inquiryOriginOtherMunicipalityRadioButton;
    @FXML
    private RadioButton inquiryOriginOtherRadioButton;
    @FXML
    private RadioButton inquiryUnderstoodYesRadioButton;
    @FXML
    private RadioButton inquiryUnderstoodNoRadioButton;
    @FXML
    private RadioButton guardianShip5RadioButton;
    @FXML
    private RadioButton guardianShip6RadioButton;
    @FXML
    private RadioButton guardianShip7RadioButton;
    @FXML
    private CheckBox rightsBystanderCheckBox;
    @FXML
    private RadioButton rightsYesRadioButton;
    @FXML
    private RadioButton rightsNoRadioButton;
    @FXML
    private TextArea agreedTextArea;
    @FXML
    private RadioButton consentYesRadioButton;
    @FXML
    private RadioButton consentNoRadioButton;
    @FXML
    private RadioButton oralConsentRadioButton;
    @FXML
    private RadioButton writtenConsentRadioButton;
    @FXML
    private CheckBox ownDoctorCheckBox;
    @FXML
    private CheckBox specialDoctorCheckBox;
    @FXML
    private CheckBox hospitalCheckBox;
    @FXML
    private CheckBox unemploymentBenefitsCheckBox;
    @FXML
    private CheckBox offerCheckBox;
    @FXML
    private CheckBox employerCheckBox;
    @FXML
    private CheckBox formerMunicipalityCheckBox;
    @FXML
    private CheckBox otherInstancesCheckBox;
    @FXML
    private TextArea specialCircumstancesTextArea;
    @FXML
    private CheckBox otherActingMunicipalityCheckBox;
    @FXML
    private TextField otherActingMunicipalityTextField;
    @FXML
    private CheckBox otherPayingMunicipalityCheckBox;
    @FXML
    private TextField otherPayingMunicipalityTextField;
    @FXML
    private Button archiveButton;
    @FXML
    private Button newCaseButton;
    @FXML
    private Label inquiryStatusTextField;
    @FXML
    private Label userOneLabel;
    @FXML
    private MenuButton menuBar;
    @FXML
    private TextField CPRBirthField;
    @FXML
    private TextField CPRSecurityField;
    @FXML
    private CheckBox treatmentSpecialDrCheckBox;

    private Map<Integer, String> serviceMap;
    private Map<Integer, String> offerMap;
    private Map<Integer, String> informationGatheringMap;
    
    @FXML
    private Label cprSyntaxLabel;
    @FXML
    private Button makeCaseButton;
    @FXML
    private TextField CPRBirthFieldRep;
    @FXML
    private TextField CPRSecuityFieldRep;
    @FXML
    private TextField firstNameTextFieldRep;
    @FXML
    private TextField lastNameTextFieldRep;
    @FXML
    private TextField streetNameTextFieldRep;
    @FXML
    private TextField streetNumberTextFieldRep;
    @FXML
    private TextField floorTextFieldRep;
    @FXML
    private TextField postalCodeTextFieldRep;
    @FXML
    private TextField cityTextFieldRep;
    @FXML
    private TextField phoneNumberPrefixTextFieldRep;
    @FXML
    private TextField phoneNumberTextFieldRep;
    @FXML
    private Label cprSyntaxLabel1;
    @FXML
    private ChoiceBox<String> attendingCaseworkerSelector;
    @FXML
    private DatePicker meetingDatePicker;
    @FXML
    private TextField meetingLocationTextfield;
    @FXML
    private TextArea caseNoteTextArea;
    @FXML
    private TextField caseCprField;
    @FXML
    private Tab inquiryTab;
    @FXML
    private Tab caseTab;
    @FXML
    private TabPane tabPane;

    private void fillServiceMap() {
        if (activity104CheckBox.isSelected()) {
            serviceMap.put(1, activity104CheckBox.getText());
        }
        if (carriage105CheckBox.isSelected()) {
            serviceMap.put(2, carriage105CheckBox.getText());
        }
        if (carriage25CheckBox.isSelected()) {
            serviceMap.put(3, carriage25CheckBox.getText());
        }
        if (carriage5CheckBox.isSelected()) {
            serviceMap.put(4, carriage5CheckBox.getText());
        }
        if (carriage10CheckBox.isSelected()) {
            serviceMap.put(5, carriage10CheckBox.getText());
        }
        if (carriage170CheckBox.isSelected()) {
            serviceMap.put(6, carriage170CheckBox.getText());
        }
        if (carriage172CheckBox.isSelected()) {
            serviceMap.put(7, carriage172CheckBox.getText());
        }
        if (individualCarriageCheckBox.isSelected()) {
            serviceMap.put(8, individualCarriageCheckBox.getText());
        }
        if (treatment101CheckBox.isSelected()) {
            serviceMap.put(9, treatment101CheckBox.getText());
        }
        if (treatment141CheckBox.isSelected()) {
            serviceMap.put(10, treatment141CheckBox.getText());
        }
        if (treatmentTherapyCheckBox.isSelected()) {
            serviceMap.put(11, treatmentTherapyCheckBox.getText());
        }
        if (treatmentPsykCheckBox.isSelected()) {
            serviceMap.put(12, treatmentPsykCheckBox.getText());
        }
        if (treatmentSpecialDrCheckBox.isSelected()) {
            serviceMap.put(13, treatmentSpecialDrCheckBox.getText());
        }
        if (protectedEmploymentCheckBox.isSelected()) {
            serviceMap.put(14, protectedEmploymentCheckBox.getText());
        }
        if (dayReliefCheckBox.isSelected()) {
            serviceMap.put(15, dayReliefCheckBox.getText());
        }
        if (remunerationCheckBox.isSelected()) {
            serviceMap.put(16, remunerationCheckBox.getText());
        }
        if (additionalCostCheckBox.isSelected()) {
            serviceMap.put(16, additionalCostCheckBox.getText());
        }
        if (control126CheckBox.isSelected()) {
            serviceMap.put(17, control126CheckBox.getText());
        }
        if (control127CheckBox.isSelected()) {
            serviceMap.put(18, control127CheckBox.getText());
        }
        if (control128CheckBox.isSelected()) {
            serviceMap.put(19, control128CheckBox.getText());
        }
        if (control125CheckBox.isSelected()) {
            serviceMap.put(20, control125CheckBox.getText());
        }
        if (_24HourReliefCheckBox.isSelected()) {
            serviceMap.put(21, _24HourReliefCheckBox.getText());
        }
        if (longInstitutionalisingCheckBox.isSelected()) {
            serviceMap.put(22, longInstitutionalisingCheckBox.getText());
        }
        if (temporaryInstitutionalising80CheckBox.isSelected()) {
            serviceMap.put(23, temporaryInstitutionalising80CheckBox.getText());
        }
        if (temporaryInstitutionalising107CheckBox.isSelected()) {
            serviceMap.put(24, temporaryInstitutionalising107CheckBox.getText());
        }
        if (temporaryInstitutionalising109CheckBox.isSelected()) {
            serviceMap.put(25, temporaryInstitutionalising109CheckBox.getText());
        }
        if (personalHelp83CheckBox.isSelected()) {
            serviceMap.put(26, personalHelp83CheckBox.getText());
        }
        if (personalHelp95CheckBox.isSelected()) {
            serviceMap.put(27, personalHelp95CheckBox.getText());
        }
        if (practicalHelp83CheckBox.isSelected()) {
            serviceMap.put(28, practicalHelp83CheckBox.getText());
        }
        if (practicalhelp95CheckBox.isSelected()) {
            serviceMap.put(29, practicalhelp95CheckBox.getText());
        }
        if (administrationSupportCheckBox.isSelected()) {
            serviceMap.put(30, administrationSupportCheckBox.getText());
        }
        if (temporaryInstitutionalising110CheckBox.isSelected()) {
            serviceMap.put(31, temporaryInstitutionalising110CheckBox.getText());
        }
        if (shoppingSupportCheckBox.isSelected()) {
            serviceMap.put(32, shoppingSupportCheckBox.getText());
        }
        if (contactSupportCheckBox.isSelected()) {
            serviceMap.put(33, contactSupportCheckBox.getText());
        }
        if (medicinalSupportCheckBox.isSelected()) {
            serviceMap.put(34, medicinalSupportCheckBox.getText());
        }
        if (personalCareCheckBox.isSelected()) {
            serviceMap.put(35, personalCareCheckBox.getText());
        }
        if (practicalSupportCheckBox.isSelected()) {
            serviceMap.put(36, practicalSupportCheckBox.getText());
        }
        if (educationSupportCheckBox.isSelected()) {
            serviceMap.put(37, educationSupportCheckBox.getText());
        }
        if (parentingSupportCheckBox.isSelected()) {
            serviceMap.put(38, parentingSupportCheckBox.getText());
        }
        if (supportPersonCheckBox.isSelected()) {
            serviceMap.put(39, supportPersonCheckBox.getText());
        }
        if (temporaryReplacement84CheckBox.isSelected()) {
            serviceMap.put(40, temporaryReplacement84CheckBox.getText());
        }
        if (temporaryReplacement95CheckBox.isSelected()) {
            serviceMap.put(41, temporaryReplacement95CheckBox.getText());
        }
        if (personalAssistanceCheckBox.isSelected()) {
            serviceMap.put(42, personalAssistanceCheckBox.getText());
        }
        if (contactForDeafblindCheckBox.isSelected()) {
            serviceMap.put(43, contactForDeafblindCheckBox.getText());
        }
        if (companionCheckBox.isSelected()) {
            serviceMap.put(44, companionCheckBox.getText());
        }
        if (kinCare118CheckBox.isSelected()) {
            serviceMap.put(45, kinCare118CheckBox.getText());
        }
        if (kinCare119CheckBox.isSelected()) {
            serviceMap.put(46, kinCare119CheckBox.getText());
        }
        if (aidCheckBox.isSelected()) {
            serviceMap.put(47, aidCheckBox.getText());
        }
        if (carAidCheckBox.isSelected()) {
            serviceMap.put(48, carAidCheckBox.getText());
        }
        if (furnishingAidCheckBox.isSelected()) {
            serviceMap.put(49, furnishingAidCheckBox.getText());
        }
        if (goodsAidCheckBox.isSelected()) {
            serviceMap.put(50, goodsAidCheckBox.getText());
        }
        if (rehabilitation85CheckBox.isSelected()) {
            serviceMap.put(51, rehabilitation85CheckBox.getText());
        }
        if (rehabilitation86CheckBox.isSelected()) {
            serviceMap.put(52, rehabilitation86CheckBox.getText());
        }
        if (rehabilitation102CheckBox.isSelected()) {
            serviceMap.put(53, rehabilitation102CheckBox.getText());
        }
        if (maintainingAbility85CheckBox.isSelected()) {
            serviceMap.put(54, maintainingAbility85CheckBox.getText());
        }
        if (maintainingAbility86CheckBox.isSelected()) {
            serviceMap.put(55, maintainingAbility86CheckBox.getText());
        }
        if (maintainingAbility102CheckBox.isSelected()) {
            serviceMap.put(56, rehabilitation102CheckBox.getText());
        }
        if (compensatingSpecialEducationCheckBox.isSelected()) {
            serviceMap.put(57, compensatingSpecialEducationCheckBox.getText());
        }
        if (youthEducationSpecialNeedsCheckBox.isSelected()) {
            serviceMap.put(58, youthEducationSpecialNeedsCheckBox.getText());
        }
        if (counselingCheckBox.isSelected()) {
            serviceMap.put(59, counselingCheckBox.getText());
        }
        if (supportOrContactPersonCheckBox.isSelected()) {
            serviceMap.put(60, supportOrContactPersonCheckBox.getText());
        }
    }

    private void fillOfferMap() {
        if (adultMedicalTreatmentCheckBox.isSelected()) {
            offerMap.put(1, adultMedicalTreatmentCheckBox.getText());
        }
        if (activityAndSocialOfferCheckBox.isSelected()) {
            offerMap.put(2, activityAndSocialOfferCheckBox.getText());
        }
        if (protectedEmploymentOfferCheckBox.isSelected()) {
            offerMap.put(3, protectedEmploymentOfferCheckBox.getText());
        }
        if (adultDailyTreatmentCheckBoc.isSelected()) {
            offerMap.put(4, adultDailyTreatmentCheckBoc.getText());
        }
        if (educationOfferCheckBox.isSelected()) {
            offerMap.put(5, educationOfferCheckBox.getText());
        }
        if (standardCareHomeCheckBox.isSelected()) {
            offerMap.put(6, standardCareHomeCheckBox.getText());
        }
        if (standardElderCareHomeCheckBox.isSelected()) {
            offerMap.put(7, standardElderCareHomeCheckBox.getText());
        }
        if (communityHomeCheckBox.isSelected()) {
            offerMap.put(8, communityHomeCheckBox.getText());
        }
        if (adultDayCareCheckBox.isSelected()) {
            offerMap.put(9, adultDayCareCheckBox.getText());
        }
        if (hostelryCheckBox.isSelected()) {
            offerMap.put(10, hostelryCheckBox.getText());
        }
        if (crisisCenterCheckBox.isSelected()) {
            offerMap.put(11, crisisCenterCheckBox.getText());
        }
        if (safeHousingCheckBox.isSelected()) {
            offerMap.put(12, safeHousingCheckBox.getText());
        }
        if (longTermSafeHousingCheckBox.isSelected()) {
            offerMap.put(13, longTermSafeHousingCheckBox.getText());
        }
        if (temporaryHousingCheckBox.isSelected()) {
            offerMap.put(14, temporaryHousingCheckBox.getText());
        }
        if (nursingHomeCheckBox.isSelected()) {
            offerMap.put(15, nursingHomeCheckBox.getText());
        }
        if (rehabilitationgOfferCheckBox.isSelected()) {
            offerMap.put(16, rehabilitationgOfferCheckBox.getText());
        }
        if (adultOutboundOffersCheckBox.isSelected()) {
            offerMap.put(17, adultOutboundOffersCheckBox.getText());
        }
        if (governmentApprovedOfferCheckBox.isSelected()) {
            offerMap.put(18, governmentApprovedOfferCheckBox.getText());
        }
    }
        
        private void informationGatheringMap(){
            if(ownDoctorCheckBox.isSelected()) {
                informationGatheringMap.put(1, ownDoctorCheckBox.getText());
            }
            if(specialDoctorCheckBox.isSelected()){
                informationGatheringMap.put(2, ownDoctorCheckBox.getText());
            }
            if(hospitalCheckBox.isSelected()){
                informationGatheringMap.put(3, hospitalCheckBox.getText());
            }
            if(unemploymentBenefitsCheckBox.isSelected()){
                informationGatheringMap.put(4, unemploymentBenefitsCheckBox.getText());
            }
            if(offerCheckBox.isSelected()){
                informationGatheringMap.put(5, offerCheckBox.getText());
            }
            if(employerCheckBox.isSelected()){
                informationGatheringMap.put(6, employerCheckBox.getText());
            }
            if(formerMunicipalityCheckBox.isSelected()){
                informationGatheringMap.put(7, formerMunicipalityCheckBox.getText());
            }
            if(otherInstancesCheckBox.isSelected()){
                informationGatheringMap.put(8, otherInstancesCheckBox.getText());
            }
        }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        userOneLabel.setText(String.format("%1$s%5$2s%2$s\t%3$s\t%4$s", business.getCurentUser().getFirstName(), business.getCurentUser().getLastName(), "-", business.getCurrentUserDomainID(), ""));
    }

    @FXML
    void newInquiry(ActionEvent event) {
        String cprNumber = CPRBirthField.getText() + "-" + CPRSecurityField.getText();
        String problemDescription = descriptionTextAreaInquiry.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String roadName = streetNameTextField.getText();
        String houseNumber = streetNumberTextField.getText();
        String floor = floorTextField.getText();
        int postalCode = Integer.parseInt(postalCodeTextField.getText());
        String city = cityTextField.getText();
        String phoneNumber = phoneNumberPrefixTextField.getText() + phoneNumberTextField.getText();
        String inquirer = inquiryOriginGroup.getSelectedToggle().toString();
//        String inquirer = "Inquirer";
        boolean citizenAgreement = inquiryUnderstoodYesRadioButton.isSelected();
        String caseworkerDomainID = business.getCurrentUserDomainID();

        boolean inquiryMade = business.newInquiry(problemDescription, inquirer,
                citizenAgreement, cprNumber, firstName,
                lastName, roadName, houseNumber, floor,
                postalCode, city, phoneNumber, caseworkerDomainID);

        if (inquiryMade) {
            System.out.println("Inquiry Made");
            inquiryStatusTextField.setText("Henvendelse er arkiveret med succes.");

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CaseworkerController.class.getName()).log(Level.SEVERE, null, ex);
            }

            inquiryUnderstoodNoRadioButton.setSelected(false);
            inquiryUnderstoodYesRadioButton.setSelected(false);
            CPRBirthField.clear();
            CPRSecurityField.clear();
            descriptionTextAreaInquiry.clear();
            firstNameTextField.clear();
            lastNameTextField.clear();
            streetNameTextField.clear();
            streetNumberTextField.clear();
            floorTextField.clear();
            postalCodeTextField.clear();
            cityTextField.clear();
            phoneNumberTextField.clear();
            inquiryOriginGroup.getSelectedToggle().setSelected(false);

        } else if (!inquiryMade) {
            System.out.println("Inquiry failed");
        }
    }

    @FXML
    private void newCase(ActionEvent event) {
        String cprNumber = CPRBirthField.getText() + "-" + CPRSecurityField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String roadName = streetNameTextField.getText();
        String houseNumber = streetNumberTextField.getText();
        String floor = floorTextField.getText();
        int postalCode = Integer.parseInt(postalCodeTextField.getText());
        String city = cityTextField.getText();
        String phoneNumber = phoneNumberPrefixTextField.getText() + phoneNumberTextField.getText();
        boolean citizenAgreement = inquiryUnderstoodYesRadioButton.isSelected();
        String problemDescription = descriptionTextAreaCase.getText();
        String inquirer = inquiryOriginGroup.getSelectedToggle().toString();
        String responsibleCaseworkerDomainID = business.getCurrentUserDomainID();
        boolean informedRightsBystander = rightsBystanderCheckBox.isSelected();
        boolean informedRightsElectronicRegistration = rightsYesOrNoGroup.getSelectedToggle().isSelected();
        String consent = "nej";

        if (consentYesRadioButton.isSelected()) {
            if (oralConsentRadioButton.isSelected()) {
                consent = oralConsentRadioButton.getText();
            } else if (writtenConsentRadioButton.isSelected()) {
                consent = writtenConsentRadioButton.getText();
            }
        } else if(consentNoRadioButton.isSelected()){
            consent = "Nej";
        }

        //A whole lot of if statements to add the different checkboxes to its corresponding list
        Collection<String> consentToInformationGathering = null;
        if (ownDoctorCheckBox.isSelected()) {
            consentToInformationGathering.add(ownDoctorCheckBox.getText());
        }
        if (specialDoctorCheckBox.isSelected()) {
            consentToInformationGathering.add(specialDoctorCheckBox.getText());
        }
        if (hospitalCheckBox.isSelected()) {
            consentToInformationGathering.add(hospitalCheckBox.getText());
        }
        if (unemploymentBenefitsCheckBox.isSelected()) {
            consentToInformationGathering.add(unemploymentBenefitsCheckBox.getText());
        }
        if (offerCheckBox.isSelected()) {
            consentToInformationGathering.add(offerCheckBox.getText());
        }
        if (employerCheckBox.isSelected()) {
            consentToInformationGathering.add(employerCheckBox.getText());
        }
        if (formerMunicipalityCheckBox.isSelected()) {
            consentToInformationGathering.add(formerMunicipalityCheckBox.getText());
        }
        if (otherInstancesCheckBox.isSelected()) {
            consentToInformationGathering.add(otherInstancesCheckBox.getText());
        }

        String specialCircumstances = specialCircumstancesTextArea.getText();
        String otherActingMunicipality = otherActingMunicipalityTextField.getText();
        String otherPayingMunicipality = otherPayingMunicipalityTextField.getText();
        Timestamp meetingDate = Timestamp.valueOf(meetingDatePicker.getValue().atStartOfDay());
        String meetingDescription = agreedTextArea.getText();
        String meetingLocation = meetingLocationTextfield.getText();
        String cprNumberRep = CPRBirthFieldRep.getText() + "-" + CPRSecuityFieldRep.getText();
        String firstNameRep = firstNameTextFieldRep.getText();
        String lastNameRep = lastNameTextFieldRep.getText();
        String roadNameRep = streetNameTextFieldRep.getText();
        String houseNumberRep = streetNumberTextFieldRep.getText();
        String floorRep = floorTextFieldRep.getText();
        String postalCodeRep = postalCodeTextFieldRep.getText();
        int postalCodeRepInt = Integer.parseInt(postalCodeRep);
        String cityRep = cityTextFieldRep.getText();
        String phoneNumberRep = phoneNumberTextFieldRep.getText();
        String representationType = guardianshipGroup.getSelectedToggle().toString();
        String note = caseNoteTextArea.getText();

        boolean result = business.newCase(problemDescription, inquirer, citizenAgreement, cprNumber, firstName,
                lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber,
                responsibleCaseworkerDomainID, informedRightsBystander, informedRightsElectronicRegistration, consent,
                specialCircumstances, otherActingMunicipality, otherPayingMunicipality,
                meetingDate, meetingDescription,
                meetingLocation, cprNumberRep, firstNameRep, lastNameRep, roadNameRep,
                houseNumberRep, floorRep, postalCodeRepInt, cityRep, phoneNumberRep, representationType,
                note, informationGatheringMap, serviceMap, offerMap);

        if (result) {
            System.out.println("Case has been made.");
        } else {
            System.out.println("Case couldn't be made.");
        }
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent loginScreen = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));

        Scene newScene = new Scene(loginScreen);
        Stage appstage = (Stage) ((Node) menuBar).getScene().getWindow();
        appstage.setScene(newScene);
        appstage.show();

        business.logOut();
    }

    @FXML
    void updateYesNoStatus(ActionEvent event) {
        if (inquiryYesRadioButton.isSelected()) {

            //Remove disable
            activity104CheckBox.setDisable(false);
            carriageCheckBox.setDisable(false);
            treatmentCheckBox.setDisable(false);
            protectedEmploymentCheckBox.setDisable(false);
            dayReliefCheckBox.setDisable(false);
            cashBenefitCheckBox.setDisable(false);
            controlCheckBox.setDisable(false);
            institutioningCheckBox.setDisable(false);
            educationCheckBox.setDisable(false);
            personalHelp83CheckBox.setDisable(false);
            personalHelp95CheckBox.setDisable(false);
            practicalHelp83CheckBox.setDisable(false);
            practicalhelp95CheckBox.setDisable(false);
            socialSupportCheckBox.setDisable(false);
            supportPersonCheckBox.setDisable(false);
            supportToolCheckBox.setDisable(false);
            trainingCheckBox.setDisable(false);
            nonSearchedServicesCheckBox.setDisable(false);
            adultMedicalTreatmentCheckBox.setDisable(false);
            activityAndSocialOfferCheckBox.setDisable(false);
            protectedEmploymentOfferCheckBox.setDisable(false);
            adultDailyTreatmentCheckBoc.setDisable(false);
            educationOfferCheckBox.setDisable(false);
            standardCareHomeCheckBox.setDisable(false);
            standardElderCareHomeCheckBox.setDisable(false);
            communityHomeCheckBox.setDisable(false);
            adultDayCareCheckBox.setDisable(false);
            hostelryCheckBox.setDisable(false);
            crisisCenterCheckBox.setDisable(false);
            safeHousingCheckBox.setDisable(false);
            longTermSafeHousingCheckBox.setDisable(false);
            temporaryHousingCheckBox.setDisable(false);
            nursingHomeCheckBox.setDisable(false);
            rehabilitationgOfferCheckBox.setDisable(false);
            adultOutboundOffersCheckBox.setDisable(false);
            governmentApprovedOfferCheckBox.setDisable(false);

        } else if (inquiryNoRadioButton.isSelected()) {

            //set disable
            if (carriageCheckBox.isSelected()) {
                carriageCheckBox.fire();
            }
            if (treatmentCheckBox.isSelected()) {
                treatmentCheckBox.fire();
            }
            if (cashBenefitCheckBox.isSelected()) {
                cashBenefitCheckBox.fire();
            }
            if (controlCheckBox.isSelected()) {
                controlCheckBox.fire();
            }
            if (institutioningCheckBox.isSelected()) {
                institutioningCheckBox.fire();
            }
            if (educationCheckBox.isSelected()) {
                educationCheckBox.fire();
            }
            if (socialSupportCheckBox.isSelected()) {
                socialSupportCheckBox.fire();
            }
            if (supportPersonCheckBox.isSelected()) {
                supportPersonCheckBox.fire();
            }
            if (supportToolCheckBox.isSelected()) {
                supportToolCheckBox.fire();
            }
            if (trainingCheckBox.isSelected()) {
                trainingCheckBox.fire();
            }
            if (nonSearchedServicesCheckBox.isSelected()) {
                nonSearchedServicesCheckBox.fire();
            }

            activity104CheckBox.setDisable(true);
            carriageCheckBox.setDisable(true);
            treatmentCheckBox.setDisable(true);
            protectedEmploymentCheckBox.setDisable(true);
            dayReliefCheckBox.setDisable(true);
            cashBenefitCheckBox.setDisable(true);
            controlCheckBox.setDisable(true);
            institutioningCheckBox.setDisable(true);
            educationCheckBox.setDisable(true);
            personalHelp83CheckBox.setDisable(true);
            personalHelp95CheckBox.setDisable(true);
            practicalHelp83CheckBox.setDisable(true);
            practicalhelp95CheckBox.setDisable(true);
            socialSupportCheckBox.setDisable(true);
            supportPersonCheckBox.setDisable(true);
            supportToolCheckBox.setDisable(true);
            trainingCheckBox.setDisable(true);
            nonSearchedServicesCheckBox.setDisable(true);
            adultMedicalTreatmentCheckBox.setDisable(true);
            activityAndSocialOfferCheckBox.setDisable(true);
            protectedEmploymentOfferCheckBox.setDisable(true);
            adultDailyTreatmentCheckBoc.setDisable(true);
            educationOfferCheckBox.setDisable(true);
            standardCareHomeCheckBox.setDisable(true);
            standardElderCareHomeCheckBox.setDisable(true);
            communityHomeCheckBox.setDisable(true);
            adultDayCareCheckBox.setDisable(true);
            hostelryCheckBox.setDisable(true);
            crisisCenterCheckBox.setDisable(true);
            safeHousingCheckBox.setDisable(true);
            longTermSafeHousingCheckBox.setDisable(true);
            temporaryHousingCheckBox.setDisable(true);
            nursingHomeCheckBox.setDisable(true);
            rehabilitationgOfferCheckBox.setDisable(true);
            adultOutboundOffersCheckBox.setDisable(true);
            governmentApprovedOfferCheckBox.setDisable(true);

            //Remove selection
            activity104CheckBox.setSelected(false);
            carriageCheckBox.setSelected(false);
            treatmentCheckBox.setSelected(false);
            protectedEmploymentCheckBox.setSelected(false);
            dayReliefCheckBox.setSelected(false);
            cashBenefitCheckBox.setSelected(false);
            controlCheckBox.setSelected(false);
            institutioningCheckBox.setSelected(false);
            educationCheckBox.setSelected(false);
            personalHelp83CheckBox.setSelected(false);
            personalHelp95CheckBox.setSelected(false);
            practicalHelp83CheckBox.setSelected(false);
            practicalhelp95CheckBox.setSelected(false);
            socialSupportCheckBox.setSelected(false);
            supportPersonCheckBox.setSelected(false);
            supportToolCheckBox.setSelected(false);
            trainingCheckBox.setSelected(false);
            nonSearchedServicesCheckBox.setSelected(false);
            adultMedicalTreatmentCheckBox.setSelected(false);
            activityAndSocialOfferCheckBox.setSelected(false);
            protectedEmploymentOfferCheckBox.setSelected(false);
            adultDailyTreatmentCheckBoc.setSelected(false);
            educationOfferCheckBox.setSelected(false);
            standardCareHomeCheckBox.setSelected(false);
            standardElderCareHomeCheckBox.setSelected(false);
            communityHomeCheckBox.setSelected(false);
            adultDayCareCheckBox.setSelected(false);
            hostelryCheckBox.setSelected(false);
            crisisCenterCheckBox.setSelected(false);
            safeHousingCheckBox.setSelected(false);
            longTermSafeHousingCheckBox.setSelected(false);
            temporaryHousingCheckBox.setSelected(false);
            nursingHomeCheckBox.setSelected(false);
            rehabilitationgOfferCheckBox.setSelected(false);
            adultOutboundOffersCheckBox.setSelected(false);
            governmentApprovedOfferCheckBox.setSelected(false);

        }
    }

    @FXML
    void updateCarriageStatus(ActionEvent event) {
        if (carriageCheckBox.isSelected()) {
            carriage105CheckBox.setDisable(false);
            carriage25CheckBox.setDisable(false);
            carriage5CheckBox.setDisable(false);
            carriage10CheckBox.setDisable(false);
            carriage170CheckBox.setDisable(false);
            carriage172CheckBox.setDisable(false);
            individualCarriageCheckBox.setDisable(false);

        } else if (!carriageCheckBox.isSelected()) {
            carriage105CheckBox.setDisable(true);
            carriage25CheckBox.setDisable(true);
            carriage5CheckBox.setDisable(true);
            carriage10CheckBox.setDisable(true);
            carriage170CheckBox.setDisable(true);
            carriage172CheckBox.setDisable(true);
            individualCarriageCheckBox.setDisable(true);

            carriage105CheckBox.setSelected(false);
            carriage25CheckBox.setSelected(false);
            carriage5CheckBox.setSelected(false);
            carriage10CheckBox.setSelected(false);
            carriage170CheckBox.setSelected(false);
            carriage172CheckBox.setSelected(false);
            individualCarriageCheckBox.setSelected(false);
        }
    }

    @FXML
    void updateTreatmentStatus(ActionEvent event) {
        if (treatmentCheckBox.isSelected()) {
            treatment101CheckBox.setDisable(false);
            treatment141CheckBox.setDisable(false);
            treatmentTherapyCheckBox.setDisable(false);
            treatmentPsykCheckBox.setDisable(false);
            treatmentSpecialDrCheckBox.setDisable(false);

        } else if (!treatmentCheckBox.isSelected()) {

            treatment101CheckBox.setDisable(true);
            treatment141CheckBox.setDisable(true);
            treatmentTherapyCheckBox.setDisable(true);
            treatmentPsykCheckBox.setDisable(true);
            treatmentSpecialDrCheckBox.setDisable(true);

            treatment101CheckBox.setSelected(false);
            treatment141CheckBox.setSelected(false);
            treatmentTherapyCheckBox.setSelected(false);
            treatmentPsykCheckBox.setSelected(false);
            treatmentSpecialDrCheckBox.setSelected(false);
        }
    }

    @FXML
    void updateCashBenefitStatus(ActionEvent event) {
        if (cashBenefitCheckBox.isSelected()) {
            remunerationCheckBox.setDisable(false);
            additionalCostCheckBox.setDisable(false);

        } else if (!cashBenefitCheckBox.isSelected()) {

            remunerationCheckBox.setDisable(true);
            additionalCostCheckBox.setDisable(true);

            remunerationCheckBox.setSelected(false);
            additionalCostCheckBox.setSelected(false);
        }
    }

    @FXML
    void updateControlStatus(ActionEvent event) {
        if (controlCheckBox.isSelected()) {

            control126CheckBox.setDisable(false);
            control127CheckBox.setDisable(false);
            control128CheckBox.setDisable(false);
            control125CheckBox.setDisable(false);

        } else if (!controlCheckBox.isSelected()) {

            control126CheckBox.setDisable(true);
            control127CheckBox.setDisable(true);
            control128CheckBox.setDisable(true);
            control125CheckBox.setDisable(true);

            control126CheckBox.setSelected(false);
            control127CheckBox.setSelected(false);
            control128CheckBox.setSelected(false);
            control125CheckBox.setSelected(false);
        }
    }

    @FXML
    void updateInstitutioningStatus(ActionEvent event) {
        if (institutioningCheckBox.isSelected()) {
            _24HourReliefCheckBox.setDisable(false);
            longInstitutionalisingCheckBox.setDisable(false);
            temporaryInstitutionalising80CheckBox.setDisable(false);
            temporaryInstitutionalising107CheckBox.setDisable(false);
            temporaryInstitutionalising109CheckBox.setDisable(false);
            temporaryInstitutionalising110CheckBox.setDisable(false);

        } else if (!institutioningCheckBox.isSelected()) {

            _24HourReliefCheckBox.setDisable(true);
            longInstitutionalisingCheckBox.setDisable(true);
            temporaryInstitutionalising80CheckBox.setDisable(true);
            temporaryInstitutionalising107CheckBox.setDisable(true);
            temporaryInstitutionalising109CheckBox.setDisable(true);
            temporaryInstitutionalising110CheckBox.setDisable(true);

            _24HourReliefCheckBox.setSelected(false);
            longInstitutionalisingCheckBox.setSelected(false);
            temporaryInstitutionalising80CheckBox.setSelected(false);
            temporaryInstitutionalising107CheckBox.setSelected(false);
            temporaryInstitutionalising109CheckBox.setSelected(false);
            temporaryInstitutionalising110CheckBox.setSelected(false);
        }
    }

    @FXML
    void updateEducationStatus(ActionEvent event) {
        if (educationCheckBox.isSelected()) {

            compensatingSpecialEducationCheckBox.setDisable(false);
            youthEducationSpecialNeedsCheckBox.setDisable(false);

        } else if (!educationCheckBox.isSelected()) {

            compensatingSpecialEducationCheckBox.setDisable(true);
            youthEducationSpecialNeedsCheckBox.setDisable(true);
            compensatingSpecialEducationCheckBox.setSelected(false);
            youthEducationSpecialNeedsCheckBox.setSelected(false);
        }
    }

    @FXML
    void updateSocialSupportStatus(ActionEvent event) {
        if (socialSupportCheckBox.isSelected()) {
            administrationSupportCheckBox.setDisable(false);
            shoppingSupportCheckBox.setDisable(false);
            contactSupportCheckBox.setDisable(false);
            medicinalSupportCheckBox.setDisable(false);
            personalCareCheckBox.setDisable(false);
            practicalSupportCheckBox.setDisable(false);
            educationSupportCheckBox.setDisable(false);
            parentingSupportCheckBox.setDisable(false);

        } else if (!socialSupportCheckBox.isSelected()) {
            //disables checkboxes
            administrationSupportCheckBox.setDisable(true);
            shoppingSupportCheckBox.setDisable(true);
            contactSupportCheckBox.setDisable(true);
            medicinalSupportCheckBox.setDisable(true);
            personalCareCheckBox.setDisable(true);
            practicalSupportCheckBox.setDisable(true);
            educationSupportCheckBox.setDisable(true);
            parentingSupportCheckBox.setDisable(true);

            //Deselect checkboxes
            administrationSupportCheckBox.setSelected(false);
            shoppingSupportCheckBox.setSelected(false);
            contactSupportCheckBox.setSelected(false);
            medicinalSupportCheckBox.setSelected(false);
            personalCareCheckBox.setSelected(false);
            practicalSupportCheckBox.setSelected(false);
            educationSupportCheckBox.setSelected(false);
            parentingSupportCheckBox.setSelected(false);
        }
    }

    @FXML
    void updateSupportPersonStatus(ActionEvent event) {
        if (supportPersonCheckBox.isSelected()) {
            //Enables checkboxes
            temporaryReplacement84CheckBox.setDisable(false);
            temporaryReplacement95CheckBox.setDisable(false);
            personalAssistanceCheckBox.setDisable(false);
            contactForDeafblindCheckBox.setDisable(false);
            companionCheckBox.setDisable(false);
            kinCare118CheckBox.setDisable(false);
            kinCare119CheckBox.setDisable(false);

        } else if (!supportPersonCheckBox.isSelected()) {
            //Disables checkboxes
            temporaryReplacement84CheckBox.setDisable(true);
            temporaryReplacement95CheckBox.setDisable(true);
            personalAssistanceCheckBox.setDisable(true);
            contactForDeafblindCheckBox.setDisable(true);
            companionCheckBox.setDisable(true);
            kinCare118CheckBox.setDisable(true);
            kinCare119CheckBox.setDisable(true);

            //Deselect checkboxes
            temporaryReplacement84CheckBox.setSelected(false);
            temporaryReplacement95CheckBox.setSelected(false);
            personalAssistanceCheckBox.setSelected(false);
            contactForDeafblindCheckBox.setSelected(false);
            companionCheckBox.setSelected(false);
            kinCare118CheckBox.setSelected(false);
            kinCare119CheckBox.setSelected(false);
        }
    }

    @FXML
    void updateSupportToolStatus(ActionEvent event) {
        if (supportToolCheckBox.isSelected()) {

            aidCheckBox.setDisable(false);
            carAidCheckBox.setDisable(false);
            furnishingAidCheckBox.setDisable(false);
            goodsAidCheckBox.setDisable(false);

        } else if (!supportToolCheckBox.isSelected()) {

            aidCheckBox.setDisable(true);
            carAidCheckBox.setDisable(true);
            furnishingAidCheckBox.setDisable(true);
            goodsAidCheckBox.setDisable(true);

            aidCheckBox.setSelected(false);
            carAidCheckBox.setSelected(false);
            furnishingAidCheckBox.setSelected(false);
            goodsAidCheckBox.setSelected(false);
        }
    }

    @FXML
    void updateTrainingStatus(ActionEvent event) {
        if (trainingCheckBox.isSelected()) {

            rehabilitation85CheckBox.setDisable(false);
            rehabilitation86CheckBox.setDisable(false);
            rehabilitation102CheckBox.setDisable(false);
            maintainingAbility85CheckBox.setDisable(false);
            maintainingAbility86CheckBox.setDisable(false);
            maintainingAbility102CheckBox.setDisable(false);

        } else if (!trainingCheckBox.isSelected()) {

            rehabilitation85CheckBox.setDisable(true);
            rehabilitation86CheckBox.setDisable(true);
            rehabilitation102CheckBox.setDisable(true);
            maintainingAbility85CheckBox.setDisable(true);
            maintainingAbility86CheckBox.setDisable(true);
            maintainingAbility102CheckBox.setDisable(true);

            rehabilitation85CheckBox.setSelected(false);
            rehabilitation86CheckBox.setSelected(false);
            rehabilitation102CheckBox.setSelected(false);
            maintainingAbility85CheckBox.setSelected(false);
            maintainingAbility86CheckBox.setSelected(false);
            maintainingAbility102CheckBox.setSelected(false);
        }
    }

    @FXML
    void updateNonSearchedServicesStatus(ActionEvent event) {
        if (nonSearchedServicesCheckBox.isSelected()) {

            counselingCheckBox.setDisable(false);
            supportOrContactPersonCheckBox.setDisable(false);

        } else if (!nonSearchedServicesCheckBox.isSelected()) {

            counselingCheckBox.setDisable(true);
            supportOrContactPersonCheckBox.setDisable(true);

            counselingCheckBox.setSelected(false);
            supportOrContactPersonCheckBox.setSelected(false);

        }
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        Parent pwScreen = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));

        Scene newScene = new Scene(pwScreen);
        Stage appstage = (Stage) menuBar.getScene().getWindow();
        appstage.setScene(newScene);
        appstage.show();
    }

    @FXML
    private void checkCPRValidityCitizen(KeyEvent event) {
        String cprCitizen = (CPRBirthField.getText() + "-" + CPRSecurityField.getText());
        boolean result = business.validateCPR(cprCitizen);
        if (result) {
            CPRBirthField.setStyle("-fx-text-fill: black;");
            CPRSecurityField.setStyle("-fx-text-fill: black;");
            cprSyntaxLabel.setVisible(false);
            newCaseButton.setDisable(false);
            archiveButton.setDisable(false);
        } else {
            CPRBirthField.setStyle("-fx-text-fill: red;");
            CPRSecurityField.setStyle("-fx-text-fill: red;");
            cprSyntaxLabel.setVisible(true);
            newCaseButton.setDisable(true);
            archiveButton.setDisable(true);
        }
    }

    @FXML
    private void checkCPRValidityRep(KeyEvent event) {
        String cprRep = (CPRBirthFieldRep.getText() + "-" + CPRSecuityFieldRep.getText());
        boolean result2 = business.validateCPR(cprRep);

        if (result2) {
            CPRBirthFieldRep.setStyle("-fx-text-fill: black;");
            CPRSecuityFieldRep.setStyle("-fx-text-fill: black;");
            cprSyntaxLabel1.setVisible(false);
        } else {
            CPRBirthFieldRep.setStyle("-fx-text-fill: red;");
            CPRSecuityFieldRep.setStyle("-fx-text-fill: red;");
            cprSyntaxLabel1.setVisible(true);
        }
    }

    @FXML
    private void switchToCase(ActionEvent event) {
        caseCprField.setText(CPRBirthField.getText() + "-" + CPRSecurityField.getText());
        descriptionTextAreaCase.setText(descriptionTextAreaInquiry.getText());

        tabPane.getSelectionModel().select(caseTab);

    }
}
