import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableSelectEx extends JFrame{
	
	JTable table;
	JScrollPane sp; 
	DefaultTableModel model;
	
	String title[] = {"�����","�޿�","���ʽ�","�Ի���"}; 
	Object[][] data= {};
	
	public JTableSelectEx() {
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		try {
		//1. JVM �� jdbc����̺� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("jdbc ����̺� �ε� ���� -->" + cnfe.getMessage());
		}
			
		try {
			//2. DB����						����ip,localhost port ���������ͺ��̽�����
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
														//dbserver, ����, ���
			Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
			//3. �������� �����. "���ڿ�"
			String sql = "select ename, sal, comm, to_char(hiredate,'YYYY-MM-DD')hiredate from emp";
					

			//4. �������� �̿��Ͽ� preparedStatement ��ü����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//5.�����ϱ�
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			
				String ename = rs.getString(1);
				int sal = rs.getInt(2);
				double comm = rs.getDouble(3); 
				String hiredate = rs.getString(4);
				

			Object [] row = {ename,sal,comm,hiredate};
			model.addRow(row);	
				
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(SQLException se) {
			System.out.println("DB���� ���� �߻�--->"+ se.getMessage());
		}
	}

	public static void main(String[] args) {
		new  JTableSelectEx();
	}
}