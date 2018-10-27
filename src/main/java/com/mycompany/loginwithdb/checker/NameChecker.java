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
public class NameChecker extends Checker
{

    private final String namePattern="[A-Z][a-z]*"; //First Letter capital, the rest is non capital
    private final int length=10;
    
    private boolean checkIfMatchesLength(String name)
    {
        return name.length() <= this.length;
    }
    
    
    @Override
    protected boolean checkIfMatchesThePattern(String email, String pattern) {
        return super.checkIfMatchesThePattern(email, pattern); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean checkIfEmpty(String name) {
        return super.checkIfEmpty(name); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public boolean checker(String name) {
        return !this.checkIfEmpty(name) && this.checkIfMatchesLength(name) && this.checkIfMatchesThePattern(name, this.namePattern);
    }
    
}
