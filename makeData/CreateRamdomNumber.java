package makeData;

import java.util.Arrays;

public class CreateRamdomNumber {
	private int[] n = new int[5];
	private String returnNum = null;
	private String text = null;
	private String textNum = "";
	//중복되지 않는 무작위 숫자 만들기 Math.random()
	//참고 사이트 : https://operstu1.tistory.com/50#b
	public String Create_Ramdom_Number(){
		returnNum = randomNumber();//"생성된 랜덤 숫자"
		System.out.println();
		return returnNum;
	}
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
	private boolean exists(int[] n, int index) {
		for(int i=0;i<n.length;i++) {
			if(n[i] == index) {
				return true;
			}
		}
		return false;
	}

}


