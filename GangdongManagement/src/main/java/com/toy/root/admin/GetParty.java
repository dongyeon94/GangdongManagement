package com.toy.root.admin;


import com.toy.root.db.DbParty;
import com.toy.root.db.DbUser;
import com.toy.root.process.ErrorList;
import com.toy.root.repository.PartyRepository;
import com.toy.root.repository.UserRepository;
import com.toy.root.admin.MemberInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetParty {	
	
	@Autowired
	private PartyRepository _partyRepo;
			
	public String Set(PartyInfo partyInfo)
	{	
		try 
		{	
			
			DbParty partyDb = new DbParty();
			if (partyInfo.get_id() != null) partyDb.setId(partyInfo.get_id());
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
	
	public List<DbParty> userDataFind(int userPkId, String date) throws ParseException {
		
		SimpleDateFormat yearMonthDayForm = new SimpleDateFormat("yyyy-MM-dd");	
		Calendar calenderForm = Calendar.getInstance();
		calenderForm.setTime(yearMonthDayForm.parse(date));
		calenderForm.add(Calendar.DATE, 1);
		String newdate = yearMonthDayForm.format(calenderForm.getTime());
		List<DbParty> partyList = _partyRepo.findUserCurrentTime(userPkId, date, newdate);
		if (partyList != null) 
			return partyList;
		return null;
	}
	
}
