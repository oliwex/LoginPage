package com.mycompany.loginwithdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.loginwithdb.interfaces.ClassStructureInterface;
import com.mycompany.loginwithdb.interfaces.AccountActionInterface;
import com.jfoenix.controls.JFXButton;
import com.mycompany.loginwithdb.database.LoadDB;
import com.mycompany.loginwithdb.database.structure.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author oliwe
 */
public class UserPostLoginScreenController extends SceneSwitcher implements Initializable,ClassStructureInterface,AccountActionInterface {

    
    
    @FXML
    private Label accountLabel;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label email;
    @FXML
    private Label login;
    @FXML
    private Label password;
    

    @FXML
    private Label nameField;
    @FXML
    private Label surnameField;
    @FXML
    private Label emailField;
    @FXML
    private Label loginField;

    
    
    @FXML
    private JFXButton logoutButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.setProperties();
    }    

    @Override
    public void setProperties() {
       
        this.accountLabel.setText("Cześć "+MainApp.stageTitle.getTitle());
        
        this.name.setText("Name: ");
        this.surname.setText("Surname: ");
        this.email.setText("Mail: ");
        this.login.setText("Login: ");
        
        User userObject=new LoadDB().getUserObject(MainApp.stageTitle.getTitle());
        this.nameField.setText(userObject.getUserPrivateData().getName());
        this.surnameField.setText(userObject.getUserPrivateData().getSurname());
        this.emailField.setText(userObject.getUserPrivateData().getEmail());
        this.loginField.setText(userObject.getUserLoginData().getLogin());

        
        
        this.logoutButton.setText("Logout");
        
    }

    
    @FXML
    @Override
    public void logout()
    {
        try {
            super.showProperStage("/fxml/LoginScene.fxml","/styles/LoginScreenStyles.css","Login And Register");
        } catch (IOException ex) {
            Logger.getLogger(UserPostLoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public void setFieldToNull() {
        
    }
    
}
