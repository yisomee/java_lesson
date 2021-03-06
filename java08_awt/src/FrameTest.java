import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

// 컨테이너 Frame상속받아 구현하기
public class FrameTest extends Frame{
	Point xy = new Point(500,300);
	Dimension wh = new Dimension(500,300);
	Rectangle rect = new Rectangle(100,100,400,400);
	public FrameTest() {
		// 창의 제목
		//setTitle("프레임생성연습중");
		super("하위에서 제목설정");// Frame("하위에서 제목설정")	
		// 창의 크기
		//setSize(500,400);
		//setSize(wh);
		setBounds(rect);
		//         x   y   w   h
		//setBounds(200,200,500,400);Rectangle x,y,w,h, 보관
		
		//setSize(500,500);// w. h Dimension 폭과 높이
		//setLocation(300,300);// x,y Point 창위치 폭과 높이 좌표  띄우기 
		// 창을 보여주기
		
		//타이틀바에 이미지아이콘 추가하기
		 //Toolkit tk = Toolkit.getDefaultToolkit();
		 //Image icon = tk.getImage("img/book.jfif");
		 
		 Image icon = Toolkit.getDefaultToolkit().getImage("img/book.jfif");
		 setIconImage(icon);
		 
		 //Button추가
		 Button btn = new Button("버튼");
		 add(btn);
		 
		 Button btn1 = new Button("111111");
		 Button btn2 = new Button("222222");
		 Button btn3 = new Button("333333");
		 Button btn4 = new Button("444444");
		 
		 add(BorderLayout.NORTH, btn1);
		 add("South",btn2);
		//add("East",btn3);
		 add(BorderLayout.EAST, btn3);
		 add(BorderLayout.WEST, btn4);
		 
		 
		 
		 setVisible(true);//true:보여줌, false:안보여줌
	}

	public static void main(String[] args) {
		new FrameTest();

	}

}
