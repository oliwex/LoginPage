/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.checker;

import com.mycompany.loginwithdb.database.LoadDB;
import com.mycompany.loginwithdb.database.structure.User;

/**
 *
 * @author oliwe
 */
public class LoginChecker extends Checker
{
    
    private final int length=10;
    private final String pattern="^[a-zA-Z0-9._-]{3,10}$"; //Length >=3 ; Valid characters: a-z, A-Z, 0-9, points, dashes and underscores.

    @Override
    protected boolean checkIfMatchesThePattern(String email, String pattern) {
        return super.checkIfMatchesThePattern(email, pattern); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean checkIfEmpty(String login) {
        return super.checkIfEmpty(login); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean checkIfMatchesLength(String login)
    {
        return login.length() <= this.length;
    }

    private boolean checkIfRepeatedInDB(String login)
    {
    User user=new LoadDB().getUserObject(login); 
    System.out.println("asdadada");
    return !user.getUserLoginData().getLogin().equals(login);   
    }

    @Override
    public boolean checker(String login) 
    {
        return !this.checkIfEmpty(login) && this.checkIfMatchesLength(login) && this.checkIfMatchesThePattern(login, this.pattern) && this.checkIfRepeatedInDB(login);
    }
}
