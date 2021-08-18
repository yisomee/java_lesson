import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ProfessorModeMain extends ProfessorModeUI implements ActionListener ,MouseListener {
	
	JPanel centerPane = new JPanel(new BorderLayout());//ProfessorModeUI ������ �����г�:��Ŭ����������ū��
	
		JPanel northP; //�������Ǹ�� 
			JPanel north_NPane;
				JLabel lb1;
			JPanel north_CPane;	
				JTable table;
				JScrollPane sp; 
				DefaultTableModel model;
				String title ;
		JPanel centerP; //���õ� ���� ���� �г�
			JPanel center_NPane;
				JLabel lb2;
			JPanel center_CPane;
				JTable table2;
				JScrollPane sp2; 
				DefaultTableModel model2;
				String title2;
			JPanel center_SPane;
				JButton jbt;
		JPanel southP; // ���ǰ˻��� ����
			JPanel south_NPane;
				JLabel lb3;
			JPanel south_CPane;
				JLabel lb4;
				JTextField tf;
				JButton jbt2;	
			
				int Class_Code; //���Ǹ����ΰ����� ������ �����ڵ�
				String searchClass; //�����Ϸ��� �˻��� ���Ǹ�
				
				
	public ProfessorModeMain() {
		init();
		add(centerPane);
		
		showProfClassAll();
		profClassAllList();
	}
	
	public void showProfClassAll() {
		//////////////���ǰ������////////////////////
		northP = new JPanel(new BorderLayout());
			north_NPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lb1 = new JLabel(" �������Ǹ��");
			north_NPane.add(lb1);
		northP.add(BorderLayout.NORTH,north_NPane);
			north_CPane = new JPanel(new BorderLayout());
				title ="���ǹ�ȣ/�����̸�/�̼�����/���Ǹ�/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǵ����"; //StudentModeVO2���
				model = new  DefaultTableModel(title.split("/"),0);
				table = new JTable(model);
				sp = new JScrollPane(table);
		    north_CPane.add(sp);
		northP.add(BorderLayout.CENTER,north_CPane);  
		
		centerPane.add(BorderLayout.NORTH,northP);
		northP.setPreferredSize(new Dimension(0,300));
		    
    	////////////���õȰ��Ǽ���////////////////////    
		centerP = new JPanel(new BorderLayout()); //���õ� ���� ���� �г�
			center_NPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lb2 = new JLabel(" ������������");
			center_NPane.add(lb2);
		centerP.add(BorderLayout.NORTH,center_NPane);
			center_CPane = new JPanel(new BorderLayout());
				title2 = "���ǹ�ȣ/�����̸�/�̼�����/���Ǹ�/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǵ����";;
				model2 = new  DefaultTableModel(title.split("/"),0);;
				table2 = new JTable(model2);
				sp2 = new JScrollPane(table2); 
			center_CPane.add(sp2);
		centerP.add(BorderLayout.CENTER,center_CPane);
			center_SPane = new JPanel(new FlowLayout());
				jbt= new JButton(" �� �� ");//�̺�Ʈ���
			center_SPane.add(jbt);
		centerP.add(BorderLayout.SOUTH,center_SPane);
    
		centerPane.add(BorderLayout.CENTER,centerP);		
		////////////���ǰ˻��Ļ���////////////////////    
		southP = new JPanel(new BorderLayout()); 
			south_NPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lb3= new JLabel(" ���ǻ��� ");
			south_NPane.add(lb3);
		southP.add(BorderLayout.NORTH,south_NPane);
			south_CPane= new JPanel(new FlowLayout());
				lb4 =new JLabel("���Ǹ�");
				
				tf = new JTextField(20);
				jbt2 = new JButton(" �� �� ");//�̺�Ʈ���
			south_CPane.setBorder(new LineBorder(Color.GRAY,1,true));
			south_CPane.add(lb4); south_CPane.add(tf); south_CPane.add(jbt2);
		southP.add(south_CPane);
		south_CPane.setPreferredSize(new Dimension(0,120));
		
		centerPane.add(BorderLayout.SOUTH,southP);	
		
		table.addMouseListener(this); //***�̺�Ʈ���
		jbt.addActionListener(this);
		jbt2.addActionListener(this);
		
		 
	}
	
	//�����������Ѱ�����ü��� �������� -JTable
	public void profClassAllList() {

		System.out.println("�ø���Ʈ����");
		ProfessorModeDAO dao = new ProfessorModeDAO();
		List<StudentModeVO2> list = dao.allClassRecord(); //��ü�л����������
		profClassModel(list);//�ҷ��°� ����
			
	}
	//�������̺� ��϶���ֱ�
	public void profClassModel(List<StudentModeVO2> list) { //����Ʈ���ް�		
		model.setRowCount(0);  
			for(int i=0; i<list.size(); i++) {
					
				StudentModeVO2 vo = list.get(i); //ȸ���Ѹ��� ���� ->�迭�� ���� model�� �߰���ų����
				Object[]obj = {vo.getClass_code(),vo.getProf_name(),vo.getClass_div(),vo.getClass_name(),vo.getClass_grade(),
							vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};
						
				model.addRow(obj); //�迭�߰�		
			}
	}
	
	
	
	
	public void actionPerformed(ActionEvent ae) {
		
		Object eventBtn = ae.getSource();
		if(eventBtn==jbt) {//����
			profClassUpdate();//�����޼ҵ�
			profClassAllList();
			model2.setRowCount(0); //�����Ұ��Ƕߴ� �κ� ����
		}else if(eventBtn==jbt2) {//����
			getClassCode() ;//�˻��޼ҵ�:���Ǹ��Է� -> �� ���Ǹ�������ϴµ������� ���ǹ�ȣ������
			classDelete(Class_Code);//�����޼ҵ�:������ ���ǹ�ȣ�� ������ ���ǻ���
			model2.setRowCount(0); 
			profClassAllList(); // �����ϰ� ȭ��ٽ� ��ȭ��
		}
		
	}
	
	//�������Ǽ���
	public void profClassUpdate() {
		System.out.println("�������Ǿ�����Ʈ������");
		StudentModeVO2 vo = new StudentModeVO2();
		
		vo.setClass_code((Integer)(table2.getValueAt(0,0))); // ****not null //�������ѹ�
		vo.setProf_name(String.valueOf(table2.getValueAt(0,1))); // not null
		vo.setClass_div(String.valueOf(table2.getValueAt(0,2))); //�Է¹����� vo����ۿ� set
		vo.setClass_name((String)table2.getValueAt(0,3));
		vo.setClass_grade((String)table2.getValueAt(0,4));
		vo.setClass_time((String)table2.getValueAt(0,5));
		vo.setClass_room((String)table2.getValueAt(0,6)); 
		
		String a = String.valueOf(table.getValueAt(0,7)); //�����ο�
		int a1 = Integer.parseInt(a);		
		vo.setTot_mem(a1);
		
		String b = String.valueOf(table.getValueAt(0,8));//��û�ο�
		int b1 = Integer.parseInt(b);
		vo.setReg_mem(b1);
		
		vo.setClass_date((String)table2.getValueAt(0,9));		
		
		
		ProfessorModeDAO dao = new ProfessorModeDAO();
		int cnt = dao.updateClassRecord(vo); //DAOŬ������ update�޼ҵ带 �̿��Ͽ� ���������� ������
		
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			System.out.println("main ����������������");
			JOptionPane.showMessageDialog(this,"�������� ���� �Ϸ��Ͽ����ϴ�");			
			//profClassAllList();
			//model2.setRowCount(0); //�������̺� ���� //�� �Ⱦ�������?
		}else {
			//���������ϸ� �ȳ��޽��� ǥ��
			System.out.println("main ����������������");
			JOptionPane.showMessageDialog(this,"�������� ���� �����Ͽ����ϴ�");
		}
	}
	

	//���Ǹ����� ���ǹ�ȣ��������
	public void getClassCode() {
		searchClass =tf.getText(); //���Ǹ�˻��Ѱ� ��
		
		if(searchClass!=null && !searchClass.equals(" ")) {
			ProfessorModeDAO dao = new ProfessorModeDAO();
			//ã��޼ҵ�
			Class_Code = dao.searchCladdCode(searchClass);//���Ǹ����� �����ڵ尡����	
			
			tf.setText(" ");
		}else if(searchClass==null && searchClass.equals(" ")){
			JOptionPane.showMessageDialog(this, "������ ���Ǹ��� �Է��ϼ���");
		}else {
			JOptionPane.showMessageDialog(this, "�������� �ʴ� ���Ǹ� �Դϴ�");
		}
	}
	
//	//�������ǻ���
	public void classDelete(int code) {//��ȣ�� �����ͼ� ���̺� �ִ��� ������ Ȯ���ϰ�
		
				ProfessorModeDAO dao = new ProfessorModeDAO();
				
				int cnt = dao.deleteClassRecord(code); 
				if(cnt>0) { //���ǻ�����
					JOptionPane.showMessageDialog(this, searchClass+"���Ǹ� �����Ͽ����ϴ�");
					profClassAllList();
					tf.setText(" "); //�Է�âŬ����
					
				}else {//���ǻ�������
					JOptionPane.showMessageDialog(this, searchClass+"���ǻ����� �����Ͽ����ϴ�");
				}
			
			
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	//���ʸ��콺��  �� Ŭ���� �Ʒ��� ���̺� ������ ���� ������ ��
	public void mouseReleased(MouseEvent e){
		if(e.getButton()==1) {//���ʹ�ưŬ��
			model2.setRowCount(0);
			int row = table.getSelectedRow(); //����Ŭ�����౸����

		
			Vector<Object> v = new Vector<Object>();
			v.add((Integer)table.getValueAt(row,0)); //���ǹ�ȣ
			v.add(String.valueOf(table.getValueAt(row,1))); //�����̸�
			v.add(String.valueOf(table.getValueAt(row,2)));//�̼�����
			v.add(String.valueOf(table.getValueAt(row,3)));//���Ǹ�
			v.add(String.valueOf(table.getValueAt(row,4)));//����
			v.add(String.valueOf(table.getValueAt(row,5)));//���ǽð�
			v.add(String.valueOf(table.getValueAt(row,6)));//���ǽ�
			
			String a = String.valueOf(table.getValueAt(row,7)); //�����ο�
			int a1 = Integer.parseInt(a);
			v.add(a1);
			
			String b = String.valueOf(table.getValueAt(row,8));//��û�ο�
			int b1 = Integer.parseInt(b);
			v.add(b1);
			
			v.add(String.valueOf(table.getValueAt(row,9))); //���ǵ����
			
			model2.addRow(v);	

		} 		
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	

	
	public static void main(String[] args) {
		new ProfessorModeMain();

	}

}
