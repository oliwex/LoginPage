package com.mycompany.loginwithdb.checker;

import com.mycompany.loginwithdb.checker.EmailChecker;
import com.mycompany.loginwithdb.checker.LoginChecker;
import com.mycompany.loginwithdb.checker.NameChecker;
import com.mycompany.loginwithdb.checker.PasswordChecker;
import com.mycompany.loginwithdb.checker.RepeatPasswordChecker;
import com.mycompany.loginwithdb.checker.SurnameChecker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author oliwe
 */
public class FieldCheckerFacade {
    
    private final boolean nameChecker;
    private final boolean surnameChecker;
    private final boolean emailChecker;
    private final boolean loginChecker;
    private final boolean passwordChecker;
    
    private final boolean repeatPasswordChecker;
    
    public FieldCheckerFacade(String name, String surname, String email, String login, String password, String repeatPassword)
    {
        this.nameChecker=new NameChecker().checker(name);
        this.surnameChecker=new SurnameChecker().checker(surname);
        this.emailChecker=new EmailChecker().checker(email);
        this.loginChecker=new LoginChecker().checker(login);
        this.passwordChecker=new PasswordChecker().checker(password);
        this.repeatPasswordChecker=new RepeatPasswordChecker(password,repeatPassword).checker(repeatPassword);
        
    }

    private boolean checkEveryElement()
    {
        return this.nameChecker && this.surnameChecker && this.emailChecker && this.loginChecker && this.passwordChecker && this.repeatPasswordChecker;
    }

    public boolean getValue()
    {
        return this.checkEveryElement();
    }
    
}
