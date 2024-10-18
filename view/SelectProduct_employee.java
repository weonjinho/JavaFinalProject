package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dao.ProductDAO;
import dto.ProductDTO;

public class SelectProduct_employee extends JFrame implements ActionListener{
	ProductDAO pdao = new ProductDAO();
	//JPanel
	private JPanel mainNorthPanel = new JPanel();
	private JPanel mainCenterPanel = new JPanel();
	private JPanel mainNWPanel = new JPanel();
	private JPanel mainNEPanel = new JPanel(); 
	private JPanel mainCenterWPanel = new JPanel();
	private JPanel mainCenterCPanel = new JPanel();
	private JPanel mainCenterWNPanel = new JPanel();
	private JPanel mainCenterWCPanel = new JPanel();
	private JPanel container1 = new JPanel();//"제고조회" 탭
	private JPanel containerNPanel = new JPanel();
	private JPanel containerCPanel = new JPanel();
	private JPanel mainTabPanel = new JPanel();
	
	//JLabel
	private JLabel mainNWLabel = new JLabel("JTabbar 위치");
	private JLabel mainNELabel = new JLabel("xxx부서 xxx로그인 중.");
	private JLabel mainCWNLabel = new JLabel("Information");
	private JLabel jTreeLabel = new JLabel("JTree 위치");
	private JLabel categoryLabel = new JLabel("카테고리");
	//카테고리, 제품명, 제품번호 
	private JLabel pNameSearchLabel = new JLabel("제품번호");
	private JLabel pNumSearchLabel = new JLabel("제품명");
	
	
	//JCombobox
	private String[] category = {"생활가전", "주방가전", "계절가전", "통신용품", "PC 용품"};
	private JComboBox<String> categoryList = new JComboBox<String>(category);
	
	//JTextField
	private JTextField searchInput = new JTextField(10);
	private JTextField pNameSearchInput = new JTextField(10);
	private JTextField pNumSearchInput = new JTextField(10);
	
	//JButton
	private JButton searchBtn = new JButton("조회");
	
	//JTree
	
	//JTabbedPane
	private JTabbedPane tab = new JTabbedPane();
	
	public SelectProduct_employee() {
		//배경색
//		mainNorthPanel.setBackground(Color.green);
//		mainCenterPanel.setBackground(Color.yellow);
//		mainNWPanel.setBackground(Color.gray);
//		mainNEPanel.setBackground(Color.red);
//		mainCenterWPanel.setBackground(Color.magenta);
//		mainCenterCPanel.setBackground(Color.blue);
//		mainCenterWNPanel.setBackground(Color.red);
//		mainCenterWCPanel.setBackground(Color.yellow);
//		containerNPanel.setBackground(Color.red);
//		containerCPanel.setBackground(Color.green);
		
		//mainNorthPanel
		mainNorthPanel.setLayout(new BorderLayout());
		mainNorthPanel.add(mainNWPanel,"West");
		mainNorthPanel.add(mainNEPanel,"East");
		//mainNWPanel
		mainNWPanel.add(mainNWLabel);
		//mainNEPanel
		mainNEPanel.add(mainNELabel);
		
		
		//mainCenterPanel
		mainCenterPanel.setLayout(new BorderLayout());
		mainCenterPanel.add(mainCenterWPanel,"West");
		mainCenterPanel.add(mainCenterCPanel,"Center");
		
		//mainCenterWPanel
		mainCenterWPanel.setLayout(new BorderLayout());
		mainCenterWPanel.add(mainCenterWNPanel,"North");
		mainCenterWPanel.add(mainCenterWCPanel,"Center");
		//mainCenterWNPanel
		mainCenterWNPanel.add(mainCWNLabel);
		//mainCenterWCPanel
		mainCenterWCPanel.add(jTreeLabel);
		
		//JTabbedPane
		tab.add("제고조회",container1);
		
		//container1
		container1.setLayout(new BorderLayout());
		container1.add(mainTabPanel);
		container1.add(containerNPanel,"North");
		container1.add(containerCPanel,"Center");
		
		
		//containerNPanel
		containerNPanel.add(categoryLabel);
		containerNPanel.add(categoryList);
		containerNPanel.add(pNameSearchLabel);
		containerNPanel.add(pNameSearchInput);
		containerNPanel.add(pNumSearchLabel);
		containerNPanel.add(pNumSearchInput);
		containerNPanel.add(searchBtn);
		
		
		//mainCenterCPanel
		mainCenterCPanel.setLayout(new BorderLayout()); //tab창이 축소되는 원인.
		mainCenterCPanel.add(tab);
		
		
		//JFrame
		this.add(mainNorthPanel,"North");
		this.add(mainCenterPanel,"Center");
		this.setTitle("제고관리창_사원");
		this.setBounds(50, 100, 1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//리스터 등록
		searchBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selected = categoryList.getSelectedItem().toString();
		String inputPName = pNameSearchInput.getText();
		String inputPNum = pNumSearchInput.getText();
		if(e.getSource() == searchBtn) {
			System.out.println("111");
			System.out.println(selected + " / " + inputPName + " / " + inputPNum);
			ProductDTO plist = new ProductDTO();
			plist.setCategory(selected);
			plist.setPname(inputPName);
			plist.setPnum(inputPNum);
			ProductDTO pp =  pdao.selectOne(plist);
			pp.toString();
//			ProductDTO pp= pdao.selectOne(plist);
//			System.out.println(pp.toString());
		}
		//ProductDAO.selectOne() 메소드로 필요한 튜플의 정보를 모두 가져온다. 
		
	}
}
