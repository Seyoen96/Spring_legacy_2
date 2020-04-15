package com.sy.Spring_2.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void memberJoin(Model model) {
//		model.addAttribute("id", "test");
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin2(HttpServletRequest request, MemberVO memberVO) throws Exception {
		
		
		if(memberVO!=null) {
			//로그인 성공이면 index page로 이동, 
			memberService.memberJoin(memberVO);
			return "redirect:../";
			
		} else {
			//실패하면 login 실패를 alert창에 띄우고 login form으로 이동
			request.setAttribute("result", "Join fail!");
			request.setAttribute("path", "./memberJoin");
			return "common/result";
		}
		
	}
	
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void memberLogin() {
		
	}
	
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public String memberLogin2(HttpSession session, MemberVO memberVO, HttpServletRequest request) throws Exception{
		
		memberVO = memberService.memberLogin(memberVO);
		
		if(memberVO!=null) {
			//로그인 성공이면 index page로 이동, 
			session.setAttribute("member", memberVO);
			return "redirect:../";
			
		} else {
			//실패하면 login 실패를 alert창에 띄우고 login form으로 이동
			request.setAttribute("result", "login fail!");
			request.setAttribute("path", "./memberLogin");
			return "common/result";
		}
	}
	
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public void memberPage(HttpSession session, MemberVO memberVO) throws Exception {
		
	}
	
	@RequestMapping(value = "memberDelete", method = RequestMethod.GET)
	public String memberDelete(HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		memberService.memberDelete(memberVO);
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public void memberUpdate(HttpSession session) throws Exception {
		
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(HttpSession session, MemberVO memberVO) throws Exception {
		memberService.memberUpdate(memberVO);
		session.setAttribute("member", memberVO);
		return "member/memberPage";
	}
	
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

}
