package com.company.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    public User() {}
    
    public User(String userName, String password) {
    	this.userName = userName;
    	this.password = password;
    }
    
    public User(int id, String userName, String password) {
    	this.id = id;
    	this.userName = userName;
    	this.password = password;
    }
    
    private String userName;

    private String password;

    
    public int getId() {
    	return this.id;
    }
    
    public void setUserName(String userName) {
    	this.userName = userName;
    }
    
    public String getUserName() {
    	return this.userName;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getPassword() {
    	return this.password;
    }
}
