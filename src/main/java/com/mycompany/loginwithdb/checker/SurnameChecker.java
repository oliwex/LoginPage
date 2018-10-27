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
public class SurnameChecker extends Checker{

    private String surnamePattern="[A-Z][a-zA-Z]*"; //First Letter capital, the rest is non capital
    private int length=20;
    
    
    @Override
    protected boolean checkIfMatchesThePattern(String email, String pattern) 
    {
        return super.checkIfMatchesThePattern(email, pattern); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean checkIfEmpty(String value) 
    {
        return super.checkIfEmpty(value); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean checkIfMatchesLength(String name)
    {
        return name.length() <= this.length;
    }

    @Override
    public boolean checker(String value) {
        return !this.checkIfEmpty(value) && this.checkIfMatchesLength(value) && this.checkIfMatchesThePattern(value, this.surnamePattern);
    }
    
}
