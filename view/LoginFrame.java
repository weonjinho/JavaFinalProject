package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dao.ProductDAO;
import dto.EmployeeDTO;

public class LoginFrame extends JFrame implements ActionListener{
	private EmployeeDAO empdao = new EmployeeDAO();
	
	private JPanel mainPanel = new JPanel();
	
	//제목
	private JLabel title = new JLabel("로그인");
	private Font font = new Font("맑은 고딕", Font.PLAIN, 20);
	
	
	
	//아이디
	private JLabel labelId = new JLabel("아이디 : ");
	private JTextField inputId = new JTextField(10);
	
	//비밀번호
	private JLabel labelPass = new JLabel("비밀번호 : ");
	private JPasswordField inputPass = new JPasswordField(10);
	
	//버튼
	private JButton loginBtn = new JButton("로그인");
	private JButton findPassBtn = new JButton("비밀번호 찾기");
	private JButton joinBtn = new JButton("신규가입");
	
	
	//값을 저장하는 멤버변수.
	private String strId = null;
	private String strPass = null;
	private String nowUserName = null;
	private String nowUserDept = null;
	
	//Getter/Setter
	public String getNowUserName() {
		return nowUserName;
	}

	public void setNowUserName(String nowUserName) {
		this.nowUserName = nowUserName;
	}

	
	public LoginFrame() {
		mainPanel.setLayout(null);
		
		//title
		title.setFont(font);
		title.setLocation(200, 60);
		title.setSize(130, 130);
		
		//아이디_위치
		labelId.setLocation(98, 150);
		//아이디_크기
		labelId.setSize(100, 30);
		//아이디_입력창_위치
		inputId.setLocation(156, 155); // ( 가로, 세로 )
		//아이디_입력창_크기
		inputId.setSize(150, 25); // ( 가로, 세로 )

		//비밀번호_위치
		labelPass.setLocation(86, 185);
		//비밀번호_크기
		labelPass.setSize(100,30);
		//비밀번호_입력창_위치
		inputPass.setLocation(156, 190);
		//비밀번호_입력창_크기
		inputPass.setSize(150, 25);

		//로그인 버튼
		loginBtn.setLocation(316, 155);
		loginBtn.setSize(80, 60);
		
		//"비밀번호 찾기"버튼
		findPassBtn.setLocation(166, 225);
		findPassBtn.setSize(110, 30);
		
		//"신규등록" 버튼
		joinBtn.setLocation(287, 225);
		joinBtn.setSize(110, 30);
		
		
		//제목
		mainPanel.add(title);
		
		//아이디
		mainPanel.add(labelId);
		mainPanel.add(labelPass);
		//비밀번호
		mainPanel.add(inputId);
		mainPanel.add(inputPass);
		//로그인 버튼
		mainPanel.add(loginBtn);
		//"비밀번호 찾기"버튼
		mainPanel.add(findPassBtn);
		//"신규등록"버튼
		mainPanel.add(joinBtn);
		
		this.add(mainPanel);
		this.setTitle("로그인");
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//리스너 등록
		loginBtn.addActionListener(this);
		findPassBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			EmployeeDTO employee = null;
			boolean flag = true;
			try {
				while(flag) {
					strId = inputId.getText();
					String password = "";
					char[] pass = inputPass.getPassword();
					String a = new String(pass);
					for(char b : pass) {
						Character.toString(b);
						password += (a.equals("")) ? "" + b + "" : "" + b + "";
					}
					strPass = password;
					employee = empdao.selectOne(strId);
					nowUserName = employee.getName();
					nowUserDept = employee.getDeptName();
					if(employee != null && strPass.equals(employee.getPassword())) {
						if(strId.equals("admin")) {
							System.out.println("관리자 입니다.");
							ManagerFrame pf = new ManagerFrame();
							pf.setEmpName(nowUserName);
							pf.setNowDeptName(nowUserDept);
							pf.ProductFrame_02();
							pf = null;
						}else {
							System.out.println("일반사원 입니다.");
							EmployeeFrame s = new EmployeeFrame();
						}
						this.dispose();
						break;
					}else {
						System.out.println("로그인 실패");
						if(!strPass.equals(employee.getPassword())) {
							System.out.println("비밀번호 오류");
						}
						flag = false;
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		//"비밀번호 찾기"
		if(e.getSource() == findPassBtn) {
			this.dispose();
//			new FindPassFrame();
			new FindPassFrame();
		}
		
		//"신규가입"
		if(e.getSource() == joinBtn) {
			this.dispose();
			new JoinFrame();
		}
		
	}
}





























