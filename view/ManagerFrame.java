package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import makeData.GetNowDate;
import makeData.MakeProductNum;

public class ManagerFrame extends JFrame implements ActionListener, MouseListener{
	//DAO 접근용 변수.
	private ProductDAO pdao = new ProductDAO();
	
	//Swing 배치
	//"mainNorthWestLabel" & "mainNorthEastLabel"이 있는 패널.
	
	
	private JPanel mainNorthPanel = new JPanel();
	private JPanel mainCenterPanel = new JPanel();
	
	
	private JLabel mainNorthWestLabel = new JLabel(" 제고관리 시스탬_관리자");
	private JLabel mainNorthEastLabel = new JLabel();
	
	//왼쪽
	
	private JPanel mainCenterWPanel = new JPanel();
	private JPanel mainCenterCPanel = new JPanel();
	
	
	
	private JPanel mainCenterWNPanel = new JPanel();
	private JPanel mainCenterWCPanel = new JPanel();
	
	//JLabel
	private JLabel westNorthLabel = new JLabel("Information");
	//JTree
	private DefaultMutableTreeNode productMge = new DefaultMutableTreeNode("제고관리");
	private DefaultMutableTreeNode addProduct = new DefaultMutableTreeNode("제고등록");
	private DefaultMutableTreeNode productInfotree  = new DefaultMutableTreeNode("제고조회/삭제");
	
	
	
	//중앙
	private JTabbedPane tab = new JTabbedPane();
	
//	---------------- container1 ---------------------
	private JPanel container1 = new JPanel();//"제고등록"의 컨테이너.
	private JPanel mainPanel = new JPanel(); 
	
//	---------------- mainCenterPanel2 ---------------------
	private JPanel mainCenterPanel2 = new JPanel();
	
	private JPanel fourthRPanel = new JPanel();
	private JLabel categoryLabel2 = new JLabel("카테고리");
	private String[] category1 = {"생활가전", "주방가전", "계절가전", "통신용품", "PC 용품"};
	private JComboBox<String> combobox1 = new JComboBox<String>(category1);
	
	private JPanel firstRPanel = new JPanel();
	private JLabel pNameLabel = new JLabel("제품명");
	private JTextField pNameInput = new JTextField(10);
	
	private JPanel secondLPanel = new JPanel();
	private JLabel priceLabel = new JLabel("가격");
	private JTextField priceInput = new JTextField(10);
	private JPanel secondRPanel = new JPanel();
	
	private JLabel stockLabel = new JLabel("제고수량");
	private JTextField stockInput = new JTextField(10);
	
	private JPanel thirdLPanel = new JPanel();
	private JLabel makerLabel = new JLabel("제조사");
	private JTextField makerInput = new JTextField(10);
	
	private JPanel btnPanel = new JPanel();
	private JButton addBtn = new JButton("등록");
	private JButton cancelBtn = new JButton("등록취소");
	
//	---------------- mainSouthPanel ---------------------
	private JPanel mainSouthPanel = new JPanel();
	private JPanel panel4 = new JPanel();
	private JTable dataTable2 = new JTable();
	private DefaultTableModel model2 = null;
	
	private String[] colNames = {"제품번호", "제품명", "입고날짜", "카테고리", "제고수량","제조사","가격"};
	private String[][] data = new String[50][7];
	private JScrollPane sp2 = null;
	
	private JTable dataTable = new JTable();
	
//	---------------- container2 ---------------------
	private JPanel container2 = new JPanel();//"제고조회/삭제"의 컨테이너.
	private JPanel container2_north = new JPanel();
	private JLabel categoryLabel = new JLabel("카테고리");

	private JComboBox<String> combobox2 = new JComboBox<String>(category1);
	private JLabel searchLabel = new JLabel(" 검색할 제품 번호");
	private JTextField searchInput = new JTextField(10);
	private JButton searchBtn = new JButton("검색");
	private JButton deleteBtn = new JButton("삭제");
	private JButton outBtn = new JButton("출고");
	private JButton backBtn = new JButton("뒤로가기");
	
	private JPanel container2_center = new JPanel();
	private JPanel panel3 = new JPanel();
	private JScrollPane sp = null;
	
	private JLabel table = new JLabel("JTable_panel의 위치입니다.");
	private JPanel tablePanel = new JPanel();//JTable를 만든 뒤 이 panel위에 올립니다.
	private String[] productInfo = {"제품번호", "제품명", "제고수량", "입고날짜", "제품가격", "카테고리"};
	
	private JLabel pNumLabel = new JLabel("제품번호");
	
	private JLabel indateLabel = new JLabel("입고날짜");
	
	private JTextField pNumInput = new JTextField(10);
	
	private JTextField indateInput = new JTextField(10);
	
	private Dimension d = null;
	private Dimension d2 = null;
	
	//값을 저장할 변수.
	private String empName = null;
	private String nowDeptName = null;
	public static String  selectedCategory = null;
	private Object bbb = null;
	private int selectedRow = 0;
	private String strPnum = null;
	
	//Getter/Setter
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
		
//		mainNorthPanel.setBackground(Color.red);
//		mainCenterPanel.setBackground(Color.cyan);
//		mainCenterWPanel.setBackground(Color.yellow);
//		mainCenterWNPanel.setBackground(Color.black);
//		mainCenterWCPanel.setBackground(Color.darkGray);
//		mainCenterCPanel.setBackground(Color.green);
//		mainCenterPanel2.setBackground(Color.red);
//		mainSouthPanel.setBackground(Color.green);
//		container2_center.setBackground(Color.blue);
		
		//JLabel
		mainCenterWNPanel.add(westNorthLabel);
		//JTree
		productMge.add(addProduct);
		productMge.add(productInfotree);
		JTree jt = new JTree(productMge);
		mainCenterWCPanel.add(jt);
		
		mainNorthPanel.add(mainNorthWestLabel,"West");
		mainNorthPanel.add(mainNorthEastLabel,"East");
		
		mainCenterWPanel.add(mainCenterWNPanel,"North");
		mainCenterWPanel.add(mainCenterWCPanel,"Center");
		
		mainCenterPanel.add(mainCenterWPanel,"West");
		mainCenterPanel.add(mainCenterCPanel,"Center");
// -----------------------------------------------------------------------------		
		//탭 생성 ---> 컨테이너 생성 ---> 컴포넌트 생성 ---> 컴포넌트를 컨테이너에 추가.
//		JTabbedPane tab = new JTabbedPane();
//		JPanel container1 = new JPanel();
//		JPanel container2 = new JPanel();
		
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
		
		firstRPanel.setLayout(new FlowLayout());
		secondLPanel.setLayout(new FlowLayout());
		secondRPanel.setLayout(new FlowLayout());
		thirdLPanel.setLayout(new FlowLayout());
		fourthRPanel.setLayout(new FlowLayout());
		
//		카테고리
		fourthRPanel.add(categoryLabel2);
		fourthRPanel.add(combobox1);
		
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
		
		//"등록" & "취소"버튼
		btnPanel.add(addBtn);
		btnPanel.add(cancelBtn);
		
		mainCenterPanel2.setLayout(new GridLayout(3, 2));
		mainCenterPanel2.add(fourthRPanel);
		mainCenterPanel2.add(firstRPanel);
		mainCenterPanel2.add(secondLPanel);
		mainCenterPanel2.add(secondRPanel);
		mainCenterPanel2.add(thirdLPanel);
		mainCenterPanel2.add(btnPanel);
		
		container1.add(mainPanel);
		
		//container2 --- 제품조회/변경
		container2.setLayout(new BorderLayout());
		container2_north.add(categoryLabel);
		container2_north.add(combobox2);
		container2_north.add(searchLabel);
		container2_north.add(searchInput);
		container2_north.add(searchBtn);
		container2_north.add(deleteBtn);
		container2_north.add(outBtn);
		
		container2_north.add(backBtn);
		backBtn.setVisible(false);
		
		container2.add(container2_north,"North");
		
		//JTable 삽입 부분. table ---> tablePanel
		container2_center.setLayout(new BorderLayout());
		container2_center.add(panel3);
		container2.add(container2_center,"Center");
		
		//탭 이름 지정.
		tab.add("제고등록",container1);
		tab.add("제고조회/삭제",container2);
		
		mainCenterCPanel.add(tab);
		mainSouthPanel.add(panel4);
		
		model2 = new DefaultTableModel(colNames,0);
		dataTable = new JTable(model2);
		dataTable2 = new JTable(model2);
		
		sp = new JScrollPane(dataTable);//table를 JScrollPane에 붙이는 코드.
		sp2 = new JScrollPane(dataTable2);//table를 JScrollPane에 붙이는 코드.
		
		dataTable.setFillsViewportHeight(true);
		d = dataTable.getPreferredSize();
		d.width = 800;
		d.height = 650;
		
		d2 = dataTable2.getPreferredSize();//"제고등록 table"
		d2.width = 700;
		d2.height = 500;
		sp2.setPreferredSize(d2);
		
		sp.setPreferredSize(d);//JScrollPane 사이즈 지정.
		panel3.add(sp);
		panel4.add(sp2);
//		list에 데이터 추가.
		String[] rowData;
		ArrayList<ProductDTO> plist = pdao.selectAll();
		for(ProductDTO i : plist) {
			rowData = new String[] {i.getPnum(),i.getPname(), i.getIndate(), i.getCategory(), Integer.toString(i.getStock()), i.getMaker(), Integer.toString(i.getPrice())};
			model2.addRow(rowData);
		}
		
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
		
		//제품등록
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectedCategory = combobox1.getSelectedItem().toString();
				ProductDTO pdto = new ProductDTO();
				pdto.setCategory(combobox1.getSelectedItem().toString());
				pdto.setPname(pNameInput.getText());
				pdto.setPrice(Integer.parseInt(priceInput.getText()));
				pdto.setStock(Integer.parseInt(stockInput.getText()));
				pdto.setMaker(makerInput.getText());
				MakeProductNum mp = new MakeProductNum();
				String pnum = mp.getProductNum(); // 메소드 호출해서 받아올값.
				mp = null;//자원 반납.
				pdao.insert(pdto,pnum);
				ProductDTO p = pdao.selectOne(pnum);
				String[] rowData;
				rowData= new String[] {p.getPnum(),p.getPname(),p.getIndate(), p.getCategory(),Integer.toString(p.getStock()), p.getMaker(), Integer.toString(p.getPrice())};
				model2.addRow(rowData);
			}
		});
		cancelBtn.addActionListener(this);
		combobox1.addActionListener(this);//combobox actionListener
		combobox2.addActionListener(this);//combobox actionListener
		
//		searchBtn.addActionListener(this);//검색 버튼 actionListener
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model2.setRowCount(0);
				ProductDTO a = pdao.selectOne(searchInput.getText());
				String[] data = {a.getPnum(), a.getPname(), a.getIndate(), a.getCategory(), Integer.toString(a.getStock()), a.getMaker(), Integer.toString(a.getPrice())};
				model2.addRow(data);
				backBtn.setVisible(true);
				backBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						model2.setRowCount(0);
						ArrayList<ProductDTO> plist = pdao.selectAll();
						for(ProductDTO i : plist) {
							String[] data = {i.getPnum(), i.getPname(), i.getIndate(), i.getCategory(), Integer.toString(i.getStock()), i.getMaker(), Integer.toString(i.getPrice())};
							model2.addRow(data);
						}
						backBtn.setVisible(false);
						searchInput.setText("");
					}
				});
			}
		});//검색 버튼 actionListener
		
		//제품출고
		outBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("출고");
				//기존화면 비우기.
				model2.setRowCount(0);
				//선택한 제품의 모든 정보를 기져오기.
				ProductDTO pdto = pdao.selectOne(strValue());
				String pnum = pdto.getPnum();
				pdto = null;
				pdao.update2(pnum);//DB에 접근, 수정된 제고수량 가져옴.
				ProductDTO a = pdao.selectOne(strValue());
				int changedRow2 = selectedRow;
				int changedColumn = 4;
				int kstock = a.getStock();
				System.out.println("남은 제고 : " + kstock);
				
				ArrayList<ProductDTO> plist = pdao.selectAll();
				for(ProductDTO i : plist) {
					String[] data = {i.getPnum(), i.getPname(), i.getIndate(), i.getCategory(), Integer.toString(i.getStock()), i.getMaker(), Integer.toString(i.getPrice())};
					model2.addRow(data);
				}
			}
		});
		
		//제품삭제
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pdao.delete(strValue());
				model2.removeRow(selectedRow);
			}
		});
		
		//마우스 이벤트 추가.
		dataTable.addMouseListener(this);
		dataTable2.addMouseListener(this);
		
		System.out.println("table 사이즈 : " + dataTable.getSize());//"제고조회/삭제"
		System.out.println("table2 사이즈 : " + dataTable2.getSize());//"제고등록"
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selected = combobox2.getSelectedItem().toString();
		//"취소"버튼
		if(e.getSource() == cancelBtn) {
			combobox1.setSelectedIndex(0);
			pNameInput.setText("");
			priceInput.setText("");
			stockInput.setText("");
			makerInput.setText("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		selectedRow = dataTable.getSelectedRow();
		Object aaa = dataTable.getValueAt(selectedRow, 0);
		System.out.println("선택된 row의 내용 : " + aaa);
		
//		int row2 = dataTable2.getSelectedRow();
//		Object aaa2 = dataTable2.getValueAt(row2, 0);
//		System.out.println("제고등록에서 선택된 값 : " + aaa2);
	
		bbb = aaa;//마우스 클릭된 row의 제품번호만 리턴.
	}
	
	public Object selNum() {
		return bbb;
	}
	public String strValue() {
		strPnum = bbb.toString();
		return strPnum;
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
