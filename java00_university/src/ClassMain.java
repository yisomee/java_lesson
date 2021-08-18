import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.table.DefaultTableModel;



public class ClassMain extends AdminUI implements ActionListener,MouseListener  {

	JPanel  centerPane = new JPanel(new BorderLayout()); //��ü�г�
		JPanel northPane;//��ü�г��Ǻ����г�
			JComboBox jcb;
			JTextField tf;
			JButton jbt;
			JButton jbt2;
		JPanel centercenterPane;//��ü�г��Ǽ���
			DefaultTableModel model;
			JTable table;
			JScrollPane sp;
		JPanel updatePane; //��ü�г��� �����г�
			JPanel updateNorth;
				JLabel updateLb1;
			JPanel updateCenter;			
				DefaultTableModel updatemodel;
				JTable updateTable;
				JScrollPane sp2;				
				
				//JPanel tfPane;

			JPanel updateSouth;
				JButton updateJbt;
				JButton deleteJbt;
			
	public ClassMain() {
		init();
		add(centerPane); //��ü�г�
		
		showClassAll();
		classAllList();
	}
	
	
	
	//��ȸ��üȭ��
	public void showClassAll() {	
		//��ȸ=======================================================================	
		northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
			String comboList[] = {"���ǹ�ȣ", "���Ǹ�", "��米��"};
			jcb = new JComboBox(comboList);
			tf = new JTextField(15); //�˻�â
			jbt = new JButton("�˻�"); //**�̺�Ʈ
			jbt2 = new JButton("��ϻ��ΰ�ħ"); //**�̺�Ʈ
			northPane.add(jcb); northPane.add(tf); northPane.add(jbt); northPane.add(jbt2);		
		centerPane.add(BorderLayout.NORTH,northPane);//������ο� �˻�����߰�
		
		centercenterPane = new JPanel(new BorderLayout()); //��ü�г��Ǽ����� ����
			String title= "���ǹ�ȣ/������ȣ/�̼�����/���Ǹ�/������/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǵ����";
			model = new  DefaultTableModel(title.split("/"),0);
		    table = new JTable(model);
		    sp = new JScrollPane(table);
		    centercenterPane.add(sp);		    
		    table.addMouseListener(this); //���콺�̺�Ʈ���
		centerPane.add(BorderLayout.CENTER,centercenterPane); //������ο� ���Ϳ� �л����̺�߰�
		
		//����=======================================================================	=	 
		updatePane = new JPanel(new BorderLayout());	//�ǾƷ� �����г�
			//1
			updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
				updateLb1 = new JLabel("������������");			
				updateNorth.add(updateLb1); 
			updatePane.add(BorderLayout.NORTH,updateNorth);
			//2
			updateCenter = new JPanel(new BorderLayout());
				String title2= "���ǹ�ȣ/������ȣ/�̼�����/���Ǹ�/������/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǵ����";
				updatemodel = new  DefaultTableModel(title2.split("/"),0);
				updateTable = new JTable(updatemodel);
				sp2 = new JScrollPane(updateTable);
				updateCenter.add(sp2);//updateCenrer�� ���Ϳ����� -north�����̴°ɷμ����Ҹ�
				//updateCenrer�� south�� ���� - center�����̴°ɷμ����Ҹ�
					//tfPane = new JPanel( new FlowLayout(FlowLayout.LEFT)); //���̾ƿ��ַ�����

				//updateCenter.add(BorderLayout.SOUTH,tfPane);
			updatePane.add(BorderLayout.CENTER,updateCenter);
			//3
			updateSouth = new JPanel();
		    	updateJbt = new JButton(" �� �� ");
		    	deleteJbt = new JButton(" �� �� ");
		    	updateSouth.add(updateJbt); updateSouth.add(deleteJbt);
		    updatePane.add(BorderLayout.SOUTH,updateSouth); 
		    
		    
		    centerPane.add(BorderLayout.SOUTH,updatePane);    
		    
		    updatePane.setPreferredSize(new Dimension(0, 140));
		    
				//**�̺�Ʈ���
			    jbt.addActionListener(this);//�˻�	
			    jbt2.addActionListener(this);//���ΰ�ħ
			    updateJbt.addActionListener(this);//����
			    deleteJbt.addActionListener(this);//����
	}
	
	//������ü��� �������� -JTable
	public void classAllList() {

		System.out.println("���ǿø���Ʈ����");
		ClassDAO dao = new ClassDAO();
		List<ClassVO2> list = dao.allRecord(); //��ü�л����������
		setClassModel(list);//�ҷ��°� ����
			
		}
	//�������̺� ��϶���ֱ�
	public void setClassModel(List<ClassVO2> list) { //����Ʈ���ް�		
		model.setRowCount(0);  
			for(int i=0; i<list.size(); i++) {
					
				ClassVO2 vo = list.get(i); //ȸ���Ѹ��� ���� ->�迭�� ���� model�� �߰���ų����
				Object[]obj = {vo.getClass_code(),vo.getProf_code(),vo.getClass_div(),vo.getClass_name(),vo.getProf_name(),vo.getClass_grade(),
							vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};
						
				model.addRow(obj); //�迭�߰�		
				}
		}
		
	//�̺�Ʈó��
	public void actionPerformed(ActionEvent ae) {//�˻�,���ΰ�ħ,����,����
		
		Object eventBtn =ae.getSource();
		
		if(eventBtn==jbt) {//�˻�
			classSearch();
		}else if(eventBtn==jbt2) { //��ϻ��ΰ�ħ
			classAllList();
		}else if(eventBtn==updateJbt) {//����
			classUpdate();
			updatemodel.setRowCount(0);//�����Ұ��� �ߴ� �κ� ����
		}else if(eventBtn==deleteJbt) {//���� -updatetable �����ϰ� ��񿡼����������λ���
			classDelete();
			updatemodel.setRowCount(0);
		}		
		
	}
	
	//���������˻�
	public void classSearch() {
		String search =tf.getText(); //�˻��Ҵܾ�
		
		if(search!=null && !search.equals(" ")) { // �˻�� �ִ�
			String searchField =String.valueOf(jcb.getSelectedItem()); // �˻��� : �л���ȣ", "�л��̸�", "�а�����"
			//�ʵ������ �����ͷ� ������
			String fieldName=" "; //��ʵ忡�� �˻����� �ܾ ������
			
			if(searchField.equals("���ǹ�ȣ")) {
				fieldName="c.class_code";
			}else if(searchField.equals("���Ǹ�")) {
				fieldName="c.class_name";
			}else if(searchField.equals("��米��")) {
				fieldName="p.jkkjprof_name";
			}
			ClassDAO dao = new ClassDAO();
			List<ClassVO2>list = dao.searchRecord(search,fieldName);
			setClassModel(list);
			tf.setText("");
		}
	}
	
	//������������
	public void classUpdate() {
		ClassVO vo = new ClassVO();
		
		
		try {
		vo.setClass_code((Integer)(updateTable.getValueAt(0,0))); // not null //�������ѹ�
		vo.setProf_code((Integer)(updateTable.getValueAt(0,1))); // not null
		vo.setClass_div(String.valueOf(updateTable.getValueAt(0,2))); //�Է¹����� vo����ۿ� set
		vo.setClass_name(String.valueOf(updateTable.getValueAt(0,3)));
		//vo.setProf_name(String.valueOf(updateTable.getValueAt(0,4)));
		vo.setClass_grade(String.valueOf(updateTable.getValueAt(0,5)));
		vo.setClass_time(String.valueOf(updateTable.getValueAt(0,6)));
		vo.setClass_room(String.valueOf(updateTable.getValueAt(0,7))); 
		
		String a = String.valueOf(updateTable.getValueAt(0,8));
		int a1 = Integer.parseInt(a);
		vo.setTot_mem(a1);
		
		String b = String.valueOf(updateTable.getValueAt(0,9));
		int b1 = Integer.parseInt(b);
		vo.setReg_mem(b1);
		
		vo.setClass_date(String.valueOf(updateTable.getValueAt(0,10)));
		
		}catch(Exception ee) {
			System.out.println("classUpdate()�޼ҵ����");
			ee.printStackTrace();
			
		}
		
		ClassDAO dao = new ClassDAO();
		int cnt = dao.updateRecord(vo); //DAOŬ������ update�޼ҵ带 �̿��Ͽ� ���������� ������
		
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			System.out.println("main �������������Ϸ�");
			JOptionPane.showMessageDialog(this,"�������� ���� �Ϸ��Ͽ����ϴ�");
			classAllList();
		}else {
			//���������ϸ� �ȳ��޽��� ǥ��
			System.out.println("main ����������������");
			JOptionPane.showMessageDialog(this,"�������� ���� �����Ͽ����ϴ�");
		}
	}
	
	//���ǻ���
	public void classDelete() {
		JOptionPane op = new JOptionPane();
		Object willBeRomoved = updatemodel.getValueAt(0,0);
		ClassDAO dao = new ClassDAO();
		int que =op.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION );
		if(que == JOptionPane.YES_OPTION) {
			updatemodel.setRowCount(0); // updatemodel.remove(0);
			int result = dao.deleteRecord(willBeRomoved);
			
			if(result>0) {
				JOptionPane.showMessageDialog(this,"���Ǹ� �����Ͽ����ϴ�");
				classAllList();
				//updatemodel.setRowCount(0); // �� �Ⱦ�������?
			}else {
				JOptionPane.showMessageDialog(this,"���ǻ����� ���� �Ͽ����ϴ�");
			}
			
		}else if(que==JOptionPane.NO_OPTION) {
			System.out.println("���ǻ�������");
		}
		
		
	}
	//���콺�̺�Ʈ
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
			v.add((Integer)table.getValueAt(row,1));
			v.add(String.valueOf(table.getValueAt(row,2)));
			v.add(String.valueOf(table.getValueAt(row,3)));
			v.add(String.valueOf(table.getValueAt(row,4))); //������
			v.add(String.valueOf(table.getValueAt(row,5)));
			v.add(String.valueOf(table.getValueAt(row,6)));
			v.add(String.valueOf(table.getValueAt(row,7)));
			String a = String.valueOf(table.getValueAt(row,8));
			int a1 = Integer.parseInt(a);
			v.add(a1);
			
			String b = String.valueOf(table.getValueAt(row,9));
			int b1 = Integer.parseInt(b);
			v.add(b1);
			
			v.add(String.valueOf(table.getValueAt(row,10)));
			
			updatemodel.addRow(v);	
			
			//System.out.println(.getValueAt(row,7));
//			tf1.setText(String.valueOf(table.getValueAt(row,7)));
//			tf2.setText(String.valueOf(table.getValueAt(row,8)));
			
		} 		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	


	public static void main(String[] args) {
		new ClassMain();

	}

}
