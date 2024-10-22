package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class JoinFrame extends JFrame implements ActionListener{
	//DAO 접근용 변수.
	private EmployeeDAO empdao = new EmployeeDAO();
	
	//Swing 배치
	private JPanel mainCenterPanel = new JPanel();//"라벨 & 입려창"이 있는 패널.
	
	private JPanel mainCenterFirstPanel = new JPanel();//"이름"의 라벨&입력창이 있는 패널.
	private JLabel nameLabel = new JLabel("이름");
	private JTextField inputName = new JTextField(10);
	private JPanel mainCenterSecondPanel = new JPanel();//"비밀번호" 라벨&입력창이 있는 패널.
	private JLabel passLabel = new JLabel("비밀번호");
	private JTextField inputPass = new JTextField(10);
	private JPanel mainCenterThirdPanel = new JPanel();//"비밀번호 확인" 라벨&입력창이 있는 패널.
	private JLabel passChkLabel = new JLabel("비밀번호 확인");
	private JTextField inputPassChk = new JTextField(10);
	private JPanel mainCenterFourthPanel = new JPanel();//"부서명" 라벨&입력창이 있는 패널.
	private JLabel deptNameLabel = new JLabel("부서명");
	private JTextField inputDeptName = new JTextField(10);
	private JPanel mainCenterFifthPanel = new JPanel();//"성별" 라벨&입력창이 있는 패널.
	private JLabel genderLabel = new JLabel("성별");
	private JTextField inputGender = new JTextField(10);
	private JPanel mainCenterSixPanel = new JPanel();//"이메일" 라벨&입력창이 있는 패널.
	private JLabel emailLabel = new JLabel("이메일");
	private JTextField inputEmail = new JTextField(10);
	private JPanel mainCenterSevenPanel = new JPanel();//"전화번호" 라벨&입력창이 있는 패널.
	private JLabel telLabel = new JLabel("전화번호");
	private JTextField inputTel = new JTextField(10);
	
	private JPanel mainSouthPanel = new JPanel(); //"취소 & 가입"버튼이 있는 패녈.
	private JButton cancelBtn = new JButton("취소");//"취소"버튼 생성.
	private JButton joinBtn = new JButton("가입");//"가입"버튼 생성.
	
	//값 저장용 변수.
	public static String inputDept = null;//사원등록시 입력한 사원번호를 받아올 변수.
	
	public JoinFrame(){
		//mainCenterPanel
		mainCenterPanel.setLayout(new GridLayout(7,0)); //mainCenterPanel의 레이아웃 지정. ( 가로:1, 세로:7 )
		
		mainCenterFirstPanel.setLayout(new GridLayout());
		mainCenterFirstPanel.add(nameLabel);
		mainCenterFirstPanel.add(inputName);
		mainCenterFirstPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainCenterPanel.add(mainCenterFirstPanel);
		
		mainCenterSecondPanel.setLayout(new GridLayout());
		mainCenterSecondPanel.add(passLabel);
		mainCenterSecondPanel.add(inputPass);
		mainCenterSecondPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainCenterPanel.add(mainCenterSecondPanel);
		
		mainCenterThirdPanel.setLayout(new GridLayout());
		mainCenterThirdPanel.add(passChkLabel);
		mainCenterThirdPanel.add(inputPassChk);
		mainCenterThirdPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainCenterPanel.add(mainCenterThirdPanel);
		
		mainCenterFourthPanel.setLayout(new GridLayout());
		mainCenterFourthPanel.add(deptNameLabel);
		mainCenterFourthPanel.add(inputDeptName);
		mainCenterFourthPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainCenterPanel.add(mainCenterFourthPanel);
		
		mainCenterFifthPanel.setLayout(new GridLayout());
		mainCenterFifthPanel.add(genderLabel);
		mainCenterFifthPanel.add(inputGender);
		mainCenterFifthPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainCenterPanel.add(mainCenterFifthPanel);
		
		mainCenterSixPanel.setLayout(new GridLayout());
		mainCenterSixPanel.add(emailLabel);
		mainCenterSixPanel.add(inputEmail);
		mainCenterSixPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainCenterPanel.add(mainCenterSixPanel);
		
		mainCenterSevenPanel.setLayout(new GridLayout());
		mainCenterSevenPanel.add(telLabel);
		mainCenterSevenPanel.add(inputTel);
		mainCenterSevenPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainCenterPanel.add(mainCenterSevenPanel);
		
		//mainSouthPanel
		mainSouthPanel.setLayout(new FlowLayout());
		mainSouthPanel.add(cancelBtn);
		mainSouthPanel.add(joinBtn);
		
		//JFrame
		this.setTitle("회원가입");
		this.setLayout(new BorderLayout());
		this.add(mainCenterPanel,"Center");
		this.add(mainSouthPanel,"South");
		this.setBounds(200, 200, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//리스너 등록
		cancelBtn.addActionListener(this);
		joinBtn.addActionListener(this);
	}

   //이메일 정규 표현식 검사.
   private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

   //전화번호 정규 표현식 검사.
   private boolean checkTelNum (String telNum) {
	   String telRegex = "^\\d{3}-\\d{3,4}-\\d{4}$";
	   return telNum.matches(telRegex);
   }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {//"취소"버튼 클릭시 action.
			this.dispose();
		}
		if(e.getSource() == joinBtn) {//"가입"버튼 클릭시 action.
			String empName1 = inputName.getText();//입력한 "사원이름" 텍스트
			String inputPass1 = inputPass.getText();//입력한 "비밀번호" 텍스트
			String inputPassChk1 = inputPassChk.getText();//입력한 "비밀번호 확인" 텍스트
			String inputDeptName1 = inputDeptName.getText();//입력한 "부서명" 택스트
			String inputGender1 = inputGender.getText();//입력한 "성별" 택스트
			String inputEmail1 = inputEmail.getText();//입력한 "이메일" 택스트
			String inputTel1 = inputTel.getText();//입력한 "전화번호" 택스트
			inputDept = inputDeptName1;
			System.out.println("전달할 부서명 : " + inputDept);
			System.out.println( "*** 신입 사원 데이터 *** : " + empName1 + " " + inputPass1 + " " + inputPassChk1 + " " + inputDeptName1 + " " + inputGender1 + " " + inputEmail1 + " " + inputTel1);
			EmployeeDTO elist = new EmployeeDTO();
			//비밀번호 확인 기능 시작.
			if(inputPass1.equals(inputPassChk1)) { 
				System.out.println("비밀번호 일치");
				elist.setPassword(inputPass1);//비밀번호 정상 입력됨.
			}else {
				System.out.println("비밀번호 불일치");
			}
			//--비밀번호 확인 기능 끝.
			//신규 사원정보 저장 시작.
			elist.setName(empName1);//사원이름 정상 입력됨.
			elist.setDeptName(inputDeptName1);//부서명 정상 입력됨.
			elist.setGender(inputGender1);//성별 정상 입력됨.
			if(isValidEmail(inputEmail1)) {
				elist.setEmail(inputEmail1);//이메일 정상 입력됨.
			}else {
				System.out.println("이메일 형식 이상.");
			}
			if(checkTelNum(inputTel1)) {
				elist.setTel(inputTel1);//전화번호 정상 입력됨.
			}else {
				System.out.println("전화번호 형식 이상.");
			}
			empdao.insert(elist);//EmployeeDAO에 전달 ---> 신규 가입한 사원의 데이터를 DB에 추가.
			//--신규 시원정보 저장 끝.
			this.dispose();
			new LoginFrame();
		}
		
	}
}
