package com.toy.root.process;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.stereotype.Service;

import com.toy.root.repository.PartyRepository;

import antlr.collections.List;

@Service
public class BestPartyJoinUser {
	
	@Autowired
	private PartyRepository partyRepo;
	
	public List bestPartyJoinUser(LocalDate startMonth, LocalDate lastMonth) 
	{
		List userList = (List) new ArrayList();
		for(LocalDate i = startMonth; startMonth.isBefore(lastMonth); startMonth.plusMonths(1)) 
		{
//			repo.countdate(startmonth)
		}
		return userList;			
	}
	
	public LocalDate firstPartyMonth() 
	{
		return partyRepo.startPartyMonth();
	}
	
	public LocalDate lastPartyMonth() 
	{
		return partyRepo.lastPartyMonth();
	}
	
	public String localDateToString(LocalDate currentDate) 
	{
		return currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public LocalDate lastDaytoCurrentMonth(String currentDate) 
	{
		YearMonth targetMonthLastDate = YearMonth.from(LocalDate.parse(currentDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		return targetMonthLastDate.atEndOfMonth();
	}
}
