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

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
