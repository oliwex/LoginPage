/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.database;


import com.mycompany.loginwithdb.database.structure.User;
import org.hibernate.*;


/**
 *
 * @author oliwe
 */
public class SaveDB extends DBOperation
{

    @Override
    protected void closeSession(Session openedSession) 
    {
        super.closeSession(openedSession); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Session getOpenedSession() 
    {
        return super.getOpenedSession(); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void saveUser(User user) 
    {
       Session session=this.getOpenedSession();
       
       session.beginTransaction();
       session.save(user);
       
       this.closeSession(session);
       
    }
}
