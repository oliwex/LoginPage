/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginwithdb.database;

import com.mycompany.loginwithdb.database.structure.User;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author oliwe
 */
public class LoadDB extends DBOperation
{

    public ObservableList<User> getAllUsers()
    {
        Session session=super.getOpenedSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin");
        query.addEntity(User.class);
        ObservableList<User> list=FXCollections.observableList(query.list());
        return list;
    }
    
    
    public User getUserObject(String login)
    {
        Session session=super.getOpenedSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE nick=:nick");
        query.addEntity(User.class);
        query.setParameter("nick", login);

        return (User)query.uniqueResult(); 
    }
    
    public User checkIfEmailExist(String email)
    {
        Session session=super.getOpenedSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE email=:email");
        query.addEntity(User.class);
        query.setParameter("email", email);
        return (User) query.uniqueResult();
    }

    public boolean checkIfUserExist(String login,String password) 
    {
        Session session=super.getOpenedSession();    
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE nick=:nick AND password=:password");    
        query.addEntity(User.class);  
        query.setParameter("nick", login);
        query.setParameter("password", password);
        return query.uniqueResult() != null;
    }
    public boolean checkIfAdmin(String login)
    {
        Session session=super.getOpenedSession();    
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE nick=:nick AND admin=:admin");    
        query.addEntity(User.class);   
        query.setParameter("nick", login);
        query.setParameter("admin", 1);   
        return query.uniqueResult() != null;
    }
    
    
}
    

