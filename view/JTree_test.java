package view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTree_test extends JComponent{
	JFrame f;
	public JTree_test(){
		f = new JFrame();
		DefaultMutableTreeNode productMge = new DefaultMutableTreeNode("제고관리");
		DefaultMutableTreeNode addProduct = new DefaultMutableTreeNode("제고등록");
		DefaultMutableTreeNode productInfo  = new DefaultMutableTreeNode("제고조회/변경");
		productMge.add(addProduct);
		productMge.add(productInfo);
		JTree jt = new JTree(productMge);
		f.add(jt);
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
