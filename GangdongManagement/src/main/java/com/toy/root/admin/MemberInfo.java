package com.toy.root.admin;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class MemberInfo {
	
	private String	_nickname;
	
	private int 	_age;
	
	private boolean	_sex; // M:true  W:false
	
	private boolean	_alive;
	
	private String	_memo;
	
	private Date	_joinDate;
	
	private Date	_quitDate;

	public String get_nickname() {
		return _nickname;
	}

	public void set_nickname(String _nickname) {
		this._nickname = _nickname;
	}

	public int get_age() {
		return _age;
	}

	public void set_age(int _age) {
		this._age = _age;
	}

	public boolean is_man() {
		return _sex;
	}

	public void set_sex(boolean _sex) {
		this._sex = _sex;
	}

	public boolean is_alive() {
		return _alive;
	}

	public void set_alive(boolean _alive) {
		this._alive = _alive;
	}

	public String get_memo() {
		return _memo;
	}

	public void set_memo(String _memo) {
		this._memo = _memo;
	}

	public Date get_joinDate() {
		return _joinDate;
	}

	public void set_joinDate(Date _joinDate) {
		this._joinDate = _joinDate;
	}

	public Date get_quitDate() {
		return _quitDate;
	}

	public void set_quitDate(Date _quitDate) {
		this._quitDate = _quitDate;
	}
	
}
