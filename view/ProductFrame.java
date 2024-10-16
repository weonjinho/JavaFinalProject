package view;

import javax.swing.JFrame;

public class ProductFrame extends JFrame{
	public ProductFrame() {
		this.setTitle("제품관리 창");
		this.setBounds(100, 100, 1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
