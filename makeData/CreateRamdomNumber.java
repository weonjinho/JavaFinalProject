package makeData;

import java.util.Arrays;

public class CreateRamdomNumber {
	
	private int[] n = new int[5];
	
	private String returnNum = null;
	private String text = null;
	private String textNum = "";
	//중복되지 않는 무작위 숫자 만들기 Math.random()
	//참고 사이트 : https://operstu1.tistory.com/50#b
	
	//외부에서 호출받을 메소드.
	public String Create_Ramdom_Number(){
		returnNum = randomNumber();
		System.out.println();
		return returnNum;
	}
	
	//숫자 생성 & 타입변환 & 배열에 저장 기능을 담당하는 메소드.
	public String randomNumber() {
		int index = 0;
		for(int i=0;i<n.length;i++) {
			do {
				index = (int)(Math.random()*10);
			} while (exists(n,index));
			n[i] = index;
		}
		for(int i=0;i<5;i++) {
			text = Integer.toString(n[i]);
			textNum += text;
		}
		return textNum;
	}
	
	//중복체크 메소드.
	private boolean exists(int[] n, int index) {
		for(int i=0;i<n.length;i++) {
			if(n[i] == index) {
				return true;
			}
		}
		return false;
	}

}


