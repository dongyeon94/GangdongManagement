package com.toy.root.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbUser;
import com.toy.root.repository.UserRepository;

import com.toy.root.admin.ErrorList;

@Service
public class AddMember {
	@Autowired
	private UserRepository userrepo;
	
	public String process(String string){
		try {
			String userget = string;
			//      nickname/age/location/sex
			userget.split("/");
			
			
			DbUser user = new DbUser();		
			userrepo.save(user);
		}catch (Exception e) {
			System.out.println(e);
			return ErrorList.ERROR_PERMISSION;
		}		
		return ErrorList.ERROR_SUCCESS;
	}
}
