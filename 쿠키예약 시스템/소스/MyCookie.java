
//���� �� ��Ű ���� ���� ��ü ������ MyCookie class ����
public class MyCookie{
	private Cookie cookie; //��ü ��Ű�߿� �����ϴ� ���̹Ƿ� ���� ��ü ��Ű �ٷ�� Cookie class ����
	private String name; //�̸�
	private int price; //����
	private int cnt; //����
	
	public MyCookie() {	
	}
//mycookie ��ü ������ ���� ��ƿ� ������ ����
	public MyCookie(Cookie cookie, String name, int price, int cnt) {
		//super();
		this.cookie = cookie; //��Ű�� ���� ��ü ���� ���޹ޱ� ���� cookie ��ü �Ű������� ���
		this.name = name; //�̸� ����
		this.price = price; //����
		this.cnt = cnt; //���� ����
	}
//���������� �� private �Ӽ��� �����ϱ� ���� getter, setter ����
	public Cookie getCookie() {
		return cookie;
	}
	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
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

	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
