package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loginForm_test extends JFrame{
	private JPanel northPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JLabel northTitle = new JLabel("사용자 로그인");
	private JPanel centerInfoPanel = new JPanel();
	
	private JPanel firstLinePanel  = new JPanel();
	private JPanel secondLinePanel = new JPanel();
	private JPanel thirdLinePanel = new JPanel();
	private JPanel fourthLinePanel = new JPanel();
	private JPanel fifthLinePanle = new JPanel();
	
	private JLabel userLabel = new JLabel("사용자명 : ");
	private JTextField userInput = new JTextField(10);
	private JCheckBox userChk = new JCheckBox("사용자저장");
	
	private JLabel passLabel = new JLabel("비밀번호 : ");
	private JTextField passInput = new JTextField(10);
	private JButton loginBtn = new JButton("로그인");
	
	private JLabel showUserPass = new JLabel("사용자명:관리자/비밀번호:123");
	private JLabel lastUser = new JLabel("마자막 사용자 : 관리자");
	private JLabel lastUseTime = new JLabel("마지막 활동시간 : 1시 25분 14초");
	
	private JButton joinBtn = new JButton("신규등록");
	private JButton cancelBtn = new JButton("취소");
	public loginForm_test() {
		this.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		southPanel.setLayout(new BorderLayout());
		
		southPanel.add(joinBtn,"West");
		southPanel.add(cancelBtn,"East");
//		northPanel.setBackground(Color.yellow);
		centerPanel.setBackground(Color.green);
//		southPanel.setBackground(Color.blue);
		centerInfoPanel.setBackground(Color.white);
		
		firstLinePanel.setLayout(new FlowLayout());
		secondLinePanel.setLayout(new FlowLayout());
		thirdLinePanel.setLayout(new FlowLayout());
		fourthLinePanel.setLayout(new FlowLayout());
		fifthLinePanle.setLayout(new FlowLayout());
		
		firstLinePanel.add(userLabel);
		firstLinePanel.add(userInput);
		firstLinePanel.add(userChk);
		
		secondLinePanel.add(passLabel);
		secondLinePanel.add(passInput);
		secondLinePanel.add(loginBtn);
		
		thirdLinePanel.add(showUserPass);
		fourthLinePanel.add(lastUser);
		fifthLinePanle.add(lastUseTime);
		
		
		
		centerInfoPanel.setLayout(new GridLayout(5, 0));
		centerInfoPanel.add(firstLinePanel);
		centerInfoPanel.add(secondLinePanel);
		centerInfoPanel.add(thirdLinePanel);
		centerInfoPanel.add(fourthLinePanel);
		centerInfoPanel.add(fifthLinePanle);
		
		
		northPanel.add(northTitle);
		centerPanel.add(centerInfoPanel);
		
		
		this.add(northPanel,"North");
		this.add(centerPanel,"Center");
		this.add(southPanel,"South");
		//JFrame
	
		this.setBounds(100, 100, 700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
