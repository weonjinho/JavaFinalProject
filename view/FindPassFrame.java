package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class FindPassFrame extends JFrame implements ActionListener{
	
	private EmployeeDAO empdao = new EmployeeDAO();
	
	private JPanel mainPanel = new JPanel();
	
	private JLabel title = new JLabel("비밀번호 찾기");
	private Font font = new Font("맑은 고딕", Font.PLAIN, 20);
	
	private JLabel idLabel = new JLabel("아이디 : ");
	private JTextField idInput = new JTextField();
	private JButton idBtn = new JButton("인증");
	private JLabel chkResult = new JLabel("인증결과 획인");
	
	
	private JLabel newPassLabel = new JLabel("새 비밀번호 입력 : ");
	private JPasswordField newPassInput = new JPasswordField(); 
	
	private JLabel newPassChkLabel = new JLabel("새 비밀번호 입력 : ");
	private JPasswordField newPassChkInput = new JPasswordField(); 
	
	private JButton cancelBtn = new JButton("취소");
	private JButton changeBtn = new JButton("변경");
	
	public FindPassFrame() {
		mainPanel.setLayout(null);
		
		//title
		title.setFont(font);
		title.setLocation(370, 10);
		title.setSize(130, 130);
		
		
		//"아이디"
		idLabel.setLocation(322, 100);
		idLabel.setSize(100, 30);
		//"아이디_입력창"
		idInput.setLocation(400, 102);
		idInput.setSize(150, 25);
		
		
		//"인중결과"
		chkResult.setLocation(435, 125);
		chkResult.setSize(100, 30);
		
		
		//"인증버튼"
		idBtn.setLocation(570, 98);
		idBtn.setSize(70, 30);
		
		//"비밀번호"
		newPassLabel.setLocation(270, 150);
		newPassLabel.setSize(100, 30);
		//"비밀번호_입력창"
		newPassInput.setLocation(400, 155);
		newPassInput.setSize(150, 25);
		
		
		//"새 비밀번호 확인"
		newPassChkLabel.setLocation(270, 185);
		newPassChkLabel.setSize(110, 50);
		
		
		//"새 비밀번호 확인_입력창"
		
		newPassChkInput.setLocation(400	,195 );
		newPassChkInput.setSize(150, 25);
		
		
		//"취소"버튼
		cancelBtn.setLocation(400, 240);
		cancelBtn.setSize(70, 30);
		
		
		
		//"변경"버튼
		changeBtn.setLocation(480, 240);
		changeBtn.setSize(70, 30);
		
		//"제목"
		mainPanel.add(title);
		
		//"아이디"
		mainPanel.add(idLabel);
		mainPanel.add(idInput);
		mainPanel.add(chkResult);
		mainPanel.add(idBtn);
		
		mainPanel.add(newPassLabel);
		mainPanel.add(newPassInput);
		
		mainPanel.add(newPassChkLabel);
		mainPanel.add(newPassChkInput);
		
		mainPanel.add(cancelBtn);
		mainPanel.add(changeBtn);
		
		
		
		this.add(mainPanel);
		this.setTitle("비밀번호 찾기");//JFrame 제목 지정.
		this.setBounds(200, 200, 900, 500);//JFrame 위치, 크기 지정.
		this.setVisible(true);//JFrame을 화면에 보일 여부 결정.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//"x"버튼 클릭시 실행종료.
		
		
		//리스너 등록
		idBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		changeBtn.addActionListener(this);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// inputChkId = idInput
		String empno1 = idInput.getText();
		if(e.getSource() == idBtn) {
			ArrayList<EmployeeDTO> elist2 = empdao.selectAll();
			for(EmployeeDTO ee : elist2) {
				String empno = ee.getEmpno();
				if(empno1.equals(empno)) {
					chkResult.setText("인증 성공!");
					chkResult.setForeground(Color.green);
					break;
				}else if(!empno1.equals(empno)) {
					chkResult.setText("인증 실패!");
					chkResult.setForeground(Color.red);
				}
			}
		}
		
		
		if(e.getSource() == cancelBtn) {
			this.dispose();
			new LoginFrame();
		}
		
		if(e.getSource() == changeBtn) {
			String inputPassword = "";
			char[] pass = newPassInput.getPassword();
			String a = new String(pass);
			for(char b : pass) {
				Character.toString(b);
				inputPassword += (a.equals("")) ? "" + b + "" : "" + b + "";
			}
			String inputPassword2 = "";
			char[] pass2 = newPassChkInput.getPassword();
			String c = new String(pass2);
			for(char d : pass2) {
				Character.toString(d);
				inputPassword2 += (c.equals("")) ? "" + d + "" : "" + d + "";
			}
			
			
			if(inputPassword.equals(inputPassword2)) {
				System.out.println("비밀번호 일치");
				empdao.update(empno1, inputPassword);
				System.out.println("비밀번호 update 완료.");
			}else {
				System.out.println("비밀번호 불일치");
			}
			this.dispose();
			new LoginFrame();
			
			
			
		}
		
		
	}
}
