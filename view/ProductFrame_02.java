package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class ProductFrame_02 extends JFrame implements ActionListener{
	ProductDAO pdao = new ProductDAO();
	
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
	
	private JLabel westNorthLabel = new JLabel("Information");
	private JLabel mainNorthEastLabel = new JLabel("xxx부서 xxx로그인중.");
	private JLabel mainNorthWestLabel = new JLabel("여기는 JTabbar의 위치입니다.");
	private JLabel mainCWLabel = new JLabel("JTree가 있을 위치");
	
	private JLabel categoryLabel = new JLabel("카테고리");
//	private JTextField categoryInput = new JTextField(10);
	private JLabel searchLabel = new JLabel("검색어");
	private JTextField searchInput = new JTextField(10);
	private JButton searchBtn = new JButton("검색");
	private JButton changeBtn = new JButton("변경");
	private JButton deleteBtn = new JButton("삭제");
	
	private JLabel table = new JLabel("JTable_panel의 위치입니다.");
	
	private JPanel tablePanel = new JPanel();//JTable를 만든 뒤 이 panel위에 올립니다.
	
	private String[] productInfo = {"제품번호", "제품명", "제고수량", "입고날짜", "제품가격", "카테고리"};
	
	private String[] category = {"생활가전", "주방가전", "계절가전", "통신용품", "PC 용품"};
	
	private JComboBox<String> combobox = new JComboBox<String>(category);
	
	private JPanel mainPanel = new JPanel(); 
	private JPanel mainCenterPanel2 = new JPanel();
	private JPanel mainSouthPanel = new JPanel();
	
	private JPanel firstLPanel = new JPanel();
	private JPanel firstRPanel = new JPanel();
	private JPanel secondLPanel = new JPanel();
	private JPanel secondRPanel = new JPanel();
	private JPanel thirdLPanel = new JPanel();
	private JPanel thirdRPanel = new JPanel();
	
	private JLabel pNumLabel = new JLabel("제품번호");
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
	
	private JButton addBtn = new JButton("등록");
	private JButton cancelBtn = new JButton("취소");
	
	public ProductFrame_02() {
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
		
		mainCenterWNPanel.add(westNorthLabel);
		mainCenterWCPanel.add(mainCWLabel);
		mainNorthPanel.add(mainNorthWestLabel,"West");
		mainNorthPanel.add(mainNorthEastLabel,"East");
		mainCenterPanel.add(mainCenterWPanel,"West");
		mainCenterWPanel.add(mainCenterWNPanel,"North");
		mainCenterWPanel.add(mainCenterWCPanel,"Center");
		mainCenterPanel.add(mainCenterCPanel,"Center");
		mainCenterCPanel.add(mainCenterCNPanel,"North");
		
//		combobox
//		JComboBox<String> combobox = new JComboBox<String>(category);
// -----------------------------------------------------------------------------
//		JTable
//		Container contentPane = this.getContentPane();
//		String[] header = {"제품번호", "제품명", "제고수량", "입고날짜", "제품가격", "카테고리"};
//		String[][] contents = {
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//				{"aaa", "90","87","98", "90","87"},	
//		};
//		JTable table = new JTable(contents, header);
//		JScrollPane scrollPane = new JScrollPane(table);
//		contentPane.add(scrollPane,BorderLayout.CENTER);
//		tablePanel.add(contentPane);
//		
//		this.pack();
		
		
		
// -----------------------------------------------------------------------------		
		//탭 생성 ---> 컨테이너 생성 ---> 컴포넌트 생성 ---> 컴포넌트를 컨테이너에 추가.
		JTabbedPane tab = new JTabbedPane();
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		//container1 --- 제품등록
		//제품번호 : productNum
		//제품명 : productName
		//가격 : price
		//제고수량 : stock
		//제조사 : maker
		//입고날짜 : indate
		mainPanel.setLayout(new BorderLayout());
		mainCenterPanel2.setBackground(Color.blue);
		mainSouthPanel.setBackground(Color.green);
		
		mainPanel.add(mainCenterPanel2,"Center");
		mainPanel.add(mainSouthPanel,"South");
		
		firstLPanel.setLayout(new FlowLayout());
		firstRPanel.setLayout(new FlowLayout());
		secondLPanel.setLayout(new FlowLayout());
		secondRPanel.setLayout(new FlowLayout());
		thirdLPanel.setLayout(new FlowLayout());
		thirdRPanel.setLayout(new FlowLayout());
		
		firstLPanel.add(pNumLabel);
		firstLPanel.add(pNumInput);
		firstRPanel.add(pNameLabel);
		firstRPanel.add(pNameInput);
		
		secondLPanel.add(priceLabel);
		secondLPanel.add(priceInput);
		secondRPanel.add(stockLabel);
		secondRPanel.add(stockInput);
		
		thirdLPanel.add(makerLabel);
		thirdLPanel.add(makerInput);
		thirdRPanel.add(indateLabel);
		thirdRPanel.add(indateInput);
		
		mainCenterPanel2.setLayout(new GridLayout(4, 2));
		mainCenterPanel2.add(firstLPanel);
		mainCenterPanel2.add(firstRPanel);
		mainCenterPanel2.add(secondLPanel);
		mainCenterPanel2.add(secondRPanel);
		mainCenterPanel2.add(thirdLPanel);
		mainCenterPanel2.add(thirdRPanel);
		
		mainCenterPanel2.add(addBtn);
		mainCenterPanel2.add(cancelBtn);
		
		
		//리스너 등록
//		addBtn.addActionListener(this);
//		cancelBtn.addActionListener(this);

		container1.add(mainPanel);
		
		//container2 --- 제품조회/변경
		container2.setLayout(new BorderLayout());
		JPanel container2_north = new JPanel();
		JPanel container2_center = new JPanel();
		container2_north.add(categoryLabel);
		container2_north.add(combobox);
		container2_north.add(searchLabel);
		container2_north.add(searchInput);
		container2_north.add(searchBtn);
		container2_north.add(changeBtn);
		container2_north.add(deleteBtn);
		container2.add(container2_north,"North");
		//JTable 삽입 부분. table ---> tablePanel
		container2_center.setLayout(new BorderLayout());
		
		container2_center.setBackground(Color.black);
		container2_center.add(tablePanel);
		container2.add(container2_center,"Center");
		container2_center.setBackground(Color.blue);
		
		//탭 이름 지정.
		tab.add("제고등록",container1);
		tab.add("제고조회/변경",container2);
		mainCenterCPanel.add(tab);
// -----------------------------------------------------------------------------	
		combobox.addActionListener(this);//combobox actionListener
		searchBtn.addActionListener(this);//검색 버튼 actionListener
		changeBtn.addActionListener(this);//변경 버튼 actionListener
		deleteBtn.addActionListener(this);//삭제 버튼 actionListener
// -----------------------------------------------------------------------------		
		this.add(mainNorthPanel,"North");
		this.add(mainCenterPanel,"Center");
		this.setTitle("제품관리 창_02");
		this.setBounds(50, 100, 1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//리스너 등록
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selected = combobox.getSelectedItem().toString();
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
			String pNum = pNumInput.getText();
			String pName = pNameInput.getText();
			int price = Integer.parseInt(priceInput.getText());
			int stock = Integer.parseInt(stockInput.getText());
			String maker = makerInput.getText();
			String indate = indateInput.getText();// 메소드 호출해서 현재 날짜 기져오기.
			
			System.out.println(pNum + " / " + pName + " / " + price + " / " + stock + " / " + maker + " / " + indate);
			
			ProductDTO pdto = new ProductDTO();
			
			pdto.setPnum(pNum);
			pdto.setPname(pName);
			pdto.setPrice(price);
			pdto.setStock(stock);
			pdto.setMaker(maker);
			pdto.setIndate(indate);
			pdto.toString();
			pdao.insert(pdto);
		}
		if(e.getSource() == cancelBtn) {
			this.dispose();
		}
	}
}
