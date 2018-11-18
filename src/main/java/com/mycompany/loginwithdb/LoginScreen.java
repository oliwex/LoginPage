/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb;

import com.mycompany.loginwithdb.interfaces.ClassStructureInterface;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mycompany.loginwithdb.database.LoadDB;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 *
 * @author oliwe
 */
public class LoginScreen extends SceneSwitcher implements Initializable,ClassStructureInterface {
    
    @FXML
    private Label login;
    
    @FXML
    private Label password;
    
    @FXML
    private JFXButton loginButton;
    
    @FXML
    private JFXButton backToMainButton;
    
    @FXML
    private JFXTextField loginField;
    
    @FXML
    private JFXPasswordField passwordField;

    
    @FXML
    @Override
    public void setProperties()
    {
        this.login.setText("Login:");
        this.password.setText("Password:");
        this.loginButton.setText("Login");
        this.backToMainButton.setText("Back to menu");
    }
    
    @FXML
    private void changeToMainScreen() throws IOException
    {
        super.showProperStage("/fxml/MainScene.fxml","/styles/MainScreenStyles.css","MainScreen");
    }
    
    @FXML
    private void logInToAccount()
    {

        LoadDB loadDB=new LoadDB();
        if(loadDB.checkIfUserExist(this.loginField.getText(),this.passwordField.getText()))
        {
            
            if (loadDB.checkIfAdmin(this.loginField.getText())) 
            {
                try {
                    super.showProperStage("/fxml/AdminPostLoginScene.fxml","/styles/AdminPostLoginScreenStyles.css",this.loginField.getText());
                } catch (IOException ex) {
                    Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else
            {
                
                try {
                    super.showProperStage("/fxml/UserPostLoginScene.fxml","/styles/UserPostLoginScreenStyles.css",this.loginField.getText());
                } catch (IOException ex) {
                    Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            
            if (new AlertDialog("Something goes wrong with data.Enter it once again").getAlertDialog(AlertType.ERROR).get() == ButtonType.OK)
            {
                this.setFieldToNull();
            }
            

        }
        
       
    }
    @Override
    public void setFieldToNull() 
    {
        this.loginField.setText("");
        this.passwordField.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.setProperties();
       
    }

    
}
