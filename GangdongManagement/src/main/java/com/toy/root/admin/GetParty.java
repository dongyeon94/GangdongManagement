package com.toy.root.admin;


import com.toy.root.db.DbParty;
import com.toy.root.db.DbUser;
import com.toy.root.repository.PartyRepository;
import com.toy.root.repository.UserRepository;
import com.toy.root.admin.MemberInfo;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.admin.ErrorList;

@Service
public class GetParty {	
	
	@Autowired
	private PartyRepository _partyRepo;
			
	public String Set(PartyInfo partyInfo)
	{	
		try 
		{
			DbParty partyDb = new DbParty();
			partyDb.setDate(partyInfo.get_date());
			partyDb.setTimes(partyInfo.get_times());
			partyDb.setUserPKId(partyInfo.get_userPKId());
			_partyRepo.save(partyDb);			
		}catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
			return ErrorList.ERROR_DB_PERMISSION;
		}		
		return ErrorList.ERROR_SUCCESS;
	}
}
