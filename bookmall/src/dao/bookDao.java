package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.bookVo;

public class bookDao {
 
public List<bookVo> getList(){
		
		List<bookVo> list = new ArrayList<bookVo>();
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		 
		
			try {
			
			conn = getConnection();
			
			String sql = "select no, bookName, price, cate_no from book";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bookVo vo = new bookVo();
				
				vo.setNo(rs.getLong(1));
				vo.setBookName(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setCate_no(rs.getInt(4));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn!= null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		 
		return list;
		
	}
	
	public boolean insert(bookVo vo) {
		
		boolean result = false;
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "insert into book values(null,?,?,null)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBookName());
			pstmt.setInt(2,vo.getPrice());
//			pstmt.setInt(3,vo.getCate_no());
			
			
			int count = pstmt.executeUpdate();
			
			result = (count >=1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn!= null) {
					conn.close();
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
			Class.forName( "com.mysql.jdbc.Driver" );
			
			String url="jdbc:mysql://localhost/bm";
			conn = DriverManager.getConnection(url, "bm", "bm");
		} catch( ClassNotFoundException e ) {
			System.out.println( "드러이버 로딩 실패:" + e );
		} 
		
		return conn;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}