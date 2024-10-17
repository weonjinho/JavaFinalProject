package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ProductFrame extends JFrame{
	private JPanel mainNorthPanel = new JPanel();
	private JPanel mainCenterPanel = new JPanel();
	private JPanel mainCenterWPanel = new JPanel();
	private JPanel mainCenterWNPanel = new JPanel();
	private JPanel mainCenterWCPanel = new JPanel();
	private JPanel mainCenterCPanel = new JPanel();
	private JPanel mainCenterCNPanel = new JPanel();
	private JPanel mainCenterCCPanel = new JPanel();
	private JPanel mainCenterCCNPanel = new JPanel();//검색창
	private JPanel mainCenterCCCPanel = new JPanel();//JTable
	
	
	private JLabel westNorthLabel = new JLabel("Information");
	private JLabel mainNorthEastLabel = new JLabel("xxx부서 xxx로그인중.");
	private JLabel mainNorthWestLabel = new JLabel("여기는 JTabbar의 위치입니다.");
	private JLabel mainCWLabel = new JLabel("JTree가 있을 위치");
	private JLabel mainCCNlabel = new JLabel("JTabbedPanel가 있을 위치_mainCenterCenterNorth");
//	private JLabel mainCCCLabel = new JLabel("여기는 검색창 & JTable의 위치입니다.");
	
	private JLabel categoryLabel = new JLabel("카테고리");
	private JTextField categoryInput = new JTextField(10);
	private JLabel searchLabel = new JLabel("검색어");
	private JTextField searchInput = new JTextField(10);
	private JButton searchBtn = new JButton("검색");
	private JButton changeBtn = new JButton("변경");
	private JButton deleteBtn = new JButton("삭제_mainCenterCenterPanel");
	
	
	
	
	
	
	
	public ProductFrame() {
		this.setLayout(new BorderLayout());
		mainNorthPanel.setLayout(new BorderLayout());
		mainCenterPanel.setLayout(new BorderLayout());
		mainCenterWPanel.setLayout(new BorderLayout());
		mainCenterCPanel.setLayout(new BorderLayout());
		mainCenterCCPanel.setLayout(new BorderLayout());
		mainCenterCCNPanel.setLayout(new FlowLayout());
		
		mainCenterCCCPanel.setLayout(new BorderLayout());
		
//		mainNorthPanel.setBackground(Color.red);
		mainCenterPanel.setBackground(Color.cyan);
//		mainCenterWPanel.setBackground(Color.yellow);
//		mainCenterWNPanel.setBackground(Color.black);
//		mainCenterWCPanel.setBackground(Color.darkGray);
		mainCenterCPanel.setBackground(Color.green);
//		mainCenterCNPanel.setBackground(Color.MAGENTA);
		mainCenterCCPanel.setBackground(Color.PINK);
		mainCenterCCNPanel.setBackground(Color.yellow);
		mainCenterCCCPanel.setBackground(Color.green);
		
		
		JTabbedPane jtp = new JTabbedPane();
		mainCenterCCCPanel.add(jtp, BorderLayout.CENTER);
		
		JPanel jpanel1 = new JPanel(new GridLayout(2, 3));
		jtp.add("제고등록",jpanel1);
		jpanel1.add(new JButton("White"));
		jpanel1.add(new JButton("Green"));
		jpanel1.add(new JButton("Red"));
		jpanel1.add(new JButton("Yellow"));
		jpanel1.add(new JButton("Black"));
		
		JPanel jpanel2 = new JPanel(new GridLayout(3, 2));
		jtp.add("제고조회/변경_mainCenterCenterCenterCenterPanel",jpanel2);
		jpanel2.add(new JButton("White"));
		jpanel2.add(new JButton("Green"));
		jpanel2.add(new JButton("Red"));
		jpanel2.add(new JButton("Yellow"));
		jpanel2.add(new JButton("Black"));
		
		
		mainCenterWNPanel.add(westNorthLabel);
		mainCenterWCPanel.add(mainCWLabel);
		mainNorthPanel.add(mainNorthWestLabel,"West");
		mainNorthPanel.add(mainNorthEastLabel,"East");
		mainCenterPanel.add(mainCenterWPanel,"West");
		mainCenterWPanel.add(mainCenterWNPanel,"North");
		mainCenterWPanel.add(mainCenterWCPanel,"Center");
		mainCenterPanel.add(mainCenterCPanel,"Center");
		mainCenterCPanel.add(mainCenterCNPanel,"North");
		mainCenterCPanel.add(mainCenterCCPanel,"Center");
		mainCenterCNPanel.add(mainCCNlabel);
		mainCenterCCPanel.add(mainCenterCCNPanel,"North");
		mainCenterCCPanel.add(mainCenterCCCPanel,"Center");
		mainCenterCCNPanel.add(categoryLabel);
		mainCenterCCNPanel.add(categoryInput);
		mainCenterCCNPanel.add(searchLabel);
		mainCenterCCNPanel.add(searchInput);
		mainCenterCCNPanel.add(searchBtn);
		mainCenterCCNPanel.add(changeBtn);
		mainCenterCCNPanel.add(deleteBtn);
		mainCenterPanel.add(mainCenterCPanel,"Center");
		
//		mainCenterCCCPanel.add(locationPointer);
		
		
		
		
		this.add(mainNorthPanel,"North");
		this.add(mainCenterPanel,"Center");
		this.setTitle("제품관리 창");
		this.setBounds(50, 100, 1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
