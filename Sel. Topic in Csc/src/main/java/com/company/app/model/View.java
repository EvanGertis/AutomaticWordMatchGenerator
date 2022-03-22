package com.company.app.model;

/*
 * WordMatch.java
 * Author: Evan Gertis
 */

import lombok.Data;


@Data
public class View {
    
	public Long id;
    
    public void setId(Long Id) {
    	this.id = Id;
    }
}
