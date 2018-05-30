package com.me.yaggesh.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.User;



public class UserDAO extends DAO{

	
	public UserDAO() {
    }

    public User get(String username) throws AdException 
    {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User create(String username, String password, String fname, String lname, String email, String userType, String street, String city, String state, String zip)
    		throws AdException
    {
        try {
            begin();
            System.out.println("inside DAO");
            
            //Email email=new Email(emailId);
            User user=new User(username,password);
            
            user.setFname(fname);
            user.setLname(lname);
            user.setEmail(email);
            user.setUserType(userType);
            user.setStreet(street);
            user.setCity(city);
            user.setState(state);
            user.setZip(zip);
            
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    
    public User update(String username, String password, String fname, String lname, String email, String userType,String street, String city, String state, String zip, User user) throws AdException {
        try {
            begin();
            user.setFname(fname);
            user.setLname(lname);
            user.setEmail(email);
            user.setUserType(userType);
            user.setStreet(street);
            user.setCity(city);
            user.setState(state);
            user.setZip(zip);
            getSession().update(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    
    public User byEmail(String email) throws AdException
    {
    	try
    {
    	begin();
    	Query q = getSession().createQuery("from User where email = :email");
    	q.setString("email", email);
    	User user = (User) q.uniqueResult();
        commit();
        return user;
    } catch (HibernateException e) 
    	{
        	rollback();
        	throw new AdException("Could not get user " + email, e);
    	}
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getUsername(), e);
        }
    }
    
    public void save(User msg) throws AdException {
        try {
            begin();
            getSession().update(msg);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the msg", e);
        }
    }
}
