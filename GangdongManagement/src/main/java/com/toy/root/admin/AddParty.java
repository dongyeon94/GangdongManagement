package com.toy.root.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;
import com.mysql.cj.result.Field;
import com.toy.root.db.DbParty;
import com.toy.root.process.BitConvert;

@Service
public class AddParty {
	
	private int		_times;	 	
	private int		_userPKId;
	private Date	_date;
	private Long	_id=null;
	@Autowired
	private GetParty getParty;
	
	private String _SaveToDb() 
	{	
		try
		{
			PartyInfo partInfo = new PartyInfo();
			
			if(_id != null)
			{
				partInfo.set_id(_id);
			}
			
			partInfo.set_date(new  Date(System.currentTimeMillis()));
			partInfo.set_times(_times);
			partInfo.set_userPKId(_userPKId);
			partInfo.set_date(_date);
			
			getParty.Set(partInfo);
			
		} catch (Exception e) 
		{
			System.out.println(e);
			return ErrorList.ERROR_DB_PERMISSION;
		}			
		
		return ErrorList.ERROR_SUCCESS;
	}
	

	public String process(HashMap<String, Object> map)
	{	
		try
		{	
			String returnError = ErrorList.ERROR_SUCCESS;
			
			List listUserID = (List)map.get("user");
			long longWhichTimesAttend = Integer.parseInt((String) map.get("times"));
			SimpleDateFormat dateAttend = new SimpleDateFormat("yyyy-MM-dd");
			
			_date = dateAttend.parse((String) map.get("datetimes"));
			for(int i = 0; i < listUserID.size(); i++) 
			{			
				_userPKId = Integer.parseInt( (String) listUserID.get(i));
				List<DbParty> listAttandantOnTheDate = getParty.userDataFind(_userPKId, (String)map.get("datetimes"));
				
				// size is 1 or 0
				if (listAttandantOnTheDate.size() > 0) 
				{
					int bmpAttendance = listAttandantOnTheDate.get(0).getTimes();
					bmpAttendance |= (1 << longWhichTimesAttend);
					
					_times = bmpAttendance;
					_id = listAttandantOnTheDate.get(0).getId();
				}
				else
				{
					_times = (1 << longWhichTimesAttend);
					_id = null;
				}		
	
				returnError = _SaveToDb();
			}						
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
