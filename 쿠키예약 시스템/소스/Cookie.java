//전체 재고 쿠키마다 각 객체로 생성할 class 
public class Cookie { 
	private String img; //쿠키 이미지 파일 이름 저장
	private String name; //쿠키 이름 저장
	private String description; //쿠키 설명 저장
	private int price; //쿠키 가격 저장
	private int inventory;//쿠키 재고량 저장

	public Cookie(String img, String name, String description, int price, int inventory) {
		this.img = img;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		this.description = description; //생성자로 받아온 값 class에 세팅하는 생성자 만들기
	}
	
	//private 속성들 접근 가능하게 getter setter 생성
	public String getImg() { //이미지 게터세터 생성
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	
}
