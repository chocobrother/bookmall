package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.cartVo;

public class cartDao {
	
public List<cartVo> getList(){
		
		List<cartVo> list = new ArrayList<cartVo>();
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		 
		
			try { 
			
			conn = getConnection();
			
			String sql = "select user_id, book_id, cartPrice from cart";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cartVo vo = new cartVo();
				
				vo.setUser_id(rs.getInt(1));
				vo.setBook_id(rs.getInt(2));
				vo.setCartPrice(rs.getInt(3));
				
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
	
	public boolean insert(cartVo vo) {
		
		boolean result = false;
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "insert into cart values(?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getUser_id());
			pstmt.setInt(2, vo.getBook_id());
			pstmt.setInt(3, vo.getCartPrice());

			
			
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