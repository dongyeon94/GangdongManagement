package com.toy.root.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.process.ErrorList;
import com.toy.root.repository.UserRepository;

@Service
public class AddMember {

	private String _nickname;
	private int _age;
	private String _location;
	private boolean _sex;
	final static int MAX_USER_INFO_CONTENT = 4;
	
	@Autowired
	private GetMember getMember;
	
	private String _SaveToDb()
	{
		try
		{
			MemberInfo memberInfo = new MemberInfo();
			
			memberInfo.set_age(_age);
			memberInfo.set_alive(true);
			memberInfo.set_joinDate(new  Date(System.currentTimeMillis()) );
			memberInfo.set_memo(_location);
			memberInfo.set_nickname(_nickname);
			memberInfo.set_quitDate(new Date("9999/12/31"));
			memberInfo.set_sex(_sex);
								
			getMember.Set(memberInfo);
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
