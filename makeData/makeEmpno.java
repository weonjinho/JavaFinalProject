package makeData;

import view.JoinFrame;

public class MakeEmpno {
	//사원번호 : 부서번호 + 입사년월( 2410 ) + 5자리숫자.
	
	//부서코드
	//1.생활가전 : 001
	//2.주방가전 : 002
	//3.계절가전 : 003
	//4.통신용품 : 004
	//5.PC용품 : 005
	
	//입사날짜 : 현재날짜의 년,월 정보 추출. (메소드 --> 리턴)
	//5자리숫자 : 5자리 중복없는 랜던숫자 생성. (메소드 ---> 리턴)
	
	//입사날짜 : GetNowDate() 호출
	
	
	//5자리숫자 : Create_Ramdom_Number() 호출
	
	private String empno = null;
	private CreateRamdomNumber a = new CreateRamdomNumber();
	public MakeEmpno() {
		System.out.println();
		System.out.println("--- makeEmpno 시작 ---");
		System.out.println("*********************");
		System.out.println();
		JoinFrame input = new JoinFrame();
		String thisDept =  input.inputDept;
		System.out.println("입력한 부서명 ### : " + thisDept);
		String deptNum = thisDept;//부서코드 저장할 번수.
		if(thisDept.equals("생활가전")) {
			deptNum = "001";
		}else if(thisDept.equals("주방가전")) {
			deptNum = "002";
		}else if(thisDept.equals("계절가전")) {
			deptNum = "003";
		}else if(thisDept.equals("통신용품")) {
			deptNum = "004";
		}else if(thisDept.equals("PC용품")) {
			deptNum = "005";
		}else {
			deptNum = "111";
		}
		GetNowDate date = new GetNowDate();
		String joinDate = date.GetNowDate();
		String number = a.Create_Ramdom_Number();
		empno = deptNum + "_" + joinDate + "_" + number;
		System.out.println("부서코드 : " + deptNum);
		System.out.println("입사날짜 : " + joinDate);
		System.out.println("생성한 사원번호 : " + empno);
		
		System.out.println();
		System.out.println("*******************");
		System.out.println("--- makeEmpno 끝 ---");
		System.out.println();
		
	}
	
	//사원번호 메소드.
	public String getEmpno() {
		return empno;
	}
	
	
}
