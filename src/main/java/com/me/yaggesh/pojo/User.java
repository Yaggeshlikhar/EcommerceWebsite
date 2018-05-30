package com.me.yaggesh.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name = "usertable")
@PrimaryKeyJoinColumn(name="personId")
public class User extends Person{
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="personId")
	private Set<Message> message = new HashSet<Message>();
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.message = new HashSet<Message>();
		
	}
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Message> getMessage() {
		return message;
	}

	public void setMessage(Set<Message> message) {
		this.message = message;
	}

	
	public void addMessage(Message message)
    {
    	getMessage().add(message);
    }

}
