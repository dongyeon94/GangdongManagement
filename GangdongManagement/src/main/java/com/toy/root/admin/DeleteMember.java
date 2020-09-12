package com.toy.root.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.repository.UserRepository;

import com.toy.root.admin.ErrorList;
import com.toy.root.db.DbUser;

@Service
public class DeleteMember {	
	
	@Autowired
	private UserRepository userRepo;	
	
	public String process(HashMap<String, Object> map)
	{
		try 
		{	
			System.out.println("gogo");
			List userIdList = (List) map.get("member");
			for(int i=0; i<userIdList.size(); i++)
			{
				System.out.println(userIdList.get(i));
				userRepo.deleteById(Long.parseLong( (String) userIdList.get(i)));
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			return ErrorList.ERROR_ADD_MEMBER_INPUT;
		}		
		
		return ErrorList.ERROR_SUCCESS;
	}
}
