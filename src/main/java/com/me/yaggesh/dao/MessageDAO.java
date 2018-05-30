package com.me.yaggesh.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.Message;
import com.me.yaggesh.pojo.User;

public class MessageDAO extends DAO {
	public Message createMessage(String senderUname, String reciever, String subject, String body, Date date, User sender, int senderId)throws AdException
	{
		try
		{
			begin();
			Message msg = new Message(senderUname, reciever, subject, body, date, sender, senderId);
			getSession().save(msg);
			commit();
			return msg;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new AdException("Exception while sending message" +e.getMessage());
		}
	}
	
	public List listMessage(String username) throws AdException
	{
		try {
			begin();
			Query q = getSession().createQuery("from Message where receiver = :username");
			q.setString("username", username);
			List list = q.list();
			return list;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new AdException("Exception while reading User" + username + "Messages" + e.getMessage());
		}
	}

	
}
