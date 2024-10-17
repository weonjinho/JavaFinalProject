package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCombobox extends JFrame implements ActionListener{
	private JLabel cLabel = new JLabel("카테고리");
	private String[] category = {"생활가전", "주방가전", "계절가전", "통신용품", "PC 용품"};
	private JComboBox<String> combobox = new JComboBox<String>(category);
	public JCombobox() {
		this.setTitle("Combobox");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
//		JComboBox<String> combobox = new JComboBox<String>(category);
		combobox.setBounds(10, 10, 100, 50);
		this.add(cLabel);
		this.add(combobox);
		this.setSize(300, 300);
		this.setVisible(true);
		
		combobox.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == combobox) {
			String selected = combobox.getSelectedItem().toString();
			System.out.println(selected);
		}
	}
}
