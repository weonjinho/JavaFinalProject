package makeData;

import view.ManagerFrame;

public class MakeProductNum {
	//제품번호 : 대분류 + 5자리 숫자.
	//대분류 :
	//1.생활가전 : 001
	//2.주방가전 : 002
	//3.계절가전 : 003
	//4.통신용품 : 004
	//5.PC용품 : 005
	private String productNum = null;
	private CreateRamdomNumber a = new CreateRamdomNumber();
	public MakeProductNum(){
		ManagerFrame pf = new ManagerFrame();
		String categoryCode = null;
		String mainCategory = pf.selectedCategory; // static -- ProductFrame_02
		if(mainCategory.equals("생활가전")) {
			categoryCode = "0001";
		}else if(mainCategory.equals("주방가전")) {
			categoryCode = "0002";
		}else if(mainCategory.equals("계절가전")) {
			categoryCode = "0003";
		}else if(mainCategory.equals("통신용품")) {
			categoryCode = "0004";
		}else if(mainCategory.equals("PC용품")) {
			categoryCode = "0005";
		}
		
		String randomNum = a.Create_Ramdom_Number();
		System.out.println("p 랜덤 숫자 : " + randomNum);
		productNum = categoryCode + "_" + randomNum;
		System.out.println("생성한 재품번호 : " + productNum);
	}
	
	public String getProductNum() {
		return productNum;
	}
	
}
