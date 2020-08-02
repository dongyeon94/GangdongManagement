package com.toy.root.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.toy.root.db.DbUser;

@Controller
public class AdminController {

	@Autowired
	private GetMemberList _getMemberList;	
	@Autowired
	private AddMember addmember;
	
	@GetMapping("/")
	public String mainPage(Model model) {		

		return "index";
	}
	
	@PostMapping("/")
	public String button(Model model) {
		model.addAttribute("list", _getMemberList.process());		
		return "index";
	}
	
	@GetMapping("/signup")
	public String signUp(@RequestBody DbUser user) {
		System.out.println(user);
		
		return "redirect:/";
	}
	
	
}
