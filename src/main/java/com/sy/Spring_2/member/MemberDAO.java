package com.sy.Spring_2.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnect;


public class MemberDAO {
	
	//1. insert
	public int memberJoin(MemberVO memberDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPwd());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getPhone());
		st.setInt(6, memberDTO.getAge());
		
		int res = st.executeUpdate();
		if(res>0) {
			System.out.println("member insert success!");			
		} else {
			System.out.println("member insert fail!");
		}
		
		st.close();
		con.close();		
		return res;
	}
	
	//2. login (DB에서 조회)
	public MemberVO memberLogin(MemberVO memberDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PWD=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPwd());
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			//로그인 성공
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setAge(rs.getInt("age"));
		} else {
			//로그인 실패
			memberDTO = null;
		}
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
	
	
	//3. delete
	public int memberDelete(MemberVO memberDTO) throws Exception {
		
		Connection con = DBConnect.getConnect();
		String sql = "DELETE MEMBER WHERE ID =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
	
		int res = st.executeUpdate();
		if(res>0) {
			System.out.println("member delete success");			
		} else {
			System.out.println("member delete fail");
		}
		
		st.close();
		con.close();
		return res;
	}
	
	
	//4. update
	public int memberUpdate(MemberVO memberDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "UPDATE MEMBER SET NAME=?, "
				+ "EMAIL=?, PHONE=?, AGE=? WHERE ID=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(5, memberDTO.getId());
		st.setString(1, memberDTO.getName());
		st.setString(2, memberDTO.getEmail());
		st.setString(3, memberDTO.getPhone());
		st.setInt(4, memberDTO.getAge());
		
		int res = st.executeUpdate();
		System.out.println(res);
		System.out.println("2");
		if(res>0) {
			System.out.println("update 성공");
		} else {
			System.out.println("update 실패");
		}
		
		st.close();
		con.close();
		return res;
	}
	

	
	
}
