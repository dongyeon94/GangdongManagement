package com.toy.root.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbUser;
import com.toy.root.process.ErrorList;
import com.toy.root.repository.UserRepository;

@Service
public class ModifiyMember {
	@Autowired
	private UserRepository _userrepo;
	
	public String process()
	{
		return ErrorList.ERROR_SUCCESS;
	}
	

}
