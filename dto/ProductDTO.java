package dto;

public class ProductDTO {
	private String pnum = null;
	private String pname = null;
	private int price = 0;
	private int stock = 0;
	private String maker = null;
	private String indate = null;
	
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		System.out.println("22222");
		return "ProductDTO [pnum=" + pnum + ", pname=" + pname + ", price=" + price + ", stock=" + stock + ", maker="
				+ maker + ", indate=" + indate + "]";
	}
	
}
