package com.toy.root.admin;


import com.toy.root.db.DbUser;
import com.toy.root.repository.UserRepository;
import com.toy.root.admin.MemberInfo;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.toy.root.admin.ErrorList;

@Service
public class GetParty {

	private UserRepository _userrepo;
	
	public String Set()
	{
		HashMap<String, String> hashMap;
		
		
		return ErrorList.ERROR_SUCCESS;
	}
}
