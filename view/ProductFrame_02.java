package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.table.DefaultTableModel;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductFrame_02 extends JFrame implements ActionListener{
	ProductDAO pdao = new ProductDAO();
	LoginFrame loginInfo = new LoginFrame();
	
	//맨 아레 복쪽.
	private JPanel mainNorthPanel = new JPanel();
	//맨 아레 중앙.
	private JPanel mainCenterPanel = new JPanel();
	
	//맨 아레 중앙 왼쪽.
	private JPanel mainCenterWPanel = new JPanel();
	//맨 아레 중앙 왼쪽 복쪽.
	private JPanel mainCenterWNPanel = new JPanel();
	//맨 아레 중앙 왼쪽 중앙.
	private JPanel mainCenterWCPanel = new JPanel();
	
	//맨 아레 중앙 중앙.
	private JPanel mainCenterCPanel = new JPanel();
	//맨 아레 중앙 중앙 북쪽.
	private JPanel mainCenterCNPanel = new JPanel();
	
	
	private JPanel container2_north = new JPanel();
	private JPanel container2_center = new JPanel();
	
	
	private JLabel westNorthLabel = new JLabel("Information");
	private JLabel mainNorthEastLabel = new JLabel();
	private JLabel mainNorthWestLabel = new JLabel("여기는 JTabbar의 위치입니다.");
	private JLabel mainCWLabel = new JLabel("JTree가 있을 위치");
	
	private JLabel categoryLabel2 = new JLabel("카테고리");
//	private JTextField categoryInput = new JTextField(10);
	private JLabel searchLabel = new JLabel("검색어");
	private JTextField searchInput = new JTextField(10);
	private JButton searchBtn = new JButton("검색");
	private JButton changeBtn = new JButton("변경");
	private JButton deleteBtn = new JButton("삭제");
	
	private JLabel table = new JLabel("JTable_panel의 위치입니다.");
	private JPanel tablePanel = new JPanel();//JTable를 만든 뒤 이 panel위에 올립니다.
	private String[] productInfo = {"제품번호", "제품명", "제고수량", "입고날짜", "제품가격", "카테고리"};
	
	private String[] category1 = {"생활가전", "주방가전", "계절가전", "통신용품", "PC 용품"};
	
	private JComboBox<String> combobox1 = new JComboBox<String>(category1);
	private JComboBox<String> combobox2 = new JComboBox<String>(category1);
	
	private JPanel mainPanel = new JPanel(); 
	private JPanel mainCenterPanel2 = new JPanel();
	private JPanel mainSouthPanel = new JPanel();
	
	private JPanel firstLPanel = new JPanel();
	private JPanel firstRPanel = new JPanel();
	private JPanel secondLPanel = new JPanel();
	private JPanel secondRPanel = new JPanel();
	private JPanel thirdLPanel = new JPanel();
	private JPanel thirdRPanel = new JPanel();
	private JPanel fourthLPanel = new JPanel();
	private JPanel fourthRPanel = new JPanel();
	
	private JLabel pNumLabel = new JLabel("제품번호");
	private JLabel categoryLabel = new JLabel("카테고리");
	private JLabel pNameLabel = new JLabel("제품명");
	private JLabel priceLabel = new JLabel("가격");
	private JLabel stockLabel = new JLabel("제고수량");
	private JLabel makerLabel = new JLabel("제조사");
	private JLabel indateLabel = new JLabel("입고날짜");
	
	private JTextField pNumInput = new JTextField(10);
	private JTextField pNameInput = new JTextField(10);
	private JTextField priceInput = new JTextField(10);
	private JTextField stockInput = new JTextField(10);
	private JTextField makerInput = new JTextField(10);
	private JTextField indateInput = new JTextField(10);
	
	private JTable dataTable = new JTable();
	private JTable dataTable2 = new JTable();
	private DefaultTableModel model2 = null;
	private String[] colNames = {"제품번호", "제품명", "입고날짜", "카테고리", "제고수량","제조사","가격"};
	private String[][] data = new String[50][7];
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JScrollPane sp = null;
	private JScrollPane sp2 = null;
	private Dimension d = null;

	private JButton addBtn = new JButton("등록");
	private JButton cancelBtn = new JButton("취소");
	
	
	private String empName = null;
	private String nowDeptName = null;
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getNowDeptName() {
		return nowDeptName;
	}

	public void setNowDeptName(String nowDeptName) {
		this.nowDeptName = nowDeptName;
	}

	public void ProductFrame_02() {
		this.setLayout(new BorderLayout());
		mainNorthPanel.setLayout(new BorderLayout());
		mainCenterPanel.setLayout(new BorderLayout());
		mainCenterWPanel.setLayout(new BorderLayout());
		mainCenterCPanel.setLayout(new BorderLayout());
//		mainCenterCCCPanel.setLayout(new BorderLayout());
		
//		mainNorthPanel.setBackground(Color.red);
		mainCenterPanel.setBackground(Color.cyan);
//		mainCenterWPanel.setBackground(Color.yellow);
//		mainCenterWNPanel.setBackground(Color.black);
//		mainCenterWCPanel.setBackground(Color.darkGray);
//		mainCenterCPanel.setBackground(Color.green);
//		mainCenterPanel2.setBackground(Color.red);
		mainSouthPanel.setBackground(Color.green);
//		container2_center.setBackground(Color.blue);
		
		
		mainCenterWNPanel.add(westNorthLabel);
		mainCenterWCPanel.add(mainCWLabel);
		mainNorthPanel.add(mainNorthWestLabel,"West");
		mainNorthPanel.add(mainNorthEastLabel,"East");
		mainCenterPanel.add(mainCenterWPanel,"West");
		mainCenterWPanel.add(mainCenterWNPanel,"North");
		mainCenterWPanel.add(mainCenterWCPanel,"Center");
		mainCenterPanel.add(mainCenterCPanel,"Center");
		mainCenterCPanel.add(mainCenterCNPanel,"North");
// -----------------------------------------------------------------------------		
		//탭 생성 ---> 컨테이너 생성 ---> 컴포넌트 생성 ---> 컴포넌트를 컨테이너에 추가.
		JTabbedPane tab = new JTabbedPane();
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		//container1 --- 제품등록
		//카테고리 : combobox
		//제품번호 : productNum
		//제품명 : productName
		//가격 : price
		//제고수량 : stock
		//제조사 : maker
		//입고날짜 : indate
		mainPanel.setLayout(new BorderLayout());
		//아레 패널
		
		mainPanel.add(mainCenterPanel2,"Center");
		mainPanel.add(mainSouthPanel,"South");
		
		firstLPanel.setLayout(new FlowLayout());
		firstRPanel.setLayout(new FlowLayout());
		secondLPanel.setLayout(new FlowLayout());
		secondRPanel.setLayout(new FlowLayout());
		thirdLPanel.setLayout(new FlowLayout());
		thirdRPanel.setLayout(new FlowLayout());
		fourthLPanel.setLayout(new FlowLayout());
		fourthRPanel.setLayout(new FlowLayout());
		
//		카테고리
		fourthLPanel.add(categoryLabel2);
		fourthRPanel.add(combobox1);
//		제품번호
		firstLPanel.add(pNumLabel);
		firstLPanel.add(pNumInput);
//		제품명
		firstRPanel.add(pNameLabel);
		firstRPanel.add(pNameInput);
//		가격
		secondLPanel.add(priceLabel);
		secondLPanel.add(priceInput);
//		제고수량
		secondRPanel.add(stockLabel);
		secondRPanel.add(stockInput);
//		제조사
		thirdLPanel.add(makerLabel);
		thirdLPanel.add(makerInput);
//		입고날짜
		thirdRPanel.add(indateLabel);
		thirdRPanel.add(indateInput);
		
		mainCenterPanel2.setLayout(new GridLayout(5, 2));
		//카테고리 Label
		mainCenterPanel2.add(fourthLPanel);
		//카테고리 창
		mainCenterPanel2.add(fourthRPanel);
		//제품번호
		mainCenterPanel2.add(firstLPanel);
		//제품명
		mainCenterPanel2.add(firstRPanel);
		//가격
		mainCenterPanel2.add(secondLPanel);
		//제고수량
		mainCenterPanel2.add(secondRPanel);
		//제조가
		mainCenterPanel2.add(thirdLPanel);
		//입고날짜
		mainCenterPanel2.add(thirdRPanel);
		//"등록" 버튼
		mainCenterPanel2.add(addBtn);
		//"취소"버튼
		mainCenterPanel2.add(cancelBtn);
	

		container1.add(mainPanel);
		
		//container2 --- 제품조회/변경
		container2.setLayout(new BorderLayout());
		container2_north.add(categoryLabel);
		container2_north.add(combobox2);
		container2_north.add(searchLabel);
		container2_north.add(searchInput);
		container2_north.add(searchBtn);
		container2_north.add(changeBtn);
		container2_north.add(deleteBtn);
		container2.add(container2_north,"North");
		
		//JTable 삽입 부분. table ---> tablePanel
		container2_center.setLayout(new BorderLayout());
		container2_center.add(panel3);
		container2.add(container2_center,"Center");
		
		//탭 이름 지정.
		tab.add("제고등록",container1);
		tab.add("제고조회/변경",container2);
		
		mainCenterCPanel.add(tab);
		mainSouthPanel.add(panel4);
// -----------------------------------------------------------------------------	
		model2 = new DefaultTableModel(colNames,0);
		dataTable = new JTable(model2);
		dataTable2 = new JTable(model2);
		sp = new JScrollPane(dataTable);//table를 JScrollPane에 붙이는 코드.
		sp2 = new JScrollPane(dataTable2);//table를 JScrollPane에 붙이는 코드.
		sp.setBackground(Color.cyan);
		dataTable.setFillsViewportHeight(true);
		d = dataTable.getPreferredSize();
		d.width = 800;
		d.height = 650;
		sp.setPreferredSize(d);//JScrollPane 사이즈 지정.
		panel3.add(sp);
		panel4.add(sp2);
// -----------------------------------------------------------------------------	
//		list에 데이터 추가.
		String[] rowData;
		ArrayList<ProductDTO> plist = pdao.selectAll();
		for(ProductDTO i : plist) {
			rowData = new String[] {i.getPnum(),i.getPname(), i.getIndate(), i.getCategory(), Integer.toString(i.getStock()), i.getMaker(), Integer.toString(i.getPrice())};
			model2.addRow(rowData);
		}
		
// -----------------------------------------------------------------------------
		
		System.out.println("사원ID : " + getEmpName());
		mainNorthEastLabel.setText(getNowDeptName() + " " + getEmpName()+" 사용중. ");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//JFrame
		this.add(mainNorthPanel,"North");
		this.add(mainCenterPanel,"Center");
		this.setTitle("제품관리창_관리자");
		this.setBounds(50, 100, 1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//리스너 등록
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		combobox1.addActionListener(this);//combobox actionListener
		combobox2.addActionListener(this);//combobox actionListener
		searchBtn.addActionListener(this);//검색 버튼 actionListener
		changeBtn.addActionListener(this);//변경 버튼 actionListener
		deleteBtn.addActionListener(this);//삭제 버튼 actionListener
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selected = combobox2.getSelectedItem().toString();
		if(e.getSource() == searchBtn) {
			String input = searchInput.getText();
			System.out.println("입력한 내용 : " + input + " / " + selected);
		}
		if(e.getSource() == changeBtn) {
			String input = searchInput.getText();
			System.out.println("변경할 내용 : " + input);
		}
		if(e.getSource() == deleteBtn) {
			String input = searchInput.getText();
			System.out.println("삭제할 내용 : " + input);
		}
		if(e.getSource() == addBtn) {
			String category = combobox1.getSelectedItem().toString();
			String pNum = pNumInput.getText();
			String pName = pNameInput.getText();
			int price = Integer.parseInt(priceInput.getText());
			int stock = Integer.parseInt(stockInput.getText());
			String maker = makerInput.getText();
			String indate = indateInput.getText();// 메소드 호출해서 현재 날짜 기져오기.
			
			System.out.println(pNum + " / " + pName + " / " + price + " / " + stock + " / " + maker + " / " + indate);
			
			ProductDTO pdto = new ProductDTO();
			pdto.setCategory(category);
			pdto.setPnum(pNum);
			pdto.setPname(pName);
			pdto.setPrice(price);
			pdto.setStock(stock);
			pdto.setMaker(maker);
			pdto.setIndate(indate);
			pdto.toString();
			String pnum = "제고0006"; // 메소드 호출해서 받아올값.
			pdao.insert(pdto,pnum);
			//새로운 값이 제품이 등록될때 마다 list를 새로고침 하는 코드. ---> 화면 껐다 다시 실행.
			this.dispose();
			new ProductFrame_02();
		}
		if(e.getSource() == cancelBtn) {
			this.dispose();
		}
	}
}
