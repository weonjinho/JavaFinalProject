package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JTabbedPane extends JFrame{
	public JTabbedPane(){
		
		JTabbedPane t = new JTabbedPane();
		JPanel p1 = new JPanel();
		
//		t.add("제품동록");
//		t.add("제품조회/변경");
		
		this.add(t);
		
		
		
		
		
		
		this.setTitle("제품관리 창");
		this.setBounds(100, 100, 1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
