import javax.swing.*;

public class Main {
	private JFrame frame;
	private Tab1 tab1;
	private Tab2 tab2;
	private Tab3 tab3;

	public Main() {
		frame = new JFrame();
		frame.setTitle("��Ű ���� �ý���"); // ���α׷� �̸� ����
		frame.setSize(1100,820); //������ ������ ����
		frame.setResizable(false); //������ ������ �Ұ���
		frame.setLocationRelativeTo(null); //������ �� ����� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ��ư ������ â ����
		JTabbedPane maintab = new JTabbedPane();//�� �г� ����
		tab1 = new Tab1(this); //�� 1-����ȭ�� ����
		tab2 = new Tab2(this); //�� 2 - ���������� ����
		tab3 = new Tab3(this); //�� 3 - ��ٱ��� ����
		maintab.addTab("����ȭ��",tab1);
		maintab.addTab("����������",tab2);
		maintab.addTab("��ٱ���",tab3); //�����ǿ� ���̱�
		
        frame.getContentPane().add(maintab); //�� �����ӿ� ���̱�
        frame.setVisible(true); // â ���̰��ϱ�
        
	}
	
	public Tab1 getTab1() {
		return tab1;
	}
	
	public Tab2 getTab2() {
		return tab2;
	}
	
	public Tab3 getTab3() {
		return tab3;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
	
}
