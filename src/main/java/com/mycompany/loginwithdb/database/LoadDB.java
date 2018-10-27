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
    
    public ObservableList<User> getAllUsers()
    {
        Session session=this.getOpenedSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin");
        query.addEntity(User.class);
        ObservableList<User> list=FXCollections.observableList(query.list());

        return list;
    }
    
    
    public User getUserObject(String login) 
    {
        Session session=this.getOpenedSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE nick=:login");
        query.addEntity(User.class);
        query.setParameter("login", login);
        return (User) query.list().get(0);
    }
    public User checkIfEmailExist(String email) //define what value get from db
    {
        Session session=this.getOpenedSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE email=:email");
        query.addEntity(User.class);
        query.setParameter("email", email);
        return (User) query.list().get(0);
    }

    public boolean checkIfUserExist(String login,String password) 
    {
        Session session=this.getOpenedSession();
            
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE nick=:nick AND password=:password");
            
        query.addEntity(User.class);
           
        query.setParameter("nick", login);
        query.setParameter("password", password);
        List results = query.list();
            
        return results!=null && !results.isEmpty();
    }
    public boolean checkIfAdmin(String login)
    {
        Session session=this.getOpenedSession();
            
        SQLQuery query = session.createSQLQuery("SELECT * FROM userslogin WHERE nick=:nick AND admin=:admin");
            
        query.addEntity(User.class);
           
        query.setParameter("nick", login);
        query.setParameter("admin", 1);
            
        List results = query.list();
            
        return results!=null && !results.isEmpty();
    }
    
    
}
    

