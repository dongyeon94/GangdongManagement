package com.toy.root.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toy.root.db.DbCounter;
import com.toy.root.db.DbParty;
import com.toy.root.db.DbUser;
import com.toy.root.process.BestPartyJoinUser;
import com.toy.root.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	private GetMemberList _getMemberList;	
	
	@Autowired
	private AddMember addmember;
	
	@Autowired
	private AddParty addParty;
	
	@Autowired
	private DeleteMember delMember;
	
	@Autowired
	private ChartSelect chartSelet;
	
	@Autowired
	private BestPartyJoinUser bestParty;
	
	
	@GetMapping("/")
	public String mainPage(Model model) throws ParseException {				
		SimpleDateFormat monthDataFormat = new SimpleDateFormat("yyyy-MM");
		String date = monthDataFormat.format(System.currentTimeMillis()) + "-01";
		
		model.addAttribute("membetList", _getMemberList.process());
		model.addAttribute("curruentdata", monthDataFormat.format(System.currentTimeMillis()));
		model.addAttribute("memberAttendCount", chartSelet.userPartyCounter(date));
		
		return "admin/index";
	}
	
	@PostMapping("/")
	public String monthChartSearch(@RequestBody String selectedDate,Model model) throws ParseException {
		SimpleDateFormat monthDataFormat = new SimpleDateFormat("yyyy-MM");
		String date = selectedDate.split("=")[1]+"-01";
		
		model.addAttribute("curruentdata", selectedDate.split("=")[1]);
		model.addAttribute("membetList", _getMemberList.process());	
		model.addAttribute("memberAttendCount", chartSelet.userPartyCounter(date));
		
		List ll = chartSelet.userPartyCounter(date);
			
		return "admin/index";
	}
		
	@PostMapping("/signup" )
	public String signUp(@RequestParam String user) {	
		addmember.process(user);
		return "redirect:/";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestBody HashMap<String, Object> map) {
		delMember.process(map);
		System.out.println(map);
		return "redirect:/"; 
	}
	
	@PostMapping("/addParty")
	public String addParty(@RequestBody HashMap<String, Object> map) {
		System.out.println(map);
		addParty.process(map);		
		return "redirect:/";
	}		
			
	@GetMapping("/tests")
	public String tests() throws ParseException {
//		System.out.println(bestParty.firstPartyMonth());
//		System.out.println(bestParty.lastPartyMonth());
//		System.out.println(bestParty.localDateToString(bestParty.lastPartyMonth()));
//		System.out.println(bestParty.lastDaytoCurrentMonth(bestParty.localDateToString(bestParty.lastPartyMonth())));
		bestParty.bestPartyJoinUser(bestParty.timestampToLocalDate(bestParty.firstPartyMonth()), 
				bestParty.timestampToLocalDate(bestParty.lastPartyMonth()));
		
		return "redirect:/";
	}
	
}
