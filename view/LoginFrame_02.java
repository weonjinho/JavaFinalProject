package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class LoginFrame_02 extends JFrame implements ActionListener{
	private EmployeeDAO empdao = new EmployeeDAO();
	private JPanel mainPanel = new JPanel();
	private JLabel titleLabel = new JLabel("로그인");
	private JPanel titlePanel = new JPanel();
	private JLabel idLable = new JLabel("아이디 : ");
	private JPanel idPanel = new JPanel();
	private JTextField idInput = new JTextField(10);
	
	private JLabel passLabel = new JLabel("비밀번호 : ");
	private JPanel passPanel = new JPanel();
	private JTextField passInput = new JTextField(10);
	
	private JButton loginBtn = new JButton("로그인");
	private JPanel loginBtnPanel = new JPanel();
	
	
	private JButton findPassBtn = new JButton("비밀번호 찾기");
	private JButton joinBtn = new JButton("신규등록");
	private JPanel btnPanel = new JPanel();
	
	private String inputId = null;
	private String inputPass = null;
	private String nowUserName = null;
	public String getNowUserName() {
		return nowUserName;
	}



	public void setNowUserName(String nowUserName) {
		this.nowUserName = nowUserName;
	}



	private String nowUserDept = null;
	
	public LoginFrame_02(){
		mainPanel.setLayout(new GridLayout(5, 0));
		titlePanel.add(titleLabel);
		mainPanel.add(titlePanel);
//		idPanel.setLayout(new GridLayout(0,2));
		idPanel.setLayout(new FlowLayout());
		idPanel.add(idLable);
		idPanel.add(idInput);
		mainPanel.add(idPanel);
		
		passPanel.setLayout(new FlowLayout());
		passPanel.add(passLabel);
		passPanel.add(passInput);
		mainPanel.add(passPanel);
		
		loginBtnPanel.add(loginBtn);
		mainPanel.add(loginBtnPanel);
		
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(findPassBtn);
		btnPanel.add(joinBtn);
		mainPanel.add(btnPanel);
		
		this.add(mainPanel);
		this.setBounds(100, 100, 700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		loginBtn.addActionListener(this);
		findPassBtn.addActionListener(this);
		joinBtn.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == loginBtn) {
			System.out.println("로그인 진행");
			EmployeeDTO employee = null;
			boolean flag = true;
			try {
				while(flag) {
					Scanner in = new Scanner(System.in);
					inputId = idInput.getText();
					inputPass = passInput.getText();
					employee = empdao.selectOne(inputId);
					nowUserName = employee.getName();
					nowUserDept = employee.getDeptName();
					if(employee != null) {
						System.out.println("로그인 성공");
						if(inputId.equals("admin")) {
							System.out.println("관리자 입니다.");
							System.out.println("관리자 이름 : " + employee.getName());
							ProductFrame_02 pf = new ProductFrame_02();
							pf.setEmpName(nowUserName);
							pf.setNowDeptName(nowUserDept);
							pf.ProductFrame_02();
						}else {
//							new SelectProduct_employee();
							SelectProduct_employee s = new SelectProduct_employee();
//							s.setNowUserName2(nowUserName);
//							s.setNowUserDeptName2(nowUserDept);
//							nowUserName2 = nowUserName;
//							nowUserDeptName2 = nowUserDept;
						}
						this.dispose();
						break;
					}else {
						System.out.println("로그인 실패");
						
						
						if(!inputPass.equals(employee.getPassword())){
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
			System.out.println("비번 찾기");
			this.dispose();
			new FindPassFrame();
		}
		
		//"회원가입"
		if(e.getSource() == joinBtn) {
			System.out.println("회원가입");
			this.dispose();
			new JoinFrame();
		}
		
	}
}

















