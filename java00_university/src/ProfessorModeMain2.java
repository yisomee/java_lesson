import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

////������ �� ���Ǹ� ��û�� �л������ �����ִ� ���̺�
public class ProfessorModeMain2 extends ProfessorModeUI implements ActionListener{
   JPanel pane = new JPanel(new BorderLayout());
         JLabel titlelb1;
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
   public ProfessorModeMain2() {
      init();
      add(pane);
      pane.add(BorderLayout.NORTH,northPane);
      pane.add(BorderLayout.CENTER,centerPane);
      pane.add(BorderLayout.SOUTH,southPane);
      
      showProfessorALL();
   
   }
 
   public void showProfessorALL() {
      
      //north
         titlelb1= new JLabel("���Ǹ��"); //��Ʈ����
      titlelb1.setFont(font);
      northPane.add(titlelb1);
      setSearchForm();
      
      //center
      String title = "�����̸�/�л���ȣ/�л��г�/�л��̸�/�л�����/�л�����ó";
      model = new DefaultTableModel(title.split("/"),0);
      professorList = new JTable(model);
      sp = new JScrollPane(professorList);
      professor_StudentAllList();
      centerPane.add(sp); 

   }
   //�����˻� ��
   public void setSearchForm() {
      searchModel.addElement("�����̸�");
      searchModel.addElement("�л���ȣ");
      searchModel.addElement("�л��̸�");
      northPane.add(searchkey);
      northPane.add(searchWord);
      northPane.add(searchBtn);
      northPane.add(newBtn);
      searchBtn.addActionListener(this);
      newBtn.addActionListener(this);
   }
   public void professor_StudentAllList() {
      ProfessorModeDAO dao = new ProfessorModeDAO();
      List<StudentVO> list = dao.allRecord();
      setProfessor_studentlistModel(list);
      }
   public void setProfessor_studentlistModel(List<StudentVO> list) {
      //���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�. 
      model.setRowCount(0);
      //�÷��ǿ� �ִ� vo�� get�Ͽ� JTable�� ������� �߰��Ѵ�.
      for(int i=0;i<list.size();i++) {
         StudentVO vo = list.get(i);
         Object[] obj = {vo.getClass_name(),vo.getStu_Code(),vo.getStu_grade(),vo.getStu_name(),
               vo.getMajor_name(),vo.getStu_tel(),};
         model.addRow(obj);
           
      }
   }

   //������ �����ǵ�� �л� �˻� 
   public void Professor_StudentSearch() {
      //�˻�� �ԷµǾ��ִ��� Ȯ��.
      String search = searchWord.getText();
      if(search!=null && !search.equals("")) {//�˻�� �ִ�. 
         String searchField = (String)searchkey.getSelectedItem();//�˻�Ű �̸� ��ȭ��ȣ �ּ�
         String fieldName = "";
         if(searchField.equals("�����̸�")) {
            fieldName = "c.Class_name";
         }else if(searchField.equals("�л���ȣ")) {
            fieldName = "st.Stu_Code";
         }else if(searchField.equals("�л��̸�")) {
            fieldName = "st.Stu_name";
         }
         
         ProfessorModeDAO dao = new ProfessorModeDAO();
         List<StudentVO> list = dao.searchRecord(search,fieldName);
         setProfessor_studentlistModel(list);
         searchWord.setText("");
      }
   }

   
   public void actionPerformed(ActionEvent ae) {
      String eventBtn = ae.getActionCommand();
      if(eventBtn.equals("�˻�")) {
         Professor_StudentSearch();
      }else if(eventBtn.equals("���ΰ�ħ")) {
         professor_StudentAllList();
      }
   }

   
   public static void main(String[] args) {
      new ProfessorModeMain2();
   }
}
