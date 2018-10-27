/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author oliwe
 */
public class DBOperation {
    
    protected Session getOpenedSession()
    {
        //create session factory
        SessionFactory factory =new Configuration().configure().buildSessionFactory();
        
        //create session
        Session session=factory.openSession();
        
        return session;
    }

    protected void closeSession(Session openedSession)
    {
        openedSession.getTransaction().commit();
        openedSession.close();
    }
  
}
