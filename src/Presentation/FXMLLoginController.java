/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IBusiness;
import Acquaintance.IUser;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alexa
 */
public class FXMLLoginController implements Initializable {

    private IBusiness business = GUIFacade.getInstance().getBusiness();

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label errorLabel;
    @FXML
    private Label errorLabel2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void quit(ActionEvent event) {
        usernameField.clear();
        passwordField.clear();
        System.exit(0);
    }

    @FXML
    public void login(ActionEvent event) throws IOException {
        String userName = usernameField.getText();
        String password = passwordField.getText();

        if (!business.checkCredentials(userName, password)) {
            errorLabel.setText("Brugernavn eller password er forkert!");
        } else {
            int result = business.login(userName, password);

            if (result == 1) {

                Parent caseworkerScene = FXMLLoader.load(getClass().getResource("Caseworker.fxml"));

                Scene newScene = new Scene(caseworkerScene);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(newScene);
                appStage.show();

            } else if (result == 2) {
                Parent adminScene = FXMLLoader.load(getClass().getResource("Admin.fxml"));

                Scene newScene = new Scene(adminScene);
                Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appstage.setScene(newScene);
                appstage.show();

            } else if (result == 0) {
                errorLabel.setText("ADGANG NÆGTET! - Denne bruger er inaktiv!");
                errorLabel2.setText("Kontakt IT-Support for hjælp");
            }

        }
    }

}
