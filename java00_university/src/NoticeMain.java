import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NoticeMain extends UI_2 implements ActionListener{

	int willBeShown = 0;
	int numberOfNotices = 0;
	int i = -1;
	boolean shouldBeRemoved = false;

	JPanel centerPane = new JPanel();
		String titles[];
		String sequences[];
		String selectedTitle = "";
	NoticeVO theOne;
//	HashMap<Integer, NoticeVO> theHashOne = new HashMap<Integer, NoticeVO>();
	List<NoticeVO> notices;
	
	JButton southBar_prevBtn;
	JButton southBar_nextBtn;
	JTextField southBar_search;
	
	public NoticeMain() {
		init();
		centerPane.setLayout(new FlowLayout());
		print10Notices();
	}

	// �������� ����
	public void print10Notices() {
		// (ó������, �� i�� -1�϶���)������ ������ ����
		if(i == -1) {
			NoticeDAO dao = new NoticeDAO();
			notices = dao.setAllNotices();
			titles = new String[notices.size()];
			sequences = new String[notices.size()];
		}
		// �ݺ����� ���ͷ�����
		Iterator<NoticeVO> noticesIterator1 = notices.iterator();
		Iterator<NoticeVO> noticesIterator2 = notices.iterator();
		// �� ĭ
		JPanel spacePane = new JPanel();
		spacePane.setPreferredSize(new Dimension(800, 32));
		centerPane.add(spacePane);
		
		// �������� ���� ����
		JPanel northBar = new JPanel();
		northBar.setPreferredSize(new Dimension(800, 40));
		northBar.setLayout(new FlowLayout());
		northBar.setBackground(new Color(108, 92, 231));
		JLabel northBar_noLbl = new JLabel("��ȣ");
		JLabel northBar_titleLbl = new JLabel("����");
		northBar.add(northBar_noLbl);
		northBar_noLbl.setHorizontalAlignment(JLabel.CENTER);
		northBar_noLbl.setPreferredSize(new Dimension(60, 32));
		northBar.add(northBar_titleLbl);
		northBar_titleLbl.setHorizontalAlignment(JLabel.CENTER);
		northBar_titleLbl.setPreferredSize(new Dimension(520, 32));

		// ��ư �����
		JButton addBtn = new JButton("�߰�");
		JButton updateBtn = new JButton("����");
		JButton deleteBtn = new JButton("����");
		addBtn.setPreferredSize(new Dimension(60, 32));
		updateBtn.setPreferredSize(new Dimension(60, 32));
		deleteBtn.setPreferredSize(new Dimension(60, 32));
		addBtn.setBackground(new Color(108, 92, 231));
		updateBtn.setBackground(new Color(108, 92, 231));
		deleteBtn.setBackground(new Color(108, 92, 231));
		addBtn.setBorderPainted(false);
		updateBtn.setBorderPainted(false);
		deleteBtn.setBorderPainted(false);
		
		// ��ġ
		northBar.add(addBtn);
		northBar.add(updateBtn);
		northBar.add(deleteBtn);
		
		// ��ư�� �̺�Ʈ ����
		addBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		centerPane.add(northBar);
		// �������� �ϳ��ϳ� ����(�ִ� 10��) > �ڡڡ� ����: ��ȸ/����/������ư ���� ������ ���� Ÿ��Ʋ�ٿ� �ϳ��� ����°�? 

		// (ó������, �� i�� -1�϶���)������ ������ ����
		if(i == -1) {
			while(noticesIterator1.hasNext()) {
				// �ϳ��� VO�� ���� �������� ������ �� ��
				NoticeVO oneNotice = noticesIterator1.next();
				// �¸� Ÿ��Ʋ��
				titles[numberOfNotices] = oneNotice.getTitle();
				// �������� �ٽ� ���� => �̰� �ʿ��Ѱ�?
				sequences[numberOfNotices] = String.valueOf(oneNotice.getCode());
				// �󺧿� �г� ����� ������, Ÿ��Ʋ ǥ��
				if(numberOfNotices < notices.size()-1) {
					numberOfNotices++;
				} else {
					i = 0;
					break;
				}
			}			
		}

		while(noticesIterator2.hasNext()) {
//			System.out.println(i + "��° ģ����: " + titles[i]);
			// �������׿� ���η� ������ �г� ��ġ
			JPanel noticePane = new JPanel();
			noticePane.setPreferredSize(new Dimension(800, 40));
			// ���̾ƿ� �ٲ�� �̻ڰ� ��ġ�ɰ�
			noticePane.setLayout(new FlowLayout());
			// ���� �����Ѱ� ã�Ƽ� �ٲ�� ��
			if (willBeShown % 2 == 0) {
				noticePane.setBackground(new Color(199, 236, 238));				
			} else {
				noticePane.setBackground(new Color(189, 195, 199));
			}

			JLabel sequenceLabel = new JLabel(sequences[i]);
			
			// �� ��ġ
			sequenceLabel.setHorizontalAlignment(JLabel.CENTER);
			sequenceLabel.setPreferredSize(new Dimension(60, 32));
			noticePane.add(sequenceLabel);
			
			// �� ��ư���� �����
			JButton titleBtn = new JButton(titles[i]);
			titleBtn.setBorderPainted(false);
			titleBtn.setPreferredSize(new Dimension(720, 32));
			titleBtn.setHorizontalAlignment(JButton.LEFT);
			if (willBeShown % 2 == 0) {
				titleBtn.setBackground(new Color(199, 236, 238));				
			} else {
				titleBtn.setBackground(new Color(189, 195, 199));
			}
			
			titleBtn.addActionListener(this);
			
			// �гο� ����
			noticePane.add(titleBtn);
			centerPane.add(noticePane);
			// ���� �̵� ��ư ������ i�� 10�� ������ ��
			if(willBeShown % 10 == 9) {
//				System.out.println(willBeShown);
				willBeShown = 0;
				break;
			} else {
				// willBeShown�� 
//				System.out.println(willBeShown);
				// �� �������� 10���� �����ٰŴϱ� i�� ����
				willBeShown++;
			}
			if(i < numberOfNotices) {
				i++;
			} else {
				break;
			}
		}
//		System.out.println("�� ���������� i��" + i);
		// ���� �����
		JPanel spacePaneSouth = new JPanel();
		spacePaneSouth.setPreferredSize(new Dimension(800, 32));
		centerPane.add(spacePaneSouth);
		
		// ������ �̵�/�˻� â
		JPanel southBar = new JPanel();
		southBar.setLayout(new FlowLayout());
		southBar_prevBtn = new JButton("��");
		southBar_prevBtn.setPreferredSize(new Dimension(60, 32));
		southBar_search = new JTextField(20);
		southBar_search.setPreferredSize(new Dimension(60, 32));
		JButton southBar_searchBtn = new JButton("�˻�");
		southBar_searchBtn.setPreferredSize(new Dimension(60, 32));
		southBar_nextBtn = new JButton("��");
		southBar_nextBtn.setEnabled(true);
		southBar_nextBtn.setPreferredSize(new Dimension(60, 32));
		southBar.add(southBar_prevBtn);
		southBar.add(southBar_search);
		southBar.add(southBar_searchBtn);
		southBar.add(southBar_nextBtn);
		southBar_prevBtn.addActionListener(this);
		southBar_searchBtn.addActionListener(this);
		southBar_nextBtn.addActionListener(this);
		
		centerPane.add(southBar);

		add(centerPane);
	}

	// ��ư Ŭ�� �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent a) {
		String btnLbl = a.getActionCommand();
		NoticeDAO dao = new NoticeDAO();
		if(btnLbl.equals("�߰�")) {
			addNotice(dao);
		} else if(btnLbl.equals("����")) {
			updateNotice(dao);
		} else if(btnLbl.equals("����")) {
			removeNotice(dao);
		} else if(btnLbl.equals("��")) {
			selectedTitle = "";
			if (i % 10 != 9) {
				i -= numberOfNotices % 10 + 10;
			} else {
				i -= 19;
			}
			if (i <= 0) {
				i = 0;
			}
			willBeShown = 0;
			reset10Notices();
//		} else if(btnLbl.equals("�˻�")) {
//			if(!(southBar_search.getText().isEmpty())) {
//				searchNotice();
//			} else {
//				JOptionPane.showMessageDialog(this, "�˻�� �Է��Ͻʽÿ�");
//			}
		} else if(btnLbl.equals("��")) {
			selectedTitle = "";
			if(i < numberOfNotices - (numberOfNotices % 10)) {
				i++;
			} else if(i == numberOfNotices) {
				i = numberOfNotices - (numberOfNotices % 10);
				willBeShown = 0;
			}
			reset10Notices();
		} else {
			// Ŭ���� ģ�� ������
			selectedTitle = btnLbl;
			selectNotice();
		}
	}
	
	// ���콺�� �Խù� ����
	public NoticeVO selectNotice() {
//		System.out.println("���� �� �ȿ���? " + selectedTitle);
		int wantedSequence = 0;
		int index = 0;
		NoticeDAO dao = new NoticeDAO();
		// �������� �����Ͱ� ��� NoticeVO�� ����
		notices = dao.setAllNotices();
		// �ݺ����� ���ͷ�����
		Iterator<NoticeVO> noticesIterator = notices.iterator();
		while(noticesIterator.hasNext()) {
			// �ϳ��� VO���� �������� ������ �� ��
			System.out.println(index);
			NoticeVO oneNotice = noticesIterator.next();
			System.out.println("�������� Ÿ��Ʋ " + oneNotice.getTitle());
			if(oneNotice.getTitle().equals(selectedTitle)) {
				wantedSequence = oneNotice.getCode();
				System.out.println("wantedSequence: " + wantedSequence);
				// ���ͼ�
				System.out.println("break ������ �ε���: "+ index);
				break;
			} else {
				System.out.println("�ݺ����� ���� �� ����� �ȿ��� �ʳ�?: "+ index);
				index++;				
			}
//			} else {
//				System.out.println("���������������?");
		}
		// ���õ� ������(�������� �Ѱ�)
		// �ؽø��̾��ٰ� ����Ʈ�� �ٲ㼭 �̰� ������ �ƴ�...
//		theOne = notices.get(wantedSequence);
		
		// �ᱹ �갡 ������.
		if(selectedTitle=="") {
			// ��, ����ư�� ��
			index = 0;
		} else if (shouldBeRemoved) {
			// ������ư�� ��
			System.out.println("wantedSequence �߸ſ�: " + wantedSequence);
			index--;
		}
		System.out.println("�ε���" + index);
		System.out.println("������" + notices.size());
		System.out.println("selectedTitle" + selectedTitle);
		theOne = notices.get(index);
		System.out.println("The one I really want: " + index);
		return theOne;
	}
	
	public void addNotice(NoticeDAO dao) {
		NoticeDetail newBoard = new NoticeDetail();
		newBoard.setFrame();
	}
	
	// ����
	public void updateNotice(NoticeDAO dao) {
		dao.showOldRecord(theOne);
	}
	
	
	// �길 �� �����ϰ�
	// �ڡڡڡڡ� ������ > �̵��ϰ� �����ϸ� �� �����ǰų� �̻��� ��ȣ�� �����Ǵµ� �ٷ� �����ϸ� Index 17 out of bounds
	public void removeNotice(NoticeDAO dao) {
		shouldBeRemoved = true;
		int question = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION);
	      if(question == JOptionPane.YES_OPTION) {
	    	  int cnt = dao.removeRecord(theOne);
	    	  System.out.println("���� ���⵵ ��������?");
	    	  if(cnt == 1) {
	    		  reset10Notices();
	    		  JOptionPane.showMessageDialog(this, "������ ������ ����!");
	    	  } else {
	    		  JOptionPane.showMessageDialog(this, "���� ���Ф̤�");
	    	  }
	      }
	}
	
	public void reset10Notices() {
		centerPane.setVisible(false);
		centerPane.removeAll();
		centerPane.setVisible(true);
		selectNotice();
		System.out.println("������ ����?");
		print10Notices();
	}
	
	// �˻��� �� �߰��ϸ� �ȴ�
	public void searchNotice() {
		String keyword = southBar_search.getText();
		System.out.println("Ű����� " + keyword);
		NoticeDAO dao = new NoticeDAO();
		notices = dao.searchRecords(keyword);
		if( notices.size() < 11 ) {
			titles = new String[10];
			sequences = new String[10];
		} else {
			titles = new String[notices.size()];
			sequences = new String[notices.size()];
		}
		i = 0;
		willBeShown = 0;
		System.out.println("�˻� �޼ҵ忡���� ������? " + selectedTitle);
		reset10Notices();
	}
	

	//����� ����
	public static void main(String[] args) {
		new NoticeMain();
	}

}
