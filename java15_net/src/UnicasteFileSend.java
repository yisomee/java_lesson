import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class UnicasteFileSend extends JFrame implements ActionListener {
   JButton btn = new JButton("���Ϻ�����");

   public UnicasteFileSend() {
      add(btn);
      setSize(400,300);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      btn.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      JFileChooser fc = new JFileChooser();
      int state = fc.showOpenDialog(this);
      if(state==0) {
         try {
            DatagramSocket  ds = new DatagramSocket();//�������� ���� �ʿ�,�޴������������
            InetAddress ia = InetAddress.getByName("172.16.101.101");//�޴¼��� ����
            
            File f = fc.getSelectedFile(); //f�ȿ��� ���+���ϸ�
            FileInputStream fis = new FileInputStream(f); //����Ʈ�ΰ����ͼ� ����Ʈ�ξ���
            String filename = "FN##"+f.getName();//���ϸ��� �ʿ� -> ���ϸ������ϴϱ�
            
            //���� ������ -> ���ϸ���� 
            //���±��� �ϳ��ε� �����������´پ� ->���ϸ�,���ϳ����� �׷��Ƿ� ���ļ������� �޴��ʿ��� ����
            //��Ŷ���� ����
            
            //                           ���ϸ��� ����Ʈ�迭�ιٲ�
            //1.���ϸ�����
            DatagramPacket dp = new DatagramPacket(filename.getBytes(),filename.getBytes().length,ia,16000);
            ds.send(dp);
            
            while(true) {
               
               //2.���ϳ��뺸���� $%#$
               //read(byte[]b , int off, int len)
               byte fileContent[] = new byte[512]; //�ִ�512byte
               fileContent[0]='$';
               fileContent[1]='%';
               fileContent[2]='#';
               fileContent[3]='$';
               
               int cnt = fis.read(fileContent,4,508);//�����о���� //read�� ��byte�о����� ����
               if(cnt<=0) break; //read�� ������ ������ 0�� �̸��̸� �ݺ��� �ߴ�
               //��Ŷ�� ������� ����
               dp = new DatagramPacket(fileContent,cnt+4,ia,16000);
               //������
               ds.send(dp);
               System.out.println("cnt===>"+cnt+"bytes");
               
            }   
            fis.close();
            //�ݺ��� �����
            //2-2.�������޽��� ������ // 
            dp = new DatagramPacket("^%#$".getBytes(),4,ia,16000);
            ds.send(dp);
            
            ds.close();
            System.out.println("�������ۿϷ�......");
         }catch(Exception e) {
            
         }
      }
      
   }
   public static void main(String[] args) {
      new UnicasteFileSend();
   }

}