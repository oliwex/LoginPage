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
    
    /*
    
Password matching expression. Password must be at least 3 characters, no more than 9 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.
Matches	
aaaa1234AAAA | 12aaAA12 | aaaaa12345AAAAA
Non-Matches	
aaaaa123456AAAAA | 12aaAA1 | 12aaaa12
    
    */
    
    
    
    
    
    
    private boolean checkIfMatchesLength(String password)
    {
        return password.length() <= this.length;
    }
    
    
    @Override
    protected boolean checkIfMatchesThePattern(String password, String pattern) {
        return super.checkIfMatchesThePattern(password, pattern); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean checkIfEmpty(String password) {
        return super.checkIfEmpty(password); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public boolean checker(String password) {
       
        return !this.checkIfEmpty(password) && this.checkIfMatchesLength(password) && this.checkIfMatchesThePattern(password, this.pattern);
    }
    
}
