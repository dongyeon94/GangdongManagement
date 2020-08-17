package com.toy.root.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.toy.root.db.DbParty;
import com.toy.root.db.DbUser;
import com.toy.root.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	private GetMemberList _getMemberList;	
	
	@Autowired
	private AddMember addmember;
	
	@Autowired
	private testfunction test;
	
	@GetMapping("/")
	public String mainPage(Model model) {		
//		System.out.println(_getMemberList.process());
//		System.out.println(_getMemberList.process().get(0).getNickName());
		model.addAttribute("membetList", _getMemberList.process());
		return "index";
	}

	
	
	@PostMapping("/signup")
	public String signUp(@RequestParam String user) {
		System.out.println(user);		
		addmember.process(user);
		return "redirect:/";
	}
	
	@GetMapping("/tests2")
	public String getTest() throws ParseException {
		List<DbParty> li= test.findAllBetween("dd");
		System.out.println(li);
		for(DbParty kk: li) {
			System.out.println("-----------------------------");			
			System.out.println(kk.getId());
			System.out.println(kk.getUserPKId());
			System.out.println(kk.getTimes());
			System.out.println("-----------------------------");
		}
		return "index";
	}
	
	@PostMapping("/tests")
	public String tests(@RequestBody HashMap<String, Object> map) throws ParseException {
		System.out.println("post mapping test");
		System.out.println(map);
		System.out.println(map.get("datetimes"));
		System.out.println("//////////////");
//		System.out.println(test.findAllBetween((String) map.get("datetimes")));
		
		List<DbParty> li= test.findAllBetween((String) map.get("datetimes"));
		System.out.println(li);
		for(DbParty kk: li) {
			System.out.println("-----------------------------");			
			System.out.println(kk.getId());
			System.out.println(kk.getUserPKId());
			System.out.println(kk.getTimes());
			System.out.println("-----------------------------");
		}
		
		return "redirect:/";
	}
	
}
