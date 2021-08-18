import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
//								default : BorderLayout
public class JFrameTest extends JFrame {
	ImageIcon icon1 = new ImageIcon("img/flower.jpg");
	ImageIcon icon2 = new ImageIcon("img/bbbbb.jfif");
	ImageIcon icon3 = new ImageIcon("img/aaaaa.jfif");
	public JFrameTest() {
		//BorderLayout�� GridLayout���� �����ϱ�
		GridLayout layout = new GridLayout(3,2,10,10);
		setLayout(layout);
		
		JButton btn1 = new JButton("��ư1");
		add(btn1);
		JButton btn2 = new JButton(icon1);
		add(btn2);
		//���콺�� ��ư ������ icon �ٲٱ�
		btn2.setPressedIcon(icon2);
		//���콺 ������ icon�ٲٱ�(�÷��� ������ icon�� 3���� �ٲ�)
		btn2.setRolloverIcon(icon3);
		JButton btn3 = new JButton("�ɺ�", icon1);
		add(btn3);
		//��ư�� Ȱ��ȭ(true) ��Ȱ��ȭ(false)
		btn3.setEnabled(false);
		
		JButton btn4 = new JButton("�׹�°��ư");
		add(btn4);
		
		//���� ��ư
		JPanel pane = new JPanel(new GridLayout(3, 1));// �׵θ��� ���� �����̳�		
		JRadioButton rBtn1 = new JRadioButton("ONE");
		JRadioButton rBtn2 = new JRadioButton("TWO");
		JRadioButton rBtn3 = new JRadioButton("THREE");
		
		//���� ��ư �׷츸���
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn1);  bg.add(rBtn2); bg.add(rBtn2);
		
		pane.add(rBtn1);
		pane.add(rBtn2);
		pane.add(rBtn3);
		add(pane);
		
		//��۹�ư
		JToggleButton toggleBtn = new JToggleButton("���", icon3);
		toggleBtn.setRolloverIcon(icon1);
		toggleBtn.setSelectedIcon(icon2);
		add(toggleBtn);
		
		//�󺧸����
		JLabel lbl = new JLabel("��ǥ��", JLabel.CENTER);
		add(lbl);
		
		//���� �÷������ϱ�
		//���� blue��� �÷��� ��������� ��ü�� ���� ��ü��.blue�ص� �ǰ�, ����ƽ�̴ϱ�  color.blue��� �ص���.. 
		btn1.setBackground(Color.ORANGE);
		//				R:0~255, g:0~255 , b: 0~255
		Color clr = new Color(100,100,200);
		toggleBtn.setBackground(clr);
		
		//���ڻ� �÷������ϱ�
		btn1.setForeground(Color.WHITE);
		
		//�󺧿� ���� �����ϱ�
		//����ó������
		lbl.setOpaque(true);// true - ����ó�� ����, false - ����ó��
		lbl.setBackground(new Color(200,70,70));
		
		//Font : �۲�(����ü, ����ü, Arial,,, ��������(����Ӳ�, ���ϰ�, ����), ����ũ��(�ȼ�px) �����ϱ�
		Font fnt = new Font("�ü�ü", Font.ITALIC+Font.BOLD,40);
		lbl.setFont(fnt);
		
		
		setSize(1000,500);
		setVisible(true);
		//���α׷��� ����Ǹ� �ڿ������ϰų�, ���α׷��� �����Ҽ������� ����.......
		//DISPOSE_ON_CLOSE : ���α׷������ �ڿ��� �����϶�
		//DO_NOTHING_ON_CLOSE: �ݱⰡ ������� �ʴ´�.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//��� ��
		try {
			Thread.sleep(5000);//5�ʵ��� �����ٰ� �󺧸� �ٲ�
		} catch (InterruptedException e) {
		}//�и���
		
		//��ư�� ��, Label�� ���� �����ϱ�
		btn1.setText("����� ��ư ��");
		lbl.setText("����� ��");
	}
	public static void main(String[] args) {
		new JFrameTest();
	}
}
