package com.toy.root.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "party")
public class DbParty {
	
	@Id
	@GeneratedValue
	private Long	id;
	
	private Date	date;
	
	private int		times;	 
	
	private int		userPKId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getUserPKId() {
		return userPKId;
	}

	public void setUserPKId(int userPKId) {
		this.userPKId = userPKId;
	}


}
