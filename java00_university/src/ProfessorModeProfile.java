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

public class ProfessorModeProfile extends ProfessorModeUI implements ActionListener{
   
   JPanel pane = new JPanel(new BorderLayout());
      JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JLabel titlelb1;
   
         JPanel formCenter = new JPanel(new BorderLayout());
         JPanel formcenterwestPane = new JPanel(new GridLayout(9,1)); //�󺧺����г�
         JPanel formcentercenterPane = new JPanel(new GridLayout(9,1));; //�ؽ�Ʈ�ʵ�
         JTextField[] formTf = {new JTextField(5), new JTextField(10),new JPasswordField(10),
                        new JTextField(10),new JTextField(20),new JTextField(15),
                        new JTextField(10),new JTextField(10),new JTextField(10)};

         String formLbl[] = {"  ��        ȣ", "  ��        ��", "  ��й�ȣ", "  ��        ��", "  �� �� ��", "  �� �� ó", "  �� �� ��", "  �� �� ��", "  �������"};

         JPanel southPane = new JPanel();
            JPanel spacePane = new JPanel();
            JButton insertBtn = new JButton("����");
            DefaultTableModel model;
        
         Font font = new Font("����", Font.BOLD, 25);
         
   public ProfessorModeProfile() {
      init();
      add(pane);//��ü�гμ���
      setForm();
      insertBtn.addActionListener(this);
   }

   public void setForm() {
      pane.add(formCenter);
      formCenter.add(BorderLayout.WEST,formcenterwestPane);
      formCenter.add(BorderLayout.CENTER,formcentercenterPane);
      
      titlelb1= new JLabel("������������"); //��Ʈ����
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

      
      ProfessorModeDAO dao = new ProfessorModeDAO();
      ProfessorVO info = dao.setProfessorProfile();
          
      for(int i=0; i<formTf.length; i++) {
         JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 12));
            p.add(formTf[i]);
            if(i==0) {
               formTf[i].setText(String.valueOf(info.getProf_code()));
            } else if(i==1) {
               formTf[i].setText(info.getMajor_name());
            } else if(i==2) {
               formTf[i].setText(info.getProf_pw());
            } else if(i==3) {
               formTf[i].setText(info.getProf_name());
            } else if(i==4) {
               formTf[i].setText(info.getProf_email());
            } else if(i==5) {
               formTf[i].setText(info.getProf_tel());
            } else if(i==6) {
               formTf[i].setText(info.getProf_room());
            } else if(i==7) {
               formTf[i].setText(info.getProf_hd());
            } else if(i==8) {
               formTf[i].setText(info.getProf_birth());
            }
            formcentercenterPane.add(p);

              if(i==0 || i==1 || i==3 || i==7 || i==8) formTf[i].setEditable(false);
      }
      
   }
   
   public void actionPerformed(ActionEvent ae) {
      String eventBtn = ae.getActionCommand();
      if(eventBtn.equals("����")) {
         updateProfessor();
      }
   }
   public void updateProfessor() {
            
      ProfessorVO vo = new ProfessorVO();
      vo.setProf_code(Integer.parseInt(formTf[0].getText()));
      vo.setMajor_name(formTf[1].getText());
      vo.setProf_pw(formTf[2].getText());
      vo.setProf_name(formTf[3].getText());
      vo.setProf_email(formTf[4].getText());
      vo.setProf_tel(formTf[5].getText());
      vo.setProf_room(formTf[6].getText());
      vo.setProf_hd(formTf[7].getText());
      vo.setProf_birth(formTf[8].getText());

      ProfessorModeDAO dao = new ProfessorModeDAO();
      int cnt = dao.updateRecord(vo);
      if(cnt>0) {
         JOptionPane.showMessageDialog(this, "�������� �����Ǿ����ϴ�.");
      }else {
         JOptionPane.showMessageDialog(this, "���������Ͽ����ϴ�.");
      }
   }

   public static void main(String[] args) {
      new ProfessorModeProfile();
   }
}