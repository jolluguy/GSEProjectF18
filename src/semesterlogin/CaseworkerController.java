/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterlogin;

import Acquaintance.IBusiness;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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
    private CheckBox inquiryYesCheckBox;
    @FXML
    private CheckBox inquiryNoCheckBox;
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
    private CheckBox controlCheckBoX;
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

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
