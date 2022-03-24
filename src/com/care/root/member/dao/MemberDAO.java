package com.care.root.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public class MemberDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public MemberDAO() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"spring", "spring");
			System.out.println("성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	
	}
	public ArrayList<MemberDTO> memberView() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		/*for(int i=0; i<5; i++) {
			MemberDTO d = new MemberDTO();
			d.setId("aaa0" + i);
			d.setPwd("aaa0" + i);
			d.setName("홍길동0" + i);
			d.setAddr("산골자기0" + i);
			list.add(d);
		}*/
		String sql = "select * from member_jsp";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO d = new MemberDTO();
				d.setId(rs.getString("id"));
				d.setPwd(rs.getString("pwd"));
				d.setName(rs.getString("name"));
				d.setAddr(rs.getString("addr"));
				list.add(d);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	public int insertMember(MemberDTO dto) {
//		System.out.println("데이터 베이스 저장");
//		System.out.println(dto.getId());
//		System.out.println(dto.getPwd());
//		System.out.println(dto.getName());
//		System.out.println(dto.getAddr());
		
		String sql = "insert into member_jsp(id,pwd,name,addr) values(?,?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAddr());
			result = ps.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public MemberDTO memberInfo(String userId) {
		String sql = "select * from member_jsp where id=?";
		MemberDTO dto=null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}
	public void modify_save(MemberDTO dto) {
		String sql = "update member_jsp set add=?, name=?, pwd=? where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAddr());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPwd());
			ps.setString(4, dto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String userId) {
		String sql = "delete from member_jsp where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
























