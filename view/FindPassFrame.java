package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class FindPassFrame extends JFrame implements ActionListener{
	private EmployeeDAO empdao = new EmployeeDAO();
	
	private JPanel mainCenterPanel = new JPanel();//기타 내용이 있을 패널.
	private JPanel mainSouthPanel = new JPanel();//"취소" & "변경" 버튼이 위치할 패널.
	
	private JPanel firstPanel = new JPanel();//"checkIdLabel"이 위치한 패널.
	private JPanel firstRPanel = new JPanel();//"inputChkId" & "checkBtn"이 위치한 패널. ---> "아이디 입력" & "인증 버튼"
	
	private JPanel secondPanel = new JPanel();//"checkResult" 라벨이 위치한 패널. ---> 인증 결과 확인.
	private JPanel thirdPanel = new JPanel();//"newPassLabel" & "inputNewPass"이 위치한 패널. ---> 새 비밀번호 입력.
	private JPanel fourthPanel = new JPanel();//"chkNewPassLabel" & "inputChkPass"이 위치한 패널. ---> 새 비밀번호 확인.
	
	
	private JLabel checkIdLabel = new JLabel("아이디를 입력하세요.");
	private JTextField inputChkId = new JTextField(10);
	
	private JLabel checkResult = new JLabel("결과");//결과
	
	private JLabel newPassLabel = new JLabel("새 비밀번호 입력");
	private JTextField inputNewPass = new JTextField(10);
	
	private JLabel chkNewPassLabel = new JLabel("새 비밀번호 확인");
	private JTextField inputChkPass = new JTextField(10);
	
	private JButton checkBtn = new JButton("인증");//"인증" 버튼
	private JButton cancelBtn = new JButton("취소");//"취소" 버튼
	private JButton changeBtn = new JButton("변경");//"변경" 버튼
	
	public FindPassFrame(){
		this.setLayout(new BorderLayout());//JFrame 레이아웃 지정.
		mainCenterPanel.setLayout(new GridLayout(4, 0));//"기타 내용"이 있는 패널의 레이아웃 지정.
		
		firstPanel.setLayout(new FlowLayout());//"firstPanel"이 위치한 패널의 레이아웃 지정.
		firstRPanel.setLayout(new FlowLayout());//"firstRPanel"이 위치한 패널의 레이아웃 지정.
		firstPanel.add(checkIdLabel);//"checkIdLabel"을 "firstPanel"위 부착.
		firstRPanel.add(inputChkId); //"inputChkId"을 "firstRPanel"위 부착.
		firstRPanel.add(checkBtn);	 //"checkBtn"을 "firstRPanel"위 부착. ---> "firstRPanel" : "inputChkId"(입력창)	& "checkBtn"("인증"버튼)										
		firstPanel.add(firstRPanel); //"firstRPanel"을 "firstPanel"위에 부착. ---> "firstPanel" = "firstPanel" + "firstRPanel"
		
		secondPanel.setLayout(new FlowLayout());//"secondPanel"의 레이아웃 지정. ---> "인증"결과 확인 라벨.
		secondPanel.add(checkResult);//"checkResult"을 secondPanel에 부착. ( "인증"결과 확인라벨 부착. )
		
		thirdPanel.setLayout(new FlowLayout());//"thirdPanel"의 레이아웃 지정.
		thirdPanel.add(newPassLabel);//"새 비번입력" 라벨
		thirdPanel.add(inputNewPass);//"새 비번입력" 입력창
		
		fourthPanel.setLayout(new FlowLayout());//"비번확인" 패널의 레이아웃 지정.
		fourthPanel.add(chkNewPassLabel);//"새 비번확인" 라벨.
		fourthPanel.add(inputChkPass);//"새 비번확인" 입력창.
		
		mainCenterPanel.add(firstPanel);//"아이디 입력" 부분 부착.
		mainCenterPanel.add(secondPanel);//"결과 확인" 부분 부착.
		mainCenterPanel.add(thirdPanel);//"새 비밀번호" 부분 부착.
		mainCenterPanel.add(fourthPanel);//"새 비밀번호 확인" 부분 부착.
		
		mainSouthPanel.setLayout(new FlowLayout());//"취소"&"변경" 버튼이 위치한 페널의 레이아웃 지정.
		mainSouthPanel.add(cancelBtn);//"취소" 버튼을 패널의 추가.
		mainSouthPanel.add(changeBtn);//"변경" 버튼을 패널의 추가.
		
		this.add(mainCenterPanel,"Center");//"기타 내용"을 "Center"에 배치한다.
		this.add(mainSouthPanel,"South");//"취소"&"변경" 버튼을 "South"에 배치.
		this.setTitle("비밀번호 찾기");//JFrame 제목 지정.
		this.setBounds(200, 200, 900, 500);//JFrame 위치, 크기 지정.
		this.setVisible(true);//JFrame을 화면에 보일 여부 결정.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//"x"버튼 클릭시 실행종료.
		
		//리스너 등록.
		checkBtn.addActionListener(this);//"인증" 버튼 리스너 추가.
		cancelBtn.addActionListener(this);//"취소" 버튼 리스너 추가.
		changeBtn.addActionListener(this);//"변경" 버튼 리스너 추가.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String empno1 = inputChkId.getText();//인증할 "아이디"를 입력받아 변수에 저장한다.
		if(e.getSource() == checkBtn) { //"인증"버튼 클릭시 발생하는 action.
			//selectAll()로 모든 튜플을 가져온다.
			ArrayList<EmployeeDTO> elist2 = empdao.selectAll();
			//입력받는 사원번호랑 같은 사원번호값을 가지고 있는 튜플이 있는지 판단한다.
			for(EmployeeDTO ee : elist2) {
				String empno = ee.getEmpno();//반복될때 마다 1개의 튜플속 사원번호값을 가져와 변수에 저장한다.
				if(empno1.equals(empno)) { // 일치시
					checkResult.setText("인증 되었습니다.");
					checkResult.setForeground(Color.green);
					break;
				}else if(!empno1.equals(empno)){ // 불일치시
					checkResult.setText("인증 실패하였습니다.");
					checkResult.setForeground(Color.red);
				}
			}
		}
		
		if(e.getSource() == cancelBtn) { //"취소"버튼 클릭시 발생하는 action.
			System.out.println("취소 버튼 클릭");
			this.dispose();
		}
		
		if(e.getSource() == changeBtn) { //"변경" 버튼 클릭시 발생하는 action.
			//새 비밀번호 입력.
			String inputPassword = inputNewPass.getText();
			//새 비밀번호 확인.
			String inputPassword2 = inputChkPass.getText();
			if(inputPassword.equals(inputPassword2)) {
				System.out.println("비밀번호 일치");
				//여기서 DB에 있는 값을 update합니다.
				//EmployeeDAO.update(empno, inputPassword)
				empdao.update(empno1, inputPassword);
				System.out.println("비밀번호 update 완료.");
			}else {
				System.out.println("비밀번호 불일치");
			}
		}
	}
}
