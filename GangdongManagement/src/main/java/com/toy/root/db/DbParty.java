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
	
	private Date	roomCreateDate;
	
	private int		degree;	 
	
	private int		userId;


	public Long getid() {
		return id;
	}


	public void setid(Long id) {
		this.id = id;
	}


	public Date getRoomCreateDate() {
		return roomCreateDate;
	}


	public void setRoomCreateDate(Date roomCreateDate) {
		this.roomCreateDate = roomCreateDate;
	}


	public int getDegree() {
		return degree;
	}


	public void setDegree(int degree) {
		this.degree = degree;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
