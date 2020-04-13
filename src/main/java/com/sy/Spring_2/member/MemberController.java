package com.sy.Spring_2.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void memberJoin() {
	
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void memberLogin() {
	
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public String memberLogin2() {
		System.out.println("member Login post");
		return "redirect:../";
	}
	
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public void memberPage() {
		
	}
	
//	@RequestMapping(value = "memberDelete", method = RequestMethod.GET)
//	public String memberDelete() {
//		return "mem";
//	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public void memberUpdate() {
	
	}
	

}
