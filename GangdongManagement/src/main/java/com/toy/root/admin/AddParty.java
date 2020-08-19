package com.toy.root.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddParty {
	
	private int		_times;	 	
	private int		_userPKId;
	
	@Autowired
	private GetParty getParty;
	
	private String _SaveToDb() 
	{	
		try
		{
			PartyInfo partInfo = new PartyInfo();
			partInfo.set_date(new  Date(System.currentTimeMillis()));
			partInfo.set_times(_times);
			partInfo.set_userPKId(_userPKId);
			
			getParty.Set(partInfo);
			
		}catch (Exception e) 
		{
			System.out.println(e);
			return ErrorList.ERROR_DB_PERMISSION;
		}
		
		return ErrorList.ERROR_SUCCESS;
	}
	
	
	public String process(PartyInfo partyInfo)
	{	
		try
		{
			String returnError;	
			//TODO 00000 <- 참여한 몇차에 1로 바꾸는거
			_times = partyInfo.get_times();
			_userPKId = partyInfo.get_userPKId();
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
