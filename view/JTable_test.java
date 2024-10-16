package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTable_test extends JFrame{
	public JTable_test() {
		
		Dimension dim = new Dimension(400, 150);
		
		this.setLocation(200, 400);
		String[] header = {"제품번호", "제품명", "제고수량", "입고날짜", "제품가격", "카테고리"};
		String[][] contents = {
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
				{"aaa", "90","87","98", "90","87"},	
		};
		
		
		JTable table = new JTable(contents, header);
		
		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll);
		this.setPreferredSize(dim);
		this.setBounds(70, 70, 900, 900);
		this.setTitle("학생명단");
		this.setVisible(true);
//		this.pack();
	}
}
