package com.company.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * WordMatch.java
 * Author: Evan Gertis
 */

import lombok.Data;


@Entity
@Table(name="visualization")
@Data
public class WordMatch {

    @Id
    public int wordMatchId;
    public String content;
    
    public void setId(int Id) {
    	this.wordMatchId = Id;
    }

    public String getContent() {
		return content;
	}

    public void setContent(String content) {
		this.content = content;
	}

    
}
