/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IBusiness;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.BreakNode;

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
    private Label infoLabel;
    @FXML
    private Label confirmChangeLabel;
    @FXML
    private Label validatePWLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    public void changePassword(ActionEvent event) {
        validatePWLabel.setText("");
        String oldPassword = oldPasswordField.getText();
        String newPassword1 = newPasswordField.getText();
        String newPassword2 = repeatNewPasswordField.getText();

        if (newPassword1.equals(newPassword2) && !newPassword1.equals("")) {
            if (business.changePassword(oldPassword, newPassword1)) {
                confirmChangeLabel.setTextFill(Paint.valueOf("GREEN"));
                confirmChangeLabel.setText("Kodeord er skiftet");
                oldPasswordField.clear();
                newPasswordField.clear();
                repeatNewPasswordField.clear();
            }
        } else {
            validatePWLabel.setText("Forkert kodeord");
        }

    }

    @FXML
    private boolean validateNewPW(KeyEvent event) {
        String newpw1 = newPasswordField.getText();
        String newpw2 = repeatNewPasswordField.getText();

        if (newpw1.equals(newpw2) && !newpw1.equals("")) {
            confirmChangeLabel.setTextFill(Paint.valueOf("GREEN"));
            confirmChangeLabel.setText("Kodeord matcher");
            return true;
        } else {
            confirmChangeLabel.setTextFill(Paint.valueOf("RED"));
            confirmChangeLabel.setText("Kontroller venligst at de nye kodeord er ens");
            return false;
        }
    }

    @FXML
    private void cancelChangePW(ActionEvent event) throws IOException {
                    switch (business.getCurentUser().getJob().getAccessLevel()) {
                
                case 1: {
                    Parent caseworkerScene = FXMLLoader.load(getClass().getResource("Caseworker.fxml"));
                    Scene newScene = new Scene(caseworkerScene);
                    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    appStage.setScene(newScene);
                    appStage.show();
                    break;
                }
                case 2: {
                    Parent adminScene = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                    Scene newScene = new Scene(adminScene);
                    Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    appstage.setScene(newScene);
                    appstage.show();
                    break;
                }
                
                default:{
                    break;
            }

        }
    }

}
