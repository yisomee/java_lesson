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

public class StudentMain extends AdminUI implements ActionListener ,MouseListener {
	
	
	
	Font font = new Font("����", Font.BOLD, 20);
	
	JPanel centerPane = new JPanel(new BorderLayout());//UI_2 ���Ϳ� �гδ���
	
	//�л���������-�л���ü��ȸȭ��	
	JPanel northPane;
		JTextField tf;	
		JComboBox<String> jcb;
		JButton jbt;
		JButton jbt2;		
	JPanel centercenterPane;	
		JTable table;
		JScrollPane sp; 
		DefaultTableModel model;
		String title;
		
	
	//�л���ȸ
	JPanel updatePane; //south-�����г�
		JPanel updateNorth;
			JLabel updateLb1;
		JPanel updateCenter; 		
			JTable updateTable;
			JScrollPane sp2; 
			DefaultTableModel updatemodel;
			String title2;
		JPanel updateSouth;		
			JButton updateJbt; //������ư
			JButton deleteJbt;
			
			
			
			String major_Name; //�������� �Էµ� ������
			int major_Code; //�Էµ����������� ������ �����ڵ�
			

	public StudentMain() {
		
		init();
		add(centerPane);
		
		showStudentAll();//1-1.��ȸ,����,���� ȭ�� �⺻����
		studentAllList();//1-2.�л���ü��ȸ+�˻���ư�̺�Ʈó��

		
	}

	//�л���������-�л���ü��ȸȭ��	
	public void showStudentAll() {
	
		northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));  //�����޺��ڽ� �ؽ����ʵ� �˻���ư

		System.out.println("�л���ü��ȸȭ��޼ҵ����"); //TEST
			String comboList[] = {"�л���ȣ", "�л��̸�", "�а�����"};
			jcb = new JComboBox(comboList);
			tf = new JTextField(15); //�˻�â
			jbt = new JButton("�˻�");
			jbt2 = new JButton("��ϻ��ΰ�ħ");
			northPane.add(jcb);
			northPane.add(tf);
			northPane.add(jbt);	
			northPane.add(jbt2);
			
		centerPane.add(BorderLayout.NORTH,northPane);//������ο� �˻�����߰�
			
		centercenterPane = new JPanel(new BorderLayout());
			
			title= "�л���ȣ/�а�����/��й�ȣ/�л��̸�/�г�/�̸���/�ڵ���/�ּ�/��������/��������/�������"; 
			model = new  DefaultTableModel(title.split("/"),0);

		    table = new JTable(model);
		    sp = new JScrollPane(table);
		    centercenterPane.add(sp);
		    
		    table.addMouseListener(this);		 
	
		centerPane.add(BorderLayout.CENTER,centercenterPane); //������ο� ���Ϳ� �л����̺�߰�
//-----------------------------------------------------------------------------------------------
		updatePane = new JPanel(new BorderLayout());	//�ǾƷ� �����г�
			//1
			updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
				updateLb1 = new JLabel("�л���������");				
			updateNorth.add(updateLb1); 
		updatePane.add(BorderLayout.NORTH,updateNorth);
			//2
			updateCenter = new JPanel(new BorderLayout());
				title2= "�л���ȣ/�а�����/��й�ȣ/�л��̸�/�г�/�̸���/�ڵ���/�ּ�/��������/��������/�������"; 
				updatemodel = new  DefaultTableModel(title2.split("/"),0);
				updateTable = new JTable(updatemodel);
				sp2 = new JScrollPane(updateTable);
			updateCenter.add(sp2);
		updatePane.add(BorderLayout.CENTER,updateCenter);
			//3
			updateSouth = new JPanel();
	    	updateJbt = new JButton(" �� �� ");
	    	deleteJbt = new JButton(" �� �� ");
	    	updateSouth.add(updateJbt);
	    	updateSouth.add(deleteJbt);
	    updatePane.add(BorderLayout.SOUTH,updateSouth); 
	    
	    centerPane.add(BorderLayout.SOUTH,updatePane);    
	    
	    updatePane.setPreferredSize(new Dimension(0, 140));
			
		    jbt.addActionListener(this);
		    jbt2.addActionListener(this);
		    updateJbt.addActionListener(this);
		    deleteJbt.addActionListener(this);
		    
	}
	
	public void actionPerformed(ActionEvent ae) {
		//���콺�̺�Ʈ�� url�׽�Ʈ....
		
		Object eventBtn =ae.getSource();
		if(eventBtn==jbt) { //�л��˻�
			studentSearch();
		}else if(eventBtn== updateJbt){//�л�����
			getMajorCode();
			studentUpdate();			
		}else if(eventBtn==deleteJbt) { //�л�����
			studentDelete();
		}else if(eventBtn==jbt2) {
			studentAllList();
		}
	}
	
	//�л���ü��� �������� -JTable
	public void studentAllList() {

		System.out.println("�ø���Ʈ����");
		StudentDAO dao = new StudentDAO();
		List<StudentVO2> list = dao.allRecord(); //��ü�л����������
		setStudentModel(list);//�ҷ��°� ����
		
	}
	//�������̺� ��϶���ֱ�
	public void setStudentModel(List<StudentVO2> list) { //����Ʈ���ް�		
		model.setRowCount(0);  
			for(int i=0; i<list.size(); i++) {
				
				StudentVO2 vo = list.get(i); //ȸ���Ѹ��� ���� ->�迭�� ���� model�� �߰���ų����
				Object[]obj = {vo.getStu_Code(),vo.getMajor_name(),vo.getStu_pw(),vo.getStu_name(),vo.getStu_grade(),
						vo.getStu_email(),vo.getStu_tel(), vo.getStu_add(), vo.getStu_state(),vo.getStu_date(),vo.getStu_birth()};
					
				model.addRow(obj); //�迭�߰�		
			}
	}
	
	//�л��˻�
	public void studentSearch() {
			
			String search =tf.getText(); //�˻��Ҵܾ�
			System.out.println(search);
			if(search!=null && !search.equals(" ")) { // �˻�� �ִ�
				String searchField = String.valueOf(jcb.getSelectedItem());//**�޼ҵ� ���þ��ص� �Ǵ°ɷ� �ٲ����
				System.out.println(searchField);
				// �˻��� : �л���ȣ", "�л��̸�", "�а�����"
				//�ʵ������ �����ͷ� ������
				String fieldName=" "; //��ʵ忡�� �˻����� �ܾ ������
				
				System.out.println("main�л��˻��޼ҵ嵵��");
				
				if(searchField.equals("�л���ȣ")) {
					fieldName="s.Stu_Code";
				}else if(searchField.equals("�л��̸�")) {
					System.out.println("�����޺��ڽ� �л��̸� ����");
					fieldName="s.stu_name";
				}else if(searchField.equals("�а�����")) {
					fieldName="m.major_name";
				}
				StudentDAO dao = new StudentDAO();
				List<StudentVO2>list = dao.searchRecord(search,fieldName);
				setStudentModel(list);
				tf.setText("");
			}
		}
		
	//�޾ƿ°� �켱LIST�� ����
	//LIST ���� ���Ǹ����� ���ǹ�ȣ ã��
	//��� ������Ʈ�Ҷ�  ���ǹ�ȣ�� ������Ʈ
	
		
	//���������� ������ȣ��������
	public void getMajorCode() {
		major_Name =String.valueOf(updateTable.getValueAt(0,1));//�������� �Էµ� ������ ������
			
			if( major_Name!=null && !major_Name.equals(" ")) {
				StudentDAO dao = new StudentDAO();
					//ã��޼ҵ�
				major_Code = dao.searchMajorCode(major_Name);//���������� �����ڵ尡����	
				System.out.println(major_Code);
					
			}else if( major_Name==null &&  major_Name.equals(" ")){
					//JOptionPane.showMessageDialog(this, "������ ���Ǹ��� �Է��ϼ���");
			}else {
				//JOptionPane.showMessageDialog(this, "�������� �ʴ� ���Ǹ� �Դϴ�");
			}
	}
		
	
	//�л���������
	public void studentUpdate() { 	
		System.out.println("����������Ʈ������");
		StudentVO3 vo = new StudentVO3();
		
		vo.setStu_Code((Integer)(updateTable.getValueAt(0,0))); // ****not null //�������ѹ�
		vo.setMajor_Code(major_Code); // not null
		vo.setStu_pw((String)updateTable.getValueAt(0,2)); //�Է¹����� vo����ۿ� set
		vo.setStu_name((String)updateTable.getValueAt(0,3));
		vo.setStu_grade((String)updateTable.getValueAt(0,4));
		vo.setStu_email((String)updateTable.getValueAt(0,5));
		vo.setStu_tel((String)updateTable.getValueAt(0,6)); 
		vo.setStu_add((String)updateTable.getValueAt(0,7));
		vo.setStu_state((String)updateTable.getValueAt(0,8));
		vo.setStu_date((String)updateTable.getValueAt(0,9));
		vo.setStu_birth((String)(updateTable.getValueAt(0,10)));  
		
		//System.out.println(vo.allprint());
		
		StudentDAO dao = new StudentDAO();
		int cnt = dao.updateRecord(vo); //DAOŬ������ update�޼ҵ带 �̿��Ͽ� ���������� ������
		
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			System.out.println("main �л�������������");
			JOptionPane.showMessageDialog(this,"ȸ������ ���� �Ϸ��Ͽ����ϴ�");			
			studentAllList();
			updatemodel.setRowCount(0); //�������̺� ����
		}else {
			//���������ϸ� �ȳ��޽��� ǥ��
			System.out.println("main �л�������������");
			JOptionPane.showMessageDialog(this,"ȸ������ ���� �����Ͽ����ϴ�");
		}
	}
	
	
	
	

	//�л�����
	public void studentDelete() {
		JOptionPane op = new JOptionPane();
		Object willBeRomoved = updatemodel.getValueAt(0,0);
		StudentDAO dao = new StudentDAO();
		int que =op.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION );
		if(que == JOptionPane.YES_OPTION) {
			updatemodel.setRowCount(0); // updatemodel.remove(0);
			int result = dao.deleteRecord(willBeRomoved);
			
			if(result>0) {
				JOptionPane.showMessageDialog(this,"�л������͸� �����Ͽ����ϴ�");
				studentAllList();
				updatemodel.setRowCount(0); //�������̺� ����
			}else {
				JOptionPane.showMessageDialog(this,"�����ͻ����� ���� �Ͽ����ϴ�");
			}
			
		}else if(que==JOptionPane.NO_OPTION) {
			System.out.println("�л���������");
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==1) {//���ʹ�ưŬ��
			updatemodel.setRowCount(0);
			int row = table.getSelectedRow(); //����Ŭ�����౸����

			Vector<Object> v = new Vector<Object>();
			v.add((Integer)table.getValueAt(row,0));
			v.add(String.valueOf(table.getValueAt(row,1)));
			v.add(String.valueOf(table.getValueAt(row,2)));
			v.add(String.valueOf(table.getValueAt(row,3)));
			v.add(String.valueOf(table.getValueAt(row,4)));
			v.add(String.valueOf(table.getValueAt(row,5)));
			v.add(String.valueOf(table.getValueAt(row,6)));
			v.add(String.valueOf(table.getValueAt(row,7)));
			v.add(String.valueOf(table.getValueAt(row,8)));
			v.add(String.valueOf(table.getValueAt(row,9)));
			v.add(String.valueOf(table.getValueAt(row,10)));
			updatemodel.addRow(v);	
			
		} 		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	

	
	public static void main(String[] args) {
		new StudentMain();

	}

	

}
