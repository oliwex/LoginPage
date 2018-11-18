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

    private final String pattern="[A-Z][a-z]*"; //First Letter capital, the rest is non capital
    private final int length=10;
    
    private boolean checkIfMatchesLength(String name)
    {
        return name.length() <= this.length;
    }

    @Override
    public boolean checker(String name) {
        return !super.checkIfEmpty(name) && this.checkIfMatchesLength(name) && super.checkIfMatchesThePattern(name, this.pattern);
    }
    
}
