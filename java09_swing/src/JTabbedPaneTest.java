import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame{
	JTabbedPane tp;
	
	JLabel lbl;
	ImageIcon ii = new ImageIcon("img/kakao2.jfif");
	JButton btn;
	ImageIcon iii = new ImageIcon("img/aaaaa.jfif");
	DigitalClock3 dc = new DigitalClock3(0,0);
	CalculatorEx2 cal = new CalculatorEx2();
	SwingCalendar2 calendar = new SwingCalendar2();
	PackMan2 pm = new PackMan2();
	public JTabbedPaneTest() {
		super("�Ǹ޴�");
		tp = new JTabbedPane(JTabbedPane.LEFT);
		tp.addTab("����", cal);
		lbl = new JLabel(ii);
		tp.addTab("���̺�", lbl);
		btn = new JButton(iii);
		tp.addTab("��ư", btn);
		
		tp.addTab("�ð�", dc);
		tp.addTab("�Ѹ�", pm);
		tp.addTab("�޷�", null, calendar, "�޷�");
		
		tp.insertTab("Button", null, new JButton("�߰��� ��ư"),"�߰��� �ǸŴ� �߰�",3);
		
		//���� Ȱ��ȭ �� ��Ȱ��ȭ
		
		//true:Ȱ��ȭ, false:��Ȱ��ȭ
		//				��Index, true/false
		//tp.setEnabledAt(2, false);
		//ù���� ���� ������ ������ ��� ���� ��Ȱ��ȭ�Ѵ�.
		//tp.setEnabled(false);
		
	
		add(tp);
		setSize(500,500);

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pm.setCanvasSize(); //�Ѹ� ĵ���� ũ�⸦ �����Ѵ�.
		Thread t = new Thread(pm);
		t.start();
	//	tp.addTab("�Ѹ�", pm);
		//���� ����
		//try {Thread.sleep(3000);}catch(Exception e) {}
		//tp.removeTabAt(3);
	}

	public static void main(String[] args) {
		new  JTabbedPaneTest ();
	}
}
