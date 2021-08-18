import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class MemberMain extends JFrame implements ActionListener{
	//JFrame - North
	JPanel formPane = new JPanel(new BorderLayout());
		JPanel formWestPane = new JPanel(new GridLayout(6,1));
			String formLbl[] = {"��  ȣ","��  ��","����ó","�̸���","��  ��","�����"};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));
			JTextField[] formTf = {new JTextField(5), new JTextField(15),new JTextField(20),
					new JTextField(30),new JTextField(45),new JTextField(20)};
			
	//JFrame - Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			JButton[] btn = {new JButton("��ü���"), new JButton("����߰�"),
					new JButton("�������"), new JButton("�������"),new JButton("�������"), 
					new JButton("����"),	new JButton("��������"), new JButton("�����б�")};
		DefaultTableModel model;
		String title = "��ȣ/�̸�/����ó/�̸���/�ּ�/�����";
		JTable memberList;
		JScrollPane sp;
			
	//JFrame - South
	JPanel southPane = new JPanel();
		JLabel searchLbl = new JLabel("�̸�");
		DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
		JComboBox<String> searchkey = new JComboBox<String>(searchModel);
			
		JTextField searchWord = new JTextField(15);
		JButton searchBtn = new JButton("Search");
			
	public MemberMain() {
		super("ȸ�������ý���");
		
		//Frame - North
		setForm();
		//Frame - Center
		setButtonJTable();
		//Frame - South
		setSearchForm();
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		memberAllList();
		
	}
	//�����ͺ��̽����� ȸ����ü ���(�̸�������) �������� - JTable�� ����� �����ش�.
	public void memberAllList() {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.allRecord();
		setMemberModel(list);
		}
	
	public void setMemberModel(List<MemberVO> list) {
		//���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�. 
		model.setRowCount(0);
		//�÷��ǿ� �ִ� vo�� get�Ͽ� JTable�� ������� �߰��Ѵ�.
		for(int i=0;i<list.size();i++) {
			MemberVO vo = list.get(i);
			Object[] obj = {vo.getMem_no(),vo.getUsername(),vo.getTel(),vo.getEmail(),
					vo.getAddr(),vo.getWrite_date()};
			model.addRow(obj);
			}
	}
	//Frame-North
	public void setForm() {
		add(BorderLayout.NORTH,formPane);
			formPane.add(BorderLayout.WEST,formWestPane);
				for(int i=0; i<formLbl.length; i++) {
					JLabel lbl = new JLabel(formLbl[i]);
					formWestPane.add(lbl);
				}
				formPane.add(BorderLayout.CENTER,formCenter);
					for(int i=0; i<formTf.length;i++) {
						JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); // jpanel �� �ѹ��� ��ƾ� ��..
						p.add(formTf[i]);
						formCenter.add(p);
						if(i==0 || i==5) formTf[i].setEditable(false);// ù��°�� �������ϰ� ��Ȱ��ȭ
					}
	}
	//Frame-Center
	public void setButtonJTable() {
		add(centerPane);
			centerPane.add(BorderLayout.NORTH,btnList);
				for(int i=0;i<btn.length;i++) {
					btnList.add(btn[i]);
					//�̺�Ʈ���
					btn[i].addActionListener(this);
				}
	//JTable							����
			model = new DefaultTableModel(title.split("/"),0);
			memberList = new JTable(model);
			sp = new JScrollPane(memberList);
			centerPane.add(sp);
			
			memberList.addMouseListener(new JTableMouseEventProcess(formTf, memberList));
	}
	//Frame - South
	public void setSearchForm() {
		add(BorderLayout.SOUTH,southPane);
		//southPane.add(searchLbl);
		searchModel.addElement("�̸�");
		searchModel.addElement("��ȭ��ȣ");
		searchModel.addElement("�ּ�");
		southPane.add(searchkey);//�޺��ڽ�
		
		southPane.add(searchWord);
		southPane.add(searchBtn);		
		searchBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("����߰�")) {
			memberInsert();
		}else if(eventBtn.equals("�������")) {
			formDataClear();
		}else if(eventBtn.equals("����")) {
			System.exit(0);
		}else if(eventBtn.equals("�������")) {
			memberUpdate();
		}else if(eventBtn.equals("�������")) {
			memberDelete();
		}else if(eventBtn.equals("Search")) {
			memberSearch();
		}else if(eventBtn.equals("��ü���")) {
			memberAllList();
		}else if(eventBtn.equals("��������")) {
			//JTable�� ���ڵ带 ������ ����
			excelWrite();
		}else if(eventBtn.equals("�����б�")) {
			excelRead();
		}
	}
	//���� �б�
	public void excelRead() {
		JFileChooser fc = new JFileChooser();
		int state = fc.showOpenDialog(this);
		if(state==0) {
			try {
				File f = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(f);
				
				POIFSFileSystem poi = new POIFSFileSystem(fis);
				HSSFWorkbook workbook = new HSSFWorkbook(poi);
				HSSFSheet sheet = workbook.getSheet("ȸ�����");
				
				//���� JTable�� ������ �����
				model.setRowCount(0);
				
				//��Ʈ�� ���Ǽ�
				int rows = sheet.getPhysicalNumberOfRows();
				for(int r=1; r<rows; r++) {
					//�������
					HSSFRow row = sheet.getRow(r);
					int cols = row.getPhysicalNumberOfCells();//����
					Vector v = new Vector();
					for(int c=0; c<cols; c++) {
						if(c==0) {
							v.add((int)row.getCell(c).getNumericCellValue());
						}else {
							v.add(row.getCell(c).getStringCellValue());
						}
					}
					model.addRow(v);
				}
				poi.close();
				fis.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("�����б⿡���߻�");
			}
		}
	}
		
	//������ ����
	public void excelWrite() {
		JFileChooser fc = new JFileChooser();
		
		int state = fc.showSaveDialog(this);
		if(state==0) {
			File f = fc.getSelectedFile();
			
			//����
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("ȸ�����");
			//����
			HSSFRow rowTitle = sheet.createRow(0);
			String[] excelTitle = title.split("/");
			
			for(int i=0; i<excelTitle.length; i++) {
				rowTitle.createCell(i).setCellValue(excelTitle[i]);
			}
			//JTable����� ���Ǽ�
			int rows = memberList.getRowCount();//5
			int cols = memberList.getColumnCount();//6
			for(int i=0;i<rows;i++) {//0,1,2,3,4
				HSSFRow row = sheet.createRow(i+1);
				//JTable����� ���Ǽ�
				for(int j=0;j<cols;j++) {//0,1,2,3,4,5
					if(j==0) {						
						row.createCell(j).setCellValue((int)memberList.getValueAt(i, j));
					}else {
						row.createCell(j).setCellValue((String)memberList.getValueAt(i, j));
					}
				}
			}
			//������ ���Ϸ� ����
			try {
				FileOutputStream fos = new FileOutputStream(f);
				workbook.write(fos);
				fos.close();
				workbook.close();
			}catch(Exception e) {
				System.out.println("������ ���⿡��");
			}
		}
	}
	//���ڵ� �˻�
	public void memberSearch() {
		//�˻�� �ԷµǾ��ִ��� Ȯ��.
		String search = searchWord.getText();
		if(search!=null && !search.equals("")) {//�˻�� �ִ�. 
			String searchField = (String)searchkey.getSelectedItem();//�˻�Ű �̸� ��ȭ��ȣ �ּ�
			String fieldName = "";
			if(searchField.equals("�̸�")) {
				fieldName = "username";
			}else if(searchField.equals("��ȭ��ȣ")) {
				fieldName = "tel";
			}else if(searchField.equals("�ּ�")) {
				fieldName = "addr";
			}
			
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.searchRecord(search,fieldName);
			setMemberModel(list);
			searchWord.setText("");
			
		}
	}
	//�������
	public void memberDelete() {
		//������ �����ȣ
		String delNum = formTf[0].getText();
		if(delNum==null || delNum.equals("")) {
			JOptionPane.showMessageDialog(this, "������ ����� ������ ������ư�� Ŭ���ϼ���.");
		}else {
			MemberDAO dao = new MemberDAO();
			int result = dao.deleteRecord(Integer.parseInt(delNum));
			if(result>0) {//ȸ��������
				JOptionPane.showMessageDialog(this, delNum+"����� �����Ͽ����ϴ�.");
				memberAllList();
				formDataClear();
			}else {//ȸ������������.
				JOptionPane.showMessageDialog(this, delNum+"��������� �����Ͽ����ϴ�.");
			}
		}
	}
	//�������
	public void memberUpdate() {
		MemberVO vo = new MemberVO();
		vo.setMem_no(Integer.parseInt(formTf[0].getText()));
		vo.setTel(formTf[2].getText());
		vo.setEmail(formTf[3].getText());
		vo.setAddr(formTf[4].getText());
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateRecord(vo);
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			memberAllList();
		}else{	//�������н� �ȳ��޽��� ǥ��
			JOptionPane.showMessageDialog(this, "ȸ������ ���� �����Ͽ����ϴ�.");
		}
	}
	public void memberInsert() {
		//���� �̸��� �Է»������� Ȯ��
		String username=formTf[1].getText();
		if(username==null || username.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
		}else {
			MemberVO vo = new MemberVO();
			vo.setUsername(username);
			vo.setTel(formTf[2].getText());
			vo.setEmail(formTf[3].getText());
			vo.setAddr(formTf[4].getText());
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.insertRecord(vo);
			if(cnt>0) {//ȸ���߰�
				formDataClear();//ȸ���� �߰��Ǹ� ���� �����͸� �����.
				memberAllList();
			}else {//ȸ���߰�����
				JOptionPane.showMessageDialog(this, "ȸ���߰� �����Ͽ����ϴ�.");
			}
		}
	}
	public void formDataClear() {
		//���� ���� �����.
		for(int i=0; i<formTf.length;i++) {
			formTf[i].setText("");
		}
	}
	public static void main(String[] args) {
		new MemberMain();
	}
}
