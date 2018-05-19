/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IAdmin;
import Acquaintance.IBusiness;
import Acquaintance.ICaseWorker;
import Acquaintance.IDepartment;
import Acquaintance.IJob;
import Acquaintance.IUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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

    Collection<IJob> jobList;
    Collection<IDepartment> departmentList;

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
    private ListView<String> userListview;
    @FXML
    private Label listviewLabel;

    private ObservableList<String> obsList;
    @FXML
    private Button refreshButton;
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

    private IBusiness business = GUIFacade.getInstance().getBusiness();
    @FXML
    private RadioButton jobInactiveRadio;
    @FXML
    private Label userOneLabel;
    @FXML
    private Button createUserCancelButton;
    @FXML
    private MenuItem logoutButton;
    @FXML
    private MenuButton menuBar;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private ChoiceBox<String> setJobChoicebox;
    @FXML
    private ChoiceBox<String> setDepartmentChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userOneLabel.setText(business.getUserOne().getUserName() + "");

        //filling choceboxes
        jobList = business.getJobList();
        for (IJob j : jobList) {
            setJobChoicebox.getItems().add(j.getJobTitle());
            // inplementer noget til inactive
        }
        departmentList = business.getdepartmentList();
        for (IDepartment d : departmentList) {
            setDepartmentChoiceBox.getItems().add(d.getDepartmentName());
        }

//        Load listview
        obsList = FXCollections.observableArrayList();
        userListview.setItems(obsList);
        fillUserList();
    }

    @FXML
    public void createUser(ActionEvent event) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String userName = usernameField.getText().toLowerCase();
        String password1 = password1Field.getText();
        String password2 = password2Field.getText();
        PresJob job = getJob(setJobChoicebox, setDepartmentChoiceBox);
        PresDepartment dep = getDepartment(setDepartmentChoiceBox);

        boolean createUserStatus = business.createUser(firstName, lastName, userName, password1, password2, job.getJobTitle(), job.getID(), job.getAccessLevel(), dep.departmentID, dep.getDepartmentName());

        String statusmessage = "";
        if (createUserStatus) {
            statusmessage = userName + " er blevet oprettet";
        } else if (!createUserStatus) {
            statusmessage = "ADVARSEL! - Bruger kunne ikke oprettes. Kontroller venligst at passwords er ens";
        }

        warningLabel.setText(statusmessage);

        firstNameField.clear();
        lastNameField.clear();
        usernameField.clear();
        password1Field.clear();
        password2Field.clear();

    }

    @FXML
    public void userCreationClearFields(ActionEvent event) {
        usernameField.clear();
        password1Field.clear();
        password2Field.clear();
        warningLabel.setText("");
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        Parent loginScreen = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));

        Scene newScene = new Scene(loginScreen);
        Stage appstage = (Stage) menuBar.getScene().getWindow();
        appstage.setScene(newScene);
        appstage.show();

        business.logOut();
    }

    @FXML
    public void changeJob(ActionEvent event) {
        String username = jobUsernameField.getText();
        String password = jobPasswordField.getText();
        String newJob = "";

        if (!(jobCaseRadio.isSelected() || jobAdminRadio.isSelected() || jobInactiveRadio.isSelected())) {
            jobWarningLabel.setText("Et job skal vælges før en ændring kan foretages");
        } else {
            if (jobCaseRadio.isSelected()) {
                newJob = "CaseWorker";
            } else if (jobAdminRadio.isSelected()) {
                newJob = "Admin";
            } else if (jobInactiveRadio.isSelected()) {
                newJob = null;
            }
            System.out.println("level is " + newJob);

            String statusMessage = "";

            boolean changeJob = business.changeJob(username, username, 0, 0, 0, username);
            if (changeJob) {
                statusMessage = username + "'s job er blevet ændret";
            } else if (!changeJob) {
                statusMessage = username + "'s job kunne ikke ændres";
            }

            jobWarningLabel.setText(statusMessage);
        }

        jobUsernameField.clear();
        jobPasswordField.clear();
        jobAdminRadio.setSelected(false);
        jobCaseRadio.setSelected(false);
        jobInactiveRadio.setSelected(false);
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
    public void refreshListview(ActionEvent event) {
        obsList.clear();
        fillUserList();
    }
    
    void fillUserList(){
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
 for (IUser i : business.getUserList()) {
            obsList.add(String.format("%1$-16s\t%2$s\t%3$s\t%4$s", i.getUserName(), i.getActive(), df.format(i.getCreatedTime()), df.format(i.getLastLoginTime())));
 }
 }

    /**
     *
     * @param choicebox
     * @return
     */
    PresJob getJob(ChoiceBox<String> choiceboxJob, ChoiceBox<String> choiceboxDepartment) {
        PresJob job = null;
        for (IJob j : jobList) {
            if (j.getJobTitle().equalsIgnoreCase(choiceboxJob.getValue())) {
                job = new PresJob(j.getJobTitle(), j.getID(), j.getAccessLevel());
            }
        }
        return job;
    }

    private PresDepartment getDepartment(ChoiceBox<String> choiceboxDepartment) {
        PresDepartment dep = null;
        for (IDepartment d : departmentList) {
            if (d.getDepartmentName().equalsIgnoreCase(choiceboxDepartment.getValue())) {
                dep = new PresDepartment(d.getDepartmentID(), d.getDepartmentName());
            }
        }
        return dep;
    }

}
