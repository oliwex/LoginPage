/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.checker;

import com.mycompany.loginwithdb.database.LoadDB;
import com.mycompany.loginwithdb.database.structure.User;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author oliwe
 */
public class EmailChecker extends Checker{

    protected String pattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"; //validating email


    private boolean checkIfRight(String email)
    {
       return EmailValidator.getInstance().isValid(email); 
    }
    
    private boolean checkIfRepeatedInDB(String email)
    {
    
        User user=new LoadDB().checkIfEmailExist(email); //jest pelne gdy email istnieje w bazie

        if (user == null) //jeśli nie istnieje
        {
            return true;
        }
        else
        {
            return false;//!user.getUserPrivateData().getEmail().equals(email);
        }
        
    }

    @Override
    public boolean checker(String email) 
    {
        return !super.checkIfEmpty(email) && this.checkIfRight(email) && super.checkIfMatchesThePattern(email, this.pattern) && this.checkIfRepeatedInDB(email);
    }

    

    

}
