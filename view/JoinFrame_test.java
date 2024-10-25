package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinFrame_test extends JFrame{
	private JPanel mainPanel = new JPanel();
	
	private JLabel label = new JLabel("출력할 내용");
	private JTextField input = new JTextField(10);
	private JPanel panel1 = new JPanel();
	private JLabel label2 = new JLabel("출력할 내용");
	private JTextField input2 = new JTextField(10);
	private JPanel panel2 = new JPanel();
	
	private JLabel label3 = new JLabel("출력할 내용");
	private JTextField input3 = new JTextField(10);
	private JPanel panel3 = new JPanel();
	
	private JButton btn = new JButton("버튼");
	public JoinFrame_test() {
		this.setLayout(null);
		mainPanel.setLayout(null);
		panel1.setLayout(null);

		label.setBounds(349, 4, 131, 330);
		
		mainPanel.setBounds(10, 10, 30, 30);
		
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		
		
		this.add(mainPanel);
		this.setTitle("JTextField 태스트");
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
