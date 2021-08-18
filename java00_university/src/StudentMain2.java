import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class StudentMain2 extends AdminUI implements ActionListener ,MouseListener {
	
	//***********�л��߰��г�****************
	
	Font font = new Font("����", Font.BOLD, 20);
	
	JPanel centerPane = new JPanel(new BorderLayout());//UI_2 ���Ϳ� �гδ���

	
	//�л��߰�,����ȭ��
	JPanel insertPane;//centerPane - north
		JPanel insertlb1P; //insertPane-north
			JLabel insertlb1; 
		JPanel insertWestPane; //insertPane-west
			String insertLb1[]= {" �� �� �� ȣ "," �� �� �� ȣ "," �� �� �� ȣ "," �� �� "," �� �� "
								," �� �� �� "," �� ȭ �� ȣ "," �� �� "," �� �� �� �� "," �� �� �� �� "," �� �� �� �� "};
		JPanel insertCenter; //insertPane-center
			JTextField[] insertTf = {new JTextField(10), new JTextField(4), new JTextField(10),new JTextField(10)
									, new JTextField(4),new JTextField(30),new JTextField(15),new JTextField(45)
									, new JTextField(10),new JTextField(15), new JTextField(20),};  
		JPanel insertSouthP; //insertPane-south
			JButton insertJbt;
	JPanel deletePane;//centerPane- center
		JPanel deletelb1P; //deletrPane-north
		JPanel deleteCenterP; //deletrPane-center

	public StudentMain2() {
		
		init();
		add(centerPane);

		
		studentInsertView(); //2.�л��߰�
		
	}

	public void actionPerformed(ActionEvent ae) {
		//���콺�̺�Ʈ�� url�׽�Ʈ....
		
		Object eventBtn =ae.getSource();
		if(eventBtn ==insertJbt) { //�л��˻�
			studentInsert();
		}
	}

	//�л��߰�ȭ��
	public void studentInsertView() {
		//�����гο� �г�2������ -> �߰��г� /�����г�		
		
		insertPane = new JPanel(new BorderLayout());//1.�߰��г�
			
			insertlb1P = new JPanel(new BorderLayout());
			insertlb1P.setBorder(new LineBorder(Color.GRAY,1,true));
				insertlb1 = new JLabel("�л��߰�"); //��Ʈ����,�гξȿ��ָ�
				insertlb1.setFont(font);				
				insertlb1.setPreferredSize(new Dimension(150, 30));
			insertlb1P.add(BorderLayout.WEST,insertlb1);
			
			insertPane.add(BorderLayout.NORTH,insertlb1P); //�����г� ���ʿ� �� �߰�
			insertlb1P.setPreferredSize(new Dimension(0, 45));
			
			insertWestPane= new JPanel(new GridLayout(11,1,5,5));

			insertCenter = new JPanel(new GridLayout(11,1)); //�ڿ� �߰��� 5�� ������ 5px��ŭ �ִ°�
						
			insertPane.add(BorderLayout.WEST,insertWestPane); //�߰��г� ���ʿ� �г��߰�
				for(int i=0; i<insertLb1.length; i++) {
					JLabel lb1 = new JLabel(insertLb1[i]);
					insertWestPane.add(lb1);
				}
			insertPane.add(BorderLayout.CENTER,insertCenter);//�߰��г� ���Ϳ� �г��߰�
				for(int i=0; i<insertTf.length; i++) {
					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //��������
					p.add(insertTf[i]);					
					insertCenter.add(p);
					
					//�ؽ�Ʈ�ʵ� ��Ȱ��ȭ
					if(i==0 || i==2 || i==9 )  insertTf[i].setEditable(false);
				}
				
			
			
			insertSouthP = new JPanel();	//���̾ƿ� �ַ�����	
			insertSouthP.setBorder(new LineBorder(Color.GRAY,1,true));
			insertJbt = new JButton(" �� �� "); //�߰��г� ���ʿ� ��ư �߰� //�гξȿ� �ָ�	
			insertJbt.setBackground(new Color(33, 140, 116));
			insertJbt.setForeground(Color.white);
			insertJbt.setFont(font);
			insertJbt.setPreferredSize(new Dimension(100, 30)); //��ư�������
			insertSouthP.add(insertJbt);
			insertPane.add(BorderLayout.SOUTH,insertSouthP);
			
			centerPane.add(BorderLayout.NORTH,insertPane);
			insertPane.setPreferredSize(new Dimension(0, 480));
		
		deletePane = new JPanel(new BorderLayout());	//2.�����г�
			
			deletelb1P = new JPanel(new BorderLayout());					
			deletePane.add(BorderLayout.NORTH,deletelb1P); //�����г� ���ʿ� �� �߰�
			deletelb1P.setPreferredSize(new Dimension(0, 45));
		
			deleteCenterP = new JPanel(); 		
			deletePane.add(BorderLayout.CENTER,deleteCenterP);
			centerPane.add(BorderLayout.CENTER,deletePane);
					
			insertJbt.addActionListener(this); //�߰���ư
			
	}
		
	//�л��߰�
	public void studentInsert() { //�л��߰� --- DAO- insertDAO
		//String Stu_code = insertTf[0].getText(); // not null //�������ѹ�
		String Major_Code = insertTf[1].getText(); // not null
		//String stu_pw = insertTf[2].getText();
		String stu_name = insertTf[3].getText();
		String stu_grade = insertTf[4].getText();
		String stu_email=insertTf[5].getText();
		String stu_tel=insertTf[6].getText();
		String stu_add=insertTf[7].getText();
		String stu_state=insertTf[8].getText();
		//int stu_date=insertTf[9].getText();
		String stu_birth = insertTf[10].getText();  // not null 
		
		
		if( Major_Code==null || Major_Code.equals(" ") || //stu_pw==null || stu_pw.equals(" ")||
			stu_name==null || stu_name.equals(" ") || stu_birth==null || stu_birth.equals(" ")	)  { //���������x �ٵ� ��......
				JOptionPane.showMessageDialog(this, "������ ���� �Է��ϼ���");
		}else {
			StudentVO3 vo = new StudentVO3();
			
			vo.setMajor_Code(Integer.parseInt(Major_Code));
			//vo.setStu_pw(stu_pw); // �ʱ��й�ȣ�� �������
			vo.setStu_name(stu_name);
			vo.setStu_grade(stu_grade);
			vo.setStu_email(stu_email);
			vo.setStu_tel(stu_tel); 
			vo.setStu_add(stu_add);
			vo.setStu_state(stu_state);
			//vo.setStu_date((stu_date);
			vo.setStu_birth(stu_birth);		
			
			StudentDAO dao = new StudentDAO();
			int cnt = dao.insertRecord(vo);
			
			if(cnt>0) {//�л��߰� : �߰��� ���ڵ尡 ������
				formDataClear(); //ȸ���� �߰��Ǹ� ���� �����и� �����
				JOptionPane.showMessageDialog(this, "�л��߰� �Ǿ����ϴ�");
			}else{ //ȸ���߰�����
				JOptionPane.showMessageDialog(this, "�л��߰� �����Ͽ����ϴ�");
			}			
		}
		
	}
	
	//�������
	public void formDataClear() {
			//�л� �߰��ǰ��� form�� �ִ� �����͸� �����
			//���� ���� �����.
		for(int i=0; i<insertTf.length; i++) {
				insertTf[i].setText(" ");
		}
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	

	
	public static void main(String[] args) {
		new StudentMain2();

	}

	

}
