package com.me.yaggesh.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name= "messagetable")
public class Message {
	
	@Id
	@GeneratedValue
	@Column(name="messageId")
	private int messageId;
	
	@Column(name="reciever")
	private String reciever;
	
	@Column(name="sender")
	private String sender;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="body")
	private String body;
	
	@Column(name="date")
	private Date date;	
	
	@JoinColumn(name="personId")
	private int personId;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="user")
	private User user;
	

	public Message(String reciever, String sender, String subject, String body, Date date, User user, int personId
			) {
		this.reciever = reciever;
		this.sender = sender;
		this.subject = subject;
		this.body = body;
		this.date = date;
		this.personId = personId;
		this.user = user;
	}


	public Message() {
		
	}
	
	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}




	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
