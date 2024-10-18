package makeData;

import view.JoinFrame;
import view.LoginFrame;

public class makeEmpno {
	//사원번호 : 부서번호 + 입사년월( 2410 ) + 5자리숫자.
	//부서번호 : (조건문)
	//1.생활가전 : 001
	//2.주방가전 : 002
	//3.개절가전 : 003
	//4.통신용품 : 004
	//5.PC용품 : 005
	
	//입사날짜 : 현재날짜의 년,월 정보 추출. (메소드 --> 리턴)
	//5자리숫자 : 5자리 중복없는 랜던숫자 생성. (메소드 ---> 리턴)
	private String empno = null;
	private Create_Ramdom_Number a = new Create_Ramdom_Number();
	private JoinFrame input = new JoinFrame();
	public makeEmpno() {
		System.out.println("입력한 부서명 : " + (input.getInputDeptName()).getText());
		String deptNum = "";
		if((input.getInputDeptName().getText()).equals("생활가전")) {
			deptNum = "001";
		}else if(input.getInputDeptName().equals("주방가전")) {
			deptNum = "002";
		}else if(input.getInputDeptName().equals("개절가전")) {
			deptNum = "003";
		}else if(input.getInputDeptName().equals("통신용품")) {
			deptNum = "004";
		}else if(input.getInputDeptName().equals("PC용품")) {
			deptNum = "005";
		}else {
			deptNum = "111";
		}
		GetNowDate date = new GetNowDate();
		String joinDate = date.GetNowDate();
		String number = a.Create_Ramdom_Number();
		empno = deptNum + "_" + joinDate + "_" + number;
		System.out.println("부서코드 : " + deptNum);
		System.out.println("joinDate : " + joinDate);
		System.out.println("생성한 사원번호 : " + empno);
	}
	public String getEmpno() {
		return empno;
	}
	
	
}
