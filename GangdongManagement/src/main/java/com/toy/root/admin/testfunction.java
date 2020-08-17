package com.toy.root.admin;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbParty;
import com.toy.root.repository.PartyRepository;
import com.toy.root.repository.UserRepository;

@Service
public class testfunction {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PartyRepository partRepo;
	
	public List<DbParty> findAllBetween(String date) throws ParseException{
			
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		c.add(Calendar.DATE, 1);
		String newdate = df.format(c.getTime());

		List<DbParty> li = partRepo.findAllBetween(date, newdate);
		return li;
	}
	
}
