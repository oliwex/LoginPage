/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.database.structure;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author oliwe
 */
@Embeddable
public class UserLoginData {
    
    
    @Column(name="nick")
    private String login;
    @Column(name="password")
    private String password;

    

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
    
}
