package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTable_test_1019 extends JFrame{
//	private JLabel nameTxt, studentNumTxt, ageTxt, birthTxt, phoneTxt = new JLabel();
//	private JButton cancelBtn = new JButton("취소");
//	private JButton deleteBtn = new JButton("삭제");
//	private JButton changeBtn = new JButton("변경");
	private JTable dataTable = new JTable();
	private String[] colNames = {"이름", "나이", "생일", "학번", "전화번호"};
	private String[][] data = new String[50][5];
	
//	private JPanel panel1 = new JPanel();
	private JPanel panel3 = new JPanel();
//	private JPanel panel4 = new JPanel();
	
	
	public JTable_test_1019(){
		dataTable = new JTable(data,colNames);
		JScrollPane sp = new JScrollPane(dataTable);//table를 JScrollPane에 붙이는 코드.
		sp.setBackground(Color.cyan);
		dataTable.setFillsViewportHeight(true);
		Dimension d = dataTable.getPreferredSize();
		d.width = 600;
		d.height = 300;
		sp.setPreferredSize(d);//JScrollPane 사이즈 지정.

		panel3.add(sp);
		panel3.setBackground(Color.yellow);
		panel3.setBounds(30, 100, 600, 200);
		this.add(panel3);//JPanel을 JFrame에 부착.
		
		this.setTitle("연락처 관리");
		this.setBounds(100, 100, 625, 350);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
