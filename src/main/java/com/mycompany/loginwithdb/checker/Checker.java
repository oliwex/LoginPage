/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author oliwe
 */
public abstract class Checker {

    protected String pattern;
    
    public abstract boolean checker(String value);
    
    protected boolean checkIfEmpty(String value)
    {
        return value.isEmpty();
    }

    
    
    protected boolean checkIfMatchesThePattern(String element,String pattern) 
    {
        Matcher matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(element);
        return matcher.find();
    }
}
