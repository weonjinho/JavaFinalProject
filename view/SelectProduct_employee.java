package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

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
	
	private String nowUserName2 = null;
	public String getNowUserName2() {
		return nowUserName2;
	}

	public void setNowUserName2(String nowUserName2) {
		this.nowUserName2 = nowUserName2;
	}

	private String nowUserDeptName2 = null;
	public String getNowUserDeptName2() {
		return nowUserDeptName2;
	}

	public void setNowUserDeptName2(String nowUserDeptName2) {
		this.nowUserDeptName2 = nowUserDeptName2;
	}

	//JLabel
	private JLabel mainNWLabel = new JLabel("제고관리 시스탬_일반사원");
	private JLabel mainNELabel = new JLabel("xxx부서 xxx로그인 중.");
	private JLabel mainCWNLabel = new JLabel("Information");
	private JLabel jTreeLabel = new JLabel();
	
	private DefaultMutableTreeNode productMge = new DefaultMutableTreeNode("제고관리");
	private DefaultMutableTreeNode addProduct = new DefaultMutableTreeNode("제고등록");
	private DefaultMutableTreeNode productInfotree  = new DefaultMutableTreeNode("제고조회/변경");
	
	
	
	
	private JLabel categoryLabel = new JLabel("카테고리");
	//카테고리, 제품명, 제품번호 
	private JLabel pNameSearchLabel = new JLabel("제품명");
	private JLabel pNumSearchLabel = new JLabel("제품번호 * ");
	
	
	//JCombobox
	private String[] category = {"생활가전", "주방가전", "계절가전", "통신용품", "PC 용품"};
	private JComboBox<String> categoryList = new JComboBox<String>(category);
	
	//JTextField
	private JTextField searchInput = new JTextField(10);
	private JTextField pNumSearchInput = new JTextField(10);
	private JTextField pNameSearchInput = new JTextField(10);
	
	//JButton
	private JButton searchBtn = new JButton("조회");
	
	
	//JTable
	private JTable dataTable = new JTable();
	private DefaultTableModel model2 = null;
	private String[] colNames = {"제품번호", "제품명", "입고날짜", "카테고리", "제고수량","제조사","가격"};
	private String[][] data = new String[50][7];
	private JPanel panel3 = new JPanel();
	private JScrollPane sp = null;
	private Dimension d = null;
	
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
		mainNELabel.setText(nowUserDeptName2 + " " + nowUserName2 + "사용중. ");
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
//		container1.add(mainTabPanel);
		container1.add(containerNPanel,"North");
		container1.add(containerCPanel,"Center");
		
		//containerNPanel
		containerNPanel.add(categoryLabel);
		containerNPanel.add(categoryList);
		containerNPanel.add(pNumSearchLabel);
		containerNPanel.add(pNumSearchInput);
		containerNPanel.add(pNameSearchLabel);
		containerNPanel.add(pNameSearchInput);
		containerNPanel.add(searchBtn);
		
		
		//mainCenterCPanel
		mainCenterCPanel.setLayout(new BorderLayout()); //tab창이 축소되는 원인.
		mainCenterCPanel.add(tab);
		
//----------------------------------------------------------------------------------	
		model2 = new DefaultTableModel(colNames,0);
		dataTable = new JTable(model2);
		sp = new JScrollPane(dataTable);//table를 JScrollPane에 붙이는 코드.
		sp.setBackground(Color.cyan);
		dataTable.setFillsViewportHeight(true);
		d = dataTable.getPreferredSize();
		d.width = 800;
		d.height = 650;
		sp.setPreferredSize(d);//JScrollPane 사이즈 지정.
		panel3.add(sp);
		
		containerCPanel.add(panel3);
//----------------------------------------------------------------------------------		
//		list에 데이터 추가.
		String[] rowData;
		ArrayList<ProductDTO> plist = pdao.selectAll();
		for(ProductDTO i : plist) {
			rowData = new String[] {i.getPnum(),i.getPname(), i.getIndate(), i.getCategory(), Integer.toString(i.getStock()), i.getMaker(), Integer.toString(i.getPrice())};
			model2.addRow(rowData);
		}
		
		productMge.add(addProduct);
		productMge.add(productInfotree);
		JTree jt = new JTree(productMge);
		mainCenterWCPanel.add(jt);
		
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
			ProductDTO plists = new ProductDTO();
			plists = pdao.selectOne(inputPNum);
			String pnum = plists.getPnum();//제품번호
			String pcategory = plists.getCategory();//카테고리
			String pname = plists.getPname();//제품명
			int price = plists.getPrice();//가격
			int stock = plists.getStock();//제고수량
			String maker = plists.getMaker();//제조사
			//"조회"하면 list에 출력할 내용.
			System.out.println("가져온 제품의 정보 : " + pnum + " " + pcategory + " " + pname + " " + price + " " + stock + " " + maker);
			ProductDTO plist = new ProductDTO();
			plist.setCategory(selected);
			plist.setPname(inputPName);
			plist.setPnum(inputPNum);
			ProductDTO pp =  pdao.selectOne2(plist);
			pp.toString();
		}
		
	}
}
