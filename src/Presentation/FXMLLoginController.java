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
import java.sql.SQLException;
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
    @FXML
    private Label connectionWarningLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Pinger().run();
    }

    @FXML
    public void quit(ActionEvent event) {
        usernameField.clear();
        passwordField.clear();
        System.exit(0);
    }

    public class Pinger implements Runnable {

        @Override
        public void run() {
            connectionWarningLabel.setText("Test");
            try {
                business.pingDatabase();
            } catch (SQLException e) {
                connectionWarningLabel.setText("Ingen forbindelse til databasen.");
            }

        }

    }

//    @FXML
//    private void pingDatabase() {
//        connectionWarningLabel.setText("Test");
//        try {
//            business.pingDatabase();
//        } catch (SQLException e) {
//            connectionWarningLabel.setText("Ingen forbindelse til databasen.");
//        }
//    }
    @FXML
    public void login(ActionEvent event) throws IOException {
        String userName = usernameField.getText().toLowerCase();
        String password = passwordField.getText();

            int result = business.login(userName, password);

            switch (result) {
                case -1:{
                    errorLabel.setText("Brugernavn eller password er forkert!");
                }
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
                case 0:{
                    errorLabel.setText("ADGANG NÆGTET! - Denne bruger er inaktiv!");
                    errorLabel2.setText("Kontakt IT-Support for hjælp");
                    break;
                }
                default:{
                    break;
            }

        }
    }

}
