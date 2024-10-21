package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbar_test extends JFrame{
	public JTabbar_test() {
		this.setTitle("JTabbar");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		
		
		JTabbedPane jtp = new JTabbedPane();
		mainPanel.add(jtp, BorderLayout.CENTER);
		this.add(mainPanel);
		
		JPanel jpanel1 = new JPanel(new GridLayout(2, 3));
		jtp.add("제고등록",jpanel1);
		jpanel1.add(new JButton("White"));
		jpanel1.add(new JButton("Green"));
		jpanel1.add(new JButton("Red"));
		jpanel1.add(new JButton("Yellow"));
		jpanel1.add(new JButton("Black"));
		
		JPanel jpanel2 = new JPanel(new GridLayout(3, 2));
		jtp.add("제고조회/변경",jpanel2);
		jpanel2.add(new JButton("White"));
		jpanel2.add(new JButton("Green"));
		jpanel2.add(new JButton("Red"));
		jpanel2.add(new JButton("Yellow"));
		jpanel2.add(new JButton("Black"));
		
//		this.add(jpanel1);
//		this.add(jpanel2);
		this.setSize(300,200);
		this.setVisible(true);
		
	}
}















