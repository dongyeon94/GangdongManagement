package com.toy.root.db;

import lombok.Data;

@Data
public class DbCounter {
	private	String	nickname;
	private int		count;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
