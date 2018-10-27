/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.database.structure;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




/**
 *
 * @author oliwe
 */
@Entity(name="userslogin")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
   
    
    @Embedded
    @Column(name="privateData")
    private UserPrivateData userPrivateData;
    
    @Embedded
    @Column(name="loginData")
    private UserLoginData userLoginData;
    
    
    @Column(name="blocked")
    private boolean blocked=false;

    @Column(name="admin")
    private boolean admin=false;
    
    public UserPrivateData getUserPrivateData() {
        return userPrivateData;
    }

    public void setUserPrivateData(UserPrivateData userPrivateData) {
        this.userPrivateData = userPrivateData;
    }

    public UserLoginData getUserLoginData() {
        return userLoginData;
    }

    public void setUserLoginData(UserLoginData userLoginData) {
        this.userLoginData = userLoginData;
    }

    

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    
    
}
