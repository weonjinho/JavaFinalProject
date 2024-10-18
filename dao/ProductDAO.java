package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void insert(ProductDTO pdto, String pnum) {
		if(conn()) {
			try {
				String sql = "insert into productmge values(?, ?, ?, ?, ?, ?, sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pnum);
				pstmt.setString(2, pdto.getCategory());
				pstmt.setString(3, pdto.getPname());
				pstmt.setInt(4, pdto.getPrice());
				pstmt.setInt(5, pdto.getStock());
				pstmt.setString(6, pdto.getMaker());
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
	
	
	public ProductDTO selectOne(ProductDTO pdto) {
		System.out.println("제품명 : " + pdto.getPname());
		if(pdto.getPname() == null) {
			if(conn()) {
				//제품번호만 입력시
				try {
					String sql = "select * from productmge where pnum = ?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pdto.getPnum());
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
						ProductDTO pTemp = new ProductDTO();
						pTemp.setPnum(rs.getString("pnum"));
						pTemp.setPname(rs.getString("pname"));
						pTemp.setPrice(rs.getInt("price"));
						pTemp.setStock(rs.getInt("stock"));
						pTemp.setMaker(rs.getString("maker"));
						pTemp.setIndate(rs.getString("indate"));
						return pTemp;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println("Connection 확득 실패");
			}
		}
		if(pdto.getPnum() == null) {
			if(conn()) {
				//제품명만 입력시
				try {
					String sql = "select * from productmge where pname = ?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pdto.getPname());
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
						ProductDTO pTemp = new ProductDTO();
						pTemp.setPnum(rs.getString("pnum"));
						pTemp.setPname(rs.getString("pname"));
						pTemp.setPrice(rs.getInt("price"));
						pTemp.setStock(rs.getInt("stock"));
						pTemp.setMaker(rs.getString("maker"));
						pTemp.setIndate(rs.getString("indate"));
						return pTemp;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//제품명만 입력시
			}else {
				System.out.println("Connection 확득 실패");
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
