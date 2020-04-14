package com.sy.Spring_2.member;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public int memberJoin(MemberVO memberDTO) throws Exception {
		return memberDAO.memberJoin(memberDTO);
	}
	
	public MemberVO memberLogin(MemberVO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
		
	}
	
	public int memberDelete(MemberVO memberDTO) throws Exception {
		return memberDAO.memberDelete(memberDTO);
	}

	public int memberUpdate(MemberVO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
}
