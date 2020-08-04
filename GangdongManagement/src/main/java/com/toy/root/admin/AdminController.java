package com.toy.root.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.toy.root.db.DbUser;
import com.toy.root.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	private GetMemberList _getMemberList;	
	
	@Autowired
	private AddMember addmember;
	
	
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
	
	@PostMapping("/tests")
	public String tests(@RequestBody HashMap<String, Object> map) {
		System.out.println("post mapping test");
		System.out.println(map);
		return "redirect:/";
	}
	
}
