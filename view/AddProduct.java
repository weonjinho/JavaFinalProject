package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProduct extends JFrame implements ActionListener{
	private JPanel mainPanel = new JPanel(); 
	private JPanel mainCenterPanel = new JPanel();
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
	
	public AddProduct() {
		//제품번호 : productNum
		//제품명 : productName
		//가격 : price
		//제고수량 : stock
		//제조사 : maker
		//입고날짜 : indate
		mainPanel.setLayout(new BorderLayout());
		mainCenterPanel.setBackground(Color.blue);
		mainSouthPanel.setBackground(Color.green);
		
		mainPanel.add(mainCenterPanel,"Center");
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
		
		mainCenterPanel.setLayout(new GridLayout(4, 2));
		mainCenterPanel.add(firstLPanel);
		mainCenterPanel.add(firstRPanel);
		mainCenterPanel.add(secondLPanel);
		mainCenterPanel.add(secondRPanel);
		mainCenterPanel.add(thirdLPanel);
		mainCenterPanel.add(thirdRPanel);
		
		mainCenterPanel.add(addBtn);
		mainCenterPanel.add(cancelBtn);
		
		this.setLayout(new BorderLayout());
		this.add(mainPanel);
		this.setTitle("제고등록");
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//리스너 등록
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addBtn) {
			String pNum = pNumInput.getText();
			String pName = pNameInput.getText();
			String price = priceInput.getText();
			String stock = stockInput.getText();
			String maker = makerInput.getText();
			String indate = indateInput.getText();// 메소드 호출해서 현재 날짜 기져오기.
		}
		if(e.getSource() == cancelBtn) {
			this.dispose();
		}
	}
}
