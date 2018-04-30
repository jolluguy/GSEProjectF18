/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterlogin;

import Acquaintance.IBusiness;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Alexa
 */
public class CaseworkerController implements Initializable {

    private IBusiness business = SemesterLogin.getInstance().getBusiness();

    @FXML
    private TextField cprTextField;
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
    private TextField descriptionTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private Button logOutButton;
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
    private CheckBox treamentSpecialDrCheckBox;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void updateYesNoStatus(ActionEvent event) {
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
            carriageCheckBox.fire();
            treatmentCheckBox.fire();
            cashBenefitCheckBox.fire();
            controlCheckBox.fire();
            institutioningCheckBox.fire();
            educationCheckBox.fire();
            socialSupportCheckBox.fire();
            supportPersonCheckBox.fire();
            supportToolCheckBox.fire();
            trainingCheckBox.fire();
            nonSearchedServicesCheckBox.fire();
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
    public void updateCarriageStatus(ActionEvent event) {
        System.out.println("test" + event);
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
    public void updateTreatmentStatus(ActionEvent event) {
        if (treatmentCheckBox.isSelected()) {
            treatment101CheckBox.setDisable(false);
            treatment141CheckBox.setDisable(false);
            treatmentTherapyCheckBox.setDisable(false);
            treatmentPsykCheckBox.setDisable(false);
            treamentSpecialDrCheckBox.setDisable(false);

        } else if(!treatmentCheckBox.isSelected()){
            
            treatment101CheckBox.setDisable(true);
            treatment141CheckBox.setDisable(true);
            treatmentTherapyCheckBox.setDisable(true);
            treatmentPsykCheckBox.setDisable(true);
            treamentSpecialDrCheckBox.setDisable(true);
            
            treatment101CheckBox.setSelected(false);
            treatment141CheckBox.setSelected(false);
            treatmentTherapyCheckBox.setSelected(false);
            treatmentPsykCheckBox.setSelected(false);
            treamentSpecialDrCheckBox.setSelected(false);
        }
    }
    
    @FXML
    public void updateCashBenefitStatus(ActionEvent event){
        if(cashBenefitCheckBox.isSelected()){
            remunerationCheckBox.setDisable(false);
            additionalCostCheckBox.setDisable(false);
            
        } else if(!cashBenefitCheckBox.isSelected()){
            
            remunerationCheckBox.setDisable(true);
            additionalCostCheckBox.setDisable(true);
            
            remunerationCheckBox.setSelected(false);
            additionalCostCheckBox.setSelected(false);
        }
    }
    
    @FXML
    public void updateControlStatus(ActionEvent event){
        if(controlCheckBox.isSelected()){
            
            control126CheckBox.setDisable(false);
            control127CheckBox.setDisable(false);
            control128CheckBox.setDisable(false);
            control125CheckBox.setDisable(false);

        } else if(!controlCheckBox.isSelected()){
            
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
    public void updateInstitutioningStatus(ActionEvent event){
        if(institutioningCheckBox.isSelected()){
            _24HourReliefCheckBox.setDisable(false);
            longInstitutionalisingCheckBox.setDisable(false);
            temporaryInstitutionalising80CheckBox.setDisable(false);
            temporaryInstitutionalising107CheckBox.setDisable(false);
            temporaryInstitutionalising109CheckBox.setDisable(false);
            temporaryInstitutionalising110CheckBox.setDisable(false);

        } else if(!institutioningCheckBox.isSelected()){
            
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
    public void updateEducationStatus(ActionEvent event){
        if(educationCheckBox.isSelected()){
            
            compensatingSpecialEducationCheckBox.setDisable(false);
            youthEducationSpecialNeedsCheckBox.setDisable(false);
            
        } else if(!educationCheckBox.isSelected()){
            
            compensatingSpecialEducationCheckBox.setDisable(true);
            youthEducationSpecialNeedsCheckBox.setDisable(true);
            compensatingSpecialEducationCheckBox.setSelected(false);
            youthEducationSpecialNeedsCheckBox.setSelected(false);
        }
    }
    
    @FXML
    public void updateSocialSupportStatus(ActionEvent event){
        if(socialSupportCheckBox.isSelected()){
            administrationSupportCheckBox.setDisable(false);
            shoppingSupportCheckBox.setDisable(false);
            contactSupportCheckBox.setDisable(false);
            medicinalSupportCheckBox.setDisable(false);
            personalCareCheckBox.setDisable(false);
            practicalSupportCheckBox.setDisable(false);
            educationSupportCheckBox.setDisable(false);
            parentingSupportCheckBox.setDisable(false);

        } else if(!socialSupportCheckBox.isSelected()){
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
    public void updateSupportPersonStatus(ActionEvent event){
        if(supportPersonCheckBox.isSelected()){
            //Enables checkboxes
            temporaryReplacement84CheckBox.setDisable(false);
            temporaryReplacement95CheckBox.setDisable(false);
            personalAssistanceCheckBox.setDisable(false);
            contactForDeafblindCheckBox.setDisable(false);
            companionCheckBox.setDisable(false);
            kinCare118CheckBox.setDisable(false);
            kinCare119CheckBox.setDisable(false);

        } else if(!supportPersonCheckBox.isSelected()){
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
    public void updateSupportToolStatus(ActionEvent event){
        if(supportToolCheckBox.isSelected()){
            
            aidCheckBox.setDisable(false);
            carAidCheckBox.setDisable(false);
            furnishingAidCheckBox.setDisable(false);
            goodsAidCheckBox.setDisable(false);

        } else if(!supportToolCheckBox.isSelected()){
            
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
    public void updateTrainingStatus (ActionEvent event){
        if(trainingCheckBox.isSelected()){
            
            rehabilitation85CheckBox.setDisable(false);
            rehabilitation86CheckBox.setDisable(false);
            rehabilitation102CheckBox.setDisable(false);
            maintainingAbility85CheckBox.setDisable(false);
            maintainingAbility86CheckBox.setDisable(false);
            maintainingAbility102CheckBox.setDisable(false);

        } else if(!trainingCheckBox.isSelected()){
            
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
    public void updateNonSearchedServicesStatus (ActionEvent event) {
        if(nonSearchedServicesCheckBox.isSelected()){
            
            counselingCheckBox.setDisable(false);
            supportOrContactPersonCheckBox.setDisable(false);

        } else if(!nonSearchedServicesCheckBox.isSelected()){

            counselingCheckBox.setDisable(true);
            supportOrContactPersonCheckBox.setDisable(true);
            
            counselingCheckBox.setSelected(false);
            supportOrContactPersonCheckBox.setSelected(false);

        }
    }

    
    
    
}
