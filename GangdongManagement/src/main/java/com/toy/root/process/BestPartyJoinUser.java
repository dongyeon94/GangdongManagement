package com.toy.root.process;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbBestJoinCounter;
import com.toy.root.db.DbUser;
import com.toy.root.repository.PartyRepository;
import com.toy.root.repository.UserRepository;


@Service
public class BestPartyJoinUser {
	
	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<Map<String,Object>> bestPartyJoinUser(LocalDate startMonth, LocalDate lastMonth) 
	{	
		List<Map<String,Object>> BestUser = new ArrayList<>();
		String partyDate = "";
		
		String start = localDateToString(startMonth)+"-01";
		String end = localDateToString(lastMonth)+"-01";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datestart = LocalDate.parse(start, formatter);
        LocalDate dateend = LocalDate.parse(end, formatter);
       
		for(LocalDate i = datestart; i.isBefore(dateend) || i.isEqual(dateend); i = i.plusMonths(1)) 
		{
			String userList = "";
			Map<String,Object> DateMap = new HashMap<String, Object>();
			
			String endData = localDateToString(i);			
			List<DbUser> list = userRepo.bestPartyJoinUser(i.toString(), lastDaytoCurrentMonth(endData+"-01").toString());
		
			for(int listLength = 0; listLength < list.size(); listLength++) 
			{
				try 
				{	
					userList = userList + list.get(listLength).getNickName().toString() + ", ";
//					userList.add(list.get(listLength).getNickName());
				}
				catch (Exception e) 
				{					
				}
			}
			DateMap.put("date", i.toString().substring(0,7));
			DateMap.put("nickname", userList);
			BestUser.add(DateMap);
		}
		return BestUser;			
	}
	
	public Timestamp firstPartyMonth() 
	{
		return partyRepo.startPartyMonth();
	}
	
	public Timestamp lastPartyMonth() 
	{
		return partyRepo.lastPartyMonth();
	}
	
	public LocalDate timestampToLocalDate(Timestamp currentDate) {
		return currentDate.toLocalDateTime().toLocalDate();
	}
	
	public String TimestampToString(Timestamp currentDate) 
	{	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(currentDate);
	}
	
	public String localDateToString(LocalDate currentDate) 
	{	
		return currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
	}
	
	public LocalDate lastDaytoCurrentMonth(String currentDate) 
	{
		YearMonth targetMonthLastDate = YearMonth.from(LocalDate.parse(currentDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		return targetMonthLastDate.atEndOfMonth();
	}
}
