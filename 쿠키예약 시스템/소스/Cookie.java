//��ü ��� ��Ű���� �� ��ü�� ������ class 
public class Cookie { 
	private String img; //��Ű �̹��� ���� �̸� ����
	private String name; //��Ű �̸� ����
	private String description; //��Ű ���� ����
	private int price; //��Ű ���� ����
	private int inventory;//��Ű ��� ����

	public Cookie(String img, String name, String description, int price, int inventory) {
		this.img = img;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		this.description = description; //�����ڷ� �޾ƿ� �� class�� �����ϴ� ������ �����
	}
	
	//private �Ӽ��� ���� �����ϰ� getter setter ����
	public String getImg() { //�̹��� ���ͼ��� ����
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
