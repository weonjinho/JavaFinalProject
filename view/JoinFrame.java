package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class JoinFrame extends JFrame implements ActionListener{
	private EmployeeDAO empdao = new EmployeeDAO();
	
	
	private JPanel mainPanel = new JPanel();
	
	//제목
	private JLabel title = new JLabel("신규등록");
	private Font font = new Font("맑은 고딕", Font.PLAIN, 20);
	
	//이름
	private JLabel nameLabel = new JLabel("이름 : ");
	private JTextField nameInput = new JTextField();
	
	//비밀번호
	private JLabel passLabel = new JLabel("비밀번호 : ");
	private JPasswordField passInput = new JPasswordField();
	
	//비밀번호 확인
	private JLabel chkPassLabel = new JLabel("비밀번호 확인 : ");
	private JPasswordField chkPassInput = new JPasswordField(); 
	
	//부서명
	private JLabel deptNameLabel = new JLabel("부서명 : ");
	private JTextField deptNameInput = new JTextField(); 
	
	//성별
	private JLabel gender = new JLabel("성별 : ");
	private JTextField genderInput = new JTextField();
	
	
	//이메일 주소
	private JLabel email = new JLabel("이메일 주소 : ");
	private JTextField emailInput = new JTextField();
	
	//전화번호
	private JLabel tel = new JLabel("전화번호 : ");
	private JTextField telInput = new JTextField();
	
	//버튼
	private JButton cancelBtn = new JButton("취소");
	private JButton joinBtn = new JButton("가입");
	
	//값 저장용 변수.
	public static String inputDept = null;//사원등록시 입력한 사원번호를 받아올 변수.
	
	public JoinFrame() {
		mainPanel.setLayout(null);
		
		//title
		title.setFont(font);
		title.setLocation(205, 1);
		title.setSize(130, 130);
		
		//이름
		nameLabel.setLocation(140, 90);
		nameLabel.setSize(100, 30);
		//이름_입력
		nameInput.setLocation(190, 90);
		nameInput.setSize(150, 25);
		
		//비밀번호
		passLabel.setLocation(116, 120);
		passLabel.setSize(100, 30);
		
		//비밀번호_입력
		passInput.setLocation(190, 120);
		passInput.setSize(150, 25);
		
		//비밀번호 확인
		chkPassLabel.setLocation(90, 150);
		chkPassLabel.setSize(100, 30);
		
		//비밀번호 확인_입력창
		chkPassInput.setLocation(190, 150);
		chkPassInput.setSize(150, 25);
		
		//부서명
		deptNameLabel.setLocation(129, 185);
		deptNameLabel.setSize(100, 30);
		
		//부서명_입력창
		deptNameInput.setLocation(190, 185);
		deptNameInput.setSize(150, 25);
		
		//성별
		gender.setLocation(141, 220);
		gender.setSize(100, 30);
		
		//성별_입력창
		genderInput.setLocation(190, 220);
		genderInput.setSize(150, 25);
		
		
		//이메일 주소
		email.setLocation(103, 250);
		email.setSize(100, 30);
		
		//이메일 주소_입력창
		emailInput.setLocation(190, 250);
		emailInput.setSize(150, 25);
		
		
		//전화번호
		tel.setLocation(118, 280);
		tel.setSize(100, 30);
		
		//전화번호_입력창
		telInput.setLocation(190, 280);
		telInput.setSize(150, 25);
		
		//취소버튼
		cancelBtn.setLocation(190, 320);
		cancelBtn.setSize(70, 30);
		
		//가입버튼
		joinBtn.setLocation(270, 320);
		joinBtn.setSize(70, 30);
		
		//제목
		mainPanel.add(title);
		
		//이름
		mainPanel.add(nameLabel);
		mainPanel.add(nameInput);
		
		//비밀번호
		mainPanel.add(passLabel);
		mainPanel.add(passInput);
		
		//비밀번호 확인
		mainPanel.add(chkPassLabel);
		mainPanel.add(chkPassInput);
		
		//부서명
		mainPanel.add(deptNameLabel);
		mainPanel.add(deptNameInput);
		
		//성별
		mainPanel.add(gender);
		mainPanel.add(genderInput);
		
		
		//이멩리
		mainPanel.add(email);
		mainPanel.add(emailInput);
		
		//전화번호
		mainPanel.add(tel);
		mainPanel.add(telInput);
		
		//취소버튼
		mainPanel.add(cancelBtn);
		
		//가입버튼
		mainPanel.add(joinBtn);
		
		this.add(mainPanel);
		this.setTitle("신규등록");
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
		// TODO Auto-generated method stub
		if(e.getSource() == cancelBtn) {
			this.dispose();
			new LoginFrame();
		}
		
		if(e.getSource() == joinBtn) {
			String empName1 = nameInput.getText();
			String inputPass1 = "";
			char[] pass = passInput.getPassword();
			String a = new String(pass);
			for(char b : pass) {
				Character.toString(b);
				inputPass1 += (a.equals("")) ? "" + b + "" : "" + b + "";
			}
			String inputPassChk1 = "";
			char[] pass2 = chkPassInput.getPassword();
			String c = new String(pass2);
			for(char b : pass) {
				Character.toString(b);
				inputPassChk1 += (c.equals("")) ? "" + b + "" : "" + b + "";
			}
			String inputDeptName1 = deptNameInput.getText();
			String inputGender1 = genderInput.getText();
			String inputEmail1 = emailInput.getText();
			String inputTel1 = telInput.getText();
			inputDept = inputDeptName1;
			EmployeeDTO elist = new EmployeeDTO();
			if(inputPass1.equals(inputPassChk1)) {
				System.out.println("비밀번호 일치");
				elist.setPassword(inputPass1);
			}else {
				System.out.println("비밀번호 불일치");
			}
			elist.setName(empName1);
			elist.setDeptName(inputDeptName1);
			elist.setGender(inputGender1);
			if(isValidEmail(inputEmail1)) {
				elist.setEmail(inputEmail1);
			}else {
				System.out.println("이메일 형식 이상");
			}
			if(checkTelNum(inputTel1)) {
				elist.setTel(inputTel1);
			}else {
				System.out.println("전화번호 형식 이상");
			}
			empdao.insert(elist);
			this.dispose();
			
			new LoginFrame();
		}
		
		System.out.println("111");
	}
}
