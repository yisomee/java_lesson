import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentModeProfile extends StudentModeUI implements ActionListener{
   
   JPanel pane = new JPanel(new BorderLayout());
      JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JLabel titlelb1;
   
         JPanel formCenter = new JPanel(new BorderLayout());
         JPanel formcenterwestPane = new JPanel(new GridLayout(11,1)); //�󺧺����г�
         JPanel formcentercenterPane = new JPanel(new GridLayout(11,1));; //�ؽ�Ʈ�ʵ�
         JTextField[] formTf = {new JTextField(10), new JTextField(10),new JPasswordField(10),
                        new JTextField(10),new JTextField(5),new JTextField(15),
                        new JTextField(10),new JTextField(20),new JTextField(10),
                        new JTextField(10),new JTextField(10)};

         String formLbl[] = {"  ��        ȣ", "  ��        ��", "  ��й�ȣ", "  ��        ��", "  ��        ��", "  �� �� ��", "  �� �� ó", "  ��        ��",
                "  ��        ��","  ��������", "  �������"};

         JPanel southPane = new JPanel();
            JPanel spacePane = new JPanel();
            JButton insertBtn = new JButton("����");
            DefaultTableModel model;
        
         Font font = new Font("����", Font.BOLD, 25);
         
   public StudentModeProfile() {
      init();
      add(pane);//��ü�гμ���
      setForm();

      insertBtn.addActionListener(this);
   }

   public void setForm() {
      pane.add(formCenter);
      formCenter.add(BorderLayout.CENTER,formcentercenterPane);
      formCenter.add(BorderLayout.WEST,formcenterwestPane);
      
      titlelb1= new JLabel("������������"); 
      titlelb1.setFont(font);
      northPane.add(titlelb1);
      
      //northPane.setPreferredSize(new Dimension(0,140));
      pane.add(BorderLayout.NORTH,northPane);   
         for(int i=0; i<formLbl.length; i++) {
             JLabel lb1 = new JLabel(formLbl[i]);
             formcenterwestPane.add(lb1);
         }
         
      //south
//      spacePane.setBackground(Color.BLACK);
      spacePane.setPreferredSize(new Dimension(600, 200));
      southPane.add(spacePane);
      southPane.add(insertBtn);
       pane.add(BorderLayout.SOUTH, southPane); 
       
//      southPane.setBorder(new LineBorder(Color.GRAY,1,true));
      insertBtn.setBackground(new Color(33, 140, 116));
      insertBtn.setForeground(Color.white);
      insertBtn.setFont(font);
      insertBtn.setPreferredSize(new Dimension(100, 30)); //��ư�������
      
      

      
      //�л��� �������������Ҷ� ���� �����ϱ�
      StudentModeDAO dao = new StudentModeDAO();
      StudentVO info = dao.setStudentProfile();
       
      for(int i=0; i<formTf.length; i++) {
         JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 12));
            p.add(formTf[i]);
            if(i==0) {
               formTf[i].setText(String.valueOf(info.getStu_Code()));
            } else if(i==1) {
               formTf[i].setText(info.getMajor_name());
            } else if(i==2) {
               formTf[i].setText(info.getStu_pw());
            } else if(i==3) {
               formTf[i].setText(info.getStu_name());
            } else if(i==4) {
               formTf[i].setText(info.getStu_grade());
            } else if(i==5) {
               formTf[i].setText(info.getStu_email());
            } else if(i==6) {
               formTf[i].setText(info.getStu_tel());
            } else if(i==7) {
               formTf[i].setText(info.getStu_add());
            } else if(i==8) {
               formTf[i].setText(info.getStu_state());
            } else if(i==9) {
               formTf[i].setText(info.getStu_date());
            } else if(i==10) {
               formTf[i].setText(info.getStu_birth());
            }
            formcentercenterPane.add(p);

              if(i==0 || i==1 || i==3 || i==4|| i==8 || i==9|| i==10) formTf[i].setEditable(false);
      }
   }
   
   public void actionPerformed(ActionEvent ae) {
      String eventBtn = ae.getActionCommand();
      if(eventBtn.equals("����")) {
         updateStudent();
      }
   }
   public void updateStudent() {
            
      StudentVO vo = new StudentVO();
      vo.setStu_Code(Integer.parseInt(formTf[0].getText()));
      vo.setMajor_name(formTf[1].getText());
      vo.setStu_pw(formTf[2].getText());
      vo.setStu_name(formTf[3].getText());
      vo.setStu_grade(formTf[4].getText());
      vo.setStu_email(formTf[5].getText());
      vo.setStu_tel(formTf[6].getText());
      vo.setStu_add(formTf[7].getText());
      vo.setStu_state(formTf[8].getText());
      vo.setStu_date(formTf[9].getText());
      vo.setStu_birth(formTf[10].getText());
      

      StudentModeDAO dao = new StudentModeDAO();
      int cnt = dao.updateRecord(vo);
      if(cnt>0) {
         JOptionPane.showMessageDialog(this, "���������Ǿ����ϴ�.");
      }else {
         JOptionPane.showMessageDialog(this, "���������Ͽ����ϴ�.");
      }
   }

   public static void main(String[] args) {
      new StudentModeProfile();
   }
}
