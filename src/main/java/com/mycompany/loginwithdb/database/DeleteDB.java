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
public class DeleteDB extends DBOperation
{
    public void deleteUser(String login,String password)
    {
        Session session = super.getOpenedSession();
        Transaction tx = session.beginTransaction();

        SQLQuery query = session.createSQLQuery("DELETE FROM userslogin WHERE nick=:nick AND password=:password");
        

        query.addEntity(User.class);
           
        query.setParameter("nick", login);
        query.setParameter("password", password);
        
        query.executeUpdate();
        
        super.closeSession(session);
    }
}
