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
	Font f = new Font("굴림", Font.PLAIN, 20);
	Font fbutton = new Font("굴림", Font.BOLD, 30);
	
	public Tab2(Main main) {
		this.main=main; 
		setBackground(Color.white);
		check = new JPanel();
		check.setPreferredSize(new Dimension(800,700));
		//주문확인 패널 사이즈 고정
		check.setLayout(new GridLayout(6,0));//세로 6칸 격자 생성
		check.setBorder(new TitledBorder(new LineBorder(Color.blue,3),"주문확인"));
		//패널 테두리 설정
		check.setBackground(bluee);
		//패널 배경색 설정
		namelabel = new JLabel("주문 품목 명: "+ cookiename+"... ");
		timelabel =new JLabel("예약시간: "+ ampm +" "+hour+"시 "+min+"분 ");
		baglabel = new JLabel("쇼핑백 여부: "+shoppingbag);
		paylabel = new JLabel("결제 수단(선결제) : "+payment);
		totallabel = new JLabel("총 금액 : "+total +"원 ");
		//주문확인에 들어갈 컴포넌트 디폴트 만들어서 넣기 (변수선언 시 초기화 해줘서 내용물은 공백으로 표시)
		namelabel.setFont(f);
		timelabel.setFont(f);
		baglabel.setFont(f);
		paylabel.setFont(f);
		totallabel.setFont(f);
		//각 라벨 폰트 맟춰주기
		check.add(namelabel);
		check.add(timelabel);
		check.add(baglabel);
		check.add(paylabel);
		check.add(totallabel);
		//각 라벨 컴포넌트 패널에 더하기
		JButton confirm = new JButton("구매 확정");
		confirm.setBorderPainted(false); //외곽 테두리 없앰
		confirm.setFocusPainted(false); //focus시 테두리 없앰
		confirm.setFont(fbutton); 
		confirm.setBackground(yellow);
		confirm.addActionListener (new ActionListener() {
			//오버라이드 
			public void actionPerformed(ActionEvent e) {
				if(total !=0) { //예약 확정된 상태에서만 구매 확정 가능하게
				popup = new Submit(main); //구매확정 버튼 클릭시 구매확정 다이얼로그 생성 	
				}else {//예약 확정 아닐 시 경고 팝업 
					JOptionPane.showMessageDialog(null, "주문 목록이 없습니다.","Error!",JOptionPane.WARNING_MESSAGE);
				}
			}});// statement에 담기 버튼에 대한 액션 이벤트 핸들링 method overriding
		
		check.add(confirm); //구메확정 버튼 패널에 붙이기
		add(check);
	}//생성자 정의 끝
	//method정의 
	public void setOrderOption(OrderOption orderOption) {
		
		cookiename = orderOption.getCookielist().get(0).getName();//cookielist의 요소 중 cookielist(주문 리스트)의 첫번째 인덱스의 객체에서 쿠키이름 속성 얻어 저장
		total = orderOption.getTotal(); //총합 개수 얻어 저장
		hour = orderOption.getHours(); //방문 시간 얻어 저장
		min = orderOption.getMiuate(); 
		//나머지 옵션은 숫자로 값을 저장했기에 출력할 때 각 숫자에 대응하는 문자로 전환작업 거쳐야 함
		if(orderOption.getAmpm() ==0) {
			ampm ="AM";
		}else if(orderOption.getAmpm() == 1) {
			ampm ="PM";
		}
		//AMPM 전환
		if(orderOption.getPayway()==1) {
			payment = "신용카드";
		}else if(orderOption.getPayway() ==2) {
			payment = "카카오페이";
		}else if(orderOption.getPayway() ==3) {
			payment = "페이코";
		}
		//결제 방식 전환
		if(orderOption.getShoppingbag() == 0) {
			shoppingbag ="쇼핑백 O";
		}else if(orderOption.getShoppingbag() ==1) {
			shoppingbag = "쇼핑백 X";
		}
		//쇼핑백 여부 전환
		render();
		//갱신된 값으로 라벨들 재출력	
	}
	//라벨 채출력 method
	public void render() {
		namelabel.setText("주문 품목 명: "+ cookiename+"... ");
		timelabel.setText("예약시간: "+ ampm +" "+hour+"시 "+min+"분 ");
		baglabel.setText("쇼핑백 여부: "+shoppingbag);
		paylabel.setText("결제 수단(선결제) : "+payment);
		totallabel.setText("총 금액 : "+total +"원 ");
	}
	//주문 확정-> 확인 시 라벨에 담긴 값들 초기화
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
