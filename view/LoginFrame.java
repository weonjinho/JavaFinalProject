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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class LoginFrame extends JFrame implements ActionListener{
	private EmployeeDAO empdao = new EmployeeDAO();
	
	//Swing 관련 멤버변수
	private JPanel mainPanel = new JPanel();//모든 패널을 담을 매인 패널.
	
	private JLabel titleLabel = new JLabel("로그인");
	private JPanel titlePanel = new JPanel();//"로그인"이라는 제목이 위치한 패널.
	
	private JLabel idLable = new JLabel("아이디 : ");//"아이디"라벨
	private JTextField idInput = new JTextField(10);//"아이디" 입력창.
	private JPanel idPanel = new JPanel();//"아이디"라벨 & "아이디"입력창이 위치한 패널.
	
	private JLabel passLabel = new JLabel("비밀번호 : ");//"비밀번호"라벨
//	private JTextField passInput = new JTextField(10);//"비밀번호" 입력창.
	private JPasswordField passInput = new JPasswordField(10);
	private JPanel passPanel = new JPanel();//"비밀번호"라벨 & "비밀번호"입력창이 위치한 패널.
	
	private JButton loginBtn = new JButton("로그인");
	private JPanel loginBtnPanel = new JPanel();//"로그인"버튼이 위치한 패널.
	
	private JButton findPassBtn = new JButton("비밀번호 찾기");
	private JButton joinBtn = new JButton("신규등록");
	private JPanel btnPanel = new JPanel();//"비밀번호 찾기", "신규등록"버튼이 위치한 패널.
	
	//값 저장 용 멤버변수.
	
	private String inputId = null;	//입력한 id를 받아 저장할 변수.
	
	private String inputPass = null; //입력한 password를 받아 저장할 변수.
	
	private String nowUserName = null; //현재 사용자 이름을 받아 저장할 변수.
	private String nowUserDept = null; //현재 사용자의 부서명을 받아 저장할 변수.
	
	//Getter/Setter
	public String getNowUserName() {
		return nowUserName;
	}
	public void setNowUserName(String nowUserName) {
		this.nowUserName = nowUserName;
	}
	
	public LoginFrame(){
		mainPanel.setLayout(new GridLayout(5, 0));//메인 패널의 layout 지정. ( 가로:5, 세로:1 )
		titlePanel.add(titleLabel);//"titleLabel"를 "titlePanel"에 부착.
		mainPanel.add(titlePanel); //"titlePanel"를 "mainPanel"에 부착.
		
		idPanel.setLayout(new FlowLayout());//"idPanel"의 layout 지정.
	
		idPanel.add(idLable);//"idLable"를 "idPanel"에 부착.
		idPanel.add(idInput);//"idInput"를 "idPanel"에 부착.
		mainPanel.add(idPanel);//"idPanel"를 "mainPanel"에 부착.
		
		passPanel.setLayout(new FlowLayout());//"passPanel"의 layout 지정.
		passPanel.add(passLabel);//"passLabel"를 "passPanel"에 부착.
		passPanel.add(passInput);//"passInput"를 "passPanel"에 부착.
		mainPanel.add(passPanel);//"passPanel"를 "mainPanel"에 부착.
		
		loginBtnPanel.add(loginBtn);//"로그인"버튼을 "로그인 버튼 패널"에 부착.
		mainPanel.add(loginBtnPanel);//"로그인 버튼 패널"을 메인패널에 부착.
		
		btnPanel.setLayout(new FlowLayout());//"비밀번호 버튼" & "신규등록 버튼"이 위치한 패널의 layout 지정.
		btnPanel.add(findPassBtn);//"비밀번호 버튼"을 버튼 패널에 부착.
		btnPanel.add(joinBtn);//"신규등록 버튼"을 버튼 패널에 부착.
		mainPanel.add(btnPanel);//"버튼 패널"을 메인 패널에 부착.
		
		this.add(mainPanel);//"메인 패널"을 JFrame에 부착.
		this.setBounds(100, 100, 700, 500);//JFrame 위치( x:100, y:100 ), 크기( 가로:700, 새로:500 ) 지정.
		this.setVisible(true);//JFrame가 화면에 보이게하는 코드.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//"x"버튼 클릭시 실행 종료.
		
		
		//리스너 등록.
		loginBtn.addActionListener(this);
		findPassBtn.addActionListener(this);
		joinBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) { //"로그인 버튼" 클릭시 발생할 action을 지정.
			System.out.println("로그인 진행");
			EmployeeDTO employee = null;//사원 1명의 정보를 DB에서 받아와 저장할 변수.
			boolean flag = true;//반복문 제어를 위해 선언된 boolean 타입 변수.
			try {
				while(flag) {
//					Scanner in = new Scanner(System.in);
					inputId = idInput.getText();//"아이디" 입력창에 입력된 문자열을 받아와 저장.
//					inputPass = passInput.getText();//"비밀번호" 입력창에 입력된 문자열을 받아와 저장.
					
					String password = "";
					char[] pass = passInput.getPassword();
					String a = new String(pass);
					for(char b : pass) {
						Character.toString(b);
						password += (a.equals("")) ? "" + b + "" : "" + b + "";
					}
					System.out.println("비밀번호123 : " + password);
					inputPass = password;
					employee = empdao.selectOne(inputId); //입력받은 String 타입의 "아이디"값으로, 그 아이디를 가진 사원의 모든 정보를 가져온다.
					nowUserName = employee.getName();//가져온 정보 중 "사원이름"을 따로 저장한다.
					nowUserDept = employee.getDeptName();//가져온 정보 중 "부서명"을 따로 저장한다.
					if(employee != null && inputPass.equals(employee.getPassword())) {//입력창이 비여있지 않는 상황.
						System.out.println("로그인 성공");
						if(inputId.equals("admin")) { //"관리자" 로그인 성공.
							System.out.println("관리자 입니다.");
							System.out.println("관리자 이름 : " + employee.getName());
							ManagerFrame pf = new ManagerFrame();
							pf.setEmpName(nowUserName);
							pf.setNowDeptName(nowUserDept);
							pf.ProductFrame_02();
							pf = null; //메모리 자원 회수.
						}else {
							System.out.println("일반사원 입니다.");
							EmployeeFrame s = new EmployeeFrame();
							//"일반사원" 로그인 성공.
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
		if(e.getSource() == findPassBtn) { //"비밀번호 찾기" 클릭시 발생할 action을 지정.
			System.out.println("비번 찾기");
			this.dispose();//현재 창을 닫는다.
			new FindPassFrame();//"비밀번호 찾기" 창을 연다.
		}
		
		//"신규등록"
		if(e.getSource() == joinBtn) { //"신규등록" 클릭시 발생할 action을 지정.
			System.out.println("신규등록");
			this.dispose();//현재 창을 닫는다.
			new JoinFrame();//"신규등록" 창을 연다.
		}
		
	}
}

















