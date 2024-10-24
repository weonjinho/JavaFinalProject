package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
//				String sql = "insert into productmge values(?, ?, sysdate, ?, ?, ?, ?)";
				String sql = "insert into productmge values(?, ?, ?, ?, ?, ?, sysdate)"; //여기서 값을 입력하는 순서랑 DB에 컬럼 순서가 일치하는게 좋음.
				PreparedStatement pstmt = conn.prepareStatement(sql);
				//pstmt에 값을 매핑할때 순서도 DB속 컬럼 순서랑 일치하는게 좋음.
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
	
	
//	public ProductDTO selectOne(ProductDTO pdto) {
	
	public ProductDTO selectOne(String pdto) {
//		System.out.println("제품명 : " + pdto.getPname());
		if(conn()) {
			//제품번호만 입력시
			try {
				String sql = "select * from productmge where pnum = ? order by indate desc";
				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, pdto.getPnum());
				pstmt.setString(1, pdto);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					ProductDTO pTemp = new ProductDTO();
					pTemp.setPnum(rs.getString("pnum"));
					pTemp.setPname(rs.getString("pname"));
					pTemp.setCategory(rs.getString("category"));
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
		return null;
	}
	
	
	
	public ProductDTO selectOne2(ProductDTO pdto) {
		System.out.println("제품명 : " + pdto.getPname());
		if(conn()) {
			//제품번호만 입력시
			try {
				String sql = "select * from productmge where pnum = ? order by indate desc";
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
		return null;
	}
	
	
	public ArrayList<ProductDTO> selectAll(){
		ArrayList<ProductDTO> plist = new ArrayList<>();
		if(conn()) {
			try {
				String sql = "select * from productmge order by indate desc";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ProductDTO pTemp = new ProductDTO();
					pTemp.setPnum(rs.getString("pnum"));
					pTemp.setCategory(rs.getString("category"));
					pTemp.setPname(rs.getString("pname"));
					pTemp.setPrice(rs.getInt("price"));
					pTemp.setStock(rs.getInt("stock"));
					pTemp.setMaker(rs.getString("maker"));
					pTemp.setIndate(rs.getString("indate"));
					plist.add(pTemp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return plist;
	}
	
	
	public void update(ProductDTO pdto) {
		if(conn()) {
			try {
				String sql = "update productmge set category = ?, pname = ?, price = ?, stock = ?, maker = ?, sysdate";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pdto.getCategory());
				pstmt.setString(2, pdto.getPname());
				pstmt.setInt(3, pdto.getPrice());
				pstmt.setInt(4, pdto.getStock());
				pstmt.setString(5, pdto.getMaker());
				int result = pstmt.executeUpdate();
				if(result > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Object sel) {
		if(conn()) {
			try {
				String a = String.valueOf(sel);
				String sql = "delete from productmge where pnum = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, a);
				int result = pstmt.executeUpdate();
				if(result > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Connection 자원 획득 실패");
		}
	}
	
	//실행할때 마다 제고에서 -1 하기 위한 메소드.
	public void update2 (String pnum) {
		if(conn()) {
			try {
				String sql = "update productmge set stock = (stock-1) where pnum = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pnum);
				int result = pstmt.executeUpdate();
				if(result > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("커넥션 자원 획득 실패");
		}
	}
	
	
	
}
