/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IBusiness;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Alexa
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private PasswordField repeatNewPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField oldPasswordField;
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;

    private IBusiness business = GUIFacade.getInstance().getBusiness();
    @FXML
    private Label infoLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void changePassword(ActionEvent event) {
        String oldPassword = oldPasswordField.getText();
        String newPassword1 = newPasswordField.getText();
        String newPassword2 = repeatNewPasswordField.getText();

        boolean change = business.changePassword(oldPassword, newPassword1, newPassword2);

        if (change) {
            infoLabel.setText("Kodeordet er nu ændret");
        } else if (!change) {
            infoLabel.setText("Fejl! - Kontroller oplysninger");
        }
        
        

    }

}
