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

    private final String pattern="[A-Z][a-zA-Z]*"; //First Letter capital, the rest is non capital
    private final int length=20;

    private boolean checkIfMatchesLength(String name)
    {
        return name.length() <= this.length;
    }

    @Override
    public boolean checker(String value) {
        return !super.checkIfEmpty(value) && this.checkIfMatchesLength(value) && super.checkIfMatchesThePattern(value, this.pattern);
    }
    
}
