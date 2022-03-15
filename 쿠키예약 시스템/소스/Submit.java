import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//tab2���� ����Ȯ�� ��ư ���� �� ���� Ȯ�� ���� ���̾�α�
public class Submit extends JDialog {
	private Main main;
	private JPanel panel;
	private JLabel label1, label2;
	private JButton ok;
	//thread���
	private TimerBar timerBar;
	private Thread threadBar;
	private TimerNum timerNum;
	private Thread threadNum;
	
	Font f = new Font("����", Font.BOLD, 20);

	public Submit(Main main) {
		this.main =main; //tab2�� �����ϱ� ���� main�� �޾ƿ��� 
		int second = 10; //�ð� ���� 10�ʷ� ����
		
		panel = new JPanel();//���̾�α� â�� ���� �г�
		panel.setLayout(null);
		//�г� Ÿ�̸� ���� �� �ȳ����� ����
		label1 = new JLabel("���Ÿ� Ȯ���Ͻðڽ��ϱ�?");
		label2 = new JLabel("Ȯ�� ������ ������ �� �����ϴ�.");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		panel.add(label2);
		//�� �гο� ���̰� ����, ��Ʈ ����
		label1.setBounds(30, 10, 400, 50);
		label2.setBounds(30, 60, 400, 50);
		label1.setFont(f);
		label2.setFont(f);
		//Ÿ�ӹ�, ī��Ʈ �ٿ� ���� �� ������ ����
		timerBar = new TimerBar(second);//10�� �־
		threadBar = new Thread(timerBar);
		threadBar.start();
		panel.add(timerBar);
		timerNum = new TimerNum(second);
		threadNum = new Thread(timerNum);
		threadNum.start();
		panel.add(timerNum);
		//���� Ȯ����ư 
		ok = new JButton("����Ȯ��");
		ok.addActionListener(new ActionListener() {	
			//���� Ȯ�� ��ư ���� �� �̺�Ʈ �ڵ鷯 method override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//���̾�α� â ����
				main.getTab2().setclear();//����Ȯ�� ��ư ������ tab2�� setclear�޼ҵ� �۵��ؼ� tab2 �� �ʱ�ȭ��
			}
		});
		panel.add(ok);//�гο� Ȯ�� ��ư���̱�
		ok.setBounds(185, 180, 100, 50);
		//�г� ���̱�
		add(panel);
		setTitle("���� Ȯ��");
		setSize(470, 300);
		setVisible(true);
		setResizable(false);//������ ���� �Ұ�
		setLocationRelativeTo(null);//�߾ӿ� �߰�
	}
	//Ÿ�̸� �ð� �� ���� �� �ڵ����� ������ �� method ����
	public void setvisible() {
		this.setVisible(false);
	}
	//�ð� counting�� runnable ����
	class TimerBar extends JLabel implements Runnable { //Ÿ�� �� ����
		int width = 400, height = 30; //Ÿ�� �� �ʺ�, ���� ����
		int x = 5, y = 110;//���� ��ġ
		Color color = new Color(255, 0, 0);//��
		
		int second; //�Ű� ������ ���� second ����

		public TimerBar(int second) {
			setBackground(color);//���� ����
			setOpaque(true);//���̰� ����
			setBounds(x, y, width, height);//���� ��ġ, �ʺ�, ���� ����
			this.second = second;// ��ȯ�ϴ� ���� class�� second �� �޾Ƽ� ����
		}

		//run() method override�ϱ�
		public void run() {
			while (true) {//�ݺ���
				try {
					Thread.sleep(1000);
					//1�ʿ� 1ĭ �з��� �����ϰ� �پ��� 
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (getWidth() > 0) {//stop��� Ư�� ���ǿ����� �۵��ϰ�
					width -= 40;	// �پ�� 1ĭ �з� ����(40)
					//System.out.println(width);
					setBounds(x, y, width, height);
				} else { //�ð� ������� �� ���̾�α� â ������ ������ ������ method �̿�
					setvisible();
					break;
				}
			}
		}
	}
	//Ÿ�ӹ� ���� ī���� number�� runnable
	class TimerNum extends JLabel implements Runnable {
		int width = 45, height = 45; //���� �ʺ�, ����
		int x = 405, y = 110; //������ ��ġ 
		
		int second; //���������� �� �޾ƿ���

		public TimerNum(int second) {
			setOpaque(true); //���̰� ����
			setBounds(x, y, width, height);
			setForeground(Color.red); //�۾� �� ����
			setText(second + ""); //���� �۾� ����
			setFont(new Font("����", Font.PLAIN, 35)); //�۾�ü ����
			setHorizontalAlignment(JLabel.CENTER);
			
			this.second = second;
		}

		//run() method override
		public void run() {
			while (true) {//���ѹݺ�
				try {
					Thread.sleep(1000);	// 1��
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (second > 0) {//stop��� Ư�� ���ǿ����� �۵��ϰ�
					second -= 1;		// 1�ʾ� �پ��
					setText(second + "");
				} else {
					//else�� ��� �ݺ��� Ż��
					break;
				}
			}
		}
	}
}
