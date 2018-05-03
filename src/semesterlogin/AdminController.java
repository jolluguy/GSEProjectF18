/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterlogin;

import Acquaintance.IBusiness;
import Acquaintance.IUser;
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

/**
 * FXML Controller class
 *
 * @author Alexa
 */
public class AdminController implements Initializable {

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
    @FXML
    private Label jobUsername;
    @FXML
    private Label jobPassword;
    @FXML
    private TextField jobUsernameField;
    @FXML
    private PasswordField jobPasswordField;
    @FXML
    private RadioButton jobCaseRadio;
    @FXML
    private ToggleGroup jobRadio;
    @FXML
    private RadioButton jobAdminRadio;
    @FXML
    private Button jobSavechangeButton;
    @FXML
    private Button jobCancelButton;
    @FXML
    private Label jobWarningLabel;
    @FXML
    private Button removeUserButton;

    private IBusiness business = GUIFacade.getInstance().getBusiness();
    @FXML
    private RadioButton jobInactiveRadio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        Load listview
        obsList = FXCollections.observableArrayList();
        userListview.setItems(obsList);
        for(IUser i : business.getUserList()){
            obsList.add(i.toString());
        }
//        obsList.addAll(business.getUserList().toString());
    }

    @FXML
    public void createUser(ActionEvent event) {
        String userName = usernameField.getText();
        String password1 = password1Field.getText();
        String password2 = password2Field.getText();
        int level = -1;

        if (!(lvl1Radio.isSelected() || lvl2Radio.isSelected())) {
            warningLabel.setText("En jobtitel skal vælges før ændringen kan foretages");
        }

        if (lvl1Radio.isSelected()) {
            level = 1;
        } else if (lvl2Radio.isSelected()) {
            level = 2;
        }

        boolean createUserStatus = business.createUser(userName, password1, password2, level);

        String statusmessage = "";
        if (createUserStatus) {
            statusmessage = userName + " er blevet oprettet";
        } else if (!createUserStatus) {
            statusmessage = "ADVARSEL! - Bruger kunne ikke oprettes. Kontroller venligst at passwords er ens";
        }

        warningLabel.setText(statusmessage);
    }

    @FXML
    public void cancelUserCreation(ActionEvent event) {
        usernameField.clear();
        password1Field.clear();
        password2Field.clear();
        lvl1Radio.setSelected(false);
        lvl2Radio.setSelected(false);
        warningLabel.setText("");
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

    @FXML
    public void changeJob(ActionEvent event) {
        String username = jobUsernameField.getText();
        String password = jobPasswordField.getText();
        int level = -1;

        if (!(jobCaseRadio.isSelected() || jobAdminRadio.isSelected() || jobInactiveRadio.isSelected())) {
            jobWarningLabel.setText("Et job skal vælges før en ændring kan foretages");
        } else {
            if (jobCaseRadio.isSelected()) {
                level = 1;
            } else if (jobAdminRadio.isSelected()) {
                level = 2;
            } else if (jobInactiveRadio.isSelected()) {
                level = 0;
            }
            System.out.println("level is " + level);

            String statusMessage = "";

            boolean changeStatus = business.changeJob(username, password, level);
            if (changeStatus) {
                statusMessage = username + "'s job er blevet ændret";
            } else if (!changeStatus) {
                statusMessage = username + "'s job kunne ikke ændres";
            }

            jobWarningLabel.setText(statusMessage);
        }
    }

    @FXML
    public void jobCancel(ActionEvent event) {
        jobUsernameField.clear();
        jobPasswordField.clear();
        jobAdminRadio.setSelected(false);
        jobCaseRadio.setSelected(false);
        jobInactiveRadio.setSelected(false);
        jobWarningLabel.setText("");
    }

    @FXML
    public void refreshListview(ActionEvent event){
        obsList.clear();
        for(IUser i : business.getUserList()){
            obsList.add(i.toString());
        }
    }
}
