/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterlogin;

import Business.BusinessFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.BreakNode;

/**
 * FXML Controller class
 *
 * @author Alexa
 */
public class AdminController implements Initializable {
    
    private Business.BusinessFacade business = BusinessFacade.getInstance();

    @FXML
    private Label usernameLabel;
    @FXML
    private Label password1label;
    @FXML
    private Label password2Label;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField password1Field;
    @FXML
    private PasswordField password2Field;
    @FXML
    private Button addUserButton;
    @FXML
    private Button logoutButton;
    @FXML
    private ListView<String> userListview;
    @FXML
    private Label listviewLabel;
    
    private ObservableList<String> obsList;
    @FXML
    private Button refreshButton;
    @FXML
    private RadioButton lvl1Radio;
    @FXML
    private ToggleGroup levelGroup;
    @FXML
    private RadioButton lvl2Radio;
    @FXML
    private Label warningLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        warningLabel.setText("");
                  
//        //Load listview
//        obsList = FXCollections.observableArrayList();
//        userListview.setItems(obsList);
//        obsList.addAll(business.getUserList());
    } 
    
    @FXML
    public void addUser(ActionEvent event) {
        String userName = usernameField.getText();
        String password1 = password1Field.getText();
        String password2 = password2Field.getText();
        int level = 0;
        
        if(!(lvl1Radio.isSelected() || lvl2Radio.isSelected())){
            warningLabel.setText("No level selected");
        } else{
        if(lvl1Radio.isSelected()){
            level = 1; 
        } else if(lvl2Radio.isSelected()){
            level = 2;
        }
            
        String statusmessage = business.addUser(userName, password1, password2, level);
        warningLabel.setText(statusmessage);
        
        }
    }
    
    @FXML
    public void logout(ActionEvent event) throws IOException {
        Parent loginScreen = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene newScene = new Scene(loginScreen);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(newScene);
        appstage.show();
        
        business.logOut();
    }
    
}
