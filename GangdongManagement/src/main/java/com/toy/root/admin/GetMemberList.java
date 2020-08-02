package com.toy.root.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbUser;
import com.toy.root.repository.UserRepository;

@Service
public class GetMemberList {

	@Autowired
	private UserRepository userrepo;
	
	public List<DbUser> process(){
		List<DbUser> li = userrepo.findAll();
		return li;
	}
	
}
