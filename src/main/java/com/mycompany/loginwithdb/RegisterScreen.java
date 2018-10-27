package com.mycompany.loginwithdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.loginwithdb.interfaces.ClassStructureInterface;
import com.mycompany.loginwithdb.checker.FieldCheckerFacade;
import com.mycompany.loginwithdb.database.structure.UserPrivateData;
import com.mycompany.loginwithdb.database.structure.UserLoginData;
import com.mycompany.loginwithdb.database.structure.User;
import com.jfoenix.controls.*;
import com.mycompany.loginwithdb.database.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;


/**
 * FXML Controller class
 *
 * @author oliwe
 */
public class RegisterScreen extends SceneSwitcher implements Initializable, ClassStructureInterface {

    /**
     * Initializes the controller class.
     */
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
    private Label repeatPassword;
    
    
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton menuButton;
    
    
    
    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXTextField surnameField;
    @FXML
    private JFXTextField emailField;
    @FXML
    private JFXTextField loginField;
    
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private JFXPasswordField repeatpasswordField;


    @FXML
    private void getTextfromFields()
    {
        if (new FieldCheckerFacade(this.nameField.getText(),this.surnameField.getText(),this.emailField.getText(),this.loginField.getText(),this.passwordField.getText(),this.repeatpasswordField.getText()).getValue())
        {
            new SaveDB().saveUser(this.buildObjectToSave());
            this.setFieldToNull();
        }
        else
        {
            this.setAlertDialog();
        }
    }
    
    private User  buildObjectToSave()
    {
        UserPrivateData upd=new UserPrivateData();
        upd.setName(this.nameField.getText());
        upd.setSurname(this.surnameField.getText());
        upd.setEmail(this.emailField.getText());
        
        UserLoginData uld=new UserLoginData();
        uld.setLogin(this.loginField.getText());
        uld.setPassword(this.passwordField.getText());
            
            
        User u=new User();
        u.setUserLoginData(uld);
        u.setUserPrivateData(upd);
        return u;
    }
    
    private void setAlertDialog()
    {
        if (new AlertDialog("Something goes wrong with data.Enter it once again").getAlertDialog().get() == ButtonType.OK)
        {
            this.setFieldToNull();
        }
    }
    
    
    @Override
    public void setProperties()
    {
        this.name.setText("Name: ");
        this.surname.setText("Surname: ");
        this.email.setText("Email: ");
        this.login.setText("Login: ");
        this.password.setText("Password: ");
        this.repeatPassword.setText("Repeat Password: ");
        
        this.menuButton.setText("Back to menu");
        this.loginButton.setText("Login");
    }
    
    @Override
    public void setFieldToNull()
    {
        this.nameField.setText("");
        this.surnameField.setText("");
        this.emailField.setText("");
        this.loginField.setText("");
        this.passwordField.setText("");
        this.repeatpasswordField.setText("");
    }
    
    @FXML
    private void changeToMainScreen() throws IOException
    {
        super.showProperStage("/fxml/MainScene.fxml","/styles/MainScreenStyles.css","Main");
    }
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setProperties();
    }
    
}
