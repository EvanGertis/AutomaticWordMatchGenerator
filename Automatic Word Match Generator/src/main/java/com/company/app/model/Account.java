package com.company.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int userId;

    private String billingAddress;
    
    private String billingProvince;
    
    private String billingCountry;

    private String phoneNumber;

    private String zip;
    
    public Account() {}
    
    public Account(int userId, 
    		String billingAddress, 
    		String billingProvince,
    		String billingCountry,
    		String phoneNumber,
    		String zip) {
    	this.userId = userId;
    	this.billingAddress = billingAddress;
    	this.billingProvince = billingProvince;
    	this.billingCountry = billingCountry;
    	this.phoneNumber = phoneNumber;
    	this.zip = zip;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingProvince() {
		return billingProvince;
	}

	public void setBillingProvince(String billingProvince) {
		this.billingProvince = billingProvince;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
