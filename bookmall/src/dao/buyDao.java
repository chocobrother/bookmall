package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.buyVo;

public class buyDao {
	
public List<buyVo> getList(){
		
		List<buyVo> list = new ArrayList<buyVo>();
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		 
		
			try {
			
			conn = getConnection();
			
			String sql = "select no, orderNo, orderPrice, home, orderday, user_no from buy";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				buyVo vo = new buyVo();
				
				vo.setNo(rs.getLong(1));
				vo.setOrderNo(rs.getInt(2));
				vo.setOrderPrice(rs.getInt(3));
				vo.setHome(rs.getString(4));
				vo.setOrderday(rs.getString(5));
				vo.setUser_no(rs.getInt(6));
				
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
	
	public boolean insert(buyVo vo) {
		
		boolean result = false;
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "insert into buy values(null,?,?,?,?null)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getOrderNo());
			pstmt.setInt(2, vo.getOrderPrice());
			pstmt.setString(3, vo.getHome());
			pstmt.setString(4, vo.getOrderday());
			pstmt.setInt(5, vo.getUser_no());
			
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