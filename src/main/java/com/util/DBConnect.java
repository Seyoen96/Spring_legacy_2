package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnect() throws Exception{
		//1. 로그인 정보 4가지
		
		//user logon denied
		//1. ID/PW 틀린 경우
		//2. DB에 해당 유저가 생성되지 않은 경우
		//3. 유저의 권한이 적용되지 않은 경우
		String user="user02";
		String password="user02";
		
		//not connect
		//1. ip 또는 port 또는 xe 정보가 잘못된 경우
		//2. 물리적으로 연결이 안되거나, 서버가 종료된 경우
		//3. Listener 문제, DB를 재실행하여 해결
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		
		//class not found
		//1. 클래스의 driver명이 틀린 경우
		//2. jdbc API가 없는 경우
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. 드라이버를 메모리에 로딩
		Class.forName(driver);
		
		//3. 로그인 Connection 객체 반환
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;

	}
	
}
