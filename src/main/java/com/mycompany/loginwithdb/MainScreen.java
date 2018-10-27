package com.mycompany.loginwithdb;

import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;

public class MainScreen extends SceneSwitcher implements Initializable {
    
   
    
    @FXML
    private JFXButton login;
    
    @FXML
    private JFXButton register;
   
    @FXML
    private void setProperties() 
    {
        this.login.setText("Login");
        this.register.setText("Register");
    }
    
    @FXML
    private void changeToLoginScreen() throws IOException
    {
        super.showProperStage("/fxml/LoginScene.fxml","/styles/LoginScreenStyles.css","Login");
    }
    
    @FXML
    private void changeToRegisterScreen() throws IOException
    {
        super.showProperStage("/fxml/RegisterScene.fxml","/styles/RegisterScreenStyles.css","Register");
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setProperties();
       
    }    

    
}
