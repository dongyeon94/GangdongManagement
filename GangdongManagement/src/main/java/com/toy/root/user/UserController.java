package com.toy.root.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toy.root.admin.AddMember;
import com.toy.root.admin.AddParty;
import com.toy.root.admin.ChartSelect;
import com.toy.root.admin.DeleteMember;
import com.toy.root.admin.GetMemberList;
import com.toy.root.process.BestPartyJoinUser;

@Controller
@RequestMapping("/user/")
public class UserController {
	
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
	
	
	@GetMapping("")
	public String mainPage(Model model) throws ParseException {				
		SimpleDateFormat monthDataFormat = new SimpleDateFormat("yyyy-MM");
		String date = monthDataFormat.format(System.currentTimeMillis()) + "-01";
		List<Map<String,Object>> BestUser = bestParty.bestPartyJoinUser(bestParty.timestampToLocalDate(bestParty.firstPartyMonth()), bestParty.timestampToLocalDate(bestParty.lastPartyMonth()));
		
		model.addAttribute("membetList", _getMemberList.process());
		model.addAttribute("curruentdata", monthDataFormat.format(System.currentTimeMillis()));
		model.addAttribute("memberAttendCount", chartSelet.userPartyCounter(date));
		model.addAttribute("BestUser", BestUser);
		
		return "user/index";
	}
	
	@PostMapping("")
	public String monthChartSearch(@RequestBody String selectedDate,Model model) throws ParseException {
		SimpleDateFormat monthDataFormat = new SimpleDateFormat("yyyy-MM");
		String date = selectedDate.split("=")[1]+"-01";
		List<Map<String,Object>> BestUser = bestParty.bestPartyJoinUser(bestParty.timestampToLocalDate(bestParty.firstPartyMonth()), bestParty.timestampToLocalDate(bestParty.lastPartyMonth()));
		
		model.addAttribute("curruentdata", selectedDate.split("=")[1]);
		model.addAttribute("membetList", _getMemberList.process());	
		model.addAttribute("memberAttendCount", chartSelet.userPartyCounter(date));
		model.addAttribute("BestUser", BestUser);
			
		return "user/index";
	}
}
