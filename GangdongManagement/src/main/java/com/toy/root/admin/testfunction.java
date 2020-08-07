package com.toy.root.admin;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public List<DbParty> findAllBetween(){
		
		String start = "2020-08-02";
		String end = "2020-08-03";
		List<DbParty> li = partRepo.findAllBetween(start, end);
		return li;
	}
	
}
