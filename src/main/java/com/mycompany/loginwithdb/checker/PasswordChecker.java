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
public class PasswordChecker extends Checker
{

    private final String pattern="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{3,9}$";
    private final int length=9;

    

    private boolean checkIfMatchesLength(String password)
    {
        return password.length() <= this.length;
    }

    
    
    @Override
    public boolean checker(String password) {
       
        return !super.checkIfEmpty(password) && this.checkIfMatchesLength(password) && super.checkIfMatchesThePattern(password, this.pattern);
    }
    
}
