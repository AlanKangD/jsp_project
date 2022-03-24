package com.care.root.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.care.root.board.dto.BoardDTO;
import com.care.root.member.dto.MemberDTO;

public class BoardDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public BoardDAO() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "spring";
		String pw = "spring";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("BoardDAO 성공");
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
		}
		
		
		
	}
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from test_board";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSavedate(rs.getTimestamp("savedate"));
				dto.setHit(rs.getInt("hit"));
				dto.setIdgroup(rs.getInt("idgroup"));
				dto.setStep(rs.getInt("step"));
				dto.setIndent(rs.getInt("indent"));
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	public void writeSave(String name, String title, String content) {
		String sql = "insert into test_board(id, name, title, content, idgroup, step, indent) "
				+ "values(test_board_seq.nextval,?,?,?,test_board_seq.currval,0,0)"; 
				//test_board_seq.currval의 의미는 시퀀스넘버와 같은 번호를 주어라 라는 의미 입니다.
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void upHit(String id) { //조회수에 관한 기능입니다.
		String sql = "update test_board set hit = hit+1 where id=" + id;
		//이렇게 sql문을 사용하면 contentView가 실행 될때마다 hit가 1씩 증가하는 기능입니다.
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BoardDTO contentView(String id, int flag) { //여기서 flag는 같은 코드를 중복해서 사용할 건데 하나의 코드에서만 upHit를 증가시키고 싶기때문에 사용
		if(flag == 1) { //1이라는 의미는 contentView에서 호출이 되면 참이 되게 해라
			upHit(id);
		}
		BoardDTO dto = new BoardDTO();
		String sql = "select * from test_board where id=" + id;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSavedate(rs.getTimestamp("savedate"));
				dto.setHit(rs.getInt("hit"));
				dto.setIdgroup(rs.getInt("idgroup"));
				dto.setStep(rs.getInt("step"));
				dto.setIndent(rs.getInt("indent"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return dto;
	}
	
	public void modify(String id, String name, String title, String content) {
		String sql = "update test_board set name=?, title=?, content=? where id=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void delete(String id) {
		String sql = "delete from test_board where id=" + id;
		
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void reply(BoardDTO dto) {
		String sql = "insert into test_board(id,name, title, content, idgroup, step, indent) "
				+ "values(test_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setInt(4, dto.getIdgroup());
			ps.setInt(5, dto.getStep()+1);
			ps.setInt(6, dto.getIndent()+1);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}























