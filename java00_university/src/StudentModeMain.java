import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentModeMain extends StudentModeUI implements ActionListener,MouseListener{
	//*****������ȣ -> ���������� ����
	
	
	JPanel centerPane = new JPanel(new BorderLayout()); //StudentModeUI_2 �� ���Ϳ����� ���� ū��
		
		JPanel centerNorthP; //centerPane�� �����г�
			JPanel northP; //��ü���Ǹ������ ���г�
				JLabel lb1;
			JPanel centerP; //�������̺� ���г�
				String title; 
				DefaultTableModel model;
				JTable table;
				JScrollPane sp;
			JPanel southP;//��û��ư���г�
				JButton jbt;
		
		JPanel centerSouthP ;//centerPane�� �Ʒ��г�
			JPanel northP2 ; //������û�������� ���г�
				JLabel lb2;
			JPanel centerP2; //��û�Ѱ������̺� ���г�
				String title2; 
				DefaultTableModel model2;
				JTable table2;
				JScrollPane sp2;
				
	String class_num;//���콺�̺�Ʈ�� ���õ����� �����ڵ尪�� �켱 ��Ʈ������ ������
	int class_code; //���õ����� ���ǹ�ȣ
	
	public StudentModeMain() {
		init();	
		add(centerPane); //StudentModeUI_2 �� ���Ϳ� ū�� add
		
		classApply(); 
		classAllList();
	}
	
	public void classApply() {//���ǽ�û
		
		centerNorthP = new JPanel(new BorderLayout()); //centerPane�� �����г�
			//1.
			northP = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lb1 = new JLabel("��ü ���Ǹ��");
				northP.add(lb1);
			centerNorthP.add(BorderLayout.NORTH,northP);
			//2.
			centerP = new JPanel(new BorderLayout()); //�������̺� ���г�
				title= "���ǹ�ȣ/�����̸�/�̼�����/���Ǹ�/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǵ����"; 
				model = new  DefaultTableModel(title.split("/"),0);
				table = new JTable(model);
				sp = new JScrollPane(table);
				centerP.add(sp);
			centerNorthP.add(BorderLayout.CENTER,centerP);
			//3
			southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));//��û��ư���г�
				jbt = new JButton(" �� û ");
				southP.add(jbt);
			centerNorthP.add(BorderLayout.SOUTH,southP);
		
		centerSouthP = new JPanel(new BorderLayout());
			//1
			northP2 = new JPanel(new FlowLayout(FlowLayout.LEFT)); //������û�������� ���г�
				lb2 = new JLabel("���� ��û����");
				northP2.add(lb2);
			centerSouthP.add(BorderLayout.NORTH,northP2);				
			//2	
			centerP2 = new JPanel(new BorderLayout()); //��û�Ѱ������̺� ���г�
				title2= "���ǹ�ȣ/�����̸�/�̼�����/���Ǹ�/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǽ�û�ð�"; 
				model2 = new  DefaultTableModel(title2.split("/"),0);
				table2= new JTable(model2);
				sp2 = new JScrollPane(table2);
				centerP2.add(sp2);
			centerSouthP.add(BorderLayout.CENTER,centerP2);
		
	
		centerPane.add(BorderLayout.CENTER,centerNorthP);//ū�ǿ��ٰ� �����г� �߰�
		centerPane.add(BorderLayout.SOUTH,centerSouthP); //ū�ǿ��ٰ� �Ʒ��г� �߰�
		
		centerSouthP.setPreferredSize(new Dimension(0, 200));
		
		
		jbt.addActionListener(this);
		table.addMouseListener(this);
	}
	
	//������ü��� �������� -JTable
	public void classAllList() {

		System.out.println("�ø���Ʈ����");
		StudentModeDAO dao = new StudentModeDAO(); //�����ڸ���� ��������DAOŬ����
		List<StudentModeVO2> list = dao.allRecord3(); //��ü�л����������
		setClassModel(list);//�ҷ��°� ����
			
	}
		//�������̺� ��϶���ֱ�
		public void setClassModel(List<StudentModeVO2> list) { //����Ʈ���ް�		
			model.setRowCount(0);  
				for(int i=0; i<list.size(); i++) {
					
					StudentModeVO2 vo = list.get(i); //ȸ���Ѹ��� ���� ->�迭�� ���� model�� �߰���ų����
					Object[]obj = {vo.getClass_code(),vo.getProf_name(),vo.getClass_div(),vo.getClass_name(),vo.getClass_grade(),
							vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};
						
					model.addRow(obj); //�迭�߰�		
				}
		}
		
//----------------------------------------------------------		
		
	//������û������� �������� -JTable
	public void classAllList2() {

		System.out.println("�ø���Ʈ����");
		StudentModeDAO dao = new StudentModeDAO(); //�����ڸ���� ��������DAOŬ����
		List<StudentModeVO2> list = dao.selectClassRecord(); //��ü�л����������
		setClassModel2(list);//�ҷ��°� ����
				
	}
		//�������̺� ��϶���ֱ�
		public void setClassModel2(List<StudentModeVO2> list) { //����Ʈ���ް�		
			model2.setRowCount(0);  
				for(int i=0; i<list.size(); i++) {
						
					StudentModeVO2 vo = list.get(i); //ȸ���Ѹ��� ���� ->�迭�� ���� model�� �߰���ų����
					Object[]obj = {vo.getClass_code(),vo.getProf_name(),vo.getClass_div(),vo.getClass_name(),vo.getClass_grade(),
							vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};
							
					model2.addRow(obj); //�迭�߰�		
				}
		}
	
	//�̺�Ʈ
	public void actionPerformed(ActionEvent ae) {
		Object eventBtn =ae.getSource();
		
		if(eventBtn==jbt) { //��û 
							//1.���콺�̺�Ʈ�� ���õ� ���ǹ�ȣ�� ����
							//2.��û�̿Ϸ�Ǹ� �޽��������� ������û���̺� table2�� ��ϳ��;ߵ�
							//3. ������û�ο�+1 ���� �����ϰ� -> ������ü���̺��;���
			applyClass(); //������û�޼ҵ�
		}
	}
	
	//������û�ϴ¸޼ҵ�
	public void applyClass() {//������û�ϴ¸޼ҵ�
		class_code = Integer.parseInt(class_num);
		//int stu_code =Integer.parseInt(AllStateSession.login_id);//�л���ȣ ??
		//String class_time = "sysdate";//������û��¥ ??���������൵�ǳ�?
		
		StudentModeVO3 vo = new StudentModeVO3();
		vo.setClass_code(class_code);
		//vo.setStu_code(stu_code);
		//vo.setClass_time(class_time);
		
		StudentModeDAO dao = new StudentModeDAO();
		int cnt = dao.insertApplyClass(vo);
		
		if(cnt>0) {//���ǽ�û�Ϸ�
			updateClassList(); //������û�ο����� + ���Ǹ���Ʈ ���κҷ���
			classAllList2();//������û�����ҷ����¸޼ҵ���� : table2�� ���� ��û�� ���̺������� ���;��Ѵ�
			
			JOptionPane.showMessageDialog(this, "���ǽ�û �Ϸ�Ǿ����ϴ�");
		}else{ //���ǽ�û����
			JOptionPane.showMessageDialog(this, "���ǽ�û �����Ͽ����ϴ�");
		}			
		
	}
	
	//������û�� ���������� ��û�ο� �����ϴ� �޼ҵ�
	public void updateClassList() { // ������û�ο�+1 , ��������Ʈ�ٽü���
		
		class_code = Integer.parseInt(class_num);
		
		ClassVO vo = new ClassVO();
		vo.setClass_code(class_code);
		
		StudentModeDAO dao = new StudentModeDAO();
		System.out.println("�ٿ���������� Ȯ��");
		int cnt = dao.updateRecord2(vo);
		System.out.println("!!Ȯ��");
		System.out.println(cnt);
		
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			classAllList();
		}else {
			//���������ϸ� �ȳ��޽��� ǥ��
			
			JOptionPane.showMessageDialog(this,"������û�ο� ���� �����Ͽ����ϴ�");
		}
	}
	
	//������û�������̺� ��������
	//�л���ȣ�� score���̺��� �л��� ��û�� "�����ڵ�"
	//"�����ڵ带" ������ class���̺��� ����������
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(e.getButton()==1) {
			int row = table.getSelectedRow();
			//���õ� ���� �����ڵ常������
			class_num = String.valueOf(table.getValueAt(row, 0));
		}
		System.out.println(class_num);
	}
		
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	
	public static void main(String[] args) {
		new StudentModeMain();
	}

}
