import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarApp extends JFrame implements ActionListener{
	JPanel northPanel = new JPanel();
	JButton leftBtn = new JButton("��");
	JButton rightBtn = new JButton("��");
	JComboBox<Integer> yearBox = new JComboBox<Integer>();
	JComboBox<Integer> monthBox = new JComboBox<Integer>();
	JPanel centerPanel = new JPanel();
	JLabel yearStr = new JLabel("��");
	JLabel monthStr = new JLabel("��");
	Font font = new Font("����ü", Font.BOLD, 25);
	Calendar now = Calendar.getInstance();
	int thisYear = now.get(Calendar.YEAR);
	int thisMonth = now.get(Calendar.MONTH);
	
	public CalendarApp() {
		Image icon = Toolkit.getDefaultToolkit().getImage("img/cat_icon.png");
		setIconImage(icon);
		setTitle("Calendar");
		
		// northPanel�� �� ��ư ����
		add(BorderLayout.NORTH, northPanel);
		northPanel.setBackground(Color.pink);
		northPanel.setPreferredSize(new Dimension(500, 50));
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		// �� �� ��ư ����
		northPanel.add(leftBtn);
		leftBtn.setSize(60, 40);
		
		inputYearBox();
		
		northPanel.add(yearStr);
		yearStr.setSize(60, 40);
		
		inputMonthBox();
		
		northPanel.add(monthStr);
		monthStr.setSize(60, 40);
		
		northPanel.add(rightBtn);
		rightBtn.setSize(60, 40);
		
		
		// centerPanel 7x7 ���̾ƿ� �����
		add(centerPanel);
		centerPanel.setLayout(new GridLayout(7, 7));
		centerPanel.setBackground(Color.lightGray);


		// days, dates �Է��ϱ�
		inputDays();
		inputDates();

		
		// ȭ��ǥ ������ �� +-1
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		// ��/�⵵ �ٲٸ� ��¥ ��ü �����ؼ� �ٽ� ���
		monthBox.addActionListener(this);
		yearBox.addActionListener(this);




		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	
	public void actionPerformed(ActionEvent aEvent) {
		if(aEvent.getActionCommand().equals("��")) {
			if(thisMonth <= 0) {
				thisMonth = 11;
				thisYear -= 1;
				yearBox.setSelectedItem(thisYear);
			} else {
				thisMonth -= 1;
			}
			monthBox.setSelectedItem(thisMonth+1);
		} else if (aEvent.getActionCommand().equals("��")) {
			if(thisMonth >= 11) {
				thisMonth = 0;
				thisYear += 1;
				yearBox.setSelectedItem(thisYear);
				System.out.println("�갡 ���� �޺��ڽ��� �ٲ��� �Ŀ� �޺��ڽ� ���� �̺�Ʈ �߻��ؾ� ��");
				// �ٵ� ������ �𸣰ڴµ� ��ư�� ������ �޺��ڽ� > ��ư ������ �����
			} else {
				thisMonth += 1;
			}
			monthBox.setSelectedItem(thisMonth+1);
		} else if (aEvent.getActionCommand().equals("comboBoxChanged")) {
			System.out.println("���޹��� �޺��ڽ�: " + thisYear);
			System.out.println("���޹��� �޺��ڽ�: " + thisMonth);
//			thisYear = Integer.parseInt(String.valueOf(yearBox.getSelectedItem()));
//			thisMonth = Integer.parseInt(String.valueOf(monthBox.getSelectedItem()))-1;
			System.out.println("�޺��ڽ�: " + thisYear);
			System.out.println("�޺��ڽ�: " + thisMonth);
			resetPanel();
		}  

	}
	
	public void resetPanel() {
		centerPanel.setVisible(false);
		centerPanel.removeAll();
		now.set(Calendar.MONTH, thisMonth);
		now.set(Calendar.YEAR, thisYear);
		centerPanel.setVisible(true);
		centerPanel.setLayout(new GridLayout(7, 7));
		centerPanel.setBackground(Color.lightGray);
		inputDays();
		inputDates();
	}

	public void inputYearBox() {
		// �� �޺� �ڽ��� ���ظ� �������� -5�� +5�� ���� ����
		northPanel.add(yearBox);
		yearBox.setSize(60, 40);
		for(int i=5; i>0; i--) {
			yearBox.addItem(thisYear-i);
		}
		yearBox.addItem(thisYear);
		for(int i=1; i<6; i++) {
			yearBox.addItem(thisYear+i);
		}
		yearBox.setSelectedItem(thisYear);
	}
	
	public void inputMonthBox() {
		// �� �޺� �ڽ��� 1~12 ���� ����
		northPanel.add(monthBox);
		monthBox.setSize(60, 40);
		int monthText = 1;
		while (true) {
			monthBox.addItem(monthText++);
			if(monthText == 13) break;
		}
		monthBox.setSelectedItem(thisMonth + 1);
	}
	
	public void inputDays() {
		String days[] = {"��", "��", "ȭ", "��", "��", "��", "��"};
		for(int i=0; i<days.length; i++) {
			JLabel dayLabel = new JLabel(days[i], JLabel.CENTER);
			if (days[i] == "��") {
				dayLabel.setForeground(Color.red);
			} else if (days[i] == "��") {
				dayLabel.setForeground(Color.blue);
			}
			dayLabel.setSize(60, 40);
			dayLabel.setFont(font);
			centerPanel.add(dayLabel);
		}
	}
	
	public void inputDates() {
		// �̹����� ��������
		int thisLastDate = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		// ������ ��¥
		int todayOfMonth = now.get(Calendar.DAY_OF_MONTH);
		// ������ ����
		int todayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		// ù ���� ������ (���ó�¥�� ù ���� ����(����-1)�� 7�� ���� ������)�� �� ����
		// 7�� 25�� �Ͽ����̶�� ġ�� ���̴� 24, 7�� ���� �������� 3�̹Ƿ� �Ͽ���(1)���� 3�� �ڷ� �� �����(-2)�� ��
		// �ٵ� �̷��� ������ ���� �� �����Ƿ� ������ �� +7�� ���ָ� �� (����� = -2 = 5)
		int theDate = 1;
		int firstDayOfWeek = todayOfWeek - ((todayOfMonth - 1) % 7);
		if (firstDayOfWeek <= 0) {
			firstDayOfWeek += 7;
		}
		int dates[] = new int[42];
		for(int i=0; i<dates.length; i++) {
			if (i<firstDayOfWeek - 1) {
				dates[i] = 0;
			} else if(theDate>thisLastDate) {
				dates[i] = 0;
			} else {
				dates[i] = theDate++;
			}
			JLabel dateLabel = new JLabel(String.valueOf(dates[i]), JLabel.CENTER);
			if (dateLabel.getText().equals("0")) {
				dateLabel.setVisible(false);
			}
			if ((i+1) % 7 == 1) {
				dateLabel.setForeground(Color.red);
			} else if ((i+1) % 7 == 0) {
				dateLabel.setForeground(Color.blue);
			}
			dateLabel.setSize(60, 40);
			dateLabel.setFont(font);
			centerPanel.add(dateLabel);
		}
		
	}

	public static void main(String[] args) {
		new CalendarApp();

	}

}
