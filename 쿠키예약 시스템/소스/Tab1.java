import java.awt.*;
import javax.swing.*;

public class Tab1 extends JPanel{
	private Main main;
	private Tab1Left pn1;
	private Tab1Right pn2; //���� ����, ������ �����ؼ� ����
	
	public Tab1(Main main) {
		this.main = main; //Main�� �Ű������� ���� 
		
		pn1 = new Tab1Left(); //Tab1Left ����
		pn2 = new Tab1Right(main); //������ �г� main�� �����ؼ� left tab�� �޼ҵ� ����ҰŶ� �Ű������� ��
		
		pn1.connectRight(pn2); //������ �гο� ���� �г� ��Ű ������ ������ ����(�⺻: ù��° ��Ű set)
		pn2.render(); //������ �г� ù��° ��Ű ���� �⺻ ���� (Ű�ڸ��� ������ ��Ű �г� ����Ʈ �� �����ְ�)
		
		pn1.setLayout(null); //���� �г� ���̾ƿ� ������

		
		setLayout(new GridBagLayout());
		
		//����<-> ������ �г� ���� ������ ���� �׸���� ���̾ƿ�
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH; //x,y�� ��ä��

        gbc.weightx=0.1; // ���� ���� 2:1
        gbc.weighty=0.1; // ���� ���� 1:1
        gbc.gridx=0;  
        gbc.gridy=0; 
        add(pn1,gbc); // 0,0 ��ġ�� �г� ��ġ

        gbc.weightx=0.2;
        gbc.weighty=0.1; // ���� ���� 1:1
        gbc.gridx=1;  
        gbc.gridy=0; 
        add(pn2,gbc); // 0,1 ��ġ�� �г� ��ġ
		
	}

	public Tab1Left getTab1Left() {
		return pn1; //Tab1���� Tab1Left�� ��ȯ�ϴ� method (�ٸ� class���� tab1left���� -> Tab3���� ���)
	}
}
