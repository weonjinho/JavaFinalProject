package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.EmployeeDTO;

public class EmployeeDAO {
	private Connection conn = null;
	
	public EmployeeDAO(){
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
//			System.out.println("Connection 자원 획득 성공.");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	//사원정보 추가 메소드.
	public void insert(EmployeeDTO empdto) {
		if(conn()) {
			try {
//				String 사원번호 = 받아온값;
				String sql = "insert into emponeinfo values ('사원번호4', ?, ?, ?, sysdate, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, sql);
//				pstmt.setString(2, empdto.getPassword());
//				pstmt.setString(3, empdto.getName());
//				pstmt.setString(4, empdto.getDeptName());
//				pstmt.setString(5, empdto.getGender());
//				pstmt.setString(6, empdto.getEmail());
//				pstmt.setString(7, empdto.getTel());
				pstmt.setString(1, empdto.getPassword());
				pstmt.setString(2, empdto.getName());
				pstmt.setString(3, empdto.getDeptName());
				pstmt.setString(4, empdto.getGender());
				pstmt.setString(5, empdto.getEmail());
				pstmt.setString(6, empdto.getTel());
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
	
	
	
	//사원정보 전체 조회 메소드
	public ArrayList<EmployeeDTO> selectAll() {
		ArrayList<EmployeeDTO> elist = new ArrayList<>();
		if(conn()) {
			try {
				String sql = "select * from emponeinfo";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					EmployeeDTO eTemp = new EmployeeDTO();
					eTemp.setEmpno(rs.getString("empno"));
					eTemp.setName(rs.getString("name"));
					eTemp.setPassword(rs.getString("password"));
					eTemp.setDeptName(rs.getString("deptname"));
					eTemp.setJoinDate(rs.getString("joindate"));
					eTemp.setGender(rs.getString("gender"));
					eTemp.setEmail(rs.getString("email"));
					eTemp.setTel(rs.getString("tel"));
					elist.add(eTemp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		}else {
			System.out.println("Connection 확득 실패");
		}
		return elist;
	}
	
	
	
	public EmployeeDTO selectOne(String employee) {
		if(conn()) {
			try {
				String sql = "select * from emponeinfo where empno = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, employee);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					EmployeeDTO eTemp = new EmployeeDTO();
					eTemp.setEmpno(rs.getString("empno"));
					eTemp.setName(rs.getString("name"));
					eTemp.setPassword(rs.getString("password"));
					eTemp.setDeptName(rs.getString("deptname"));
					eTemp.setJoinDate(rs.getString("joindate"));
					eTemp.setGender(rs.getString("gender"));
					eTemp.setEmail(rs.getString("email"));
					eTemp.setTel(rs.getString("tel"));
					return eTemp;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		}else {
			System.out.println("Connection 자원 획득 실패");
		}
		return null;
	}
	
	
	
	public void update(String empno, String i) {
		if(conn()) {
			try {
				System.out.println("111");
				System.out.println(empno + " / " + i);
				String sql = "update emponeinfo set password = ? where empno = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, i);
				pstmt.setString(2, empno);
				int result = pstmt.executeUpdate();
				if(result > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		}else {
			System.out.println("Connection 확득 실패");
		}
		
	}
	
	
	
	public void delete(String empno) {
		if(conn()) {
			try {
				String sql = "delete from emponeinfo where empno = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, empno);
				int result = pstmt.executeUpdate();
				if(result > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		}else {
			System.out.println("Connection 확득 실패");
		}
	}
	
	
	
	
	
	
}



















