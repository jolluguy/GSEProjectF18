/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterlogin;

import Acquaintance.IBusiness;
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
        System.out.println("Login entered");
        String userName = usernameField.getText();
        String password = passwordField.getText();
        
        System.out.println("requesting result");
        int result = business.login(userName, password);
        System.out.println("return from result login");
        
        if(result == 1){
            
            Parent caseworkerScene = FXMLLoader.load(getClass().getResource("Caseworker.fxml"));
            
            Scene newScene = new Scene(caseworkerScene);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(newScene);
            appStage.show();
            
            
        } else if(result == 2){
            System.out.println("Admin detected");
            Parent adminScene = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            
            Scene newScene = new Scene(adminScene);
            Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appstage.setScene(newScene);
            appstage.show();
            
        }
    }    
    
}
