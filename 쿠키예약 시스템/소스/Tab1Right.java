import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Tab1Right extends JPanel{
	private Main main;
	private JLabel pic; //top�г� �� �̹���
	private JLabel[] imagelabel = new JLabel[4]; //bottom�г� �� ���� �� 
	private JLabel need; //��� ���� ���� �� ��
	private Cookie cookie; //��Ű class ��ü ����
	JPanel top, bottom; 
	public int a = 0; //��� �̺�Ʈ�� ���
	private int needn = 1;//���� ������ ���� (��� ���� ����)

	Font f =new Font("����", Font.BOLD,20); //�� ��Ʈ
	Color btcolor = new Color(255,255,204);//�ϴ� �гο� ���� �� ����
	
	
	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
	} //���� �гηκ��� ��Ű ���� �޾ƿ�
	public Tab1Right(Main main) { //���� Ŭ���� ���ؼ� �ٸ� Ŭ���� �����ϱ� ���� main ���ڷ�
		this.main = main; 
		setLayout(new GridLayout(2,0));	// ũ�� 2�κ����� ����
		setPreferredSize(new Dimension(300,800)); //������ �г� ������ ���ϱ�
		setMaximumSize(this.getPreferredSize());//������ ����
		setMinimumSize(getPreferredSize());
		//����ũ�⿡ ���� �г� ������ ����
		
		top = new JPanel(); //�г� �� ������ ���� �г�(���� ����)
		bottom = new JPanel(); //�г� �Ʒ� ������ ���� �г�(��������)
		bottom.setLayout(new GridLayout(5,0)); //�Ʒ� ������ 5�� ��� ���� ���� ����
		//top�гο� �� ������Ʈ ����
		pic = new JLabel(); //���� �� �� ����
		pic.setHorizontalAlignment(JLabel.CENTER);//�� �߾� ����
		pic.setBorder(BorderFactory.createEmptyBorder(50,0,0,0)); //���� ���� ���� 50
		top.setBackground(Color.white); //�� �г� ��� �� ���
		top.add(pic); //�̹��� �� �� ����
		
		//bottom �гο� �� ������Ʈ ����
		bottom.setBackground(btcolor); //�Ʒ� �г� ���� ����
		for (int i =0;i<4;i++) { //for������ �Ʒ� �� ������ �� �� ����
			imagelabel[i] = new JLabel();
			imagelabel[i].setHorizontalAlignment(JLabel.CENTER);
			imagelabel[i].setFont(f);
			bottom.add(imagelabel[i]); //�ϴ� �гο� �����Ѵ�� �� �ֱ�
		}
		
		JPanel combobox = new JPanel(); //���� �� �г� ����
		combobox.setBackground(new Color(204,229,255));//���� �г� �� ����
		combobox.setLayout(new FlowLayout());
		
		JButton minusButton = new JButton("-"); //���̳ʽ� ��ư����
		minusButton.setFocusPainted(false);
        minusButton.setBounds(20, 390, 50, 30); //���̳ʽ� ��ư ��ġ ����
        combobox.add(minusButton);//���� �гο� ����
        minusButton.setBackground(Color.white); //��ư ����
		
        need = new JLabel("1"); //���� ���� ǥ���� �� (�⺻: 1)
        need.setBounds(80, 390, 80, 30);//��ġ ����
        combobox.add(need); //���̳ʽ���ư ���� ���
        //���� ���� ���� ������Ʈ ����
        JButton plusButton = new JButton("+"); //�÷��� ��ư
		plusButton.setFocusPainted(false);
		plusButton.setBounds(100, 390, 50, 30);
		combobox.add(plusButton);
        plusButton.setBackground(Color.white);
       //��� ��ư ����
        JButton ok = new JButton("���");
		ok.setFocusPainted(false);
		combobox.add(ok);
		ok.addActionListener(new ActionListener() { //��� ������ �� �̺�Ʈ ������
			public void actionPerformed(ActionEvent e) {
				if (cookie.getInventory() <= 0) { //cookie�� ���� �� ��� ���� üũ-> 0���� �۰ų� ������(ǰ��)
					JOptionPane.showMessageDialog(null, "��� ����.","Sorry",JOptionPane.WARNING_MESSAGE);
					//��� ���� �޽��� -> �ƹ��ϵ� �߻�X
				}else {//��� ����������
					main.getTab3().addCookies(new MyCookie(cookie, cookie.getName(), cookie.getPrice(), needn));
					//���� �������� getTab3 function�� �̿��� Tab3Ŭ������ addCookies method ���
					//(���� ��Ű ����Ʈ�� �ش� ��Ű ����, ���� �߰� MyCookie ��ü�� ����� �߰�)
					cookie.setInventory(cookie.getInventory()-needn);
					//��� ��Ű �ܿ��� ���� (���� ����-���� ����)
					if(cookie.getInventory() <= 0) { //��� ���� ��Ű �ܿ����� 0�϶�
						imagelabel[3].setText("��� ����"); //��� ��-> ��� �������� ��ȯ
						needn = 0; // ��� ���� 0���� ����(�����)
						need.setText("X"); //��� ���� ǥ�� X�� ǥ��
					}else {
						imagelabel[3].setText("����: "+ cookie.getInventory()+"��"); //���ŵ� ���� ���� ǥ��
						needn = 1; //��� ���� �ʱ�ȭ
						need.setText(Integer.toString(needn)); //��� ���� ǥ�� 1�� �ʱ�ȭ
					}
				}
			}
		}); // statement�� ��� ��ư�� ���� �׼� �̺�Ʈ �ڵ鸵 method overriding
        
        plusButton.addActionListener(new ActionListener() { //�÷�����ư �̺�Ʈ ������
			public void actionPerformed(ActionEvent e) {
				if (needn >= cookie.getInventory()) { //��� ������ ��� �ʰ��� ��
					JOptionPane.showMessageDialog(null, "��� ���� �̻� ������ �� �����ϴ�.","Error!",JOptionPane.ERROR_MESSAGE);
					//��� ���� �޽��� ǥ�� -> �ƹ� �� X
				}else {
					needn++; //���� ������ ��� �����϶� -> ������ +1
					need.setText(Integer.toString(needn)); //+1�� ������ ����
				}
			}
		}); // statement�� �÷��� ��ư�� ���� �׼� �̺�Ʈ �ڵ鸵 method overriding
        
        minusButton.addActionListener(new ActionListener() {//���̳ʽ� ��ư �̺�Ʈ ������
			public void actionPerformed(ActionEvent e) {
				if(needn <= 1) { //������ 1�� �̸����� ������ ��
					JOptionPane.showMessageDialog(null, "���� ���� �ּҼ����� 1 ���Դϴ�.","Error!",JOptionPane.ERROR_MESSAGE);
					//�ּҼ��� �˸� �޽��� ǥ��-> �ƹ� �� �߻�X
				}else { //1�� �ʰ��� ���¿��� ���̳ʽ� �۵� ������ ��
					needn--; //��� ���� -1 ���� �۵�
					need.setText(Integer.toString(needn)); //-1�� ���� ����
				}
			}
		});
        
		bottom.add(combobox); //���� ���� �г� �Ʒ� �гο� ���̱�		
		add(top);
		add(bottom);
		//���������� �гε� ���������� ���̱�

	}
	public void setSelectedCookieUI(Cookie cookie) { //Tab1Right class�� method-> ���� �г� ��Ű UI����� �޼ҵ� (���гο��� �۵�)
		this.cookie = cookie; //�Ű������� ��Ű ��ü �޾ƿ�
		pic.setIcon(new ImageIcon("../img/"+cookie.getImg()+"Big.png"));
		//��Ű ��ü�� getImg() method �̿��ؼ� img ���� �� (=�̹��� ���� �̸�) ��������
		imagelabel[0].setText("��ǰ��: "+ cookie.getName());
		imagelabel[1].setText("���: "+ cookie.getdescription());
		imagelabel[2].setText("����: "+ cookie.getPrice()+"��");
		imagelabel[3].setText("����: "+ cookie.getInventory()+"��"); 
		//�Ű������� ����Ű�� ��Ű ��ü ������ UI ����
		if(cookie.getInventory() <= 0) { //�Ӽ� �� ��� �Ӽ� üũ-> ������ == ǰ���϶�
			imagelabel[3].setText("��� ����"); //ǰ�� ǥ�� (���� �� ����)
			needn = 0; // ���� ���� 0���� ����-> �����
			need.setText("X"); //���� ���� �� X�� ǥ��
		}else { //��Ű ǰ�� �ƴҶ�
			needn = 1;
			need.setText(Integer.toString(needn)); //����Ʈ �� 1�� ����
		}
	}
	//�г� UI �����ϴ� method (ó�� ȭ�� ���� �� Main���� ���)
	public void render() {
		pic.setIcon(new ImageIcon("../img/"+cookie.getImg()+"Big.png"));
		imagelabel[0].setText("��ǰ��: "+ cookie.getName());
		imagelabel[1].setText("���: "+ cookie.getdescription());
		imagelabel[2].setText("����: "+ cookie.getPrice()+"��");
		imagelabel[3].setText("����: "+ cookie.getInventory()+"��");
	}
} 