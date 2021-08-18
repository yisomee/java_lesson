import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//�ϳ���, �迭��, ���ͷ� �𵨷� �޺��ڽ��� ������� 

public class JComboBoxTest extends JFrame implements ItemListener {
	JPanel pane = new JPanel();
	JComboBox<String> cb1 = new JComboBox<String>();
	JComboBox<String> cb2, cb3, cb4;
	
	JLabel lbl = new JLabel("���ð� ǥ�õǴ� ��", JLabel.CENTER);
	Color clr[] = {Color.red, Color.blue, Color.green, Color.white,Color.black};
	public JComboBoxTest() {
		add(BorderLayout.NORTH,pane);
		pane.add(cb1);
		
		lbl.setOpaque(true);//����ȭ
		add(lbl);
		
		//����߰�
		cb1.addItem("�ڹ�");
		cb1.addItem("������");
		cb1.addItem("JSP");
		
		//�迭�� �����͸� ��ϸ����
		String comboList[] = {"RED", "BLUE","GREEN","WHILE","BLACK"};
		cb2 = new JComboBox(comboList);
		pane.add(cb2);
		
		//�÷���(Vector)�� �̿��� ��ϸ����
		Vector<String> v = new Vector<String>();
		v.add("AAAAA");
		v.add("BBBBB");
		v.add("CCCCC");
		
		cb3 = new JComboBox(v);
		pane.add(cb3);
		//���� �̿��� ��� ����� 
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("���");
		model.addElement("��ȭ");
		model.addElement("ƫ��");
		cb4 = new JComboBox<String>(model);
		pane.add(cb4);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ ��� 
		cb2.addItemListener(this);
		cb4.addItemListener(this);
	}
	//�������̵�
	public void itemStateChanged(ItemEvent ie) {
	JComboBox event= (JComboBox)ie.getSource();
	if(event.equals(cb2)) {
		//���ø���� index��������
		int idx = cb2.getSelectedIndex();
		lbl.setBackground(clr[idx]);
	}else if(event.equals(cb4)) {
		lbl.setText((String)cb4.getSelectedItem());	
	}
}
	
	public static void main(String[] args) {
		new JComboBoxTest();
	}
}
