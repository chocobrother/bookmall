package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.orderbookVo;

public class orderbookDao {

	public List<orderbookVo> getList(){
		List<orderbookVo> list= new ArrayList<orderbookVo>();
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "select order_no, book_no, count, orderBP from orderBook";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderbookVo vo = new orderbookVo();
				
				vo.setOrder_no(rs.getInt(1));
				vo.setBook_no(rs.getInt(2));
				vo.setCount(rs.getInt(3));
				vo.setOrderBP(rs.getInt(4));
				
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
	public boolean insert(orderbookVo vo) {
		
		boolean result = false;
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "insert into orderbook values(?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getOrder_no());
			pstmt.setInt(2, vo.getBook_no());
			pstmt.setInt(3, vo.getCount());
			pstmt.setInt(4, vo.getOrderBP());
			
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
