/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterlogin;

import Acquaintance.IBusiness;
import Acquaintance.IGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alexa
 */
public class SemesterLogin extends Application implements IGUI {
    
    private IBusiness business;
    private static SemesterLogin ui;
    
    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }
    
    @Override
    public void startApplication(String[] args) {
        System.out.println("UI initializing");
        //Because of static method.
        ui = this;
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        stage.setTitle("VUM+");
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static SemesterLogin getInstance(){
        return ui;
    }
    
    public IBusiness getBusiness(){
        return business;
    }
    
    
}
