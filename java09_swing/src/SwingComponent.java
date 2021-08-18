import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SwingComponent {
	JFrame frm = new JFrame("������Ʈ������");
	Rectangle frmSize = new Rectangle(200,200,500,500);//x,y,w,h
	public SwingComponent() {
		frm.setTitle("Component");
		//JTextField : ������ ���ڿ��� �Է��� �� �ִ� ���۳�Ʈ
		//JFrame ->FlowLayout�� ����
		frm.setLayout(new FlowLayout());
		
		JTextField tf = new JTextField(10);
		frm.add(tf);
		
		JTextField tf2 = new JTextField("ABCDEFG", 20);
		//���� �����ϱ�
		tf2.setText("�ؽ�Ʈ �ʵ��� ���� ����Ǿ����ϴ�.");
		
		try {
			String str1 = tf2.getText();
			String str2 = tf2.getText(2,3);
			System.out.println("str1-->"+str1);
			System.out.println("str2-->"+str2);
		} catch (Exception e) {
			
		}
		frm.add(tf2);
		//JPasswordField : ���ڸ� ��ũ�� ���ش�.
		JPasswordField
		pf = new JPasswordField(20);
		frm.add(pf);
		
		//JTextArea: �������� ���ڿ��� �Է��ϴ� ���۳�Ʈ
		JTextArea ta = new JTextArea(5, 30);
		JScrollPane sp = new JScrollPane(ta);//��ũ�ѱ���� �ִ� �����̳�
		frm.add(sp);
		
		
		//JCheckBox :�������� ������ �� �ִ� ���۳�Ʈ
		JCheckBox cb1 = new JCheckBox("���");
		JCheckBox cb2 = new JCheckBox("��", true);
		frm.add(cb1);
		frm.add(cb2);
		
		//JSlider : ��ƽ�� �̿��� �� ��å
		JSlider s1 = new JSlider(JSlider.HORIZONTAL, 1, 10, 5); 
		frm.add(s1);
		
						//x,y,w,h
		frm.setBounds(frmSize);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new SwingComponent();
	}
}
