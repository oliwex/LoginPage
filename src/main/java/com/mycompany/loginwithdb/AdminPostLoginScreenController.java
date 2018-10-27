package com.mycompany.loginwithdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.loginwithdb.interfaces.*;
import com.jfoenix.controls.JFXButton;
import com.mycompany.loginwithdb.database.LoadDB;
import com.mycompany.loginwithdb.database.structure.User;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.*;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author oliwe
 */
public class AdminPostLoginScreenController extends SceneSwitcher implements Initializable, AccountActionInterface, ClassStructureInterface {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton logoutButton;
    
    @FXML
    private TableView<User> adminTable;
    
    private final TableColumn<User,String> nameColumn=new TableColumn<>("Name");
    private final TableColumn<User,String> surnameColumn=new TableColumn<>("Surname");
    private final TableColumn<User,String> emailColumn=new TableColumn<>("Email");
    private final TableColumn<User,String> loginColumn=new TableColumn<>("Login");
    private final TableColumn<User,String> passwordColumn=new TableColumn<>("Password");
    private final TableColumn<User,String> blockedColumn=new TableColumn<>("Blocked");
    
    
    
    
    
    private void setColumns()
    {

        this.adminTable.getColumns().addAll(this.nameColumn,this.surnameColumn,this.emailColumn,this.loginColumn,this.passwordColumn,this.blockedColumn);
 
        this.adminTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.adminTable.setEditable(false);
    }
    
    private void setData()
    {
        System.out.println("DATA");
        
        
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Surname"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Login"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Password"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Blocked"));
        
        this.adminTable.setItems(new LoadDB().getAllUsers());
        
        
        
        System.out.println("Koniec daty");
    }
    
   
    
    @FXML
    @Override
    public void logout()
    {
        try {
            super.showProperStage("/fxml/LoginScene.fxml","/styles/LoginScreenStyles.css","Login And Register");
        } catch (IOException ex) {
            Logger.getLogger(AdminPostLoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       

    @Override
    public void setProperties() {
        this.logoutButton.setText("Logout");
    }

    @Override
    public void setFieldToNull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setColumns();
        this.setData();
        this.setProperties();
    }
    
}
