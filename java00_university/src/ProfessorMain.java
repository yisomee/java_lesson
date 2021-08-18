import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;


public class ProfessorMain extends AdminUI implements ActionListener{
   JPanel pane = new JPanel(new BorderLayout());
      JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JLabel searchLbl = new JLabel("������");
         DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
         JComboBox<String> searchkey = new JComboBox<String>(searchModel);
         JTextField searchWord = new JTextField(20);            
         JButton searchBtn = new JButton("�˻�");
         JButton newBtn = new JButton("���ΰ�ħ");
      JPanel centerPane = new JPanel(new BorderLayout());
         DefaultTableModel model;
         JTable professorList;
         JScrollPane sp;
      JPanel southPane = new JPanel(new BorderLayout());
         JPanel updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JPanel updateCenter = new JPanel(new BorderLayout());
         JPanel updateSouth = new JPanel();   
         
         DefaultTableModel model2;
         JTable professorList2;         
         JScrollPane sp2;
      int row;
   public ProfessorMain() {
      init();
      add(pane);
      pane.add(BorderLayout.NORTH,northPane);
      pane.add(BorderLayout.CENTER,centerPane);
      pane.add(BorderLayout.SOUTH,southPane);
      
      showProfessorALL();
      professorList.addMouseListener(new MyEvent());
   }
 
   public void showProfessorALL() {
      
      //north
      setSearchForm();
      
      //center
      String title = "������ȣ/�����ڵ�/��й�ȣ/�����̸�/�̸���/�ڵ���/������/�Ի���/����";
      model = new DefaultTableModel(title.split("/"),0);
      professorList = new JTable(model);
      sp = new JScrollPane(professorList);
      professorAllList();
      centerPane.add(sp); 
      
      //south - north
         JLabel lbl = new JLabel("��������");
         southPane.add(BorderLayout.NORTH,updateNorth);
         updateNorth.add(lbl);
      
      //south - center   
      String title2 = "������ȣ/�����ڵ�/��й�ȣ/�����̸�/�̸���/�ڵ���/������/�Ի���/����";
      model2 = new DefaultTableModel(title2.split("/"),0);
      professorList2 = new JTable(model2);
      sp2 = new JScrollPane(professorList2);
      professorAllList();
      updateCenter.add(sp2);
      southPane.add(BorderLayout.CENTER,updateCenter);   
         
      //south - south   
   
      JButton updateBtn = new JButton("����");
      JButton deleteBtn = new JButton("����");
      updateSouth.add(updateBtn);
      updateSouth.add(deleteBtn);
      southPane.add(BorderLayout.SOUTH,updateSouth);
   
      southPane.setPreferredSize(new Dimension(0, 140));
      deleteBtn.addActionListener(this);
      updateBtn.addActionListener(this);
   }
   //�����˻� ��
   public void setSearchForm() {
      searchModel.addElement("������");
      searchModel.addElement("������ȣ");
      searchModel.addElement("�ڵ�����ȣ");
      northPane.add(searchkey);
      northPane.add(searchWord);
      northPane.add(searchBtn);   
      northPane.add(newBtn);
      searchBtn.addActionListener(this);
      newBtn.addActionListener(this);
   }
   public void professorAllList() {
      ProfessorDAO dao = new ProfessorDAO();
      List<ProfessorVO> list = dao.allRecord();
      setProfessorModel(list);
      }
   public void setProfessorModel(List<ProfessorVO> list) {
      //���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�. 
      model.setRowCount(0);
      //�÷��ǿ� �ִ� vo�� get�Ͽ� JTable�� ������� �߰��Ѵ�.
      for(int i=0;i<list.size();i++) {
         ProfessorVO vo = list.get(i);
         Object[] obj = {vo.getProf_code(),vo.getMajor_code(),vo.getProf_pw(),vo.getProf_name(),
               vo.getProf_email(),vo.getProf_tel(),vo.getProf_room(),vo.getProf_hd(), vo.getProf_birth()};
         model.addRow(obj);
           
      }
   }

   //��������
   public void professorDelete() {
      //������ �����ȣ
      JOptionPane op = new JOptionPane();
      Object willBeRemoved = model.getValueAt(row, 0);//���̺��Ǽ�:������ȣ
      ProfessorDAO dao = new ProfessorDAO();
      int que = op.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
      if(que == JOptionPane.YES_OPTION) {
         model.removeRow(row);
         int result = dao.deleteRecord(willBeRemoved);

         if(result>0) {
            JOptionPane.showMessageDialog(this,"���� �����Ͽ����ϴ�.");
            professorAllList();
         }else {
            JOptionPane.showMessageDialog(this,"�������� �����Ͽ����ϴ�.");
         }

      }else if(que ==JOptionPane.NO_OPTION) {
         
      }
   }
   //���� �˻�
   public void ProfessorSearch() {
      //�˻�� �ԷµǾ��ִ��� Ȯ��.
      String search = searchWord.getText();
      if(search!=null && !search.equals("")) {//�˻�� �ִ�. 
         String searchField = (String)searchkey.getSelectedItem();//�˻�Ű �̸� ��ȭ��ȣ �ּ�
         String fieldName = "";
         if(searchField.equals("������")) {
            fieldName = "prof_name";
         }else if(searchField.equals("������ȣ")) {
            fieldName = "prof_code";
         }else if(searchField.equals("�ڵ�����ȣ")) {
            fieldName = "prof_tel";
         }
         
         ProfessorDAO dao = new ProfessorDAO();
         List<ProfessorVO> list = dao.searchRecord(search,fieldName);
         setProfessorModel(list);
         searchWord.setText("");
      }
   }
   //��������
   public void professorUpdate() {

      ProfessorVO vo = new ProfessorVO();
      vo.setProf_code((Integer)(professorList2.getValueAt(0,0))); 
      vo.setMajor_code((Integer)(professorList2.getValueAt(0,1))); 
      vo.setProf_pw((String)professorList2.getValueAt(0,2));
      vo.setProf_name((String)professorList2.getValueAt(0,3));
      vo.setProf_email((String)professorList2.getValueAt(0,4));
      vo.setProf_tel((String)professorList2.getValueAt(0,5));
      vo.setProf_room((String)professorList2.getValueAt(0,6)); 
      vo.setProf_hd((String)professorList2.getValueAt(0,7));
      vo.setProf_birth((String)professorList2.getValueAt(0,8));
      

   ProfessorDAO dao = new ProfessorDAO();
      int cnt = dao.updateRecord(vo);
      if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
         professorAllList();
         JOptionPane.showMessageDialog(this, "�������� ��������");
      }else{   //�������н� �ȳ��޽��� ǥ��
         JOptionPane.showMessageDialog(this, "�������� ��������");
      }
   }
   
   
   public void actionPerformed(ActionEvent ae) {
      String eventBtn = ae.getActionCommand();
      if(eventBtn.equals("����")) {
         professorUpdate();
      }else if(eventBtn.equals("����")) {
         professorDelete();
         
      }else if(eventBtn.equals("�˻�")) {
         ProfessorSearch();
      }else if(eventBtn.equals("���ΰ�ħ")) {
         professorAllList();
      }
   }
   public class MyEvent extends MouseAdapter{
      //��������̵�
      @Override
      public void mouseClicked(MouseEvent me) {
         int eventBtn = me.getButton();
         if(eventBtn==1) {
            model2.setRowCount(0);
            row = professorList.getSelectedRow();
            
            Vector<Object> v = new Vector<Object>();
            v.add((Integer)professorList.getValueAt(row,0));
            v.add((Integer)professorList.getValueAt(row,1));
            v.add((String)professorList.getValueAt(row,2));
            v.add((String)professorList.getValueAt(row,3));
            v.add((String)professorList.getValueAt(row,4));
            v.add((String)professorList.getValueAt(row,5));
            v.add((String)professorList.getValueAt(row,6));
            v.add((String)professorList.getValueAt(row,7));
            v.add((String)professorList.getValueAt(row,8));
            
            model2.addRow(v);
         }
      }
   }
   
   public static void main(String[] args) {
      new ProfessorMain();
   }
}