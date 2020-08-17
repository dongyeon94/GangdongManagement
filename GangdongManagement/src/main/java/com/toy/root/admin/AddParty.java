package com.toy.root.admin;

import org.springframework.stereotype.Service;

@Service
public class AddParty {
	
	private String _nickname;
	private int _age;
	private String _location;
	private boolean _sex;
	
	
	public String process()
	{
		return ErrorList.ERROR_SUCCESS;
	}
}
