package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ProductDTO;

public class ProductDAO {
	private Connection conn = null;
	
	public ProductDAO(){
		init();
	}
	private void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean conn() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("Connection 자원 획득 성공.");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void insert(ProductDTO pdto) {
		if(conn()) {
			try {
				String sql = "insert into productmge values('제품번호5', ?, ?, ?, ?, sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pdto.getPname());
				pstmt.setInt(2, pdto.getPrice());
				pstmt.setInt(3, pdto.getStock());
				pstmt.setString(4, pdto.getMaker());
				int result = pstmt.executeUpdate();
				if(result > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e2) {
					
				}
			}
		}else {
			System.out.println("Connection 확득 실패");
		}
	}
	
}
