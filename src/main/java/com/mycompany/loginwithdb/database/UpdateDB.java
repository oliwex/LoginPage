/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.database;

import com.mycompany.loginwithdb.database.structure.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author oliwe
 */
public class UpdateDB extends DBOperation
{
    
    public void blockUser(String login,String password,boolean blocked)
    {
        Session session = super.getOpenedSession();
        Transaction tx = session.beginTransaction();

        SQLQuery query;
        
        if (blocked)
        {
            query = session.createSQLQuery("UPDATE userslogin SET blocked=0 WHERE nick=:nick AND password=:password");
        }
        else
        {
            query = session.createSQLQuery("UPDATE userslogin SET blocked=1 WHERE nick=:nick AND password=:password");
        }

        query.addEntity(User.class);
           
        query.setParameter("nick", login);
        query.setParameter("password", password);
        
        query.executeUpdate();
        
        super.closeSession(session);
  
    }
    
    
}
