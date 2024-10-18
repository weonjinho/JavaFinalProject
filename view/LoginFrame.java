package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class LoginFrame extends JFrame implements ActionListener{
	EmployeeDAO empdao = new EmployeeDAO();
	
	private JPanel mainCenterPanel = new JPanel();
	private JPanel mainSouthPanel = new JPanel();
	private JPanel mainCLeftPanel = new JPanel();
	private JPanel mainCCenterPanel = new JPanel();
	private JPanel mainCRightPanel = new JPanel();
	private JButton findPassBtn = new JButton("비밀번호 찾기");
	private JButton joinBtn = new JButton("회원가입");
	private JButton loginBtn = new JButton("로그인");
	private JLabel labelId = new JLabel("아이디");
	private JLabel labelPass = new JLabel("비밀번호");
	private JTextField inputId = new JTextField(10);
	private JTextField inputPass = new JTextField(10);
	
	
	public LoginFrame(){
		//BackgroundColor
		mainCenterPanel.setLayout(new GridLayout(0,3));
		mainCenterPanel.add(mainCLeftPanel);
		mainCenterPanel.add(mainCCenterPanel);
		mainCenterPanel.add(mainCRightPanel);
		
		mainSouthPanel.setLayout(new GridLayout(0,2));
		mainSouthPanel.add(findPassBtn);
		mainSouthPanel.add(joinBtn);
		
		mainCLeftPanel.setLayout(new GridLayout(2, 0));
		mainCLeftPanel.add(labelId);
		mainCLeftPanel.add(labelPass);
		
		mainCCenterPanel.setLayout(new GridLayout(2,0));
		mainCCenterPanel.add(inputId);
		mainCCenterPanel.add(inputPass);
		
		System.out.println(loginBtn.getPreferredSize());
		loginBtn.setPreferredSize(new Dimension(100, 70));
		
		mainCRightPanel.add(loginBtn);
		
		//JFrame
		this.setTitle("로그인");
		this.setLayout(new BorderLayout());
		this.add(mainCenterPanel,"Center");
		this.add(mainSouthPanel,"South");
		this.setBounds(200, 200, 300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		loginBtn.addActionListener(this);
		findPassBtn.addActionListener(this);
		joinBtn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//"로그인"창에서 "로그인"버튼 클릭
		if(e.getSource() == loginBtn) {
			System.out.println("로그인 진행");
			//로그인 기능 구현 코드.
			String inputId2 = null;
			String inputPass2 = null;
			EmployeeDTO employee = null;
			boolean flag = true;
			try {
				while(flag) { //로그인 실패시 제업력 코드.
					Scanner in = new Scanner(System.in);
					inputId2 = inputId.getText();
					inputPass2 = inputPass.getText();
					//입력받은 "사원번호"로 검색후 관련 정보 가져오기.
					employee = empdao.selectOne(inputId2);
					if(employee != null) {
						if(inputPass2.equals(employee.getPassword())) {
							System.out.println("로그인 성공");
							if(inputId2.equals("admin")) {
								System.out.println("*****");
								System.out.println("관리자 입니다.");
								System.out.println("현재 관리자이름은 : " + employee.getName() + "입니다.");
								new ProductFrame_02();
							}else {
								System.out.println("====== " + employee.getDeptName() + "부 " + employee.getName() + " 사원입니다." + " ======");
								new SelectProduct_employee();
							}
							this.dispose();
							break;
						}else {
							System.out.println("로그인 실패");
							if(!inputPass2.equals(employee.getPassword())) {
								System.out.println("비번 오류");
							}
							flag = false;
						}
					}else if(employee == null) {
						System.out.println("존재하지 않은 아이디입니다.");
						break;
					}
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("입력창이 비여 있습니다.");
//				e2.printStackTrace();
			}
		}
		
		
		//"비밀번호찾기" 클릭.
		if(e.getSource() == findPassBtn) {
			System.out.println("로그인 창 닫임.");
			this.dispose();
			new FindPassFrame();
		}
		
		
		//"회원가입" 클릭.
		if(e.getSource() == joinBtn) {
			System.out.println("회원가입 창으로 이동.");
			this.dispose();
			new JoinFrame();
		}
	}
}
