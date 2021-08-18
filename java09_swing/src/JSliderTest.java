import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class JSliderTest  extends JFrame {
	JSlider s1 = new JSlider(JSlider.HORIZONTAL, 0,100,40);
	JSlider s2 = new JSlider(JSlider.VERTICAL, 0,100,50);

	public JSliderTest (){
		//s1�� �ɼǼ���
		s1.setMajorTickSpacing(10);//�ִ���ǥ��
		s1.setMinorTickSpacing(2);//��������
		s1.setPaintTicks(true);//���ݺ����ֱ�
		s1.setPaintLabels(true);//��ǥ��(�� ���ݴ����� ���ڷ� �����ֱ�)
		
		//s2
		//�󺧸����
		Hashtable<Integer, JLabel> ht = new Hashtable<Integer,JLabel>();
		ht.put(0,new JLabel("��"));
		ht.put(50, new JLabel("��"));
		ht.put(100, new JLabel ("��"));
		
		s2.setMajorTickSpacing(50);//���ݰ���
		s2.setLabelTable(ht);//��������� �󺧼���
		s2.setPaintTicks(true);//���ݺ��̱�
		s2.setPaintLabels(true);//�󺧺��̱�
		
		//�ڵ����ݼ����� �̵��ϱ� 
		s2.setSnapToTicks(true);
		
		
		add(BorderLayout.NORTH,s1);
		add(BorderLayout.WEST,s2);
		
		setSize(500,500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new JSliderTest();
	}
}
