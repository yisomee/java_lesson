import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class PacMan extends JFrame implements KeyListener {
	
	MyCanvas canvas = new MyCanvas();
	Image img;
	int keyCode;
	int WofPackMan;
	int HofPackMan;
	int currentX1 = 100;
	int currentY1 = 100;
	int currentX2;
	int currentY2;
	boolean openMouth = true;

	public PacMan() {
		add(canvas);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		addKeyListener(this);
//		setFocusable(true);
	}
	
	public class MyCanvas extends Canvas {
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
			this.requestFocusInWindow();
		}
		
		public void paint(Graphics g) {
			WofPackMan = img.getWidth(this);
			HofPackMan = img.getHeight(this);
			if(keyCode == KeyEvent.VK_RIGHT) {
				moveRight(g);
			} else if(keyCode == KeyEvent.VK_LEFT) {
				moveLeft(g);
			} else if(keyCode == KeyEvent.VK_UP) {
				moveUp(g);
			} else if(keyCode == KeyEvent.VK_DOWN) {
				moveDown(g);
			}
			currentX2 = currentX1+WofPackMan/8;
			currentY2 = currentY1+HofPackMan;
			openMouth = !openMouth;
			
			if(currentX2<0) {
				currentX1 += 500;
				currentX2 += 500;
			} else if(currentX2>500) {
				currentX1 -= 500;
				currentX2 -= 500;
			} else if(currentY1<0) {
				currentY1 += 500;
				currentY2 += 500;
			} else if(currentY2>500) {
				currentY1 -= 500;
				currentY2 -= 500;
			}
		}
	}
	
	// Ű �̺�Ʈ ������ > �׳� ��� ������ keyCode�� Ű���� �����ϰ� canvas�� repaint�� �ϸ� �ȴ�
	public void keyPressed(KeyEvent e) {
		keyCode = e.getKeyCode();
		canvas.repaint();
	}
	
	public void moveLeft(Graphics g) {
		currentX1 -= 10;
		currentX2 -= 10;
		if(openMouth == true) {
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, WofPackMan/8, 1, WofPackMan*2/8, HofPackMan, this);
		} else {
			//1�� �Ѹ�		�׷����� ����									�̹����� �κ�
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, 1, 1, WofPackMan/8, HofPackMan, this);
		}
	}
	public void moveRight(Graphics g) {
		currentX1 += 10;
		currentX2 += 10;
		if(openMouth == true) {
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, WofPackMan*2/8, 1, WofPackMan*3/8, HofPackMan, this);
		} else {
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, WofPackMan*3/8, 1, WofPackMan*4/8, HofPackMan, this);
		}
	}
	public void moveUp(Graphics g) {
		currentY1 -= 10;
		currentY2 -= 10;
		if(openMouth == true) {
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, WofPackMan*4/8, 1, WofPackMan*5/8, HofPackMan, this);
		} else {
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, WofPackMan*5/8, 1, WofPackMan*6/8, HofPackMan, this);
		}
	}
	public void moveDown(Graphics g) {
		currentY1 += 10;
		currentY2 += 10;
		if(openMouth == true) {
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, WofPackMan*6/8, 1, WofPackMan*7/8, HofPackMan, this);
		} else {
			g.drawImage(img, currentX1, currentY1, currentX2, currentY2, WofPackMan*7/8, 1, WofPackMan*8/8, HofPackMan, this);
		}
	}
	
	
	// �Ƚᵵ �Ǵµ� ���Ǵ� �ؾ� �ϴ� �߻� �޼ҵ��
	public void keyReleased(KeyEvent ke) {			
	}
	public void keyTyped(KeyEvent ke) {		
	}

	// �����
	public static void main(String[] args) {
		new PacMan();
	}

}

// ����Ű�� �̵�
// ĭ �Ѿ�� �ݴ��ʿ��� ����