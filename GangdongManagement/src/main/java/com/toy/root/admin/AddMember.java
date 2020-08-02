package com.toy.root.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbUser;
import com.toy.root.repository.UserRepository;

import com.toy.root.admin.ErrorList;
import com.toy.root.admin.ErrorList;
@Service
public class AddMember {
	@Autowired
	private UserRepository _userRepo;
	private String _nickname;
	private int _age;
	private String _location;
	private boolean _sex;
	final static int MAX_USER_INFO_CONTENT = 4;
	
	private String _SaveToDb()
	{
		try
		{
			DbUser user = new DbUser();
			
			user.setUserName(_nickname);
			user.setSex(_sex);
			user.setAge(_age);
			user.setMemo(_location);
			user.setAlive(true);
			
			user.setJoinDate(new Date(System.currentTimeMillis()));
			user.setQuitDate(new Date(Long.MAX_VALUE));
			
			System.out.println(_nickname);
			System.out.println(_sex);
			System.out.println(_age);
			System.out.println(_location);
			System.out.println(user.getJoinDate());
			System.out.println(user.getQuitDate());
			
			//_userRepo.save(user);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return ErrorList.ERROR_DB_PERMISSION;
		}
		
		return ErrorList.ERROR_SUCCESS;
	}
	private boolean _GetGender(String gender)
	{
		if (gender.startsWith("여"))
		{
			return false;
		}
		
		return true;
	}
	

	public String process(String userInfo)
	{
		//nickname/age/location/sex
		
		try 
		{
			String[] userInfoList = userInfo.split("/", MAX_USER_INFO_CONTENT);
			String returnError;
			
			_nickname = userInfoList[0];
			_age = Integer.parseInt(userInfoList[1]);
			_location = userInfoList[2];
			_sex = _GetGender(userInfoList[3]);
			
			returnError = _SaveToDb();
			if (!returnError.equals(ErrorList.ERROR_SUCCESS))
			{
				return returnError;
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
