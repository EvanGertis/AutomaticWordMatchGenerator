package com.company.app.model;

import lombok.Data;

@Data
public class Registration {
	
    private String userName;

    private String password;
    
    private String billingAddress;
    
    private String billingProvince;
    
    private String billingCountry;

    private String phoneNumber;

    private String zip;
    
    
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
   
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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
}

