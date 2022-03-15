import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Tab3 extends JPanel implements ItemListener { //JPanel ��ӹް� ItemListener ���� ���� implements

	private Main main;
	JButton clear;
	Choice timeHour, timeMin; //���̽�-> ��, �� ����
	JRadioButton pay1, pay2, pay3,spbag1, spbag2, am, pm;
	JTable table;
	JPanel tablepanel;
	ImageIcon butdefault = new ImageIcon("../img/button1.png");
	ImageIcon buthover = new ImageIcon("../img/button2.png");
	Color bluee = new Color(204,229,255);
	Color yellow = new Color(255,255,204);
	Font font = new Font("����", Font.BOLD, 20); //�� �ݾ� ǥ���� ��Ʈ
	
	String[] columName = {"��ǰ��", "����", "�ݾ�"};//���̺� ��ܿ� �� ColumName
	int pw, spb, ap = -1; //���� ���� �Ǵ��ϱ� ���� ����(+ ��� �� �� ����)
	String hr, mi ="zero"; //���� ���� (String)
	String[] timehour = {"01","02","03","04","05","06","07","08","09","10","11","12"};
	String[] timeminuate = {"00","10","20","30","40","50"};
	//choice ������ ������ �迭 ����
	JLabel total;
	int totalprice;//���̺��� ���� ����� �� �ݾ� ���� ����
	
	private ArrayList<MyCookie> cookielist = new ArrayList<>();
	//���� �� ��Ű�� ���� ������ �迭�� ����-> ���̺� ���� ���� arraylist ����(ũ�� ������, �߰�, ���� ����)

	
	public Tab3(Main main) {//��ü ������ ����
		this.main = main; //Main �г� ������ �ٸ� tab�� �����ϱ� ���� ����

		setLayout(new GridLayout(2,0)); //���̺�/�ɼ� ���� �κ� ũ�� 2������ ������ 0*2
		
		//Table ���� part
		tablepanel = new JPanel(); //���̺� ���� �г� ����
		tablepanel.setLayout(new BorderLayout());//���̾ƿ� ����
		DefaultTableModel tableModel = new DefaultTableModel(columName,0); //���̺� �����ϱ� ���� ���̺� �� ��� (����Ʈ�� value���� �������)
		table = new JTable(tableModel); //���̺� �� �̿��� ���̺� ����
		
		JScrollPane scp = new JScrollPane(table);//���̺� ���� ��ũ�� �г� ����
		tablepanel.add("Center",scp); //��ũ�� �г� ���̺� ���� �г��� Center�� ���̱�
		clear =new JButton("�ʱ�ȭ"); //���̺� �ʱ�ȭ ��ų �ʱ�ȭ ��ư ����
		clear.addActionListener(new ActionListener() { //�ʱ�ȭ��ư�� �׼� ������ ����
			//�׼� �̺�Ʈ ������ override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<cookielist.size(); i++) { //�����鼭 ���ҵ� ��� �ٽ� �ǵ����� ���� for�� ������
					Cookie cookie = cookielist.get(i).getCookie(); //arraylist�� ��� ������ �ε������� get�ؼ� cookie ��ü�� �ο�
					cookie.setInventory(cookie.getInventory()+cookielist.get(i).getCnt()); //arraylist�� ��� ������ �̿��� ����� �ٽ� ����������ŭ ���ؼ� ���󺹱� ��Ű��
				}//��Ű�� ��� ���� �Ϸ�
				main.getTab1().getTab1Left().renderTab1Right();//������ ���� Tab1 ������ �ٽ� ���� (���� �� �� 1���� ���� �� �� ������ �� ���� �޼ҵ�ȣ��)
				table.setModel(tableModel); //���̺� ����
				cookielist.clear(); //����Ʈ �ʱ�ȭ
				totalprice = 0;//�� �ݾ� 0���� �ʱ�ȭ
				total.setText(String.valueOf(totalprice)); //�ϴܿ� ������ �� �ݾ� �󺧵� 0���� ����
			}
		});// statement�� �ʱ�ȭ ��ư�� ���� �׼� �̺�Ʈ �ڵ鸵 method overriding
		clear.setBackground(bluee);
		tablepanel.add("South",clear); //�ʱ�ȭ ��ư ���г� �ϴܿ� �߰�
		add(tablepanel); //�� �г� ���ϱ�	
		
		//���̺� ��Ÿ ����
		scp.getViewport().setBackground(Color.WHITE);//���̺� ���ºκ� ȸ��->���
		table.setAutoCreateColumnsFromModel(false);
		//��� �÷��� ���� ���� -> �ڵ����� ����
		DefaultTableCellRenderer dcr = new DefaultTableCellRenderer();
		dcr.setHorizontalAlignment(SwingConstants.CENTER);
		//���̺� ���� ��� ����
		
		TableColumnModel tcm = table.getColumnModel();
		for (int i=0;i<tcm.getColumnCount();i++) {
			tcm.getColumn(i).setCellRenderer(dcr);
		} //��� ���� ������ ������ �緣����
	
		//�г� �Ʒ��κ� ���� 
		JPanel bottom = new JPanel();
		
		bottom.setLayout(new GridLayout(0,2));
		//�Ʒ��κ� ���� ũ�� �¿� ���� ����
		JPanel bottomP = new JPanel();
		
		bottomP.setLayout(new GridLayout(4,0));
		//���� �гο� �� �г� ����, ���� 4��
		JPanel bottomP1 = new JPanel();
		JPanel bottomP2 = new JPanel();
		JPanel bottomP3 = new JPanel();
		bottomP1.setBackground(yellow);
		bottomP2.setBackground(yellow);
		bottomP3.setBackground(yellow);
		
		//�� ������ư�� �� �г� ����
		
		//1) ���� ���� �г�
		JPanel g1P = new JPanel();
		ButtonGroup g1 = new ButtonGroup();//���� ���� ������ ��ư �׷� ����
		pay1 = new JRadioButton("�ſ�ī��", false);
		pay2 = new JRadioButton("īī������", false);
		pay3 = new JRadioButton("������", false);
		pay1.setBackground(yellow);
		pay2.setBackground(yellow);
		pay3.setBackground(yellow);
		//��ư ����
		pay1.addItemListener(this);
		pay2.addItemListener(this);
		pay3.addItemListener(this);
		//�� ��ư�� ������ ������ ���(�ش� Ŭ���� ���� method�� override)
		g1P.add(new JLabel("�������            "));
		//��ư �׷쿡 ������Ʈ �߰�
		g1.add(pay1);
		g1.add(pay2);
		g1.add(pay3);
		//�гο� ������Ʈ �߰�
		g1P.add(pay1);
		g1P.add(pay2);
		g1P.add(pay3);
		//�����ο� �������� �г� �߰� (1��° ĭ)
		bottomP1.add(g1P);
		//2) ���ι� ���� ���� �г�
		JPanel g2P = new JPanel();//���� ����
		ButtonGroup g2 = new ButtonGroup();
		spbag1 = new JRadioButton("Yes", false);
		spbag2= new JRadioButton("No", false);
		spbag1.setBackground(yellow);
		spbag2.setBackground(yellow);
		spbag1.addItemListener(this);
		spbag2.addItemListener(this);
		g2P.add(new JLabel("���ι� ����         "));
		
		g2.add(spbag1);
		g2.add(spbag2);
		g2P.add(spbag1);
		g2P.add(spbag2);
		
		bottomP2.add(g2P);
		//3) �湮 �ð� ���� �г�
		JPanel g3P = new JPanel();
		ButtonGroup g3 = new ButtonGroup();
		am = new JRadioButton("AM", false);
		pm= new JRadioButton("PM", false);
		am.setBackground(yellow);
		pm.setBackground(yellow);
		am.addItemListener(this);
		pm.addItemListener(this);
		//am,pm ������ ������ư����
		//�ð� ���� choice
		timeHour = new Choice();
		timeHour.addItemListener(this); //�������� ������ ������ �̺�Ʈ ���
		
		for(int i=0; i<timehour.length;i++) {
		timeHour.add(timehour[i]);} //���̽� ������ for��+�迭 �̿��� ����
		//�� ���� choice
		timeMin = new Choice();
		timeMin.addItemListener(this);
		for(int i=0; i<timeminuate.length;i++) {
			timeMin.add(timeminuate[i]);} //���̽� ������ for��+�迭 �̿��� ����
	
		g3P.add(new JLabel("�湮 �ð� ����           "));
		g3.add(am);
		g3.add(pm);
		//��ư�׷쿡 �߰�
		g3P.add(am);
		g3P.add(pm);
		//�гο� ���̱� (am,pm)
		g3P.add(timeHour);
		g3P.add(new JLabel(" : "));
		g3P.add(timeMin);
		//��, �� ������Ʈ �гο� ���̱�
		bottomP3.add(g3P);
		//���� ��ģ 3�� �г� ���� ���̱�
		//4) �� �ݾ� �ȳ� �г�
		JPanel g4P = new JPanel();
		JLabel front = new JLabel("�� �ݾ�: ");
		total = new JLabel("0");//����Ʈ ��
		JLabel back = new JLabel(" ��");
		//�г� 4���� ������Ʈ�� ���̱�
		g4P.add(front);
		g4P.add(total);
		g4P.add(back);
		front.setFont(font);
		total.setFont(font);
		back.setFont(font);
		//�ϴ� ���� ������Ʈ ���� �Ϸ�
		g1P.setBackground(yellow);
		g2P.setBackground(yellow);
		g3P.setBackground(yellow);
		g4P.setBackground(yellow);
		front.setBackground(yellow);
		back.setBackground(yellow);
		//���� ����
		bottomP.add(bottomP1);
		bottomP.add(bottomP2);
		bottomP.add(bottomP3);
		bottomP.add(g4P);
		
		//���� ������Ʈ ���� �Ϸ�
		JButton confirm = new JButton(butdefault);
		confirm.setRolloverIcon(buthover);
		confirm.setBorderPainted(false);//��ư �׵θ� ���� ����
		
		confirm.addActionListener(new Confirm());
		//innerclass�� action listener ����
		
		bottom.add(bottomP);
		bottom.add(confirm);
		add(bottom);
	}
	public void itemStateChanged (ItemEvent e) {
		Object o = e.getSource();
		if(o == pay1) {
			pw = 1; //�������� ���� ���ںο�-> ���߿� ����Ҷ� �����ؼ� ���
		}else if(o==pay2) {
			pw = 2;
		}else if(o==pay3) {
			pw = 3;
		}else if(o==spbag1) {
			spb = 0;
		}else if(o==spbag2) {
			spb = 1;
		}else if(o== am) {
			ap = 0; //am
		}else if(o== pm) {
			ap = 1; //pm
		}else if(o== timeHour) {
			hr = timeHour.getSelectedItem(); // �ð� ���ڿ��� �ֱ�
		}else if(o== timeMin) {
			mi = timeMin.getSelectedItem(); // �� ���ڿ��� �ֱ�
		}
	}
	//private ��Ű arraylist�� get�ϱ� ���� method ������ ����
	public ArrayList<MyCookie> getCookielist() {
		return cookielist;
	}
	//���� Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ ó�� ���� ������ inner class
	private class Confirm implements ActionListener { //���� Ȯ�� ��ư ó���� innerclass

		public void actionPerformed (ActionEvent e) {
			//orderoption ���� ���ϸ� �ֹ� �ȳѾ��
			if (pw < 0) {
				JOptionPane.showMessageDialog(null, "��� ���� �Է��ϼ���.","Error!",JOptionPane.ERROR_MESSAGE);
			}else if (spb < 0) {
				JOptionPane.showMessageDialog(null, "��� ���� �Է��ϼ���.","Error!",JOptionPane.ERROR_MESSAGE);	
			}else if (ap < 0) {
				JOptionPane.showMessageDialog(null, "��� ���� �Է��ϼ���.","Error!",JOptionPane.ERROR_MESSAGE);
			}else if (hr == "zero") {
				JOptionPane.showMessageDialog(null, "��� ���� �Է��ϼ���.","Error!",JOptionPane.ERROR_MESSAGE);		
			}else if (mi == "zero") {
				JOptionPane.showMessageDialog(null, "��� ���� �Է��ϼ���.","Error!",JOptionPane.ERROR_MESSAGE);		
			}else {//��� �ɼ��� �����ϸ鼭
				if(totalprice !=0) {//���̺��� ����� ���� ���� ��
				JOptionPane.showMessageDialog(null, "��û �Ϸ�Ǿ����ϴ�.","Permit",JOptionPane.INFORMATION_MESSAGE);
				optionset(totalprice, pw, ap, hr, mi, cookielist); //tab2�� ������ ���� ����
				DefaultTableModel tableModel = new DefaultTableModel(columName,0); 
				table.setModel(tableModel);
				//���̺� �ʱ�ȭ
				cookielist.clear();
				//���� ��� �ʱ�ȭ
				totalprice = 0;
				//�� ���� �ʱ�ȭ
				total.setText(String.valueOf(totalprice));
				//���� �� ����
				}else{//���̺��� ����� �ִ� ���
					JOptionPane.showMessageDialog(null, "�ֹ� ����� �����ϴ�. ","Error!",JOptionPane.ERROR_MESSAGE);}
			}
		}
	}
	//���̺� ���� ��Ű �߰��ϴ� method ���� 
	public void addCookies(MyCookie myCookie) {
		for(int i=0; i<cookielist.size(); i++) {
			if(cookielist.get(i).getName().equals(myCookie.getName())){//���� ��ǰ ���� �� �����ǰ�
				cookielist.get(i).setCnt(cookielist.get(i).getCnt()+myCookie.getCnt());
				renderTable();//���̺� ����
				return;
			}
		}
		cookielist.add(myCookie); //mycookie ��ü ���̺� ���� arraylist�� �߰�
		renderTable();//���̺� ����
		for(MyCookie cookie : cookielist) { //cookielist �迭�� for�� ������ consolâ�� ����ǰ�(Ȯ�ο�)
			System.out.println(cookie.getName()+" "+cookie.getPrice()+" "+cookie.getCnt());
		}
	}
	//Orderoption�� ���� Ȯ���� value�� �����ؼ� tab2���� ��밡���ϰ�
	
	public void optionset (int total, int pw, int ampm, String hour, String min, ArrayList<MyCookie> cookielist) {
		
		OrderOption orderOption = new OrderOption();
		
		orderOption.setPayway(pw);
		orderOption.setShoppingbag(spb);
		orderOption.setAmpm(ampm);
		orderOption.setHours(hour);
		orderOption.setMiuate(min);
		orderOption.setCookielist(cookielist);
		orderOption.setTotal(total);
		//�� value���� ����
		main.getTab2().setOrderOption(orderOption);
		//tab2���� ������ ���� ��밡���ϰ� �� ������ ��ü�� �Ű������� tab2 method ��������
	}

	//���̺� ���� method
	private void renderTable() {
		DefaultTableModel tableModel = new DefaultTableModel(columName,0);
		totalprice = 0;//�Ѿ� �ʱ�ȭ
		for (int i =0; i<cookielist.size();i++) { //��� ��Ű�� ���� ��� ���̺� ����
			String cookiename = cookielist.get(i).getName();
			int cookiecount = cookielist.get(i).getCnt();
			int cookieprice = cookielist.get(i).getPrice() * cookiecount;
			//�̸�, ����, ��Ű �� �� �ݾ� ���
			totalprice += cookieprice; //���� �հ�ݾ� ���
			Object[] data = {cookiename, cookiecount, cookieprice};
			//Object list ���� ���̺� �𵨿� �߰�
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
		//������ ���̺� �𵨷� ���̺� ����
		total.setText(String.valueOf(totalprice));
		//���� �� ����
	}
}
