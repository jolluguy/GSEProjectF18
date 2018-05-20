/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IBusiness;
import Acquaintance.IDepartment;
import Acquaintance.IJob;
import Acquaintance.IUser;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alexa
 */
public class AdminController implements Initializable {

    private Collection<IJob> jobList;
    private Collection<IDepartment> departmentList;
    private Collection<IUser> userlist;

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
    private TextField jobUsernameField;
    private PasswordField jobPasswordField;
    private RadioButton jobCaseRadio;
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
    @FXML
    private Tab addNewUserTab;
    @FXML
    private Tab changeExistingUserTab;
    @FXML
    private TextField changeJobUsernameField;
    @FXML
    private ToggleGroup changeJobUserStatus;
    @FXML
    private ChoiceBox<String> changeJobChoicebox;
    @FXML
    private ChoiceBox<String> changeDepartmentChoicebox;
    @FXML
    private RadioButton jobActiveRadio;
    @FXML
    private RadioButton jobUnchangedRadio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userOneLabel.setText(business.getCurentUser().getUserName() + "");
        userlist = new ArrayList<>();

        //filling choceboxes
        jobList = business.getJobList();
        for (IJob j : jobList) {
            setJobChoicebox.getItems().add(j.getJobTitle());
            changeJobChoicebox.getItems().add(j.getJobTitle());
            // inplementer noget til inactive
        }
        departmentList = business.getdepartmentList();
        for (IDepartment d : departmentList) {
            setDepartmentChoiceBox.getItems().add(d.getDepartmentName());
            changeDepartmentChoicebox.getItems().add(d.getDepartmentName());
        }

        // setting a value in the chiceboxes so that empty dosent get chosen by acsident
        setDepartmentChoiceBox.setValue(departmentList.iterator().next().getDepartmentName());
        setJobChoicebox.setValue(jobList.iterator().next().getJobTitle());
        changeJobChoicebox.getItems().add("Uændret");
        changeDepartmentChoicebox.getItems().add("Uændret");
        changeJobChoicebox.setValue("Uændret");
        changeDepartmentChoicebox.setValue("Uændret");

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
        PresJob job = getJob(setJobChoicebox);
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
        String statusMessage = "";
        jobWarningLabel.setText(statusMessage);
        String username = changeJobUsernameField.getText();
        if (business.doesUserExist(username)) {
            if (changeJobChoicebox.getValue().equals("Uændret") && changeDepartmentChoicebox.getValue().equals("Uændret") && jobUnchangedRadio.isSelected()) {
                statusMessage = "Der er ikke valgt nogle ændringer";
            } else {

                IJob newjob = null;
                IDepartment newdepart = null;
                boolean setUserActive = true;

                if (!changeJobChoicebox.getValue().equals("Uændret")) {
                    newjob = getJob(changeJobChoicebox);
                } else {
                    for (IUser i : userlist) {
                        if (i.getUserName().equals(username)) {
                            newjob = new PresJob(i.getJob().getJobTitle(), i.getJob().getID(), i.getJob().getAccessLevel());
                            break;
                        }
                    }
                }
                if (!changeDepartmentChoicebox.getValue().equals("Uændret")) {
                    newdepart = getDepartment(changeDepartmentChoicebox);
                } else {
                    for (IUser i : userlist) {
                        if (i.getUserName().equals(username)) {
                            newdepart = new PresDepartment(i.getJob().getDepartment().getDepartmentID(), i.getJob().getDepartment().getDepartmentName());
                            break;
                        }
                    }
                }
                if (!jobUnchangedRadio.isSelected()) {
                    if (jobInactiveRadio.isSelected()) {
                        setUserActive = false;
                    } else {
                        setUserActive = true;
                    }
                } else {
                    for (IUser i : userlist) {
                        if (i.getUserName().equals(username)) {
                            setUserActive = i.getActive();
                            break;
                        }
                    }
                }
                if (business.changeJob(username, setUserActive, newjob.getJobTitle(), newjob.getID(), newjob.getAccessLevel(), newdepart.getDepartmentID(), newdepart.getDepartmentName())) {
                    statusMessage = username + "'s job er blevet ændret";
                } else {
                    statusMessage = username + "'s job kunne ikke ændres";
                }

                changeJobUsernameField.clear();
                changeJobChoicebox.setValue("Uændret");
                changeDepartmentChoicebox.setValue("Uændret");
                jobActiveRadio.setSelected(false);
                jobInactiveRadio.setSelected(false);

            }
        } else {
            statusMessage = "Indtast korrekt brugernavn";
        }
        jobWarningLabel.setText(statusMessage);
    }

    @FXML
    public void jobCancel(ActionEvent event) {
        changeJobUsernameField.clear();
        changeJobChoicebox.setValue("Uændret");
        changeDepartmentChoicebox.setValue("Uændret");
        jobActiveRadio.setSelected(false);
        jobInactiveRadio.setSelected(false);
        jobWarningLabel.setText("");
    }

    @FXML
    public void refreshListview(ActionEvent event) {
        obsList.clear();
        fillUserList();
    }

    void fillUserList() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        userlist.clear();
        for (IUser i : business.getUserList()) {
            userlist.add(i);
        }
        for (IUser i : userlist) {
            obsList.add(String.format("%1$-16s\t%2$s\t%3$s\t%4$s", i.getUserName(), i.getActive(), df.format(i.getCreatedTime()), df.format(i.getLastLoginTime())));
        }
    }

    /**
     *
     * @param choicebox
     * @return
     */
    PresJob getJob(ChoiceBox<String> choiceboxJob) {
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
