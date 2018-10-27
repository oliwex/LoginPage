/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.checker;

/**
 *
 * @author oliwe
 */
public class RepeatPasswordChecker extends Checker
{

    private final String passwordField;
    private final String repeatPasswordField;
    
    
    public RepeatPasswordChecker(String passwordField,String repeatPasswordField)
    {
        this.passwordField=passwordField;
        this.repeatPasswordField=repeatPasswordField;
    }
    
    private boolean checkIfFieldsAreTheSame()
    {
        
        return this.passwordField.equals(this.repeatPasswordField);
    }
    
    
    @Override
    public boolean checker(String value) {
        return this.checkIfFieldsAreTheSame();
    }
    
}
