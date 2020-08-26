package com.toy.root.admin;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbCounter;
import com.toy.root.db.DbParty;
import com.toy.root.db.DbUser;
import com.toy.root.process.DateCalculrator;
import com.toy.root.repository.PartyRepository;

@Service
public class ChartSelect {

	@Autowired
	private PartyRepository partyRepo;
	
	public List userPartyCounter(String date) throws ParseException {		
		List userCountList = partyRepo.userPartyCount(date, new DateCalculrator().datePlusOneMonth(date));		
		return userCountList;
	}
}
