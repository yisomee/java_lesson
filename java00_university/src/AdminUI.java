import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminUI extends JFrame{
	
	String id =AllStateSession.login_id;
	
	
	JPanel northPane;
	JLabel northlb1; 
	JButton logout;

	JPanel leftMenuPane;
	String [] menuTitle = {"�������׸��","���������ۼ�", "������������","������������","�����߰�","�л���������","�л���������"};
	Font font;
	
	
	
	
	JPanel centerP;
		JPanel centerP_northP;
			JPanel northP_north;
			JPanel northP_center;
		
	public AdminUI() {
		init();
		
		
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void init() {
		setNorthPane(); //nothpanel ����
		setLeftMenu(); //�޴���
		
	}

	public void setNorthPane() {		
		
		northPane = new JPanel(new BorderLayout());	
		northPane.setBackground(new Color(33, 140, 116));
		
		northlb1 = new JLabel(id); //������ ���� *******�α��� �� id **********
		northlb1.setHorizontalAlignment(JLabel.CENTER);
		
	
		northlb1.setOpaque(true);
		northlb1.setBackground(new Color(33, 140, 116)); 
		northlb1.setForeground(Color.white);
		northlb1.setPreferredSize(new Dimension(900, 0)); 
		
		logout = new JButton("�α׾ƿ�");
		
		
		northPane.add(BorderLayout.WEST,northlb1); //������ ����� ���� �����ִ� JLabel �߰�
		northPane.add(BorderLayout.EAST,logout); // �α׾ƿ���ư
		northPane.setPreferredSize(new Dimension(0, 35)); //����������
		add(BorderLayout.NORTH,northPane);
	}
	
	public void setLeftMenu() {
		leftMenuPane = new JPanel(new GridLayout(8,0));
		leftMenuPane.setPreferredSize(new Dimension(160, 0));//�޴����г� ������,��ġ
		leftMenuPane.setBackground(new Color(213, 213, 213));
		font = new Font("����", Font.BOLD, 20);

		for(int i=0; i<menuTitle.length; i++) {
			JButton jbt= new JButton(menuTitle[i]);
			jbt.setFont(font);	
			jbt.setBackground(new Color(213, 213, 213));
			leftMenuPane.add(jbt);
		}
		
		add(BorderLayout.WEST,leftMenuPane);		
	}
	
	
	
	public void addComponent() {
		
		centerP = new JPanel(new BorderLayout());
		add(centerP);
			centerP_northP = new JPanel(new BorderLayout());
				northP_north = new JPanel();//����..����
				northP_north.setBackground(Color.white);
				northP_center = new JPanel();//����
		add(BorderLayout.NORTH,northP_north);
		
	}

	public static void main(String[] args) {
		new  AdminUI();
	}

}
