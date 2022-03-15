import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//tab2에서 구매확정 버튼 누를 시 최종 확인 위한 다이얼로그
public class Submit extends JDialog {
	private Main main;
	private JPanel panel;
	private JLabel label1, label2;
	private JButton ok;
	//thread사용
	private TimerBar timerBar;
	private Thread threadBar;
	private TimerNum timerNum;
	private Thread threadNum;
	
	Font f = new Font("굴림", Font.BOLD, 20);

	public Submit(Main main) {
		this.main =main; //tab2와 연동하기 위해 main탭 받아오기 
		int second = 10; //시간 제한 10초로 설정
		
		panel = new JPanel();//다이얼로그 창에 붙일 패널
		panel.setLayout(null);
		//패널 타이머 위에 들어갈 안내문구 설정
		label1 = new JLabel("구매를 확정하시겠습니까?");
		label2 = new JLabel("확정 사항은 변경할 수 없습니다.");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		panel.add(label2);
		//라벨 패널에 붙이고 세팅, 폰트 설정
		label1.setBounds(30, 10, 400, 50);
		label2.setBounds(30, 60, 400, 50);
		label1.setFont(f);
		label2.setFont(f);
		//타임바, 카운트 다운 진행 할 스레드 생성
		timerBar = new TimerBar(second);//10초 넣어서
		threadBar = new Thread(timerBar);
		threadBar.start();
		panel.add(timerBar);
		timerNum = new TimerNum(second);
		threadNum = new Thread(timerNum);
		threadNum.start();
		panel.add(timerNum);
		//구매 확정버튼 
		ok = new JButton("구매확정");
		ok.addActionListener(new ActionListener() {	
			//구매 확정 버튼 누를 시 이벤트 핸들러 method override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//다이얼로그 창 끄기
				main.getTab2().setclear();//구매확정 버튼 누르면 tab2의 setclear메소드 작동해서 tab2 라벨 초기화됨
			}
		});
		panel.add(ok);//패널에 확인 버튼붙이기
		ok.setBounds(185, 180, 100, 50);
		//패널 붙이기
		add(panel);
		setTitle("구매 확정");
		setSize(470, 300);
		setVisible(true);
		setResizable(false);//사이즈 수정 불가
		setLocationRelativeTo(null);//중앙에 뜨게
	}
	//타이머 시간 다 됐을 때 자동으로 꺼지게 할 method 생성
	public void setvisible() {
		this.setVisible(false);
	}
	//시간 counting할 runnable 생성
	class TimerBar extends JLabel implements Runnable { //타임 바 설정
		int width = 400, height = 30; //타임 바 너비, 높이 설정
		int x = 5, y = 110;//붙일 위치
		Color color = new Color(255, 0, 0);//색
		
		int second; //매개 변수로 받을 second 정의

		public TimerBar(int second) {
			setBackground(color);//배경색 설정
			setOpaque(true);//보이게 설정
			setBounds(x, y, width, height);//붙일 위치, 너비, 높이 설정
			this.second = second;// 소환하는 상위 class의 second 값 받아서 적용
		}

		//run() method override하기
		public void run() {
			while (true) {//반복문
				try {
					Thread.sleep(1000);
					//1초에 1칸 분량씩 동일하게 줄어들게 
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (getWidth() > 0) {//stop대신 특정 조건에서만 작동하게
					width -= 40;	// 줄어들 1칸 분량 설정(40)
					//System.out.println(width);
					setBounds(x, y, width, height);
				} else { //시간 만료됐을 때 다이얼로그 창 꺼지게 위에서 정의한 method 이용
					setvisible();
					break;
				}
			}
		}
	}
	//타임바 옆에 카운팅 number할 runnable
	class TimerNum extends JLabel implements Runnable {
		int width = 45, height = 45; //숫자 너비, 높이
		int x = 405, y = 110; //세팅할 위치 
		
		int second; //마찬가지로 초 받아오기

		public TimerNum(int second) {
			setOpaque(true); //보이게 설정
			setBounds(x, y, width, height);
			setForeground(Color.red); //글씨 색 설정
			setText(second + ""); //라벨의 글씨 설정
			setFont(new Font("굴림", Font.PLAIN, 35)); //글씨체 설정
			setHorizontalAlignment(JLabel.CENTER);
			
			this.second = second;
		}

		//run() method override
		public void run() {
			while (true) {//무한반복
				try {
					Thread.sleep(1000);	// 1초
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (second > 0) {//stop대신 특정 조건에서만 작동하게
					second -= 1;		// 1초씩 줄어듦
					setText(second + "");
				} else {
					//else인 경우 반복문 탈출
					break;
				}
			}
		}
	}
}
