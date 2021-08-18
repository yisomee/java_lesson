import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;

public class PackMan2 extends JPanel implements KeyListener,Runnable {
   MyCanvas mc = new MyCanvas();
   Dimension dim;
   
   // ĵ������ x��ǥ, y��ǥ
   int x, y;
   // �̹��� ����Ʈ�� ����� ����
   int p=0;
   
   public PackMan2() {
      setLayout(new BorderLayout());//�г��� �÷ο췹�̾ƿ����� �ٲ����� 
      add(mc);//ĵ������ ���� ������. 

      mc.setFocusable(true);
      
      // �̺�Ʈ ��� -- Ű �̺�Ʈ
      mc.addKeyListener(this); // �޼���� ���� Ŭ������ �ִ�. this
      
    //  Thread t = new Thread(this);
      //t.start();
     
    
    }
         public void setCanvasSize() {
                     dim = mc.getSize(); //ĵ���� ������ 
                     x = (int) dim.getWidth()/2 - 25;
                     y = (int) dim.getHeight()/2 -25;
                     System.out.println("x="+dim.getWidth()+",h="+dim.getHeight());
     
         }
         public void packmanStart(PackMan2 pm) {
       	  setCanvasSize();
       	  Thread t = new Thread(pm);
       	  t.start();
       	  
         }
         public void run() {
            while(true) {
            mc.repaint();
            // �̹��� ��ȯ // �������� �̵� 0,1   2,3      4,5      6,7
            if(p%2==0) p++;
            else p--;
            // ��ǥ �̵� // �������� �̵�
            if(p==0 || p==1) { // �������� �̵�
               x-=5;
               if(x<=-50) x = (int) dim.getWidth();
            } else if(p==2 || p==3) {
               x+=5;
               if(x>=dim.getWidth())x=-50;
            } else if(p==4 || p==5) {
               y-=5;
               if(y<=50) y=(int) dim.getHeight();
            }else if(p==6||p==7) {
               y+=5;
               if(y>dim.getHeight()) y=-50;
            
               
            }   //else if(p==)
            // �ð� ����
            try {
               Thread.sleep(200);
               } catch(Exception e) {
          
           }
         }
      }
            
      
   
   class MyCanvas extends Canvas{
      Image packMan;
      MyCanvas(){
       
         packMan = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
      }
      
      public void paint(Graphics g) {
         //                canvas                  img
         //                              p=0      0,    0,    50,   50
         //                              p=1      50, 0, 100, 50
         //                              p=2      100,0, 150,   50
         //                              p=3      150,0, 200, 50
         g.drawImage(packMan, x, y, x+50, y+50,   p*50, 0, p*50+50, 50, this);            
      }
   }
   
   // KeyEvent �������̵�
   public void keyPressed(KeyEvent ke) {}
   
   public void keyReleased(KeyEvent ke) {
      int code = ke.getKeyCode();
      if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) { // ���� ����Ű
         p=0;
      } else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
         p=2;
      } else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
         p=4;
      } else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_X) {
         p=6;
      }
      
      
      //System.out.println(key); // 37,38,39,40 < ^ > �Ʒ�
   }

   public void keyTyped(KeyEvent ke) {}
   
}   

//   public static void main(String[] args) {
//      new PackMan1();
//
//   }