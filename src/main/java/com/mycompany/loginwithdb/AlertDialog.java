/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author oliwe
 */
public class AlertDialog {
    
    private String contentText;
    
    public AlertDialog(String contentText)
    {
        this.contentText=contentText;
    }
    
    private Alert setAlertDialogAppearance()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(null);
        alert.setContentText(this.contentText);
        return alert;  
    }
    public Optional getAlertDialog() 
    {
        Optional<ButtonType> result=this.setAlertDialogAppearance().showAndWait();
        return result;
    }
}
