package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.categoryVo;

public class categoryDao {


	public List<categoryVo> getList(){
		List<categoryVo> list= new ArrayList<categoryVo>();
		
		Connection conn = null;
		
		PreparedStatement pstmt = null; 
		
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "select no, cateName from category";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				categoryVo vo = new categoryVo();
				
				vo.setNo(rs.getInt(1));
				vo.setCateName(rs.getString(2));
				
				list.add(vo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return list;
	}
	public boolean insert(categoryVo vo) {
		
		boolean result = false;
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "insert into category values(?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1, vo.getOrder_no());
//			pstmt.setInt(2, vo.getBook_no());
//			pstmt.setInt(3, vo.getCount());
//			pstmt.setInt(4, vo.getOrderBP());
//			
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(1, vo.getCateName());
			
			int count = pstmt.executeUpdate();
			
			result = (count>=1);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url ="jdbc:mysql://localhost/bm";
			
			conn = DriverManager.getConnection(url,"bm","bm");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
