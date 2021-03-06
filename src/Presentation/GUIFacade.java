/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

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
public class GUIFacade extends Application implements IGUI {
    
    private IBusiness business;
    
    private static GUIFacade instance;
    public static GUIFacade getInstance(){
        if(instance == null){
            instance = new GUIFacade();
        }
        return instance;
    }
    
    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }
    
    @Override
    public void startApplication(String[] args) {
        System.out.println("UI initializing");
        //Because of static method.
        instance = this;
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        stage.setTitle("Sensum Udred");
        
        javafx.scene.image.Image image = new javafx.scene.image.Image("/AssetsLibrary/icon.png");
        
        stage.getIcons().add(image);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    public IBusiness getBusiness(){
        return business;
    }
    
    
}
