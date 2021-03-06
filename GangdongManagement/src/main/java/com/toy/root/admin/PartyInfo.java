package com.toy.root.admin;

import java.util.Date;

import javax.persistence.GeneratedValue;

public class PartyInfo {
	
	private Long	_id;
	
	private Date	_date;
	
	private int		_times;	 
	
	private int		_userPKId;
	
	
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public Date get_date() {
		return _date;
	}

	public void set_date(Date _date) {
		this._date = _date;
	}

	public int get_times() {
		return _times;
	}

	public void set_times(int _times) {
		this._times = _times;
	}

	public int get_userPKId() {
		return _userPKId;
	}

	public void set_userPKId(int _userPKId) {
		this._userPKId = _userPKId;
	}
	
	
}
