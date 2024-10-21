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
	EmployeeDAO empdao = new EmployeeDAO();
	
	private JPanel mainCenterPanel = new JPanel();
	private JPanel mainSouthPanel = new JPanel();
	private JButton cancelBtn = new JButton("취소");
	private JButton joinBtn = new JButton("가입");
	private JPanel mainCenterFirstPanel = new JPanel();
	private JPanel mainCenterSecondPanel = new JPanel();
	private JPanel mainCenterThirdPanel = new JPanel();
	private JPanel mainCenterFourthPanel = new JPanel();
	private JPanel mainCenterFifthPanel = new JPanel();
	private JPanel mainCenterSixPanel = new JPanel();
	private JPanel mainCenterSevenPanel = new JPanel();
	
	private JLabel nameLabel = new JLabel("이름");
	private JLabel passLabel = new JLabel("비밀번호");
	private JLabel passChkLabel = new JLabel("비밀번호 확인");
	private JLabel deptNameLabel = new JLabel("부서명");
	private JLabel genderLabel = new JLabel("성별");
	private JLabel emailLabel = new JLabel("이메일");
	private JLabel telLabel = new JLabel("전화번호");
	
	private JTextField inputName = new JTextField(10);
	private JTextField inputPass = new JTextField(10);
	private JTextField inputPassChk = new JTextField(10);
	private JTextField inputDeptName = new JTextField(10);
	private JTextField inputGender = new JTextField(10);
	private JTextField inputEmail = new JTextField(10);
	private JTextField inputTel = new JTextField(10);
	
	public static String inputDept = null;//사원등록시 입력한 사원번호를 받아올 변수.
	public JoinFrame(){
		//mainCenterPanel
		//mainCenterPanel - Layout
		mainCenterPanel.setLayout(new GridLayout(7,0));
		mainCenterFirstPanel.setLayout(new GridLayout());
		mainCenterSecondPanel.setLayout(new GridLayout());
		mainCenterThirdPanel.setLayout(new GridLayout());
		mainCenterFourthPanel.setLayout(new GridLayout());
		mainCenterFifthPanel.setLayout(new GridLayout());
		mainCenterSixPanel.setLayout(new GridLayout());
		mainCenterSevenPanel.setLayout(new GridLayout());
		
		//mainCenterPanel - Add Panel
		mainCenterPanel.add(mainCenterFirstPanel);
		mainCenterPanel.add(mainCenterSecondPanel);
		mainCenterPanel.add(mainCenterThirdPanel);
		mainCenterPanel.add(mainCenterFourthPanel);
		mainCenterPanel.add(mainCenterFifthPanel);
		mainCenterPanel.add(mainCenterSixPanel);
		mainCenterPanel.add(mainCenterSevenPanel);

		mainCenterFirstPanel.add(nameLabel);
		mainCenterFirstPanel.add(inputName);
		mainCenterFirstPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		mainCenterSecondPanel.add(passLabel);
		mainCenterSecondPanel.add(inputPass);
		mainCenterSecondPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		mainCenterThirdPanel.add(passChkLabel);
		mainCenterThirdPanel.add(inputPassChk);
		mainCenterThirdPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		mainCenterFourthPanel.add(deptNameLabel);
		mainCenterFourthPanel.add(inputDeptName);
		mainCenterFourthPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		mainCenterFifthPanel.add(genderLabel);
		mainCenterFifthPanel.add(inputGender);
		mainCenterFifthPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		mainCenterSixPanel.add(emailLabel);
		mainCenterSixPanel.add(inputEmail);
		mainCenterSixPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		mainCenterSevenPanel.add(telLabel);
		mainCenterSevenPanel.add(inputTel);
		mainCenterSevenPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		//mainSouthPanel
		mainSouthPanel.setLayout(new FlowLayout());
		mainSouthPanel.add(cancelBtn);
		mainSouthPanel.add(joinBtn);
		
		cancelBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		
		//JFrame
		this.setTitle("회원가입");
		this.setLayout(new BorderLayout());
		this.add(mainCenterPanel,"Center");
		this.add(mainSouthPanel,"South");
		this.setBounds(200, 200, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	   //이메일 정규 표현식 검사.
	   private boolean isValidEmail(String email) {
	        // 이메일 유효성 검사 정규표현식
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
		if(e.getSource() == cancelBtn) {
			//창 닫는 코드.
			this.dispose();
		}
		if(e.getSource() == joinBtn) {
			System.out.println();
			System.out.println("----- JoinFrame 시작 -----");
			System.out.println();
			System.out.println("--- 입력한 회원정보를 DB에 저장 시작 ---");
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
			
			
			
			
			empdao.insert(elist);//EmployeeDAO에 전달
			System.out.println("--- 입력한 회원정보를 DB에 저장 끝 ---");

			System.out.println();
			System.out.println("----- JoinFrame 끝 -----");
			System.out.println();
			//현재 창 닫기.
			this.dispose();
			//로그인 창으로 이동.
			new LoginFrame();
		}
		
	}
}
