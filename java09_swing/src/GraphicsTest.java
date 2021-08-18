import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{
	MyCanvas canvas = new MyCanvas();
	public GraphicsTest() {
		System.out.println("GraphicsTest");
		add(canvas);
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public class MyCanvas extends Canvas{
		public MyCanvas() {
			System.out.println("MyCanvas");
			
		}
		public void paint(Graphics g) {
			//�׸��� �׸���.
			g.drawLine(100,100,500,500);
			//�׸��� �׸������� �÷� �����ϰ� �׸��� �׸���.
			g.setColor(Color.red);
			g.drawLine(100,500,500,100);
			//			x	y	w	h
			g.drawOval(200,200,300,300);
			g.drawRect(200,200,300,300);
			g.setColor(Color.green);
			g.fillOval(300, 300, 300, 300);
			g.fillRect(100,100,300,300);
			
			g.setColor(Color.blue);
			int[] x = {100,170,250,50};
			int[] y = {50,50,230,200};
			g.drawPolygon(x,y,x.length);
			
			g.drawRoundRect(300, 300, 500, 500, 50, 50);//�ձ� �簢��
			
			//���ڸ� �׸���
			String txt = "JAVA ���α׷���";
			g.setColor(Color.magenta);
			g.setFont(new Font("����ü",Font.BOLD,40));
			g.drawString(txt, 100, 100);
		}
	}
	public static void main(String[] args) {
		new GraphicsTest();
	}

}
