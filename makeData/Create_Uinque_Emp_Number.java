package makeData;

import java.util.ArrayList;

public class Create_Uinque_Emp_Number {
//	private static ArrayList<String> empList = new ArrayList<>();
//	public static void main(String[] args) {
////		int empCnt = 5; //직원 인원수
////		for(int i=0;i<empCnt;i++) {
////			Create_Ramdom_Number num = new Create_Ramdom_Number();
////			String oneEmp = num.Create_Ramdom_Number();
////			System.out.println("oneEmp : " + oneEmp);
////			empList.add(oneEmp);
////			num = null;
////		}
////		System.out.println("empList : " + empList);
//		
//		
//	}
	public static void main(String[] args) {
		createEmpNum();
	}
	
	
	//사원번호 생성 메소드
	private static void createEmpNum() {
		//생성된 사원번호 받아오기
		Create_Ramdom_Number num = new Create_Ramdom_Number();
		
		
		//선택한 부서를 읽어온다. ---> checkbox;
		//String deptName = null;
		
		//데이터를 입력한 날짜의 "년, 월"을 읽어온다. ---> substr()메소드 사용 절삭
		//String empNumDate = null;
		
		//사원번호
		String oneEmp = num.Create_Ramdom_Number();//직원 한명에 사원번호 중 랜덤숫자를 저장할 변수.
		
		//부서명 + "입사 년,월" + 사원번호
		//String finalEmpNum = deptName + empNumDate + oneEmp;
//		System.out.println("완성된 사원번호 : " + finalEmpNum);
		num = null;
	}
}
