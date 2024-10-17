package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JTabbedPane_02 extends JFrame{
	public JTabbedPane_02() {
		
//탭 생성 ---> 컨테이너 생성 ---> 컴포넌트 생성 ---> 컴포넌트를 컨테이너에 추가.
		
		
		//탭 생성
		JTabbedPane tab = new JTabbedPane();
		
		//1. 탭의 갯수만큰 컨테이너가 만들어져야한다.
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		//1-1. 컨테이너마다 배경색을 다르게 지정해줍니다.
		container1.setBackground(Color.orange);
		container2.setBackground(Color.gray);
		container3.setBackground(Color.pink);
		
		//2. 컴포넌트 만들기
		//2-1. 첫변째 탭에 올라갈 컴포넌트를 만들어 보자.
		//첫번째 탭에는 버튼을 만듭니다.
		JButton jb1 = new JButton("버튼1");
		JButton jb2 = new JButton("버튼2");
		JButton jb3 = new JButton("버튼3");
		
		//2-1-1. 첫번째 탭에 올려질 컴포넌트를 컨테이너(container1)에 올려야 한다.
		container1.add(jb1);
		container1.add(jb2);
		container1.add(jb3);
		
		//2-2. 두번째 탭에 올려질 컴포넌트를 만듭니다.
		//두번째 탭에는 체크박스를 만듭니다.
		JCheckBox jcb1 = new JCheckBox("여행");
		JCheckBox jcb2 = new JCheckBox("운동");
		JCheckBox jcb3 = new JCheckBox("게임");
		JCheckBox jcb4 = new JCheckBox("잠자기");
		
		//2-2-1.
		
		
		
	}
}

















