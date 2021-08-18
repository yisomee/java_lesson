import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class StudentMode_delete extends StudentModeUI implements ActionListener{
   JPanel pane = new JPanel(new BorderLayout());
      JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
         DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
         JComboBox<String> searchkey = new JComboBox<String>(searchModel);
         JTextField searchWord = new JTextField(20);   
         JButton searchBtn = new JButton("�˻�");
         JButton newBtn = new JButton("���ΰ�ħ");
         JLabel northLbl = new JLabel("������û���");
      JPanel centerPane = new JPanel(new BorderLayout());
         DefaultTableModel model;
         JTable studentModelist;
         JScrollPane sp;
         JButton delbtn = new JButton("�������");
      JPanel southPane = new JPanel();
         int row;
         int willBeRemoved ;//����� �����ڵ�
         
   public StudentMode_delete() {
      init();
      setForm();
      studentModelist.addMouseListener(new MyEvent());
      searchBtn.addActionListener(this);
      delbtn.addActionListener(this);
      newBtn.addActionListener(this);
   }
   
   public void setForm() {
      //north
      add(pane);
      pane.add(BorderLayout.NORTH,northPane);
         northPane.add(northLbl);   
      setSearchForm();
      northPane.add(newBtn);
      //center
      String title = "�����ڵ�/����̸�/�����̸�/�̼�����/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǽ��νð�";
      model = new DefaultTableModel(title.split("/"),0);
      studentModelist = new JTable(model);
      sp = new JScrollPane(studentModelist);
      StudentModeAllList();
      centerPane.add(sp); 
      
      pane.add(BorderLayout.CENTER,centerPane);
      pane.add(BorderLayout.SOUTH,southPane);   
      
      //����
      southPane.add(delbtn);
       pane.add(BorderLayout.SOUTH, southPane); 
       
      southPane.setBorder(new LineBorder(Color.GRAY,1,true));
      delbtn.setBackground(new Color(33, 140, 116));
      delbtn.setForeground(Color.white);
      delbtn.setFont(font);
      delbtn.setPreferredSize(new Dimension(110, 30)); //��ư�������
      
   
   }
   public void setSearchForm() {
      searchModel.addElement("�����ڵ�");
      searchModel.addElement("����̸�");
      searchModel.addElement("�����̸�");
      northPane.add(searchkey);
      northPane.add(searchWord);
      northPane.add(searchBtn);       
      
   }
   public void StudentModeAllList() {
      StudentModeDAO dao = new StudentModeDAO();
      List<StudentModeVO2> list = dao.allRecord2();
      setStudentModeModel(list);
   }
   
   public void setStudentModeModel(List<StudentModeVO2> list) {
      //���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�. 
      model.setRowCount(0);
      //�÷��ǿ� �ִ� vo�� get�Ͽ� JTable�� ������� �߰��Ѵ�.
      for(int i=0;i<list.size();i++) {
         StudentModeVO2 vo = list.get(i);
         Object[] obj = {vo.getClass_code(), vo.getProf_name(), vo.getClass_name(),vo.getClass_div(),
               vo.getClass_grade(),vo.getClass_time(),vo.getClass_room(),vo.getTot_mem(),
               vo.getReg_mem(),vo.getClass_date()};
         System.out.println(vo.getProf_name());
         model.addRow(obj);
      }
   }
   public void actionPerformed(ActionEvent ae) {
         String eventBtn = ae.getActionCommand();
         if(eventBtn.equals("�������")) {
            StudentModeDelete();
         }else if(eventBtn.equals("�˻�")) {
            StudentModeSearch();
         }else if(eventBtn.equals("���ΰ�ħ")) {
            StudentModeAllList();
         }
      }
   public void StudentModeDelete() {
      //������ ��û���
      JOptionPane op = new JOptionPane();
      willBeRemoved =(Integer)model.getValueAt(row, 0);

      StudentModeDAO dao = new StudentModeDAO();
      int que = op.showConfirmDialog(this,"���� ����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
      if(que == JOptionPane.YES_OPTION) {
         model.removeRow(row);
         int result = dao.deleteRecord(willBeRemoved);

         if(result>0) {
            JOptionPane.showMessageDialog(this,"������� �Ͽ����ϴ�.");
            updateClassList();
         }else {
            JOptionPane.showMessageDialog(this,"������� �����Ͽ����ϴ�.");
         }

      }else if(que ==JOptionPane.NO_OPTION) {
         
      }
   }
   public void updateClassList() {
         
         ClassVO vo = new ClassVO();
         vo.setClass_code(willBeRemoved);
         
         StudentModeDAO dao = new StudentModeDAO();
         int cnt = dao.updateRecord3(vo);
         System.out.println(cnt);
         
         if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
            System.out.println("main��û�ο�-1");
    
         }else {
            //���������ϸ� �ȳ��޽��� ǥ��
            JOptionPane.showMessageDialog(this,"������û�ο� ���� �����Ͽ����ϴ�");
         }
   }

   //�˻�
   public void StudentModeSearch() {
      //�˻�� �ԷµǾ��ִ��� Ȯ��.
      String search = searchWord.getText();
      if(search!=null && !search.equals("")) {//�˻�� �ִ�. 
         String searchField = (String)searchkey.getSelectedItem();//�˻�Ű �̸� ��ȭ��ȣ �ּ�
         String fieldName = "";
         if(searchField.equals("�����ڵ�")) {
            fieldName = "c.class_code";
         }else if(searchField.equals("����̸�")) {
            fieldName = "p.prof_name";
         }else if(searchField.equals("�����̸�")) {
            fieldName = "c.class_name";
         }
         
         StudentModeDAO dao = new StudentModeDAO();
         List<StudentModeVO2> list = dao.searchRecord(search,fieldName);
         setStudentModeModel(list);
         searchWord.setText("");
      }
   }
   
   
   
   public class MyEvent extends MouseAdapter{
      //��������̵�
      @Override
      public void mouseClicked(MouseEvent me) {
         int eventBtn = me.getButton();
         if(eventBtn==1) {
            row = studentModelist.getSelectedRow();

         }
      }
   }
   public static void main(String[] args) {
      new StudentMode_delete();
      

   }

}