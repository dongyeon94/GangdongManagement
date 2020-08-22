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
			if(_id !=null) partInfo.set_id(_id);
			partInfo.set_date(new  Date(System.currentTimeMillis()));
			partInfo.set_times(_times);
			partInfo.set_userPKId(_userPKId);
			partInfo.set_date(_date);
			getParty.Set(partInfo);
			
		}catch (Exception e) 
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
			String returnError = null;	
			List li = (List) map.get("user");
			int get_times = Integer.parseInt( (String) map.get("times") );
			
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			_date = transFormat.parse((String) map.get("datetimes"));
									
			for(int i=0 ;i< li.size();i++) {											
				_userPKId = Integer.parseInt( (String) li.get(i) );				
				List<DbParty>  check = getParty.userDataFind( _userPKId,(String) map.get("datetimes") );				
				if ( check.size() >0 ) {
					_id = check.get(0).getId();
					String tmp_times = new BitConvert().BitConvert(check.get(0).getTimes());
					String str_times = tmp_times.substring(0,8-get_times) + '1' + tmp_times.substring(9-get_times);
					_times = new BitConvert().BitConvert(str_times);
				}
				else {
					_id = null;
					String tmp_times = new BitConvert().BitConvert(0);
					String str_times = tmp_times.substring(0,8-get_times) + '1' + tmp_times.substring(9-get_times);
					_times = new BitConvert().BitConvert(str_times);
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
