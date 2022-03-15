import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tab1Left extends JPanel{
	private Tab1Right panel; //오른쪽 패널 참조
	private Cookie[] cookies = {new Cookie("walnut", "월넛 초코칩 쿠키","호두 + 초코칩", 3400, 5), 
			new Cookie("malcha", "말차 화이트 쿠키", "녹차 + 화이트 초코칩", 3500, 5), new Cookie("oreo", "오레오 스모어 쿠키", "마시멜로우 + 화이트 초코칩 + 오레오", 3500, 5), 
			new Cookie("lotus", "로투스 스모어 쿠키", "마시멜로우 + 카라멜 소스 + 로투스", 3400, 5), new Cookie("cheese", "치즈치즈 쿠키", "크림치즈 + 황치즈 + 리츠", 3400, 5)};
			//쿠키 정보 1-> 객체 1개로 만들어 세팅
	JButton[] leftb = new JButton[5]; //패널 왼쪽에 뜰 쿠키 담을 버튼

	
	public Tab1Left(){
		
		ScrollPane sp = new ScrollPane();//격자 붙일 스크롤
		JPanel leftP = new JPanel(); //스크롤 위에 붙일 패널

		leftP.setLayout(new GridLayout(5,0)); //패널 격자 생성 세로 5칸
		leftP.setBackground(Color.white);//배경색 설정
		sp.setSize(300, 750); //스크롤패널 사이즈 설정
		//배경 세팅
		for(int i=0; i<cookies.length; i++) { //5칸에 들어갈 쿠키 사진 아이콘 만들기
			Cookie cookie = cookies[i]; // 위에서 입력한 쿠키 정보 Cookie 클래스에 세팅
			ImageIcon image = new ImageIcon("../img/"+cookies[i].getImg()+".png");
			//이미지 아이콘 생성 (쿠키 class에서 getImg method 이용(객체에서 첫번째 요소인 walnut등 이미지 이름 전달)
			leftb[i] = new JButton(image); //버튼에 이미지 아이콘 넣기
			//쿠키 아이콘들 생성
			leftb[i].addActionListener(new ActionListener() {//각 아이콘 이벤트 리스너추가
			    public void actionPerformed(ActionEvent e) {
			    	panel.setSelectedCookieUI(cookie);//오른쪽 패널의 선택 쿠키 UI세팅 method 실행
			    		
			    }
			});//한 줄에 이벤트 핸들러 statement
			leftb[i].setBorderPainted(false); //테두리 투명 설정
			leftb[i].setContentAreaFilled(false); //배경색 없앰
			
			leftP.add(leftb[i]); // 왼쪽 패널에 아이콘들 넣기(격자 당 한개씩)
		}
		//왼편에 붙일 패널에 쿠키버튼 세팅 완료
		sp.add(leftP); //스크롤패널에 세팅된 패널 붙이기
		add(sp);//스크롤 패널 왼쪽 패널에 붙이기
	}
	
	public void connectRight(Tab1Right panel) { //오른쪽 패널에서 쓸 setPanel 정의
		this.panel = panel; //왼쪽 패널과 오른쪽 패널 서로 참조해 연결되게
		panel.setCookie(cookies[0]); //처음 들어갔을 때 right패널에 첫번째 쿠키 나오도록 설정
	}
	
	public void renderTab1Right() { //오른쪽 패널 랜더링 (선택에 따라 UI 바뀌도록)
		panel.setSelectedCookieUI(cookies[0]); //장바구니 탭에서 초기화 후 메인탭으로 돌아갔을 때 첫번째 쿠키 정보 띄움
	}

}
