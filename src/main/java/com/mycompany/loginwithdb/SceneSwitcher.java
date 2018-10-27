package com.mycompany.loginwithdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author oliwe
 */
public class SceneSwitcher {
 
    
    
    protected void showProperStage(String fxmlResource,String stylesheetResource,String title) throws IOException
    {
        MainApp.stageTitle.setTitle(title);
        MainApp.stageTitle.setScene(this.chooseProperResources(fxmlResource, stylesheetResource));
        MainApp.stageTitle.show();
    }
    
    private Scene chooseProperResources(String fxmlResource,String stylesheetResource) throws IOException
    {
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource(fxmlResource)));
        scene.getStylesheets().add(stylesheetResource);
        
        return scene;  
    }
    
}
