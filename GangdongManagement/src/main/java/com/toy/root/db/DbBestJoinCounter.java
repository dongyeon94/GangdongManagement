package com.toy.root.db;

import lombok.Data;

@Data
public class DbBestJoinCounter {
	
	private String nickname;
	private int	counter;
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
