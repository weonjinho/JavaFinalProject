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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn) {
			//창 닫는 코드.
			this.dispose();
			//전체조회 코드 ( 테스트용 )
			//selectAll() 실행 확인 코드.
//			ArrayList<EmployeeDTO> elist2 = empdao.selectAll();
//			for(EmployeeDTO ee : elist2) {
//				System.out.println("111");
//				System.out.println(ee.toString());
//				System.out.println("사원번호 : " + ee.getEmpno());
//				System.out.println("비밀번호 : " + ee.getPassword());
//			}
		}
		if(e.getSource() == joinBtn) {
			System.out.println("입력한 회원정보를 DB에 저장");
			String empName1 = inputName.getText();
			String inputPass1 = inputPass.getText();
			String inputPassChk1 = inputPassChk.getText();
			String inputDeptName1 = inputDeptName.getText();
			String inputGender1 = inputGender.getText();
			String inputEmail1 = inputEmail.getText();
			String inputTel1 = inputTel.getText();
			System.out.println(empName1 + " " + inputPass1 + " " + inputPassChk1 + " " + inputDeptName1 + " " + inputGender1 + " " + inputEmail1 + " " + inputTel1);
			EmployeeDTO elist = new EmployeeDTO();
			elist.setName(empName1);
			if(inputPass1.equals(inputPassChk1)) {
				System.out.println("비밀번호 일치");
				elist.setPassword(inputPass1);
			}else {
				System.out.println("비밀번호 불일치");
			}
			elist.setDeptName(inputDeptName1);
			elist.setGender(inputGender1);
			elist.setEmail(inputEmail1);
			elist.setTel(inputTel1);
			empdao.insert(elist);
			//현재 창 닫기.
			this.dispose();
			//로그인 창으로 이동.
			new LoginFrame();
		}
		
	}
}
