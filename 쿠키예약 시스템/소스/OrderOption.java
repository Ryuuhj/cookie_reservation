import java.util.ArrayList;

public class OrderOption {
	
	private int total;
	private ArrayList<MyCookie> cookielist = new ArrayList<MyCookie>();
	//Orederoption에 저장한 주문 쿠키 list 생성
	private int payway;
	private int shoppingbag;
	private int ampm;
	private String hours, minuate;
	public OrderOption() {
		
	}

	public ArrayList<MyCookie> getCookielist() {
		return cookielist;
	}

	public void setCookielist(ArrayList<MyCookie> cookielist) {
		this.cookielist = cookielist;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPayway() {
		return payway;
	}
	public void setPayway(int payway) {
		this.payway = payway;
	}
	public int getShoppingbag() {
		return shoppingbag;
	}
	public void setShoppingbag(int shoppingbag) {
		this.shoppingbag = shoppingbag;
	}
	public int getAmpm() {
		return ampm;
	}
	public void setAmpm(int ampm) {
		this.ampm = ampm;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getMiuate() {
		return minuate;
	}
	public void setMiuate(String minuate) {
		this.minuate = minuate;
	}
}
