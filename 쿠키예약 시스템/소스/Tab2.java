import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Tab2 extends JPanel{
	private Main main;
	Submit popup;
	JPanel check; 
	Color bluee = new Color(204,229,255);
	Color yellow = new Color(255,255,204);

	JLabel namelabel, timelabel, baglabel, paylabel,totallabel;
	String ampm="", hour="", min="", payment="", shoppingbag="", cookiename="";
	int total = 0;
	Font f = new Font("����", Font.PLAIN, 20);
	Font fbutton = new Font("����", Font.BOLD, 30);
	
	public Tab2(Main main) {
		this.main=main; 
		setBackground(Color.white);
		check = new JPanel();
		check.setPreferredSize(new Dimension(800,700));
		//�ֹ�Ȯ�� �г� ������ ����
		check.setLayout(new GridLayout(6,0));//���� 6ĭ ���� ����
		check.setBorder(new TitledBorder(new LineBorder(Color.blue,3),"�ֹ�Ȯ��"));
		//�г� �׵θ� ����
		check.setBackground(bluee);
		//�г� ���� ����
		namelabel = new JLabel("�ֹ� ǰ�� ��: "+ cookiename+"... ");
		timelabel =new JLabel("����ð�: "+ ampm +" "+hour+"�� "+min+"�� ");
		baglabel = new JLabel("���ι� ����: "+shoppingbag);
		paylabel = new JLabel("���� ����(������) : "+payment);
		totallabel = new JLabel("�� �ݾ� : "+total +"�� ");
		//�ֹ�Ȯ�ο� �� ������Ʈ ����Ʈ ���� �ֱ� (�������� �� �ʱ�ȭ ���༭ ���빰�� �������� ǥ��)
		namelabel.setFont(f);
		timelabel.setFont(f);
		baglabel.setFont(f);
		paylabel.setFont(f);
		totallabel.setFont(f);
		//�� �� ��Ʈ �����ֱ�
		check.add(namelabel);
		check.add(timelabel);
		check.add(baglabel);
		check.add(paylabel);
		check.add(totallabel);
		//�� �� ������Ʈ �гο� ���ϱ�
		JButton confirm = new JButton("���� Ȯ��");
		confirm.setBorderPainted(false); //�ܰ� �׵θ� ����
		confirm.setFocusPainted(false); //focus�� �׵θ� ����
		confirm.setFont(fbutton); 
		confirm.setBackground(yellow);
		confirm.addActionListener (new ActionListener() {
			//�������̵� 
			public void actionPerformed(ActionEvent e) {
				if(total !=0) { //���� Ȯ���� ���¿����� ���� Ȯ�� �����ϰ�
				popup = new Submit(main); //����Ȯ�� ��ư Ŭ���� ����Ȯ�� ���̾�α� ���� 	
				}else {//���� Ȯ�� �ƴ� �� ��� �˾� 
					JOptionPane.showMessageDialog(null, "�ֹ� ����� �����ϴ�.","Error!",JOptionPane.WARNING_MESSAGE);
				}
			}});// statement�� ��� ��ư�� ���� �׼� �̺�Ʈ �ڵ鸵 method overriding
		
		check.add(confirm); //����Ȯ�� ��ư �гο� ���̱�
		add(check);
	}//������ ���� ��
	//method���� 
	public void setOrderOption(OrderOption orderOption) {
		
		cookiename = orderOption.getCookielist().get(0).getName();//cookielist�� ��� �� cookielist(�ֹ� ����Ʈ)�� ù��° �ε����� ��ü���� ��Ű�̸� �Ӽ� ��� ����
		total = orderOption.getTotal(); //���� ���� ��� ����
		hour = orderOption.getHours(); //�湮 �ð� ��� ����
		min = orderOption.getMiuate(); 
		//������ �ɼ��� ���ڷ� ���� �����߱⿡ ����� �� �� ���ڿ� �����ϴ� ���ڷ� ��ȯ�۾� ���ľ� ��
		if(orderOption.getAmpm() ==0) {
			ampm ="AM";
		}else if(orderOption.getAmpm() == 1) {
			ampm ="PM";
		}
		//AMPM ��ȯ
		if(orderOption.getPayway()==1) {
			payment = "�ſ�ī��";
		}else if(orderOption.getPayway() ==2) {
			payment = "īī������";
		}else if(orderOption.getPayway() ==3) {
			payment = "������";
		}
		//���� ��� ��ȯ
		if(orderOption.getShoppingbag() == 0) {
			shoppingbag ="���ι� O";
		}else if(orderOption.getShoppingbag() ==1) {
			shoppingbag = "���ι� X";
		}
		//���ι� ���� ��ȯ
		render();
		//���ŵ� ������ �󺧵� �����	
	}
	//�� ä��� method
	public void render() {
		namelabel.setText("�ֹ� ǰ�� ��: "+ cookiename+"... ");
		timelabel.setText("����ð�: "+ ampm +" "+hour+"�� "+min+"�� ");
		baglabel.setText("���ι� ����: "+shoppingbag);
		paylabel.setText("���� ����(������) : "+payment);
		totallabel.setText("�� �ݾ� : "+total +"�� ");
	}
	//�ֹ� Ȯ��-> Ȯ�� �� �󺧿� ��� ���� �ʱ�ȭ
	public void setclear() {
			this.cookiename = "";
			this.ampm ="";
			this.hour="";
			this.min="";
			this.shoppingbag= "";
			this.payment= ""; 
			this.total= 0;
			render();
	}
}
