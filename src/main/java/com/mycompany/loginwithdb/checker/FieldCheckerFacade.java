package com.mycompany.loginwithdb.checker;



/**
 *
 * @author oliwe
 */
public class FieldCheckerFacade { //zapisuje dane do bazy jeśli to prawda
    
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
        
        System.out.println("SPRAWDZAM: "+this.nameChecker+" "+this.nameChecker+" "+this.surnameChecker+" "+this.emailChecker+" "+this.loginChecker+" "+this.passwordChecker+" "+this.repeatPasswordChecker);
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
