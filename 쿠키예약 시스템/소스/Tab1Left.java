import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tab1Left extends JPanel{
	private Tab1Right panel; //������ �г� ����
	private Cookie[] cookies = {new Cookie("walnut", "���� ����Ĩ ��Ű","ȣ�� + ����Ĩ", 3400, 5), 
			new Cookie("malcha", "���� ȭ��Ʈ ��Ű", "���� + ȭ��Ʈ ����Ĩ", 3500, 5), new Cookie("oreo", "������ ����� ��Ű", "���ø�ο� + ȭ��Ʈ ����Ĩ + ������", 3500, 5), 
			new Cookie("lotus", "������ ����� ��Ű", "���ø�ο� + ī��� �ҽ� + ������", 3400, 5), new Cookie("cheese", "ġ��ġ�� ��Ű", "ũ��ġ�� + Ȳġ�� + ����", 3400, 5)};
			//��Ű ���� 1-> ��ü 1���� ����� ����
	JButton[] leftb = new JButton[5]; //�г� ���ʿ� �� ��Ű ���� ��ư

	
	public Tab1Left(){
		
		ScrollPane sp = new ScrollPane();//���� ���� ��ũ��
		JPanel leftP = new JPanel(); //��ũ�� ���� ���� �г�

		leftP.setLayout(new GridLayout(5,0)); //�г� ���� ���� ���� 5ĭ
		leftP.setBackground(Color.white);//���� ����
		sp.setSize(300, 750); //��ũ���г� ������ ����
		//��� ����
		for(int i=0; i<cookies.length; i++) { //5ĭ�� �� ��Ű ���� ������ �����
			Cookie cookie = cookies[i]; // ������ �Է��� ��Ű ���� Cookie Ŭ������ ����
			ImageIcon image = new ImageIcon("../img/"+cookies[i].getImg()+".png");
			//�̹��� ������ ���� (��Ű class���� getImg method �̿�(��ü���� ù��° ����� walnut�� �̹��� �̸� ����)
			leftb[i] = new JButton(image); //��ư�� �̹��� ������ �ֱ�
			//��Ű �����ܵ� ����
			leftb[i].addActionListener(new ActionListener() {//�� ������ �̺�Ʈ �������߰�
			    public void actionPerformed(ActionEvent e) {
			    	panel.setSelectedCookieUI(cookie);//������ �г��� ���� ��Ű UI���� method ����
			    		
			    }
			});//�� �ٿ� �̺�Ʈ �ڵ鷯 statement
			leftb[i].setBorderPainted(false); //�׵θ� ���� ����
			leftb[i].setContentAreaFilled(false); //���� ����
			
			leftP.add(leftb[i]); // ���� �гο� �����ܵ� �ֱ�(���� �� �Ѱ���)
		}
		//���� ���� �гο� ��Ű��ư ���� �Ϸ�
		sp.add(leftP); //��ũ���гο� ���õ� �г� ���̱�
		add(sp);//��ũ�� �г� ���� �гο� ���̱�
	}
	
	public void connectRight(Tab1Right panel) { //������ �гο��� �� setPanel ����
		this.panel = panel; //���� �гΰ� ������ �г� ���� ������ ����ǰ�
		panel.setCookie(cookies[0]); //ó�� ���� �� right�гο� ù��° ��Ű �������� ����
	}
	
	public void renderTab1Right() { //������ �г� ������ (���ÿ� ���� UI �ٲ��)
		panel.setSelectedCookieUI(cookies[0]); //��ٱ��� �ǿ��� �ʱ�ȭ �� ���������� ���ư��� �� ù��° ��Ű ���� ���
	}

}
