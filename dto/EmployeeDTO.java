package dto;

public class EmployeeDTO {
	private String empno = null;
	private String password = null;
	private String name = null;
	private String deptName = null;
	private String joinDate = null;
	private String gender = null;
	private String email = null;
	private String tel = null;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empno=" + empno + ", password=" + password + ", name=" + name + ", deptName=" + deptName
				+ ", joinDate=" + joinDate + ", gender=" + gender + ", email=" + email + ", tel=" + tel + "]";
	}
	
	
}
