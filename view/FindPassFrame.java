package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class FindPassFrame extends JFrame implements ActionListener{
	EmployeeDAO empdao = new EmployeeDAO();
	
	private JPanel mainCenterPanel = new JPanel();
	private JPanel mainSouthPanel = new JPanel();
	private JPanel firstPanel = new JPanel();
	private JPanel secondPanel = new JPanel();
	private JPanel thirdPanel = new JPanel();
	private JPanel fourthPanel = new JPanel();
	private JPanel firstRPanel = new JPanel();
	
	private JButton checkBtn = new JButton("인증");
	private JButton cancelBtn = new JButton("취소");
	private JButton changeBtn = new JButton("변경");
	
	private JLabel checkIdLabel = new JLabel("아이디를 입력하세요.");
	private JLabel checkResult = new JLabel("결과");//결과
	private JLabel newPassLabel = new JLabel("새 비밀번호 입력");
	private JLabel chkNewPassLabel = new JLabel("새 비밀번호 확인");
	
	private JTextField inputChkId = new JTextField(10);
	private JTextField inputNewPass = new JTextField(10);
	private JTextField inputChkPass = new JTextField(10);
	
	public FindPassFrame(){
		this.setLayout(new BorderLayout());
		mainCenterPanel.setLayout(new GridLayout(4, 0));
		
		firstPanel.setLayout(new GridLayout(0, 2));
		firstRPanel.setLayout(new GridLayout(0, 2));
		firstPanel.add(checkIdLabel);
		firstRPanel.add(inputChkId);
		firstRPanel.add(checkBtn);
		firstPanel.add(firstRPanel);
		
		secondPanel.setLayout(new GridLayout(0,1));
		secondPanel.add(checkResult);
		
		thirdPanel.setLayout(new GridLayout(0, 2));
		thirdPanel.add(newPassLabel);
		thirdPanel.add(inputNewPass);
		
		fourthPanel.setLayout(new GridLayout(0, 2));
		fourthPanel.add(chkNewPassLabel);
		fourthPanel.add(inputChkPass);
		
		mainCenterPanel.add(firstPanel);
		mainCenterPanel.add(secondPanel);
		mainCenterPanel.add(thirdPanel);
		mainCenterPanel.add(fourthPanel);
		
		mainSouthPanel.setLayout(new GridLayout(0, 2));
		mainSouthPanel.add(cancelBtn);
		mainSouthPanel.add(changeBtn);
		
		checkBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		changeBtn.addActionListener(this);
		
		this.add(mainCenterPanel,"Center");
		this.add(mainSouthPanel,"South");
		this.setTitle("비밀번호 찾기");
		this.setBounds(200, 200, 900, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String empno1 = inputChkId.getText();
		System.out.println("*** : "+empno1);
		if(e.getSource() == checkBtn) {
			//모든 튜플을 가져온다.
			//입력받는 사원번호랑 같은 사원번호값을 가지고 있는 튜플이 있는지 판단한다.
			ArrayList<EmployeeDTO> elist2 = empdao.selectAll();
//			empno1 = inputChkId.getText();
			for(EmployeeDTO ee : elist2) {
				String empno = ee.getEmpno();
				if(empno1.equals(empno)) {
					checkResult.setText("인증 되었습니다.");
					checkResult.setForeground(Color.green);
					break;
				}else if(!empno1.equals(empno)){
					checkResult.setText("인증 실패하였습니다.");
					checkResult.setForeground(Color.red);
				}
			}
		}
		
		if(e.getSource() == cancelBtn) {
			System.out.println("취소");
			this.dispose();
		}
		
		if(e.getSource() == changeBtn) {
			//새 비밀번호 입력.
			String inputPassword = inputNewPass.getText();
			//새 비밀번호 확인.
			String inputPassword2 = inputChkPass.getText();
			if(inputPassword.equals(inputPassword2)) {
				System.out.println("비밀번호 일치");
				//여기서 DB에 있는 값을 update합니다.
				//EmployeeDAO.update(empno, inputPassword)
				empdao.update(empno1, inputPassword);
				System.out.println("비밀번호 update 완료.");
			}else {
				System.out.println("비밀번호 불일치");
			}
		}
	}
}
