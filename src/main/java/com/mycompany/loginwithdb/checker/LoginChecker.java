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


    private boolean checkIfMatchesLength(String login)
    {
        return login.length() <= this.length;
    }

    private boolean checkIfRepeatedInDB(String login)
    {
        User user=new LoadDB().getUserObject(login); 
        return !(user instanceof User);
    }
//PROBLEM:POWTORZONY W BAZIE DANYCH
    @Override
    public boolean checker(String login) 
    {
        System.out.println("SPRAWDZAM LOGIN: "+!super.checkIfEmpty(login)+" "+this.checkIfMatchesLength(login)+" "+super.checkIfMatchesThePattern(login, this.pattern)+" "+this.checkIfRepeatedInDB(login));
        return !super.checkIfEmpty(login) && this.checkIfMatchesLength(login) && super.checkIfMatchesThePattern(login, this.pattern) && this.checkIfRepeatedInDB(login);
    }
}
